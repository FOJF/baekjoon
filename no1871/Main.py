r = ['not nice', 'nice']
for _ in range(int(input())):
	f, s = input().split("-")

	f = list(f)
	a = sum((ord(f[i])-ord('Z')+25) * (26**(len(f)-i-1)) for i in range(len(f)))
		
	print(r[abs(a-int(s)) <= 100])