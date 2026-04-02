import java.util.*;
import java.io.*;

public class Main2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		boolean[][] grid = new boolean[N][M];
		int[][] dist = new int[N][M];

		for(int i = 0; i < N; i++) {
			char[] c = br.readLine().toCharArray();
			for(int j = 0; j < c.length; j++) {
				grid[i][j] = c[j] == '1';
			}
		}

		Queue<int[]> bfsQ = new LinkedList<>();

		bfsQ.add(new int[]{0,0});
		dist[0][0] = 1;

		int[][] delta = {{1,0}, {0,1}, {-1,0}, {0,-1}};

		while(!bfsQ.isEmpty()) {
			int[] cur = bfsQ.poll();

			for(int[] dir : delta) {
				int nX = cur[0] + dir[0];
				int nY = cur[1] + dir[1];

				if (0 <= nX && nX < N && 0 <= nY && nY < M && dist[nX][nY] == 0 && grid[nX][nY]) {
					dist[nX][nY] = dist[cur[0]][cur[1]] + 1;
					bfsQ.add(new int[]{nX, nY});
				}

				if (nX == N-1 && nY == M-1) {
					System.out.println(dist[nX][nY]);
					return;
				}
			}
		}
	}
}