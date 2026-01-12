import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for(int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());

			List<int[]> ranks = new ArrayList<>();
			
			int cutLine = 0;

			for(int j = 0; j < N; j++) {
				int[] now = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
				ranks.add(now);
				
				if (now[0] == 1) {
					cutLine = now[1];
				}
			}

			ranks.sort((o1, o2) -> o1[0]-o2[0]);

			int cnt = 0;

			for(int[] rank : ranks) {
				if (rank[1] <= cutLine) {
					cnt++;
					cutLine = rank[1];
				}

				if (rank[1] == 1) break;
			}

			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}
}