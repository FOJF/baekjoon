package studyjava.no2667;

import java.io.*;
import java.util.*;

public class Main {
	public static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int getX() {
			return this.x;
		}

		public int getY() {
			return this.y;
		}
	}
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		boolean[][] isVisited = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			String[] input = br.readLine().split("");
			for (int j = 0; j < n; j++) {
				isVisited[i][j] = input[j].equals("0");
			}
		}

		br.close();

		// System.out.println(Arrays.deepToString(isVisited));
		int count = 0;
		List<Integer> aptCnts = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (isVisited[i][j]) continue;
				count++;
				aptCnts.add(getApartmentCnt(isVisited, new Point(i,j)));
				
			}
		}
		System.out.println(count);

		Collections.sort(aptCnts);
		
		for (int cnt : aptCnts) {
			System.out.println(cnt);
		}
	}

	public static int getApartmentCnt (boolean[][] isVisited, Point startPoint) {
		int n = isVisited.length;
		int[][] delta = {{1,0},{-1,0},{0,1},{0,-1}};

		Queue<Point> bfsQ = new LinkedList<>();

		bfsQ.add(startPoint);
		isVisited[startPoint.getX()][startPoint.getY()] = true;

		int cnt = 0;
		while(!bfsQ.isEmpty()) {
			Point cur = bfsQ.poll();
			cnt++;

			for (int[] dir : delta) {
				int nextX = cur.getX() + dir[0];
				int nextY = cur.getY() + dir[1];

				if (0 <= nextX && nextX < n && 0 <= nextY && nextY < n && !isVisited[nextX][nextY]) {
					bfsQ.add(new Point(nextX, nextY));
					isVisited[nextX][nextY] = true;
				}
			}
		}

		return cnt;
	}
}