import path
import copy

pl = [-1, -1]

lengo = {
    0 : "love",
    1 : "15",
    2 : "30",
    3 : "40"
}

def p_score():
    if pl[0] == pl[1]:
        if pl[0] < 3:
            print(lengo[pl[0]] + "-all")
        else:
            print("deuce")
    elif pl[0] > 3 or pl[1] > 3:
        if abs(pl[0] - pl[1]) == 2:
            do_win()
        elif pl[0] == pl[1]:
            print("deuce")
        elif pl[0] > pl[1]:
            print("Advantage Player 1")
        else:
            print("Advantage Player 2")
    else:
        print(lengo[pl[0]] + "-" + lengo[pl[1]])

def do_win():
    if pl[0] > pl[1]:
        print("Game Player 1")
    else:
        print("Game Player 2")
    for i in range(0, 2):
        pl[i] = -1

path = path.j_input + "Prob10.in.txt"
file = open(path, "r")

while True:
    try:
        pl[int(file.readline()) - 1] += 1
        if pl[0] == -1 or pl[1] == -1:
            pl[0] += 1
            pl[1] += 1
            print("Game start")
    except ValueError:
        break
    if (pl[0] == 4 or pl[1] == 4) and (pl[0] + pl[1]) < 7:
        do_win()
        continue
    p_score()