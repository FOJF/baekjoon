package studyjava.no1106;

import java.io.*;
import java.util.*;

public class Main {
    // 딱 맞게 구해버린듯.....................!@ㄸㅇㄴㅎㄹ남허;ㄴㄹ 
	// public static void main(String[] args) throws IOException {
    //     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //     StringTokenizer st = new StringTokenizer(br.readLine());

    //     int c = Integer.parseInt(st.nextToken()); // 목표 고객 수 
    //     int n = Integer.parseInt(st.nextToken()); // 도시 수

    //     int[][] items = new int[n][2];

    //     for (int i = 0; i < n; i++) {
    //     	st = new StringTokenizer(br.readLine());
    //     	items[i][0] = Integer.parseInt(st.nextToken()); // 비용 
    //     	items[i][1] = Integer.parseInt(st.nextToken()); // 얻는 고객 수
    //     }

    //     br.close();

    //     int[][] dp = new int[c+1][n+1];


    //     for (int i = 0; i < c+1; i++) {
    //         dp[i][n] = Integer.MAX_VALUE;

    //         // 아이템을 하나씩 골라서 최소 비용을 갱신
    //         for (int j = 0; j < items.length; j++) {

    //             if (items[j][1] > i) { 
    //                 // 고객을 아예 얻을 수 없을 때
    //                 dp[i][j] = Integer.MAX_VALUE;
    //                 // continue;
    //             } 


    //             // 홍보가 가능하면 ?
    //             // 가능하고 남은 고객수 dp 라인을 찾아가서 최소값 구해서 더해버린다음 저장 ?
    //             // 그걸 어떻게 코드로 할 건데
    //             // 매번 또 반복문을 돌 거야 ?
    //             // 그냥 하나 저장해 ?


    //             // 현재도시에서 홍보했을 경우 = 남은 고객수의 최소값 + 현재 도시에서 홍보할때 쓴 비용
                

    //             else if (i-items[j][1] == 0) { // 알맞게 고객을 얻었을 때
    //                 dp[i][j] = items[j][0];
    //             } else { // 고객을 더 얻어야 하는 경우 
    //                 // 남은 고객의 최소 비용이 있는 경우(고객을 맞춰서 얻을 수 있는 경우)는 최소비용 + 현재비용, 아니라면 MAX_VALUE
    //                 System.out.println(i + " " + j);
    //                 dp[i][j] = dp[i-items[j][1]][n] == Integer.MAX_VALUE ? Integer.MAX_VALUE : dp[i-items[j][1]][n] + items[j][0];
    //             }






    //             // i명의 고객수를 얻는데 드는 최소 비용
    //             dp[i][n] = Math.min(dp[i][n], dp[i][j]);
    //         }
    //     }

    //     System.out.println(Arrays.deepToString(dp));
	// }







    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int c = Integer.parseInt(st.nextToken()); // 목표 고객 수 
        int n = Integer.parseInt(st.nextToken()); // 도시 수

        int[][] citys = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            citys[i][0] = Integer.parseInt(st.nextToken()); // 비용 
            citys[i][1] = Integer.parseInt(st.nextToken()); // 얻는 고객 수
        }

        br.close();

        // 개같은 호텔 망해라
        int[] dp = new int[100*1000+1];

        for (int i = 0; i < dp.length; i++) {
            dp[i] = 0;
            // i(예산) 비용으로 구할 수 있는 최대 고객놈들을 구해보자아
            for (int j = 0; j < citys.length; j++) {
                
                // 고객을 아예 얻을 수 없을 때(예산이 현재 도시의 홍보비보다 적을 때)
                if (citys[j][0] > i) continue;

                // 예산을 알맞게 썼을 때
                // 예산이 남았을 때    
                dp[i] = Math.max(dp[i], citys[j][1] + dp[i-citys[j][0]]);
                


                // 현재 비용으로 구할 수 있는 고객 수
                // dp[i] = Math.max(dp[i], dp[i][j]);
            }

            if (dp[i] >= c) {
                System.out.println(i);
                return;
            }
        }
    }
}

/*
0 [[2147483647, 2147483647, 2147483647, 2147483647],
1  [3, 2147483647, 2147483647, 3],
2  [6, 2, 2147483647, 2],
3  [5, 5, 1, 1],
4  [4, 4, 4, 4], 
5  [7, 3, 3, 3], 
6  [6, 6, 2, 2], 
7  [5, 5, 5, 5], 
8  [8, 4, 4, 4], 
9  [7, 7, 3, 3], 
10 [6, 6, 6, 6]]
*/