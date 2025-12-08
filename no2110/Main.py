import sys
input = sys.stdin.readline

N, C = map(int, input().split())

houses = [int(input()) for _ in range(N)]

houses.sort()

l, r = 1, houses[-1]-houses[0]

answer = 1

while l <= r:
	mid = (l+r)//2

	cnt = 1

	last_idx = 0

	for i in range(1, len(houses)):
		if houses[i] - houses[last_idx] >= mid:
			cnt += 1
			last_idx = i

	if cnt >= C:
		l = mid+1
		answer = mid
	else:
		r = mid-1

print(answer)