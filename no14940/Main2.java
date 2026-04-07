import java.io.*;
import java.util.*;

public class Main2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		boolean[][] grid = new boolean[n][m];
		int[][] dist = new int[n][m];
		int[] start = { -1, -1 };

		for(int i = 0; i < n; i++) {
			String s = br.readLine();
			for(int j = 0; j < m; j++) {
				char c = s.charAt(j * 2);
				grid[i][j] = (c != '0');

				if (c == '2') {
					start[0] = i;
					start[1] = j;
				} else if (c == '0') {
					dist[i][j] = 1;
				}
			}
		}

		int[][] delta = {{1,0}, {-1,0}, {0,1}, {0,-1}};
		Queue<int[]> bfsQ = new ArrayDeque<>();

		bfsQ.add(start);
		dist[start[0]][start[1]] = 1;

		while(!bfsQ.isEmpty()) {
			int[] cur = bfsQ.poll();

			for(int[] dir : delta) {
				int nX = dir[0] + cur[0];
				int nY = dir[1] + cur[1];

				if (0 <= nX && nX < n && 0 <= nY && nY < m && grid[nX][nY] && dist[nX][nY] == 0) {
					bfsQ.add(new int[]{nX, nY});
					dist[nX][nY] = dist[cur[0]][cur[1]] + 1;
				}
			}
		}

		StringBuilder sb = new StringBuilder();

		for(int[] dis : dist) {
			for(int d : dis) {
				sb.append(d-1).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}
}