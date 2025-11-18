package studyjava.no9465;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        final int STICKER_LINES = 2;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] stickers = new int[STICKER_LINES][];
            int[][] dp = new int[STICKER_LINES][2];

            for (int j = 0; j < STICKER_LINES; j++) {
                stickers[j] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            if (n == 1) {
                sb.append(Math.max(stickers[0][0], stickers[1][0])).append("\n");
                continue;
            }

            dp[0][0] = stickers[0][0];
            dp[1][0] = stickers[1][0];

            dp[0][1] = stickers[0][1] + dp[1][0];
            dp[1][1] = stickers[1][1] + dp[0][0];

            for (int j = 2; j < n; j++) {
                int tmp0 = stickers[0][j] + Math.max(dp[1][1], dp[1][0]);
                int tmp1 = stickers[1][j] + Math.max(dp[0][0], dp[0][1]);

                dp[0][0] = dp[0][1];
                dp[0][1] = tmp0;

                dp[1][0] = dp[1][1];
                dp[1][1] = tmp1;
            }
            sb.append(Math.max(dp[0][1], dp[1][1])).append("\n");
            // System.out.println(Arrays.deepToString(dp));
        }
        
        System.out.println(sb);
        br.close();
    }
}