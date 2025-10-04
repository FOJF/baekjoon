import java.util.*;
import java.io.*;

public class Main2 {
	static List<Set<Integer>> adj = new ArrayList<>();
	static int[] visited;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] NMV = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		visited = new int[NMV[0]+1];

		for(int i = 0; i < NMV[0]+1; i++) {
			adj.add(new TreeSet<>());
		}

		for(int i = 0; i < NMV[1]; i++) {
			int[] edge = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

			adj.get(edge[0]).add(edge[1]);
			adj.get(edge[1]).add(edge[0]);
		}

		br.close();

		//dfs
		dfs(NMV[2]);
		sb.append("\n");

		//bfs
		Queue<Integer> q = new LinkedList<>();

		q.add(NMV[2]);
		visited[NMV[2]] = 1;
		sb.append(NMV[2]).append(" ");

		while(!q.isEmpty()) {
			int cur = q.poll();

			for(int next : adj.get(cur)) {
				if (visited[next] == 1) continue;

				q.add(next);
				visited[next] = 1;
				sb.append(next).append(" ");
			}
		}

		sb.append("\n");

		System.out.println(sb);
	}

	public static void dfs(int start) {
		visited[start] = 2;
		sb.append(start).append(" ");

		for(int next : adj.get(start)) {
			if (visited[next] == 2) continue;

			dfs(next);
		}
	}
}