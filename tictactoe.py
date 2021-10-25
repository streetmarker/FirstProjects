def prt(x, y):
    board[x-1][y-1] == "X"
    print("---------")
    print("|" + " " + board[0][0] + " " + board[0][1] + " " + board[0][2] + " " + "|")
    print("|" + " " + board[1][0] + " " + board[1][1] + " " + board[1][2] + " " + "|")
    print("|" + " " + board[2][0] + " " + board[2][1] + " " + board[2][2] + " " + "|")
    print("---------")
def xWin():
    print("X wins")
    exit()
def oWin():
    print("O wins")
    exit()

# Game State print
board = [[" ", " ", " "],
         [" ", " ", " "],
         [" ", " ", " "]]

print("---------")
print("|" + " " + board[0][0] + " " + board[0][1] + " " + board[0][2] + " " + "|")
print("|" + " " + board[1][0] + " " + board[1][1] + " " + board[1][2] + " " + "|")
print("|" + " " + board[2][0] + " " + board[2][1] + " " + board[2][2] + " " + "|")
print("---------")

# me
count = 0
flag = 3
xCzyY = 1
print("Order of input:# #")
for _ in range(9):
    count += 1
    try:
        # code with possible error
        move = input("Enter the coordinates: ")
    except:
        print("Wrong input type (# #)")
        move = input("Enter the coordinates: ")

    a = int(move[0])
    b = int(move[2])
    for i in range(100):
        if a>3 or b>3:
            flag -= 1
            print("Coordinates should be from 1 to 3!")
        elif board[a-1][b-1]=="X" or board[a-1][b-1]=="O":
            flag -= 1
            print("This cell is occupied! Choose another one!")
        elif a+b!=a+b:
            flag -= 1
            print("You should enter numbers!")
        if flag == 3:
            if xCzyY % 2 != 0:
                board[a - 1][b - 1] = "X"
            else:
                board[a - 1][b - 1] = "O"
            xCzyY += 1
            prt(a, b)
            break
        else:
            flag = 3
            move = input("Enter the coordinates: ")
            a = int(move[0])
            b = int(move[2])


    for i in range(3):
        if board[i] == ["X","X","X"]:
            xWin()


        for j in range(3):
            for ji in range(3):
                if board[j][ji] == ["X","X","X"]:
                    xWin()



    for i in range(3):
        if board[i] == ["O","O","O"]:
            oWin()


        for j in range(3):
            for ji in range(3):
                if board[j][ji] == ["O","O","O"]:
                    oWin()



    if board[2][0] == "X" and board[1][1] == "X" and board[0][2] == "X":
        xWin()

    elif board[0][0] == "X" and board[1][1] == "X" and board[2][2] == "X":
        xWin()

    if board[2][0] == "O" and board[1][1] == "O" and board[0][2] == "O":
        oWin()
    elif board[0][0] == "O" and board[1][1] == "O" and board[2][2] == "O":
        oWin()
