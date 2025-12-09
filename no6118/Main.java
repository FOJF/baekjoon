import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		List<List<Integer>> adjList = new ArrayList<>();

		for (int i = 0; i < N+1; i++) {
			adjList.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			adjList.get(a).add(b);
			adjList.get(b).add(a);
		}

		int[] dist = new int[N+1];

		Queue<Integer> bfsQ = new LinkedList<>();

		bfsQ.add(1);
		dist[1] = 1;

		while(!bfsQ.isEmpty()) {
			int now = bfsQ.poll();

			for (int next : adjList.get(now)) {
				if (dist[next] != 0) continue;

				bfsQ.add(next);
				dist[next] = dist[now] + 1;
			}
		}

		int answer = 0;
		int max = 0;
		int cnt = 0;

		for (int i = 1; i < N+1; i++) {
			if (max < dist[i]) {
				max = dist[i];
				answer = i;
				cnt = 1;
			} else if (max == dist[i]) {
				cnt++;
			}
		}

		System.out.println(answer + " " + (max-1) + " " + cnt);
	}
}