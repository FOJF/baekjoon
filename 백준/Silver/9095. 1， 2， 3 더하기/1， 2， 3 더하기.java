import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());


        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int answer = 0;
            int[] dp = {1, 1, 2, 3};

            for (int j = 1; j <= n; j++) {
                if (j <= 4) {
                    answer += dp[j - 1];
                } else {
                    dp[0] = dp[1];
                    dp[1] = dp[2];
                    dp[2] = dp[3];

                    int gapBetweenNowAndNext = dp[0] + dp[1] + dp[2];

                    dp[3] = gapBetweenNowAndNext;

                    answer += gapBetweenNowAndNext;
                }
            }
            System.out.println(answer);
        }
        br.close();
    }
}