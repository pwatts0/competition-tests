import path

def print_m(name):
	m = ""
	names = name.split(' ')
	for n in names: 
		m += n[0]
	n_m = m[0]
	n_m += m[2]
	n_m += m[1]	
	print(n_m.upper())

input = path.j_input + "Prob01.in.txt"
file = open(input, "r");
amt = int(file.readline());

for i in range(0, amt):
	sub_test_a = int(file.readline())
	for i2 in range(0, sub_test_a):
		line = file.readline()
		print_m(line)
