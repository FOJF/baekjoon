import java.util.*;
import java.io.*;

public class Main2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		if (N == K) {
			System.out.println(0);
			return;
		}

		final int MIN_P = 0;
		final int MAX_P = 100000;

		Queue<Integer> bfsQ = new LinkedList<>();

		int[] dist = new int[MAX_P+1];

		bfsQ.add(N);
		dist[N] = 1;

		while(!bfsQ.isEmpty()) {
			int cur = bfsQ.poll();

			int[] nexts = {cur-1, cur+1, cur*2};

			for(int next : nexts) {
				if (next == K) {
					System.out.println(dist[cur]);
					return;
				}

				if (MIN_P <= next && next <= MAX_P && dist[next] == 0) {
					bfsQ.add(next);
					dist[next] = dist[cur]+1;
				}
			}
		}
	}
}