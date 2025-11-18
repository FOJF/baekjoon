import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[][] grid = new int[N][N];

		Set<Integer> heights = new HashSet<>();

		for(int i = 0; i < N; i++) {
			grid[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			for (int height : grid[i]) {
				heights.add(height);
			}
		}

		br.close();

		int[][] visited = new int[N][N];

		int[][] delta = {{1,0},{0,1},{-1,0},{0,-1}};

		int answer = 1;

		Queue<int[]> q = new LinkedList<>();

		for(int h : heights) {
			int safeArea = 0;

			for(int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (grid[i][j] <= h || visited[i][j] == h) continue;

					safeArea++;

					q.add(new int[]{i, j});
					visited[i][j] = h;

					while(!q.isEmpty()) {
						int[] cur = q.poll();

						for(int[] dir : delta) {
							int nI = cur[0] + dir[0];
							int nJ = cur[1] + dir[1];

							if (0 <= nI && nI < N && 0 <= nJ && nJ < N && grid[nI][nJ] > h && visited[nI][nJ] != h) {
								q.add(new int[]{nI, nJ});
								visited[nI][nJ] = h;
							}
						}
					}

				}
			}
			answer = Math.max(answer, safeArea);
		}

		System.out.println(answer);
	}
}