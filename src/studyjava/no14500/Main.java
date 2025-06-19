import java.io.*;
import java.util.*;

public class Main {
	static class Point {
		public int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int n;
	static int m;
	static int[][] board;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		board = new int[n][m];

		for (int i = 0; i < n; i++) {
			board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}

		br.close();

		int max = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				max = Math.max(max, bfs(new Point(i,j)));
			}
		}

		System.out.println(max);
	}

	// TODO : bfs로 하니까 되는 지 확인도 못하고 시간 초과 발생, dfs로 해봐야하나....?
	// 그리고 ㅗ 모양도 추가적으로 검사해야함(bfs로 검사하고 대충 모양만들어서 추가로 검사해주려고 했는데)
	// bfs자체만으로도 시간초과 발생해버림
	// ->> dfs도전해봐야겠다 
	public static int bfs(Point startP) {
		int[][] delta = {{1,0},{-1,0},{0,1},{0,-1}};
		boolean[][] isVisited = new boolean[n][m];

		Queue<Point> bfsQ = new LinkedList<>();

		bfsQ.add(startP);
		isVisited[startP.x][startP.y] = true;

		int depth = 0;
		int sum = board[startP.x][startP.y];

		// System.out.println("---------------------------------");

		while(depth < 3) {
			Point cur = bfsQ.poll();

			int max = 0;
			Point next = null;

			for (int[] dir : delta) {
				int nextX = cur.x + dir[0];
				int nextY = cur.y + dir[1];

				if ((0 <= nextX && nextX < n) && (0 <= nextY && nextY < m) && !isVisited[nextX][nextY] && max < board[nextX][nextY]) {
					max = board[nextX][nextY];
					next = new Point(nextX, nextY);
				}
			}

			isVisited[next.x][next.y] = true;

 			if (next == null) {
 				bfsQ.add(cur);
 				continue;
 			}
			
			bfsQ.add(next);
			sum += max;
			// System.out.println(sum + " " + max + " " + next.x + " " + next.y);
			depth++;
		}

		return sum;
	}
}

/*
3 3
0 5 6
6 4 0
0 6 0
*/