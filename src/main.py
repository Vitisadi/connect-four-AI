import asyncio
import websockets

ip = "129.161.66.109"

async def create_game():
    async with websockets.connect("ws://" + ip + ":5000/create") as websocket:
        await websocket.send("/")
        response = await websocket.recv()
        id = response.split(":")[1]
        return id

async def join_game(id):
    print("ws://" + ip + ":5000/join/:" + id)
    async with websockets.connect("ws://" + ip + ":5000/join/:" + id) as websocket:
        await websocket.send("/")
        response = await websocket.recv()
        print(response)

async def list_games():
    async with websockets.connect("ws://" + ip + ":5000/list") as websocket:
        await websocket.send("/")
        response = await websocket.recv()
        print(response)


if __name__ == '__main__':
    id = asyncio.run(create_game())
    print("Created game with id", id)
    asyncio.run(join_game(id))
    #asyncio.run(list_games())

    