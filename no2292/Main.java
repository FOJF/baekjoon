package studyjava.no2292;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int n = (new Scanner(System.in)).nextInt();
        int i = 1;

        n--;
        if (n <= 0) {
            System.out.println(1);
            return;
        }


        for (; i < n; i++) {
            n -= 6 * i;
            if (n <= 0) break;
        }

        System.out.println(i + 1);
    }
}
