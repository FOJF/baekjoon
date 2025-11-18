package studyjava.no11050;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int factorial(int number) {
        if (number <= 1) return 1; // 0! == 1, 1! == 1

        return number * factorial(number - 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");

        br.close();

        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);

        // 이항계수는 n! / k!*(n-k)!
        int answer = factorial(n) / (factorial(k)*factorial(n-k));

        System.out.println(answer);
    }
}

//