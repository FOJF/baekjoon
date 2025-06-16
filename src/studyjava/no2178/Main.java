import java.io.*;
import java.util.*;

public class Main {
	public static class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int getX() {
            return this.x;
        }

        int getY() {
            return this.y;
        }
    }

	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");

		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);

		int[][] board = new int[n][m];

		for (int i = 0; i < n; i++) {
			input = br.readLine().split("");
			for (int j = 0; j < m; j++) {
				board[i][j] = Integer.parseInt(input[j]);
			}
		}
		br.close();



		System.out.println(findExit(board));
	}

	public static int findExit(int[][] board) {
		int[][] delta = {{1,0},{-1,0},{0,1},{0,-1}};

		int[][] distance = new int[board.length][board[0].length];
		for (int [] arr : distance)
		Arrays.fill(arr, Integer.MAX_VALUE);
		
		Queue<Point> bfsQ = new LinkedList<>();

		bfsQ.add(new Point(0,0));
		distance[0][0] = 1;

		while(!bfsQ.isEmpty()) {
			Point cur = bfsQ.poll();

			for (int[] dir : delta) {
				int nextX = cur.getX() + dir[0];
				int nextY = cur.getY() + dir[1];
				if (0 <= nextX && nextX < board.length && 0 <= nextY && nextY < board[0].length && board[cur.getX()][cur.getY()] != 0
				 &&
				 distance[nextX][nextY] > distance[cur.getX()][cur.getY()]+1) {
					bfsQ.add(new Point(nextX, nextY));
					distance[nextX][nextY] = distance[cur.getX()][cur.getY()]+1;
				}
			}
		}

		return distance[distance.length-1][distance[0].length-1];
	}
}