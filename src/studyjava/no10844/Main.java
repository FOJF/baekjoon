import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		br.close();

		// long a = 0;
		
		// long start = 1;

		// for (int i = 1; i < N; i++) {
		// 	start *= 10;
		// }

		// long end = start * 10;

		// aaa:
		// for(long i = start; i < end; i++) {
		// 	char[] num = String.valueOf(i).toCharArray();

		// 	for (int j = 1; j < num.length; j++) {
		// 		if (Math.abs(num[j-1]-num[j]) != 1) continue aaa;
		// 	}

		// 	a++;
		// }

		// System.out.println(a);

		BigInteger[][] pascal = new BigInteger[N+1][];
		pascal[1] = new BigInteger[]{BigInteger.ONE, BigInteger.ONE};

		BigInteger[] dp = new BigInteger[N+1];
		dp[1] = BigInteger.valueOf(9);

		for (int i = 2; i <= N; i++) {
		    pascal[i] = new BigInteger[i+1];
		    pascal[i][0] = BigInteger.ONE;
		    pascal[i][i] = BigInteger.ONE;
			for(int j = 1; j < i; j++) {
				pascal[i][j] = pascal[i-1][j-1].add(pascal[i-1][j]);
			}

			dp[i] = dp[i-1].multiply(BigInteger.valueOf(2)).subtract(pascal[i-1][i/2]);
		}
		
		System.out.println(dp[N].mod(BigInteger.valueOf(1000000000L)));

		int MOD = 1000000000;
		        // dp[i][j]: 길이가 i이고 마지막 자리가 j인 계단 수의 개수
        long[][] dp2 = new long[N + 1][10];

        // 길이가 1인 계단 수 초기화
        for (int j = 1; j <= 9; j++) {
            dp2[1][j] = 1;
        }

        // 길이가 2부터 N까지 계산
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j == 0) {
                    dp2[i][0] = dp2[i - 1][1] % MOD;
                } else if (j == 9) {
                    dp2[i][9] = dp2[i - 1][8] % MOD;
                } else {
                    dp2[i][j] = (dp2[i - 1][j - 1] + dp2[i - 1][j + 1]) % MOD;
                }
            }
        }

        long result = 0;
        // 길이가 N인 모든 계단 수의 개수를 합산
        for (int j = 0; j <= 9; j++) {
            result = (result + dp2[N][j]) % MOD;
        }

        System.out.println(result);
	}
}

// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;

// public class Main {
//     static final int MOD = 1000000000;

//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         int N = Integer.parseInt(br.readLine());
//         br.close();

//         // dp[i][j]: 길이가 i이고 마지막 자리가 j인 계단 수의 개수
//         long[][] dp = new long[N + 1][10];

//         // 길이가 1인 계단 수 초기화
//         for (int j = 1; j <= 9; j++) {
//             dp[1][j] = 1;
//         }

//         // 길이가 2부터 N까지 계산
//         for (int i = 2; i <= N; i++) {
//             for (int j = 0; j <= 9; j++) {
//                 if (j == 0) {
//                     dp[i][0] = dp[i - 1][1] % MOD;
//                 } else if (j == 9) {
//                     dp[i][9] = dp[i - 1][8] % MOD;
//                 } else {
//                     dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % MOD;
//                 }
//             }
//         }

//         long result = 0;
//         // 길이가 N인 모든 계단 수의 개수를 합산
//         for (int j = 0; j <= 9; j++) {
//             result = (result + dp[N][j]) % MOD;
//         }

//         System.out.println(result);
//     }
// }