import java.io.*;
import java.util.*;

public class Main2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());

		int[][][] box = new int[h][n][m];

		Queue<int[]> bfsQ = new ArrayDeque<>();
		int cnt = n*m*h;

		for(int i = 0; i < h; i++) {
			for(int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < m; k++) {
					int a = Integer.parseInt(st.nextToken());

					if (a == 0) continue;

					if (a == 1) bfsQ.add(new int[]{i,j,k});

					box[i][j][k] = a;
					cnt--;
				}
			}
		}

		int answer = 0;

		int[][] delta = {{0,0,1},{0,0,-1},{0,1,0},{0,-1,0},{1,0,0},{-1,0,0}};

		while(!bfsQ.isEmpty()) {
			int[] cur = bfsQ.poll();

			for (int[] dir : delta) {
				int nX = cur[1] + dir[1];
				int nY = cur[2] + dir[2];
				int nZ = cur[0] + dir[0];

				if (0<=nX && nX<n && 0<=nY && nY<m && 0<=nZ && nZ<h && box[nZ][nX][nY]==0) {
					bfsQ.add(new int[]{nZ,nX,nY});
					box[nZ][nX][nY] = box[cur[0]][cur[1]][cur[2]]+1;
					cnt--;
					answer = Math.max(box[nZ][nX][nY]-1, answer);
				}
			}
		}

		System.out.println(cnt==0 ? answer : -1);

	}
}