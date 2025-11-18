package studyjava.no1003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        int[] answer = new int[41];
        answer[0] = 0;
        answer[1] = 1;

        int calculatedIdx = 1;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());

            if (n == 0) {
                sb.append("1 0\n");
                continue;
            }

            while(calculatedIdx < n) {
                calculatedIdx++;
                answer[calculatedIdx] = answer[calculatedIdx-1] + answer[calculatedIdx-2];
            }

            sb.append(answer[n-1]).append(" ").append(answer[n]).append("\n");
        }

        br.close();
        System.out.println(sb);
    }
}