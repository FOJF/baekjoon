sum = 0
heights = {'Es': 21, 'Stair': 17}
for _ in range(4):
	t, h = input().split()
	sum += heights[t]*int(h)
print(sum)