import java.util.*;
import java.io.*;

public class Main {
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

			int pcA = Integer.parseInt(st.nextToken());
			int pcB = Integer.parseInt(st.nextToken());

			adjList.get(pcB).add(pcA);
		}

		br.close();

		int[] answer = new int[N+1];
		int max = 0;
		int[] visited = new int[N+1];

		for(int i = 1; i <= N; i++) {
			

			Queue<Integer> bfsQ = new LinkedList<>();

			bfsQ.add(i);
			visited[i] = i;
			answer[i] = 1;

			while(!bfsQ.isEmpty()) {
				int cur = bfsQ.poll();

				for(int next : adjList.get(cur)) {
					if (visited[next] == i) continue; // visited 배열을 매번 새롭게 만드는 것이 아니라 버전관리 하는 느낌으로

					bfsQ.add(next);
					visited[next] = i;
					answer[i]++;
				}
			}

			max = Math.max(max, answer[i]);
		}

		StringBuilder sb = new StringBuilder();

		for(int i = 1; i < answer.length; i++) {
			if (answer[i] == max)
				sb.append(i).append(" ");
		}

		System.out.println(sb);
	}
}