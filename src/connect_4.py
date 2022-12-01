import copy

## tutorial: https://youtu.be/MMLtza3CZFM

NUM_ROWS = 6 # number of rows on a connect 4 board
NUM_COLS = 7 # number of columns on a connect 4 board

"""
Values to be stored in the board list
0 if location is unoccupied
1 if location is occupied by player piece
2 if location if occupied by AI piece
"""
EMPTY = 0
PLAYER = 1
AI = 2

"""
Creates starting board
board[0][0] is top left location
board[5][6] is bottom right location
"""
main_board = [[0, 0, 0, 0, 0, 0, 0] for i in range(NUM_COLS)]

"""
Prints the board in the terminal to help with visualization
"""
def print_board(board):
    for r in range(NUM_ROWS):
        print(board[r])

"""
Returns true if board location is empty
"""
def is_empty(board, row, col):
    return board[row][col] == 0

def find_empty_row(board, col):
	for r in range(NUM_ROWS-1, 0, -1):
		if board[r][col] == 0:
			return r

"""
Returns true if column has space for piece to be dropped and desired column exists
"""
def is_valid_move(board, col):
    return col >= 0 and col <= NUM_COLS - 1 and board[0][col] == 0

"""
Places piece in board location

***Does not check if move is valid
"""
def make_move(board, row, col, piece):
    board[row][col] = piece

"""
Returns true if either the player of AI wins the game depending on value of piece
Piece will have value of 1 if checking player victory, or 2 if checking AI victory
"""
def check_victory(board, piece):
    #check horizontal
    for r in range(NUM_ROWS):
        for c in range(NUM_COLS - 3):
            if board[r][c] == piece and board[r][c+1] == piece \
                and board[r][c+2] == piece and board[r][c+3] == piece: return True

    #check vertical
    for r in range(NUM_ROWS - 3):
        for c in range(NUM_COLS):
            if board[r][c] == piece and board[r+1][c] == piece \
                and board[r+2][c] == piece and board[r+3][c] == piece: return True

    #check ascending diagonal
    for r in range(3):
        for c in range(NUM_COLS - 3):
            if board[r][c] == piece and board[r-1][c+1] == piece \
                and board[r-2][c+2] == piece and board[r-3][c+3] == piece: return True

    #check descending diagonal
    for r in range(3):
        for c in range(3):
            if board[r][c] == piece and board[r-1][c-1] == piece \
                and board[r-2][c-2] == piece and board[r-3][c-3] == piece: return True

    return False

def evaluate_set(set, piece):
    score = 0

    if piece == PLAYER: opp = AI
    else: opp = PLAYER

    if set.count(piece) == 4:
        score += 100
    elif set.count(piece) == 3 and set.count(EMPTY) == 1:
        score += 5
    elif set.count(piece) == 2 and set.count(EMPTY) == 2:
        score += 2

    if set.count(opp) == 3 and set.count(EMPTY) == 1:
        score -= 30

    return score

def score_board(board, piece):
    score = 0

    ## checks all horizontal sets of 4 locations
    for r in range(NUM_ROWS):
        for c in range(NUM_COLS-3):
            set = board[r][c:c+4]
            score += evaluate_set(set, piece)

    ## checks all vertical sets of 4 locations *NOT WORKING*
    for c in range(NUM_COLS):
        for r in range(NUM_ROWS-3):
            set = board[r:r+4][c]
            score += evaluate_set(set, piece)

    ## checks all ascending diagonal sets of 4 locations

    ## checks all descending sets of 4 locations

    return score

def find_valid_moves(board):
	valid_moves = []
	for c in range(NUM_COLS):
		if is_valid_move(board, c):
			valid_moves.append(c)
	return valid_moves

def find_best_move(board, piece):
    valid_moves = find_valid_moves(board)
    best_score = -10000
    best_col = 0
    for c in valid_moves:
        row = find_empty_row(board, c)
        temp_board = copy.deepcopy(board)
        make_move(temp_board, row, c, piece)
        print()
        print_board(temp_board)
        score = score_board(temp_board, piece)
        if score > best_score:
            best_score = score
            best_col = c

    return best_col

#make_move(main_board, 5, 0, AI)
#make_move(main_board, 5, 1, AI)

#make_move(main_board, 4, 0, AI)
#make_move(main_board, 4, 1, AI)

#make_move(main_board, 5, 2, PLAYER)
#make_move(main_board, 5, 3, PLAYER)
#make_move(main_board, 5, 4, PLAYER)

#print_board(main_board)

#print(find_best_move(main_board, AI))



A = []
for i in range(6):
    A.append([i, 1, 2, 3, 4, 5, 6])

print(A)

a = A[0:4][3]
print(a)

b = []
while(len(b) < 4):
    for r in range(6):
        for c in range(7):
            if c == 3: b.append(r)

print(b)
