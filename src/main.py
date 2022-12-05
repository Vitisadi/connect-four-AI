import asyncio
import websockets
import requests
import connect_4

PLAYER_MODE = False


async def create_game(server):
    async with websockets.connect(f'ws://{server}/create') as websocket:
        response = await websocket.recv()
        id = response.split(":")[1]

        print("Created game with id", id)

        return await game_loop(websocket, True)

async def join_game(server, id):
    async with websockets.connect(f'ws://{server}/join/{id}') as websocket:
        response = await websocket.recv()

        return await game_loop(websocket, False)

async def get_list_games():
    response = requests.get("http://localhost:5000/list")
    return response.text

async def game_loop(socket, created):
    game_active = True
    message = None

    while game_active:
        message = (await socket.recv()).split(':')

        match message[0]:
            case 'GAMESTART' | 'OPPONENT':
                if (message[0] == 'GAMESTART' and not created):
                    continue

                if not len(message) == 1:
                    connect_4.get_opponent_move(message[1])
                
                if PLAYER_MODE: #Testing
                    move = input("Enter a move: ").strip()
                    await socket.send(f'PLAY:{move}')
                else:
                    move = connect_4.calculate_move()
                    await socket.send(f'PLAY:{move}')

                #await socket.send(f'PLAY:{move}')
                
                #print(message[1])
            case 'WIN':
                message = 'Game won!'
                game_active = False
            case 'LOSS':
                message = "Game lost."
                game_active = False
            case 'TERMINATED':
                message ="Game terminated."
                game_active = False
            case 'DRAW':
                message = "Game drawn."
                game_active = False

    return message




if __name__ == '__main__':
    #server = input('Server IP: ').strip()
    server = "128.113.228.203:5000"
    protocol = input('Do you want to join or create a game? (j/c) ').strip()\

    message = None

    if protocol == 'c':
        message = asyncio.run(create_game(server))
    else:
        id = input('Game ID: ').strip()

        message = asyncio.run(join_game(server, id))