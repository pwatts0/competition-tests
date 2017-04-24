import path

path = path.j_input + "Prob02.in.txt"
file = open(path, "r")
amt = int(file.readline())

for i in range(0, amt):
	sub_amt = int(file.readline())
	sum = 0
	for i2 in range(0, sub_amt):
		sum += int(file.readline())
	print(str(sum))
