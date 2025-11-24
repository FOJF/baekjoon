N, M = map(int, input().split())

nums = list(map(int, input().split()))
nums.sort()

answer = []

def bt(nums, answer, M, picked=[], start=0):
	if len(picked) == M:
		if picked not in answer:
			answer.append(picked.copy())
		return

	for i in range(start, len(nums)):
		picked.append(nums[i])
		bt(nums, answer, M, picked, i)
		picked.pop()

bt(nums, answer, M)

print("\n".join(" ".join(str(a) for a in an) for an in answer))