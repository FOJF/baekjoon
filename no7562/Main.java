import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		int[][] delta = {{1,2},{2,1},{1,-2},{2,-1},{-1,2},{-2,1},{-1,-2},{-2,-1}};

		StringBuilder sb = new StringBuilder();

		for(int i = 0; i < T; i++) {
			int[][] visited = new int[300][300];

			int n = Integer.parseInt(br.readLine());
			int[] start = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int[] target = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

			Queue<int[]> bfsQ = new LinkedList<>();

			bfsQ.add(start);
			visited[start[0]][start[1]] = 1;

			while(!bfsQ.isEmpty()) {
				int[] cur = bfsQ.poll();

				if (cur[0] == target[0] && cur[1] == target[1]) break;

				for (int[] dir : delta) {
					int nX = cur[0] + dir[0];
					int nY = cur[1] + dir[1];

					if (0 <= nX && nX < n && 0 <= nY && nY < n && visited[nX][nY] == 0) {
						bfsQ.add(new int[]{nX, nY});
						visited[nX][nY] = visited[cur[0]][cur[1]] + 1;
					}
				}
			}
			sb.append(visited[target[0]][target[1]]-1).append("\n");
		}
		System.out.println(sb);
	}
}