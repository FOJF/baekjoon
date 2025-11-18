package studyjava.no10026;

import java.io.*;
import java.util.*;

public class Main {
	static class Point {
		int x, y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static char[][] board;
	static boolean[][] isVisitedForNormal;
	static boolean[][] isVisitedForColorBlind;
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		board = new char[n][n];
		isVisitedForNormal = new boolean[n][n];
		isVisitedForColorBlind = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j = 0; j < n; j++) {
				board[i][j] = input[j];
			}
		}

		br.close();

		int[] count = new int[2]; // 0 normal, 1 colorblind
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!isVisitedForNormal[i][j]) {bfs(new Point(i,j), false); count[0]++;}
				if (!isVisitedForColorBlind[i][j]) {bfs(new Point(i,j), true); count[1]++;}
			}
		}
		System.out.println(count[0] + " " + count[1]);
	}

	public static void bfs(Point start, boolean isColorBlind) {
		int[][] delta = {{0,-1},{0,1},{-1,0},{1,0}};

		Queue<Point> bfsQ = new LinkedList<>();
        boolean[][] visited = isColorBlind ? isVisitedForColorBlind : isVisitedForNormal;

        bfsQ.add(start);
        visited[start.x][start.y] = true;

        while (!bfsQ.isEmpty()) {
            Point cur = bfsQ.poll();

            for (int[] dir : delta) {
                int newX = cur.x + dir[0];
                int newY = cur.y + dir[1];

                if (hasIdx(newX, newY) && !visited[newX][newY] && isSameColor(board[start.x][start.y], board[newX][newY], isColorBlind)) {
                        bfsQ.add(new Point(newX, newY));
                        visited[newX][newY] = true;
                }
            }
        }
	}

    public static boolean isSameColor(char a, char b, boolean isColorBlind) {
        if (!isColorBlind) return a == b;
        
        if (a == 'B') return b == 'B';
        return b != 'B';
    }

    public static boolean hasIdx(int x, int y) {
        return (0 <= x && x < n) && (0 <= y && y < n);
    }
}