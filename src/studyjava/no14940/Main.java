import java.io.*;
import java.util.*;

public class Main {
	static class Point {
		public int x;
		public int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int n;
	static int m;
	static int[][] board;
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);

		board = new int[n][m];
		Point start = null;
		for (int i = 0; i < n; i++) {
			input = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				board[i][j] = Integer.parseInt(input[j]);
				if (board[i][j] == 2) start = new Point(i,j);
			}
		}
		br.close();

		int[][] distanceBoard = getDistanceBoard(start);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int num = distanceBoard[i][j];
				if (board[i][j] == 0) num = 0;
				else if (num == Integer.MAX_VALUE) num = -1;
				
				sb.append(num).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}

	public static int[][] getDistanceBoard(Point start) {
		int[][] delta = {{1,0}, {-1,0}, {0,1}, {0,-1}};
		int[][] answer = new int[n][m];

		for (int i = 0; i < n; i++) {
			Arrays.fill(answer[i], Integer.MAX_VALUE);
		}

		Queue<Point> bfsQ = new LinkedList<>();

		bfsQ.offer(start);
		answer[start.x][start.y] = 0;

		while (!bfsQ.isEmpty()) {
			Point cur = bfsQ.poll();

			for (int[] dir : delta) {
				int nextX = cur.x + dir[0];
				int nextY = cur.y + dir[1];

				if (0 <= nextX && nextX < n && 0 <= nextY && nextY < m && answer[nextX][nextY] > answer[cur.x][cur.y]+1 && board[nextX][nextY] != 0) {
					bfsQ.add(new Point(nextX, nextY));
					answer[nextX][nextY] = answer[cur.x][cur.y]+1;
				}
			}
		}
		return answer;
	}
}