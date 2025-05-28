package studyjava.no1003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(getZeroTimes(n) + " " + getOneTimes(n));
        }

        br.close();
    }

    static int getZeroTimes(int n) {
        int[] beforeNumbers = {1, 0};
        int newNumber = 0;
        for (int i = 0; i <= n; i++) {
            if (i == 0) continue;
            else if (i == 1) continue;

            newNumber = beforeNumbers[0] + beforeNumbers[1];
            beforeNumbers[0] = beforeNumbers[1];
            beforeNumbers[1] = newNumber;
        }
        return n < 2 ? beforeNumbers[n] : newNumber;
    }

    static int getOneTimes(int n) {
        int[] beforeNumbers = {0, 1};
        int newNumber = 0;
        for (int i = 0; i <= n; i++) {
            if (i == 0) continue;
            else if (i == 1) continue;

            newNumber = beforeNumbers[0] + beforeNumbers[1];
            beforeNumbers[0] = beforeNumbers[1];
            beforeNumbers[1] = newNumber;
        }
        return n < 2 ? beforeNumbers[n] : newNumber;
    }
}
