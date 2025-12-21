import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		boolean[] visited = new boolean[V+1];

		List<List<int[]>> adj = new ArrayList<>();
		for (int i = 0; i < V+1; i++) {
			adj.add(new ArrayList<>());
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			adj.get(s).add(new int[]{e, c});
			adj.get(e).add(new int[]{s, c});
		}

		Queue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1]-o2[1]);

		pq.add(new int[]{1, 0});
		
		int answer = 0;
		int cnt = 0;

		while(!pq.isEmpty()) {
			int[] edge = pq.poll();

			if (visited[edge[0]]) continue;

			visited[edge[0]] = true;
			answer += edge[1];
			if (++cnt == V) break;

			for(int[] e : adj.get(edge[0])) {
				if (visited[e[0]]) continue;
				pq.add(e);
			}
		}

		System.out.println(answer);
	}
}