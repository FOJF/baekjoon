package studyjava.no2475;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strs = sc.nextLine().split(" ");

        int squareSum = 0;

        for (String str : strs) {
            squareSum += (int) Math.pow(Integer.parseInt(str), 2);
        }

        System.out.println(squareSum % 10);
    }
}
