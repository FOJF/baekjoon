import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] dp = new int[k+1];
		int[] coins = new int[n];

		int maxCoin = 0;
		for (int i = 0; i < coins.length; i++) {
			coins[i] = Integer.parseInt(br.readLine());
			
			if (coins[i] < dp.length) dp[coins[i]] = 1;
		}

		br.close();

		for (int i = 1; i < k+1; i++) {
			if (dp[i] != 0) continue;

			int min = Integer.MAX_VALUE;
			for (int coin : coins) {
				if (i-coin < 0) continue;

				min = Math.min(min, (dp[i-coin] == 0) ? Integer.MAX_VALUE : dp[i-coin]);
			}
			dp[i] = (min == Integer.MAX_VALUE) ? 0 : min+1;
		}

		System.out.println((dp[k] == 0) ? -1 : dp[k]);
	}
}