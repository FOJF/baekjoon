x = int(input())

t_floors = 0
sum = 0

while sum < x :
	t_floors += 1
	sum += t_floors

offset = sum - x

if t_floors % 2 == 0 :
	print(f"{t_floors-offset}/{1+offset}")
else :
	print(f"{1+offset}/{t_floors-offset}")