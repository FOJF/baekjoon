import java.util.*;
import java.io.*;

public class Main2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		List<List<Integer>> adjList = new ArrayList<>();

		for(int i = 0; i < N+1; i++) {
			adjList.add(new ArrayList<>());
		}

		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			adjList.get(a).add(b);
			adjList.get(b).add(a);
		}

		Queue<Integer> bfsQ = new LinkedList<>();

		int answerIdx = 1;
		int answerVal = Integer.MAX_VALUE;

		for(int i = 1; i <= N; i++) {
			int[] visited = new int[N+1];
			bfsQ.add(i);
			visited[i] = 1;

			while(!bfsQ.isEmpty()) {
				int cur = bfsQ.poll();

				for(int next : adjList.get(cur)) {
					if (visited[next] != 0) continue;

					bfsQ.add(next);
					visited[next] = visited[cur] + 1;
				}
			}

			int kbCnt = Arrays.stream(visited).sum();

			if (answerVal > kbCnt) {
				answerVal = kbCnt;
				answerIdx = i;
			}
		}

		System.out.println(answerIdx);
	}
}