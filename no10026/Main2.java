import java.io.*;
import java.util.*;

public class Main2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		char[][] grid = new char[N][];

		for(int i = 0; i < N; i++) {
			grid[i] = br.readLine().toCharArray();
		}
		
		int cnt = 0;
		int cbCnt = 0;

		int[][] delta = {{0,1},{0,-1},{1,0},{-1,0}};
		
		boolean[][] visited = new boolean[N][N];
		boolean[][] cbVisited = new boolean[N][N];

		Queue<int[]> bfsQ = new ArrayDeque<>();
		Queue<int[]> cbBfsQ = new ArrayDeque<>();

		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if (grid[i][j] == 'B') {
					if (visited[i][j]) continue;

					bfsQ.add(new int[]{i,j});
					
					visited[i][j] = true;
					cbVisited[i][j] = true;
					cnt++;
					cbCnt++;

					while(!bfsQ.isEmpty()) {
						int[] cur = bfsQ.poll();
						for(int[] dir : delta) {
							int nX = cur[0] + dir[0];
							int nY = cur[1] + dir[1];
							if (0<=nX && nX<grid.length && 0<=nY && nY<grid.length && !visited[nX][nY] && grid[nX][nY] == 'B') {
								bfsQ.add(new int[]{nX,nY});
								visited[nX][nY] = true;
								cbVisited[nX][nY] = true;
							}
						}
					}
				} else {
					if (!visited[i][j]) {
						bfsQ.add(new int[]{i,j});

						visited[i][j] = true;
						cnt++;

						while(!bfsQ.isEmpty()) {
							int[] cur = bfsQ.poll();
							for(int[] dir : delta) {
								int nX = cur[0] + dir[0];
								int nY = cur[1] + dir[1];
								if (0<=nX && nX<grid.length && 0<=nY && nY<grid.length && !visited[nX][nY] && grid[nX][nY] == grid[i][j]) {
									bfsQ.add(new int[]{nX,nY});
									visited[nX][nY] = true;
								}
							}
						}
					}

					if (!cbVisited[i][j]) {
						cbBfsQ.add(new int[]{i,j});

						cbVisited[i][j] = true;
						cbCnt++;

						while(!cbBfsQ.isEmpty()) {
							int[] cur = cbBfsQ.poll();
							for(int[] dir : delta) {
								int nX = cur[0] + dir[0];
								int nY = cur[1] + dir[1];
								if (0<=nX && nX<grid.length && 0<=nY && nY<grid.length && !cbVisited[nX][nY] && grid[nX][nY] != 'B') {
									cbBfsQ.add(new int[]{nX,nY});
									cbVisited[nX][nY] = true;
								}
							}
						}
					}
				}
				
			}
		}

		System.out.println(cnt + " " + cbCnt);
	}
}