import path

path = path.ex_input + "Prob03.in.txt"
file = open(path, "r")
amt = int(file.readline())

for i in range(0, amt):
	sub_amt = int(file.readline())
	for i2 in range(0, sub_amt):
		y = int(file.readline())
		if (y < 1582):
			print("No")
		elif (y % 4 != 0):
			print("No")	
		elif (y % 100 != 0):
			print("Yes")
		elif (y % 400 != 0):
			print("No")
		else:
			print("Yes")
