import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Set<Integer> truth = new HashSet<>();

		List<Set<Integer>> adj = new ArrayList<>();

		for(int i = 0; i < N+1; i++) {
			adj.add(new HashSet<>());
		}

		List<Set<Integer>> party = new ArrayList<>();

		st = new StringTokenizer(br.readLine());

		int t = Integer.parseInt(st.nextToken());
		
		Queue<Integer> bfsQ = new LinkedList<>();
		for(int i = 0; i < t; i++) {
			int tr = Integer.parseInt(st.nextToken());
			bfsQ.add(tr);
			truth.add(tr);
		}


		for(int i = 0; i < M; i++) {
			Set<Integer> p = new HashSet<>();

			st = new StringTokenizer(br.readLine());

			int att = Integer.parseInt(st.nextToken());
			for (int j = 0; j < att; j++) {
				p.add(Integer.parseInt(st.nextToken()));
			}

			party.add(p);

			for(int n : p) {
				Set<Integer> s = adj.get(n);
				for(int nn : p) {
					if (n != nn)
						s.add(nn);
				}
			}
		}

		while(!bfsQ.isEmpty()) {
			int now = bfsQ.poll();

			for(int next : adj.get(now)) {
				if (truth.contains(next)) continue;

				bfsQ.add(next);
				truth.add(next);
			}
		}

		int cnt = 0;
		for(Set ppp : party) {
			if (ppp.removeAll(truth)) cnt++;
		}

		System.out.println(M-cnt);
	}

}