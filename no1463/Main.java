package studyjava.no1463;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        br.close();

        System.out.println(getAnswer(n));
    }

    static int getAnswer(int n) {
        // 재귀없이 하면 될 듯..? 됨
//        if (n == 1) return 0;
//        if (n <= 3) return 1;
//
//        int min = getAnswer(n - 1);
//
//        if (n % 3 == 0)
//            min = Math.min(min, getAnswer(n / 3));
//        if (n % 2 == 0)
//            min = Math.min(min, getAnswer(n / 2));
//        return min + 1;

        int[] mins = new int[1000001];
        mins[2] = 1;
        mins[3] = 1;

        for (int i = 4; i <= n; i++) {
            int min = mins[i - 1];

            if (i % 3 == 0)
                min = Math.min(mins[i / 3], min);
            if (i % 2 == 0)
                min = Math.min(mins[i / 2], min);
            mins[i] = min + 1;
        }

        return mins[n];
    }
}