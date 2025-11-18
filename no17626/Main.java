package studyjava.no17626;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(br.readLine());
        br.close();

        System.out.println(findMinSquares(target, 4));
    }

    // n: 목표 숫자, remainingCount: 남은 제곱수 개수
    public static int findMinSquares(int n, int remainingCount) {
        if (n <= 1) return n;

        int sqrt = (int) Math.sqrt(n);
        int minCount = remainingCount;

        while (n / (sqrt * sqrt) < remainingCount) {
            int next = findMinSquares(n - (sqrt * sqrt), remainingCount - 1) + 1;
            minCount = Math.min(minCount, next);
            sqrt--;

            if (sqrt == 0) break;
        }

        return minCount;
    }
}