import java.io.*;
import java.util.*;

public class Ex14002 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            A[i] =  Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N + 1];
        Arrays.fill(dp, 1);

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (A[j] < A[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            answer = Math.max(answer, dp[i]);
        }

        Stack<Integer> progression = new Stack<>();
        int len = answer;
        for (int i = N - 1; i >= 0; i--) {
            if (dp[i] == len) {
                progression.push(A[i]);
                len--;
            }
        }

        System.out.println(answer);

        while (!progression.isEmpty()) {
            System.out.print(progression.pop() + " ");
        }
    }
}