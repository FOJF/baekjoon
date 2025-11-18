package studyjava.no18111;

import java.io.*;
import java.util.*;

public class Main {
    final static int REMOVE_TIME = 2;
    final static int PUT_TIME = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int blockCnt = Integer.parseInt(input[2]);

        int[][] ground = new int[n][m];

        int highest = 0;

        // 블럭을 입려받으면서 최대 높이를 구함
        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                ground[i][j] = Integer.parseInt(input[j]);
                highest = Math.max(highest, ground[i][j]);
            }
        }

        br.close();

        int answerTime = Integer.MAX_VALUE;
        int answerLevel = highest;

        // 최대 높이부터 완전탐색
        for (int i = highest; i >= 0; i--) {
            int timeToFlat = getTimeToFlat(ground, i, blockCnt);

            if (timeToFlat == -1) continue;

            // 높은 높이부터 탐색하기 때문에 지금까지 구한 최소값보다 클 때만 갱신
            // 같을 때도 갱신하면 가장 낮은 높이를 구하게 됨
            if (answerTime > timeToFlat) {
                answerTime = timeToFlat;
                answerLevel = i;
            }
        }

        StringBuilder sb = new StringBuilder();
        System.out.println(sb.append(answerTime).append(" ").append(answerLevel));
    }

    public static int getTimeToFlat(int[][] ground, int targetLevel, int blockCnt) {
        int time = 0;

        // 목표 높이까지 땅 파기, 얻은 블록 저장, 걸린 시간 저장
        for (int[] arr : ground) {
            for (int i : arr) {
                if (i <= targetLevel) continue;

                time += REMOVE_TIME * (i - targetLevel);
                blockCnt += (i - targetLevel);
            }
        }

        // 목표 높이보다 낮거나 같은 땅들만 존재
        // 목표 높이까지 채움, 블럭 수가 부족하면 -1리턴
        // 아니면 땅 채우는데 걸린 시간 추가
        for (int[] arr : ground) {
            for (int i : arr) {
                if (i >= targetLevel) continue;

                time += PUT_TIME * (targetLevel - i);
                blockCnt -= (targetLevel - i);
                if (blockCnt < 0) return -1;
            }
        }

        return time;
    }
}