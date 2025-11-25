s = list(input())

st = []
for c in s:
	if c == ')' and st and st[-1] == '(':
			st.pop()
	else:
		st.append(c)

print(len(st))