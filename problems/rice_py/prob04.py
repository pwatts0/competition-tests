import path
import math

def c(f):
	return float((5.0 / 9.0) * (f - 32.0))

def f(c):
	return float((((9.0 / 5.0) * c) + 32.0))

path = path.j_input + "Prob04.in.txt"
file = open(path, "r")
amt = int(file.readline())

for i in range(0, amt):
	sa = int(file.readline())
	for i2 in range(0, sa):
		line = file.readline()
		line = line[0:len(line) - 1]
		b = line.split(' ')
		if (b[1] == "F"):
			new = c(float(b[0]))
			print(line + " = " + str(math.ceil(new * 10) / 10) + " C")
		else:
			new = f(float(b[0]))
			print(line + " = " + str(math.ceil(new * 10) / 10) + " F")
			
		
