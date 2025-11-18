package studyjava.no12865;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 물건 수 
        int k = Integer.parseInt(st.nextToken()); // 목표 무게

        int[][] items = new int[n+1][2];

        for (int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine());
        	items[i+1][0] = Integer.parseInt(st.nextToken()); // 무게
        	items[i+1][1] = Integer.parseInt(st.nextToken()); // 가치
        }

        br.close();

        // int[][] dp = new int[n+1][k+1];

        // for(int i = 1; i < dp.length; i++) {
        // 	for(int j = 1; j < dp[i].length; j++) { // 현재 배낭에 넣을 수 있는 무게
        // 		if (items[i][0] > j) { // 아이템의 무게가 현재 배낭의 무게보다 더 무거울 때 
        // 			dp[i][j] = dp[i-1][j];
        // 		} else {
        // 			dp[i][j] = Math.max(items[i][1] + dp[i-1][j-items[i][0]], dp[i-1][j]);
        // 		}
        // 	}
        // }

        // System.out.println(dp[n][k]);

        int[] dp = new int[k+1];

        for (int i = 1; i < items.length; i++) {
        	for (int j = k; j >= items[i][0]; j--) {
        		dp[j] = Math.max(items[i][1] + dp[j-items[i][0]], dp[j]);
        	}
        }

        System.out.println(dp[k]);
	}
}