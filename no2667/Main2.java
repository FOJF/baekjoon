import java.io.*;
import java.util.*;

public class Main2{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		boolean[][] grid = new boolean[N][N];
		boolean[][] visited = new boolean[N][N];

		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
    			grid[i][j] = (s.charAt(j) == '1');
			}
		}

		int[][] delta = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
		Queue<int[]> bfsQ = new LinkedList<>();

		List<Integer> answer = new ArrayList<>();

		for(int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!grid[i][j] || visited[i][j]) continue;

				bfsQ.add(new int[]{i,j});
				visited[i][j] = true;

				int cnt = 1;

				while(!bfsQ.isEmpty()) {
					int[] cur = bfsQ.poll();

					for(int[] dir : delta) {
						int nX = cur[0] + dir[0];
						int nY = cur[1] + dir[1];

						if (0 <= nX && nX < N && 0 <= nY && nY < N && grid[nX][nY] && !visited[nX][nY]) {
							bfsQ.add(new int[]{nX, nY});
							visited[nX][nY] = true;
							cnt++;
						}
					}
				}

				answer.add(cnt);
			}
		}

		StringBuilder sb = new StringBuilder();

		sb.append(answer.size()).append("\n");

		answer.sort((a,b) -> a-b);

		for(int a : answer) {
			sb.append(a).append("\n");
		}

		System.out.println(sb);
	}
}