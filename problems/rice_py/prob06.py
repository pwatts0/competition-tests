import path

path = path.j_input + "Prob06.in.txt"
file = open(path, "r")
amt = int(file.readline())

def scan_grid(letter, grid, r, c):
	finds = []
	try:
		if letter == grid[r + 1][c]:
			finds.append(str(r + 1) + " " + str(c))
	except IndexError:
		pass
	try:
		if letter == grid[r + 1][c + 1]:
			finds.append(str(r + 1) + " " + str(c + 1))
	except IndexError:
		pass
	try:
		if letter == grid[r][c + 1]:
			finds.append(str(r) + " " + str(c + 1))
	except IndexError:
		pass
	try:
		if letter == grid[r - 1][c + 1]:
			finds.append(str(r - 1) + " " + str(c + 1))
	except IndexError:
		pass
	try:
		if letter == grid[r - 1][c]:
			finds.append(str(r - 1) + " " + str(c))
	except IndexError:
		pass
	try:
		if letter == grid[r - 1][c - 1]:
			finds.append(str(r - 1) + " " + str(c - 1))
	except IndexError:
		pass
	try:
		if letter == grid[r][c - 1]:
			finds.append(str(r) + " " + str(c - 1))
	except IndexError:
		pass
	try:
		if letter == grid[r + 1][c - 1]:
			finds.append(str(r + 1) + " " + str(c - 1))
	except IndexError:
		pass

	return finds
	
def find_word(word, pos, grid, r_l, c_l):
	if pos == 0:
		for r in range(0, len(grid)):
			for c in range(0, len(grid[r])):
				if grid[r][c] == word[pos]:
					rtn = find_word(word, pos + 1, grid, r, c)
					if rtn == "FOUND":
						return rtn
		return "NOT_FOUND"
	else:
		if pos == len(word):
			return "FOUND"

		finds = scan_grid(word[pos], grid, r_l, c_l)
		
		for f in finds:
			r = int(f.split(" ")[0])
			c = int(f.split(" ")[1])
			if r < 0 or c < 0:
				continue
			rtn = find_word(word, pos + 1, grid, r, c)
			if rtn == "FOUND":
				return rtn
		return "NOT_FOUND"
			
			
for i in range(0, amt):
	line = file.readline()[0:-1]
	rows = int(line.split(" ")[0])
	cols = int(line.split(" ")[1])
	grid = []
	for i2 in range(0, rows):
		grid.append(file.readline().replace(" ", "")[0:-1])
	w_amt = int(file.readline())
	for i2 in range(0, w_amt):
		word = file.readline()[0:-1]
		if find_word(word, 0, grid, 0, 0) == "FOUND":
			print(word)
	
