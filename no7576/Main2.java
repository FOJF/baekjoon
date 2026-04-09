import java.io.*;
import java.util.*;

public class Main2 {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		int[][] box = new int[n][m];

		int cnt = n*m;

		Queue<int[]> bfsQ = new ArrayDeque<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			// System.out.println(st);
			for (int j = 0; j < m; j++) {
				int a = Integer.parseInt(st.nextToken());
				if (a == 0) continue;

				if (a == 1) {
					bfsQ.add(new int[]{i,j});
				}

				box[i][j] = a;
				cnt--;
			}
		}

		int[][] delta = {{1,0},{-1,0},{0,1},{0,-1}};

		int answer = 0;

		while(!bfsQ.isEmpty()) {
			int[] cur = bfsQ.poll();

			for (int[] dir : delta) {
				int nX = cur[0] + dir[0];
				int nY = cur[1] + dir[1];

				if (0<=nX && nX<n && 0<=nY && nY<m && box[nX][nY]==0) {
					bfsQ.add(new int[]{nX,nY});
					box[nX][nY] = box[cur[0]][cur[1]] + 1;
					answer = Math.max(answer, box[nX][nY]-1);
					cnt--;
				}
			}
		}

		System.out.println(cnt > 0 ? -1 : answer);
	}
}