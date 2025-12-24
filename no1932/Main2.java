import java.util.*;
import java.io.*;

public class Main2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[][] dp = new int[2][n];

		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int[] tmp = dp[0];
			dp[0] = dp[1];
			dp[1] = tmp;

			for(int j = 0; j <= i; j++) {
				int max = 0;
				
				if (j == 0) max = dp[0][0];
				else if (j == i) max = dp[0][j-1];
				else max = Math.max(dp[0][j-1], dp[0][j]);

				dp[1][j] = Integer.parseInt(st.nextToken()) + max;
			}
		}

		System.out.println(Arrays.stream(dp[1]).max().getAsInt());
	}
}