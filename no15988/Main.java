import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        final int M = 1000000009;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] dp = new int[1000001];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        int idx = 4;

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());

            for(; idx <= n; idx++) {
                dp[idx] = ((dp[idx-1] % M + dp[idx-2] % M) % M + dp[idx-3] % M) % M;
            }

            sb.append(dp[n]).append("\n");
        }

        System.out.println(sb);
    }
}