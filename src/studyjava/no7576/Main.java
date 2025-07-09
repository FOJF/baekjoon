package studyjava.no7576;

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

	static Queue<Point> bfsQ = new LinkedList<>();
	
	static int m;
	static int n;

	static int[][] tray;
	static boolean[][] isVisited;

	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
        tray = new int[n][m];
		isVisited = new boolean[n][m];
        
		for (int i = 0; i < tray.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < tray[i].length; j++) {
                int tomato = Integer.parseInt(st.nextToken());
				if (tomato == 1) bfsQ.add(new Point(i,j));
				tray[i][j] = tomato;
			}
		}
		br.close();

		bfs();

		int max = 0;
		for (int i = 0; i < tray.length; i++) {
			for (int j = 0; j < tray[i].length; j++) {
				if (tray[i][j] == 0) {System.out.println("-1"); return;}
				max = Math.max(max, tray[i][j]);
			}
		}
		System.out.println(max-1);
	}

	public static void bfs() {
		int[][] delta = {{1,0},{-1,0},{0,1},{0,-1}};
		while(!bfsQ.isEmpty()) {
			Point cur = bfsQ.poll();

			for (int[] dir : delta) {
				int nextX = cur.x + dir[0];
				int nextY = cur.y + dir[1];
				if (isValidIdx(nextX,nextY)) {
					bfsQ.add(new Point(nextX, nextY));
					tray[nextX][nextY] = tray[cur.x][cur.y]+1;
				}
			}
		}
	}

	public static boolean isValidIdx(int x, int y) {
		return (0 <= x && x < n) && (0 <= y && y < m) && tray[x][y]==0;
	}
}