import path

path = path.j_input + "Prob09.in.txt"
file = open(path, "r")

amt = int(file.readline())

def do_x(data):
    for d in reversed(data):
        print(str(d))

def do_y(data):
    temp = list(data)
    temp.sort(key = lambda x: len(x))
    max_l = len(temp[len(temp) - 1])
    for d in data:
        print(str(d)[::-1].rjust(max_l, ' '))

def do_i(data):
    run = True
    i = 0
    while run:
        line = ""
        e = 0
        for d in data:
            try:
                line += d[i]
            except IndexError:
                line += " "
                e += 1
            if e == len(data):
                run = False
        if run == False:
            break
        print(line)
        i += 1

op = {"X" : do_x, "Y" : do_y, "INVERSE" : do_i}

for i in range(0, amt):
    s_amt = int(file.readline()[0:-1])
    data = []
    for i2 in range(0, s_amt):
        data.append(file.readline()[0:-1])
    op[file.readline()[0:-1]](data)
print("done")
