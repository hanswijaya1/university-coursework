"""
Sudoku boards partially retrieved from
- https://puzzlemadness.co.uk
- https://sudokudragon.com
"""

########### Sudoku boards ##############################

small = [[1, 0, 0, 0],
         [0, 4, 1, 0],
         [0, 0, 0, 3],
         [4, 0, 0, 0]]

small2 = [[0, 0, 1, 0],
          [4, 0, 0, 0],
          [0, 0, 0, 2],
          [0, 3, 0, 0]]

big = [[0, 0, 0, 0, 0, 0, 0, 0, 0],
       [4, 0, 0, 7, 8, 9, 0, 0, 0],
       [7, 8, 0, 0, 0, 0, 0, 5, 6],
       [0, 2, 0, 3, 6, 0, 8, 0, 0],
       [0, 0, 5, 0, 0, 7, 0, 1, 0],
       [8, 0, 0, 2, 0, 0, 0, 0, 5],
       [0, 0, 1, 6, 4, 0, 9, 7, 0],
       [0, 0, 0, 9, 0, 0, 0, 0, 0],
       [0, 0, 0, 0, 3, 0, 0, 0, 2]]

big2 = [[7, 0, 0, 0, 0, 0, 0, 1, 0],
        [0, 5, 0, 0, 0, 9, 0, 0, 0],
        [8, 0, 0, 0, 3, 0, 0, 4, 0],
        [0, 0, 0, 7, 6, 0, 0, 0, 8],
        [6, 2, 0, 0, 5, 0, 0, 0, 0],
        [0, 0, 0, 0, 0, 3, 0, 7, 0],
        [0, 0, 0, 6, 0, 0, 9, 8, 0],
        [0, 0, 0, 0, 2, 7, 3, 0, 0],
        [0, 0, 2, 0, 8, 0, 0, 5, 0]]

big3 = [[0, 0, 8, 1, 9, 0, 0, 0, 6],
        [0, 4, 0, 0, 0, 0, 0, 0, 0],
        [0, 0, 7, 6, 0, 0, 1, 3, 0],
        [0, 0, 6, 0, 1, 0, 0, 0, 0],
        [0, 0, 0, 0, 8, 0, 0, 0, 0],
        [4, 0, 0, 0, 0, 2, 0, 0, 5],
        [0, 0, 0, 0, 3, 0, 9, 0, 0],
        [0, 1, 0, 4, 0, 0, 0, 0, 2],
        [0, 0, 0, 0, 0, 0, 0, 5, 7]]

big4 = [[0, 0, 0, 6, 0, 0, 2, 0, 0],
        [8, 0, 4, 0, 3, 0, 0, 0, 0],
        [0, 0, 0, 0, 0, 9, 0, 0, 0],
        [4, 0, 5, 0, 0, 0, 0, 0, 7],
        [7, 1, 0, 0, 0, 0, 0, 0, 0],
        [0, 0, 3, 0, 5, 0, 0, 0, 8],
        [3, 0, 0, 0, 7, 0, 0, 0, 4],
        [0, 0, 0, 0, 0, 1, 9, 0, 0],
        [0, 0, 0, 2, 0, 0, 0, 6, 0]]

giant = [[ 0,  0, 13,  0,  0,  0,  0,  0,  2,  0,  8,  0,  0,  0, 12, 15],
         [ 7,  8, 12,  2, 10,  0,  0, 13,  0,  0, 14, 11,  6,  9,  0,  4],
         [11, 10,  0,  0,  0,  6, 12,  5,  0,  3,  0,  0,  0, 14,  0,  8],
         [ 1,  0,  0,  0, 14,  0,  2,  0,  0,  4,  6,  0, 16,  3,  0, 13],
         [12,  6,  0,  3,  0,  0, 16, 11,  0, 10,  1,  7, 13, 15,  0,  0],
         [ 0, 13,  0,  0,  0, 15,  8,  0, 14,  0,  0,  0,  0, 16,  5, 11],
         [ 8,  0, 11,  9, 13,  0,  7,  0,  0,  0,  0,  3,  2,  4,  0, 12],
         [ 5,  0,  0, 16, 12,  9,  0, 10, 11,  2, 13,  0,  0,  0,  8,  0],
         [ 0,  0,  0,  0, 16,  8,  9, 12,  0,  0,  0,  0,  0,  6,  3,  0],
         [ 2, 16,  0,  0,  0, 11,  0,  0,  7,  0, 12,  6,  0, 13, 15,  0],
         [ 0,  0,  4,  0,  0, 13,  0,  7,  3, 15,  0,  5,  0,  0,  0,  0],
         [ 0,  7,  0, 13,  4,  5, 10,  0,  1,  0, 11, 16,  9,  0, 14,  2],
         [ 0,  2,  8,  0,  9,  0,  0,  0,  4,  0,  7,  0,  0,  5,  0,  0],
         [14,  0,  0,  0, 15,  2, 11,  4,  9, 13,  3,  0, 12,  0,  0,  0],
         [ 0,  1,  9,  7,  0,  0,  5,  0,  0, 11, 15, 12,  0,  0,  0,  0],
         [16,  3, 15,  0,  0, 14, 13,  6, 10,  1,  0,  2,  0,  8,  4,  9]]

giant2 = [[ 0,  5,  0,  0,  0,  4,  0,  8,  0,  6,  0,  0,  0,  0,  9, 16],
          [ 1,  0,  0,  0,  0,  0,  0, 13,  4,  0,  0,  7, 15,  0,  8,  0],
          [13,  0,  0,  0,  0,  7,  3,  0,  0,  0,  0,  9,  5, 10,  0,  0],
          [ 0, 11, 12, 15, 10,  0,  0,  0,  0,  0,  5,  0,  3,  4,  0, 13],
          [15,  0,  1,  3,  0,  0,  7,  2,  0,  0,  0,  0,  0,  5,  0,  0],
          [ 0,  0,  0, 12,  0,  3,  0,  5,  0, 11,  0, 14,  0,  0,  0,  9],
          [ 4,  7,  0,  0,  0,  0,  0,  0, 12,  0, 15, 16,  0,  0,  0,  0],
          [ 0,  0,  0,  0, 14,  0, 15,  0,  6,  9,  0,  0,  0,  0, 12,  0],
          [ 3,  0, 15,  4,  0, 13, 14,  0,  0,  0,  0,  1,  0,  0,  7,  8],
          [ 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  9, 10,  0,  0,  0,  0],
          [11,  0, 16, 10,  0,  0,  0,  0,  0,  7,  0,  0,  0,  3,  5,  0],
          [ 0,  0, 13,  0,  0,  0,  0,  0, 14,  0, 16, 15,  0,  9,  0,  1],
          [ 9,  0,  2,  0,  0, 14,  0,  4,  8,  0,  0,  0,  0,  0,  0,  0],
          [ 0, 14,  0,  0,  0,  0,  0, 10,  9,  0,  3,  0,  0,  0,  1,  7],
          [ 8,  0,  0,  0, 16,  0,  0,  1,  2, 14, 11,  4,  0,  0,  0,  3],
          [ 0,  0,  0,  1,  0,  0,  5,  0,  0, 16,  0,  6,  0, 12,  0,  0]]

giant3 = [[ 0,  4,  0,  0,  0,  0,  0, 12,  0,  1,  0,  0,  9,  0,  8,  0],
          [15, 14,  0,  0,  9,  0,  0, 13,  8,  0,  0, 10,  1,  0,  0,  0],
          [ 0,  7,  0,  0,  0,  0,  0,  8, 16,  0, 14,  0,  0,  2,  0,  0],
          [ 0,  0,  0,  9,  0,  0, 11,  0,  0,  0,  0,  0,  5,  0,  0, 15],
          [ 3,  0, 12,  0,  7,  0, 10,  0,  0, 11,  2,  0,  0,  0,  0,  6],
          [14,  8,  0,  0,  0, 12,  0,  6,  0,  0,  0, 16,  0,  0,  0, 10],
          [ 0, 16,  0,  0, 13,  0,  0,  0,  0,  0,  0,  0,  0,  0, 12,  0],
          [ 6,  0,  0,  0,  0,  8,  0,  5,  1,  7, 13,  0, 11,  0,  0, 14],
          [ 0,  0,  0,  2,  0,  0, 16,  0, 15, 12,  0,  3, 10,  7,  0,  0],
          [ 0,  9,  0,  5, 11,  0,  3,  0,  4, 13, 16,  0,  0, 15,  6,  0],
          [ 0,  0,  0,  0,  5,  4,  0,  0,  9,  6,  0,  2,  0,  0,  0,  0],
          [ 1,  0,  0,  0,  0, 15, 12,  0,  0,  0,  5,  0,  0,  0,  9,  0],
          [12, 10,  0, 15,  0,  1,  0,  0,  2,  9,  3,  4,  0,  0,  5,  0],
          [ 0,  0,  0,  3, 10,  0,  4,  0,  0, 15,  0,  0,  0,  0,  0,  0],
          [ 0,  0,  0,  0, 16,  0,  0,  0,  0,  0,  0,  0,  0,  0, 10, 11],
          [11,  6,  8,  0,  0,  0, 15,  0, 14,  0,  0,  0,  0, 13,  0,  2]]

sudokus = [[], [], [small, small2], [big, big2, big3, big4], [giant, giant2, giant3]]

########### Module functions ###########################

def print_board(board):
    from math import sqrt
    root = int(sqrt(len(board)))
    rnc = root +len(board) +1
    # rnc is the number of rows and columns the board is going to have
    lst = ['A','B','C','D','E','F','G']
    board1 = ''
    for i in range (len(board)):
        if i % root == 0:
            board1 += '-'*rnc +'\n'
        for j in range(len(board[i])):
            if j % root == 0:
                board1 +='|'
            if board[i][j]>=10:
                board1+= lst[board[i][j]-10]
            elif board[i][j] ==0:
                board1+=' ' 
            elif board[i][j]==-1:
                board1 +='*'
            else :
                board1+= str(board[i][j])
        board1+='|'
        board1 += '\n'
    board1+='-'*rnc
    print (board1)
    
    """
    Prints a given board to the console in a way that aligns the content of columns and makes
    the subgrids visible.

    Input : a Sudoku board (board) of size 4x4, 9x9, or 16x16
    Effect: prints the board to the console 

    For example:

    >>> print_board(small2)
    -------
    |  |1 |
    |4 |  |
    -------
    |  | 2|
    | 3|  |
    -------
    >>> print_board(big)
    -------------
    |   |   |   |
    |4  |789|   |
    |78 |   | 56|
    -------------
    | 2 |36 |8  |
    |  5|  7| 1 |
    |8  |2  |  5|
    -------------
    |  1|64 |97 |
    |   |9  |   |
    |   | 3 |  2|
    -------------
    >>> print_board(giant2)
    ---------------------
    | 5  | 4 8| 6  |  9G|
    |1   |   D|4  7|F 8 |
    |D   | 73 |   9|5A  |
    | BCF|A   |  5 |34 D|
    ---------------------
    |F 13|  72|    | 5  |
    |   C| 3 5| B E|   9|
    |47  |    |C FG|    |
    |    |E F |69  |  C |
    ---------------------
    |3 F4| DE |   1|  78|
    |    |    |  9A|    |
    |B GA|    | 7  | 35 |
    |  D |    |E GF| 9 1|
    ---------------------
    |9 2 | E 4|8   |    |
    | E  |   A|9 3 |  17|
    |8   |G  1|2EB4|   3|
    |   1|  5 | G 6| C  |
    ---------------------
    """

def subgrid_values(board, r, c):
    from math import sqrt
    lst = []
    root = int(sqrt(len(board)))
    rows= r//root
    columns = c//root
    rtimesroot = rows * root
    ctimesroot = columns * root
    for i in range (rtimesroot,rtimesroot+root):
        for j in range (ctimesroot,ctimesroot+root):
            if board[i][j]!= 0:
                lst.append(board[i][j])
    return lst

    """
    Input : Sudoku board (board), row index (r), and column index (c)
    Output: list of all numbers that are present in the subgrid of the board related to the
            field (r, c)

    For example:

    >>> subgrid_values(small2, 1, 3)
    [1]
    >>> subgrid_values(big, 4, 5)
    [3, 6, 7, 2]
    >>> subgrid_values(giant2, 4, 5)
    [7, 2, 3, 5, 14, 15]
    """
    pass


def options(board, r, c):
    lst=[]
    notlst= []
    for i in range(len(board)):
        if board[r][i] != 0:
            notlst.append(board[r][i])
    for i in range (len(board)):
        if board[i][c] != 0 :
            notlst.append(board[i][c])
    notlst+=subgrid_values(board,r,c)
    for i in range (1, len(board)+1):
        if i not in notlst:
            lst.append(i)
    return lst
    
    """
    Input : Sudoku board (board), row index (r), and column index (c)
    Output: list of all numbers that player is allowed to place on field (r, c),
            i.e., those that are not already present in row r, column c,
            and subgrid related to field (r, c)

    For example:

    >>> options(small2, 0, 0)
    [2, 3]
    >>> options(big, 6, 8)
    [3, 8]
    >>> options(giant2, 1, 5)
    [2, 5, 6, 9, 11, 12, 16]
    """
    pass


def play(board):
    """
    Input : Sudoku board
    Effect: Allows user to play board via console
    """
    from copy import deepcopy
    from math import sqrt
    print_board(board)
    copyboard = deepcopy(board)
    rowu=[]
    columnu=[]
    while True:
        root = int(sqrt(len(board)))
        total = 0
        row = 0
        column = 0
        congratulations = "Congratulations, you have completed the puzzle"
        allnumbersadded = ((len(board)/2)*(1+len(board)))* len(board)
        for a in range(len(board)):
            total+= sum(board[a])
        if total == allnumbersadded:
            print(congratulations)
        inp = input().split(' ')
        if inp[0] == 'u' or inp[0] == 'undo':
            if rowu==[] or columnu==[]:
                print("Error : Please make a move before you use the function undo")
            else :
                board[rowu.pop()][columnu.pop()] = 0
                print_board(board)
        elif len(inp) == 3 and inp[0].isdecimal() and inp[1].isdecimal() and inp[2].isdecimal():
            i = int(inp[0])
            j = int(inp[1])
            x = int(inp[2])
            if board[i][j] != 0 and board[i][j]!= -1:
                print("Error : Please input in the spots that do not have a number yet")
            elif x in options(board,i,j):
                board[i][j] = x
                rowu.append(i)
                columnu.append(j)
            else :
                print('Error : Please input a number that is not in row, column, or subgrid as well as not greater than the length of the board')
            print_board(board)
        elif len(inp)==3 and (inp[0] == 'n' or inp[0] == 'new') and inp[1].isdecimal() and inp[2].isdecimal():
            k = int(inp[1])
            d = int(inp[2])
            if k < len(sudokus) and 0 < d <= len(sudokus[k]):
                board = sudokus[k][d-1]
                copyboard = deepcopy(board)
                print_board(board)
            else:
                print('board not found')
        elif inp[0] == 'r' or inp[0] == 'restart':
            board = deepcopy(copyboard)
            print_board(board)
        elif inp[0] =='h' or inp[0] == 'hint':
            minimum = 99999999
            for y in range(len(board)):
                for z in range(len(board[y])):
                    if board[y][z]==0 or board[y][z] == -1:
                        if minimum > len(options(board,y,z)):
                            minimum = len(options(board,y,z))
                            row = y
                            column = z
            if board[row][column]==0 or board[row][column] == -1:
                board[row][column]= -1
                print_board(board)
                print((row,column))
            else:
                print_board(board)
        elif inp[0] =='i' or inp[0]=='infer':
            print_board(inferred(board))
        elif inp[0]=='s' or inp[0]=='solve':
            print_board(solve(board))
        elif len(inp)==2 and (inp[0]=='g' or inp[0]=='generate') and inp[1].isdecimal():
            board=generate(int(inp[1]))
            print_board(board)
        elif inp[0] == 'q' or inp[0] == 'quit':
            return
        else:
            print('Invalid input')

        """
        The hint function that I code looks if the spot has been taken with another number or not. If the spot has been taken,
        then it won't take a look at it and carry on to the next spot. Then I checked whether it has the minimum amount of options.
        If it has the minimum amount of options then I print it and then put a -1 as the value. This -1 won't mess with my code especially my code
        that will print the congratulatory message when the player finished the sudoku. This -1 will then be printed as '*' in my print_board function.
        Then, if we want to change it, we can just input the row and column as well as the number we want it to change respectively and it will register. But,
        the * will not be there anymore if you inputted an invalid input. I chose the minimum number of options because it is going to be easier for the player to
        choose a number from a small list rather than a big one.        
        """

def value_by_single(board, i, j):
    from math import sqrt
    root = sqrt(len(board))
    notlst=[]
    lst=[]
    value=0
    rows=i//root
    columns=j//root
    lst2=[]
    if len(options(board,i,j))==1:
        value=options(board,i,j)[0]
    else:
        lst=options(board,i,j)
        for k in range(len(board)):
            if board[i][k]==0 and k!=j:
                notlst+= options(board,i,k)
        for c in range(1,len(board)+1):
            if c in lst and c not in notlst:
                lst2.append(c)
        if len(lst2)==1:
            value=lst2[0]
        else:
            lst2=[]
            notlst=[]
            for l in range(len(board[i])):
                if board[l][j]== 0 and l !=i:
                    notlst+=options(board,l,j)
            for c in range(1,len(board)+1):
                if c in lst and c not in notlst:
                    lst2.append(c)
            if len(lst2)==1:
                value=lst2[0]
            else:
                for a in range(int(rows* root), int(rows*(root+1))):
                    for b in range(int(columns*root), int(columns*(root+1))):
                        if board[a][b] ==0 and a!=i and b !=j:
                            notlst+=options(board,a,b)
                for c in range(1,len(board)+1):
                    if c in lst and c not in notlst:
                        lst2.append(c)
                if len(lst2)==1:
                    value=lst2[0]
                else:
                    value=None                        
    return value
        
    """
    Input : board, row, and column index
    Output: The correct value for field (i, j) in board if it can be inferred as
            either a forward or a backward single; or None otherwise. 
    
    For example:

    >>> value_by_single(small2, 0, 1)
    2
    >>> value_by_single(small2, 0, 0)
    3
    >>> value_by_single(big, 0, 0)
    """
    pass
'''
value_by_single is comparing the options in board[i][j] with all the other
options in either row, column, or subgrid. But, this does not take the options
of a field if the field already has a number on it. If it has a number, then
we just add the number into the list will all the other options. After we check
either row, column, or subgrid, we compare them. If we have 1 number left
in options after deleting the option that appears in the list with all the other
options. Then, we know that is the value we are looking for. Else, we check
for column, or subgrid if we do row for the first check. If after we checked
row, column, and subgrid, we don't get a number, we return None.
'''


def inferred(board):
    from copy import deepcopy
    copyboard=deepcopy(board)
    copyboard2=[]
    while copyboard!= copyboard2:
        copyboard2=deepcopy(copyboard)
        for i in range(len(board)):
            for j in range(len(board[i])):
                if value_by_single(copyboard,i,j)!= None and copyboard[i][j]==0:
                    copyboard[i][j] = value_by_single(copyboard,i,j)
    return copyboard
    """
    Input : Sudoku board
    Output: new Soduko board with all values field from input board plus
            all values that can be inferred by repeated application of 
            forward and backward single rule

    For example board big can be completely inferred:

    >>> inferred(big) # doctest: +NORMALIZE_WHITESPACE
    [[2, 1, 3, 4, 5, 6, 7, 8, 9],
    [4, 5, 6, 7, 8, 9, 1, 2, 3],
    [7, 8, 9, 1, 2, 3, 4, 5, 6],
    [1, 2, 4, 3, 6, 5, 8, 9, 7],
    [3, 6, 5, 8, 9, 7, 2, 1, 4],
    [8, 9, 7, 2, 1, 4, 3, 6, 5],
    [5, 3, 1, 6, 4, 2, 9, 7, 8],
    [6, 4, 2, 9, 7, 8, 5, 3, 1],
    [9, 7, 8, 5, 3, 1, 6, 4, 2]]

    But function doesn't modify input board:

    >>> big # doctest: +NORMALIZE_WHITESPACE
    [[0, 0, 0, 0, 0, 0, 0, 0, 0],
     [4, 0, 0, 7, 8, 9, 0, 0, 0],
     [7, 8, 0, 0, 0, 0, 0, 5, 6],
     [0, 2, 0, 3, 6, 0, 8, 0, 0],
     [0, 0, 5, 0, 0, 7, 0, 1, 0],
     [8, 0, 0, 2, 0, 0, 0, 0, 5], 
     [0, 0, 1, 6, 4, 0, 9, 7, 0],
     [0, 0, 0, 9, 0, 0, 0, 0, 0],
     [0, 0, 0, 0, 3, 0, 0, 0, 2]]

    In board big4 there is nothing to infer:
    
    >>> inferred(big4) # doctest: +NORMALIZE_WHITESPACE
    [[0, 0, 0, 6, 0, 0, 2, 0, 0],
     [8, 0, 4, 0, 3, 0, 0, 0, 0],
     [0, 0, 0, 0, 0, 9, 0, 0, 0], 
     [4, 0, 5, 0, 0, 0, 0, 0, 7],
     [7, 1, 0, 0, 0, 0, 0, 0, 0],
     [0, 0, 3, 0, 5, 0, 0, 0, 8],
     [3, 0, 0, 0, 7, 0, 0, 0, 4],
     [0, 0, 0, 0, 0, 1, 9, 0, 0],
     [0, 0, 0, 2, 0, 0, 0, 6, 0]]
    """
    pass
'''
For inferred, we go through every single spot in the board, if it doesn't have
a number, then we call value_by_single, if it returns a number then we
just assign it to the field. But, we need to do this multiple times because
after we loop the first time, there might be value_by_single that returns a number
after we assign numbers last time. Because of this, I just use a while loop
with the condition that the board before being looped is not the same
with the board after looped.
'''

def checkcomplete(board):
    """
    Input : a sudoku board
    Output: True if the board is completed, False otherwise
    """
    if board==[]:
        return False
    total=0
    allnumbersadded = ((len(board)/2)*(1+len(board)))* len(board)
    for a in range(len(board)):
        total+= sum(board[a])
    if total == allnumbersadded:
        return True
    return False

def minimumoptions(board):
    """
    Input : a sudoku board
    Output: a list with the length of 2 consisting of row and column indices
            that has the minimum number of options,
            the first element is always row and the second element is always
            columns.
    """
    import math
    minimum=math.inf
    for i in range(len(board)):
        for j in range(len(board)):
            if board[i][j]==0:
                if minimum> len(options(board,i,j)):
                    minimum=len(options(board,i,j))
                    a=i
                    b=j
    return [a,b]

def solve(board):
    """
    Input : a sudoku board
    Output: a solved sudoku board if the board is valid, False otherwise
    """
    # print_board(board)
    board = inferred(board)
    if checkcomplete(board):
        return board
    lst=minimumoptions(board)
    i,j=lst[0],lst[1]
    for opt in options(board,i,j):
        board[i][j]=opt
        if solve(board):
            return solve(board)
        else:
            board[i][j]=0
    return False

# Code for solve(board) is adapted from the youtube video made by Computerphile
#with the url of https://www.youtube.com/watch?v=G_UYXzGuqvM.
#How solve function works
'''
We return the board if it is already completed when it is inferred, then
we assign 1 option from options to index i,j to the board and then we call
the solve function again. If after going through every option, the board is not
completed we backtrack by changing the spot to 0.
'''
#How the selection works
'''
I think that we need to fill the field with the least options available first
because it has more chances of being correct. If the choice is correct,
then we do not need to change board[i][j] to another opt
as opposed to picking the wrong choice.
'''
#How inferred works in solve
'''
Inferrence works because we already know that the value
is correct when we inferred. This drastically reduces computational complexity
because we need to multiply len(options) for every single field if we do
not use it, while inferred is just looping through the board a few times.
'''

def generate(k):
    """
    Input: a value k (board size)
    Output: a valid unique sudoku board with size k**2*k**2
    """
    import random
    board=generate_board_valid(k)
    lst=solvegenerate(board)
    indexlist=[]
    value=0
    numbersintheboard=[]
    for i in range(k**2):
        indexlist.append(i)
    for j in range(k**3-k,k**3+k):
        numbersintheboard.append(j)
    random.shuffle(numbersintheboard)
    while numbersinboard(board)>numbersintheboard[0]:
        #print_board(board)
        random.shuffle(indexlist)
        i=indexlist[0]
        random.shuffle(indexlist)
        j=indexlist[0]
        value=board[i][j]
        board[i][j]=0
        lst=solvegenerate(board)
        if len(lst)>1:
            board[i][j]=value
    return board
'''
Even though we already have a board that is valid from
generateboardvalid, this program cannot use the unsolved version of it.
This is because this program does not know if the board is unique or not because of that
this program is coded into removing numbers randomly from the board
until numbersintheboard numbers are left. Numbersintheboard is a list that
has numbers from k**3-k to k**3+k,
then it is shuffled and the first element
is how many numbers there are going to be in the board.
This program also checks whether we have
a unique board or not after removing the numbers, if it is not unique, then
we return the number.
'''
def generate_board_random(k):
    """
    Input: a value k(board size)
    Output: a k**2*k**2 board with k**3 numbers filled
    """
    import random
    lst=[[0 for i in range(k**2)]for j in range(k**2)]
    numberslist=[]
    indexlist=[]
    empty=[]
    x=0
    empty=indexvalues(k)
    random.shuffle(empty)
    for i in range(1,k**2+1):
        numberslist.append(i)
        indexlist.append(i-1)
    numbersintheboard=k**3
    count=numbersinboard(lst)
    while count<numbersintheboard:
        random.shuffle(indexlist)
        a=indexlist[0]
        random.shuffle(indexlist)
        b=indexlist[0]
        while lst[a][b]!=0:
            a,b=empty[x][0],empty[x][1]
            x+=1
        x=0
        if options(lst,a,b)==[]:
            i=0
            lst=[[0 for i in range(k**2)]for j in range(k**2)]
        random.shuffle(numberslist)
        c=numberslist[0]
        while c not in options(lst,a,b):
            if c ==len(lst):
                c=1
            else:
                c+=1
        lst[a][b]=c
        count=numbersinboard(lst)
    # print_board(lst)
    return lst
'''
For generating a random board, this program first created an empty board then I
assign numbers randomly to a random index. this program did this until the board is
filled with numbers numbersintheboard times. This is because
we can already have a non-valid board when doing this process, when
it is non-valid, this program will reset the board to an empty one.
A non-valid board is defined as not having any option as we won't be able
to fill the entire board that way.
'''

def indexvalues(k):
    """
    Input: value (board size)
    Output: a list containing tuples of all possible index values.
            the first element in the tuple is row, the second element
            is column.
    """
    a=[]
    for i in range(k**2):
        for j in range(k**2):
            a.append((i,j))
    return a

def generate_board_valid(k):
    board=generate_board_random(k)
    while not solve(board):
        board=generate_board_random(k)
    return solve(board)
'''
Because generate_board_random can produce a board that is not valid, we need
to check if it is valid or not by using the solve function, if it is not
valid (not having a solution), then we generate another random board. This
continues until the board is valid and we returned the solved version of it.
'''
def numbersinboard(board):
    """
    Input: a sudoku board
    Output: how many numbers are filled inside the board
    """
    count=0
    for i in range(len(board)):
        for j in range(len(board)):
            if board[i][j]!=0:
                count+=1
    return count

def solvegenerate(board):
    """
    Input : a sudoku board
    Output: all the possible solutions of the sudoku board
    """
    # print_board(board)
    from copy import deepcopy
    copyboard=deepcopy(board)
    if checkcomplete(copyboard):
        return [copyboard]
    res=[]
    lst=minimumoptions(board)
    i,j=lst[0],lst[1]
    for opt in options(copyboard,i,j):
        res+=solvegenerate(copyboard[:i]+[copyboard[i][:j]+[opt]+copyboard[i][j+1:]]+copyboard[i+1:])
        if len(res)>1:
            return res
    return res
'''
solvegenerate function is used for producing at most 2 of the
solutions of a sudoku board since we only want a unique sudoku board. This
function is used in generate to check whether or not there is a unique solution
to a sudoku board
'''
#code for solvegenerate(board) adapted from lecture 10 slide 95

            
########### Driver code (executed when running module) #

import doctest
doctest.testmod()

#uncomment the line below to play via the console interface
#play(big)
