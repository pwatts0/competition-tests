import path
import math

path = path.j_input + "Prob05.in.txt"
file = open(path, "r")
amt = int(file.readline())

for i in range(0, amt):
	print(file.readline()[0:-1] + ":")
	sa = int(file.readline())
	output = []
	for i2 in range(0, sa):
		line = file.readline()
		info = line.split(' ')
		pc = ((round((float(info[0]) / 10000.0), 1)) * 10000.0)
		output.append(info[1][0:-1] + " " + ('*' * int(pc / 1000.0)))
	output.sort(key = lambda s: int(s.split(' ')[0]))
	for out in output:
		print(out)
