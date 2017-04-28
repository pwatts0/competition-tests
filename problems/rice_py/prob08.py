import path

path = path.j_input + "Prob08.in.txt"
file = open(path, "r")
amt = int(file.readline())

for i in range(0, amt):
    s_amt = int(file.readline())
    for i2 in range(0, s_amt):
        name = file.readline()[0:-1]
        p0 = file.readline()[0:-1]
        p1 = file.readline()[0:-1]
        p2 = file.readline()[0:-1]
        rise = (float(p1.split(",")[1]) - float(p0.split(",")[1]))
        run = (float(p1.split(",")[0]) - float(p0.split(",")[0]))
        slope = float(rise / run)
        if slope <= -.8 and slope >= -1.6:
            rise = (float(p2.split(",")[1]) - float(p0.split(",")[1]))
            run = (float(p2.split(",")[0]) - float(p0.split(",")[0]))
            slope = float(rise / run)
            if slope <= -.8 and slope >= -1.6:
                print(name + str(", Clear To Land!"))
            else:
                print(name + str(", Abort Landing!"))
        else:
            print(name + str(", Abort Landing!"))