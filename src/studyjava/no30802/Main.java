package studyjava.no30802;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        String[] strSizes = sc.nextLine().split(" ");

        int[] sizes = new int[strSizes.length];

        int t = sc.nextInt();
        int p = sc.nextInt();

        for (int i = 0; i < strSizes.length; i++) {
            sizes[i] = Integer.parseInt(strSizes[i]);
        }

        int buyT = 0;
        for (int size : sizes) {
            buyT += (size / t);
            if (size % t > 0)
                buyT++;
        }
        System.out.println(buyT);
        System.out.println(n / p + " " + n % p);
    }
}
