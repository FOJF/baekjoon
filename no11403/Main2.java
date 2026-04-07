import java.io.*;
import java.util.*;

public class Main2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		List<List<Integer>> adjList = new ArrayList<>();

		for(int i = 0; i < N; i++) {
			List<Integer> l = new ArrayList<>();
			String s = br.readLine();
			for(int j = 0; j < N; j++) {
				if (s.charAt(j*2) == '1') {
					l.add(j);
				}
			}
			adjList.add(l);
		}

		boolean[][] answer = new boolean[N][N];

		Queue<Integer> bfsQ = new ArrayDeque<>();

		for(int i = 0; i < N; i++) {
			bfsQ.add(i);
			while(!bfsQ.isEmpty()) {
				int cur = bfsQ.poll();

				for(int next : adjList.get(cur)) {
					if (answer[i][next]) continue;

					bfsQ.add(next);
					answer[i][next] = true;
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for(boolean[] ans : answer) {
			for(boolean a : ans) {
				sb.append(a ? 1 : 0).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}
}