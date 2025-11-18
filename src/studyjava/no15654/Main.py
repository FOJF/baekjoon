N, M = map(int, input().split())
data = list(map(int, input().split()))
data.sort()

picked = []

def bt(picked, data, M) :
	if len(picked) == M :
		for p in picked :
			print(p, end=" ")
		print()
		return

	for d in data :
		if not d in picked :
			picked.append(d)
			bt(picked, data, M)
			picked.pop()

bt(picked, data, M)

###### 개쩌는 코드(https://www.acmicpc.net/source/80129200) ######

from itertools import permutations
N, M = map(int, input().split())
data = list(map(int, input().split()))
data.sort()
print('\n'.join(map(' '.join, permutations(map(str, data), M))))