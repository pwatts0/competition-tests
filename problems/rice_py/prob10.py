import path

pl = [0, 0]

lengo = {
    0 : "love",
    1 : "15",
    2 : "30",
    3 : "40"
}

def p_score():
    if pl[0] == pl[1] and pl[0] < 3:
        print()

path = path.ex_input + "Prob10.in.txt"
file = open(path, "r")
amt = int(file.readline())

