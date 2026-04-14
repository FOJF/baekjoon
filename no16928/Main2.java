import java.io.*;
import java.util.*;

public class Main2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sum();

		Map<Integer, Integer> m = new HashMap<>();

		while(t-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			m.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		Queue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
			if (o1[1] == o2[1]) return o1[0]-o2[0];
			return o1[1]-o2[1];
		});

		boolean[] visited = new boolean[101];
		pq.add(new int[]{1, 0});
		visited[1] = true;

		while(!pq.isEmpty()) {
			int[] cur = pq.poll();

			for(int i = 1; i <= 6; i++) {
				int[] next = {m.getOrDefault(cur[0]+i, cur[0]+i), cur[1]+1};

				if (next[0] > 100 || visited[next[0]]) continue;

				if (next[0] == 100) {
					System.out.println(next[1]);
					return;
				}

				pq.add(next);
                visited[next[0]] = true;
			}
		}
	}
}