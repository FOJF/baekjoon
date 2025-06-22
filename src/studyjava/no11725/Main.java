import java.io.*;
import java.util.*;

public class Main {
	static Map<Integer, Set<Integer>> graph;
	static int[] parents;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		graph = new HashMap<>();

		int k = Integer.parseInt(br.readLine());

		for (int i = 0; i < k-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			addEgde(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		br.close();

		parents = new int[graph.size()-1];

		getParents();

		StringBuilder sb = new StringBuilder();

		for (int i : parents) {
			sb.append(i).append("\n");
		}

		System.out.println(sb);
	}

	public static void addEgde(int a, int b) {
		Set<Integer> setA = graph.getOrDefault(a, new HashSet<>());
		Set<Integer> setB = graph.getOrDefault(b, new HashSet<>());

		setA.add(b);
		setB.add(a);

		graph.put(a, setA);
		graph.put(b, setB);
	}

	public static void getParents() {
		Queue<Integer> bfsQ = new LinkedList<>();
		boolean[] isVisited = new boolean[graph.size()];
		
		bfsQ.add(1);
		isVisited[0] = true;

		while(!bfsQ.isEmpty()) {
			int now = bfsQ.poll();
			Set<Integer> linked = graph.get(now);

			for (int next : linked) {
				if (isVisited[next-1]) continue;

				bfsQ.add(next);
				isVisited[next-1] = true;
				parents[next-2] = now;
			}
		}
	}
}