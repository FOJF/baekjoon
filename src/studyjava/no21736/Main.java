import java.io.*;
import java.util.*;

public class Main {
	static class Point {
		int x;
		int y;

		public Point (int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int getX() {
			return this.x;
		}

		public int getY() {
			return this.y;
		}

		public void setXY(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}


	static int[][] board;
	static boolean[][] isVisited;
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");

		final int N = Integer.parseInt(input[0]);
		final int M = Integer.parseInt(input[1]);

		board = new int[N][M];
		isVisited = new boolean[N][M];

		Point startP = null;

		for (int i = 0; i < N; i++) {
			input = br.readLine().split("");
			for (int j = 0; j < input.length; j++) {
				board[i][j] = switch(input[j]) {
					case "X" -> -1;
					case "I" -> 1;
					case "P" -> 2;
					default -> 0;
				};
				if (board[i][j] == 1) startP = new Point(i,j);
			}
		}
		br.close();

		// System.out.println(Arrays.deepToString(board));
		System.out.println(getCntFriend(startP));

	}

	public static String getCntFriend(Point startP) {
		int[][] delta = {{1,0},{-1,0},{0,1},{0,-1}};
		
		Queue<Point> bfsQ = new LinkedList<>();

		bfsQ.add(startP);
		isVisited[startP.getX()][startP.getY()] = true;

		int countFriend = 0;

		while(!bfsQ.isEmpty()) {
			Point cur = bfsQ.poll();
			int curX = cur.getX();
			int curY = cur.getY();

			if (board[curX][curY] == 2) countFriend++;

			for(int[] dir : delta) {
				int nextX = curX + dir[0];
				int nextY = curY + dir[1];
				if ((0 <= nextX && nextX < board.length) && (0 <= nextY && nextY < board[0].length) 
					&& !isVisited[nextX][nextY] && board[nextX][nextY] != -1) {
					bfsQ.add(new Point(nextX, nextY));
					isVisited[nextX][nextY] = true;
				}
			}

		}

		return countFriend == 0 ? "TT" : String.valueOf(countFriend);
	}
}