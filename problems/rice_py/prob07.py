import path

path = path.j_input + "Prob07.in.txt"
file = open(path, "r")
amt = int(file.readline())

# ship data Touple format (name, x, y)
for i in range(0, amt):
	s_amt = int(file.readline())
	ships = []
	# Read ships
	for i2 in range(0, s_amt):
		line = file.readline()[0:-1]
		cords = line.split(":")[1]
		ships.append((line.split(":")[0], int(cords.split(",")[0]), int(cords.split(",")[1])))
	# Do Sim 
	while(len(ships) != 0):
		# distroy ship
		s = min(ships, key = lambda x: abs(x[1]) - abs(x[2]))
		(d_name, d_x, d_y) = s
		print("Destroyed Ship: " + d_name.split("_")[0] + " xLoc: " + str(d_x))
		ships.remove(s)
		# step ships
		for i2 in range(0, len(ships)):
			(name, x, y) = ships[i2]
			s_type = name.split("_")[1]
			if s_type == "A":
				if x > 0:
					x -= 10
				else:
					x += 10
			elif s_type == "B":
				if x > 0:
					x -= 20
				else:
					x += 20
			elif s_type == "C":
				if x > 0:
					x -= 30
				else:
					x += 30
			ships[i2] = (name, x, y)
			
