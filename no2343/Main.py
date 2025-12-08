N, M = map(int, input().split())

lectures = list(map(int, input().split()))

l, r = max(lectures), sum(lectures)
answer = r

while l <= r:
	mid = (l + r) // 2
	
	cnt = 1
	size = 0

	for lec in lectures:
		size += lec
		if size > mid:
			size = lec
			cnt += 1

	if cnt > M:
		l = mid + 1
	else:
		answer = min(answer, mid)
		r = mid - 1

print(answer)