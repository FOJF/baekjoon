package studyjava.no12920;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken()); // 물건 종류
		int m = Integer.parseInt(st.nextToken()); // 가방의 최대 무게

		List<int[]> items = new ArrayList<>();
		int[] dp = new int[m+1];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken()); // 무게
			int v = Integer.parseInt(st.nextToken()); // 가치 
			int c = Integer.parseInt(st.nextToken()); // 개수

			for (int j = 0; j < c; j++) {
				items.add(new int[]{w, v});
			}
		}

		br.close();

		for (int i = 0; i < items.size(); i++) {
			int[] item = items.get(i);
			for (int j = m; j >= item[0]; j--) {
				dp[j] = Math.max(dp[j], item[1] + dp[j-item[0]]);
			}
		}
		
		System.out.println(dp[m]);
	}
}