import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] NM = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] weights = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Set<Integer> answer = new TreeSet<Integer>();

        bt(answer, weights, NM[1], 0);

        if (answer.isEmpty()) {
            System.out.println(-1);
            return;
        }

        StringBuilder sb = new StringBuilder();

        for(int a : answer) {
            sb.append(a).append(" ");
        }

        System.out.println(sb);
    }

    static int sum = 0;
    static int cnt = 0;

    static void bt(Set<Integer> answer, int[] weights, int m, int start) {
        if (cnt == m) {
            if (isPrime(sum)) answer.add(sum);
            return;
        }

        for (int i = start; i < weights.length; i++) {
            sum += weights[i];
            cnt++;

            bt(answer, weights, m, i+1);

            sum -= weights[i];
            cnt--;
        }
    }

    static boolean isPrime(int num) {
        for (int i = 2; i * i <= num; i++) {
            if (num%i == 0) return false;
        }

        return true;
    }
}