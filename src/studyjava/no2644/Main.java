import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] ab = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		List<List<Integer>> adjList = new ArrayList<>();

		for (int i = 0; i < n+1; i++) {
			adjList.add(new ArrayList<>());
		}

		int m = Integer.parseInt(br.readLine());

		for (int i = 0; i < m; i++) {
			int[] edge = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

			adjList.get(edge[0]).add(edge[1]);
			adjList.get(edge[1]).add(edge[0]);
		}

		br.close();

		int[] visited = new int[n+1];
		Queue<Integer> bfsQ = new LinkedList<>();

		visited[ab[0]] = 1;
		bfsQ.add(ab[0]);

		while(!bfsQ.isEmpty()) {
			int cur = bfsQ.poll();

			for(int next : adjList.get(cur)) {
				if (visited[next] != 0) continue;

				if (ab[1] == next) {
					System.out.println(visited[cur]);
					return;
				}

				bfsQ.add(next);
				visited[next] = visited[cur] + 1;
			}
		}

		System.out.println("-1");
	}
}