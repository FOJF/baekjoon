N, M = map(int, input().split())
r,c,d = map(int, input().split())

robot = {'x': r, 'y': c, 'dir': d}

room = [list(map(int, input().split())) for i in range(N)]

delta = [(-1, 0), (0, 1), (1, 0), (0, -1)]

answer = 0
while True:
	if room[robot['x']][robot['y']] == 0:
		room[robot['x']][robot['y']] = 2
		answer += 1

	flag = False
	for i in range(4):
		next_dir = (robot['dir'] + 3 - i) % 4
		next_x = robot['x'] + delta[next_dir][0]
		next_y = robot['y'] + delta[next_dir][1]
		
		if room[next_x][next_y] == 0:
			robot['x'] = next_x
			robot['y'] = next_y
			robot['dir'] = next_dir
			flag = True
			break

	if flag: continue

	if not room[robot['x']-delta[robot['dir']][0]][robot['y']-delta[robot['dir']][1]] == 1:
		robot['x'] -= delta[robot['dir']][0]
		robot['y'] -= delta[robot['dir']][1]
	else:
		break

print(answer)