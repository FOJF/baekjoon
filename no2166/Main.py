N = int(input())

points = [list(map(int, input().split())) for _ in range(N)]

points.append(points[0])

print(round(abs(sum(points[i][0] * points[i+1][1] - points[i+1][0] * points[i][1] for i in range(len(points)-1))/2),1))