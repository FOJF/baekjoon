import java.io.*;
import java.util.*;

public class Main {
	static int sum = 0;
	static int answer = Integer.MAX_VALUE;
	static Set<Integer> visited = new LinkedHashSet<>();
	
	static int N;
	static int[][] adj;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		adj = new int[N][N];

		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				adj[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		visited.add(0);
		bt(0);

		System.out.println(answer);
	}

	static void bt(int cityNo) {
		if (visited.size() == N && adj[cityNo][0] != 0) {
			answer = Math.min(answer, sum + adj[cityNo][0]);
			return;
		}

		for(int i = 0; i < N; i++) {
			if (visited.contains(i) || adj[cityNo][i] == 0) continue;

			sum += adj[cityNo][i];
			visited.add(i);

			bt(i);

			sum -= adj[cityNo][i];
			visited.remove(i);
		}
	}
}