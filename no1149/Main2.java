import java.io.*;
import java.util.*;

public class Main2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[][] dp = new int[2][3];

		for(int i = 0; i < N; i++) {
			int[] tmp = dp[0];
			dp[0] = dp[1];
			dp[1] = tmp;

			StringTokenizer st = new StringTokenizer(br.readLine());

			dp[1][0] = Integer.parseInt(st.nextToken()) + Math.min(dp[0][1], dp[0][2]);
			dp[1][1] = Integer.parseInt(st.nextToken()) + Math.min(dp[0][0], dp[0][2]);
			dp[1][2] = Integer.parseInt(st.nextToken()) + Math.min(dp[0][0], dp[0][1]);
		}

		System.out.println(Arrays.stream(dp[1]).min().getAsInt());
	}
}