package studyjava.no1978;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
//        int[] testNumbers = new int[n];

        int countPrimeNumber = 0;

        for (int i = 0; i < n; i++) {
            int testNumber = sc.nextInt();
//            System.out.println("testNumber = " + testNumber);
            int checkPrime = 0;
            for (int j = 2; j < (int)(Math.sqrt(testNumber)+1); j++) {
//                System.out.println("(int)(Math.sqrt(testNumber)+1) = " + (int)(Math.sqrt(testNumber)+1));
                if(testNumber % j == 0) {
                    checkPrime++;
//                    System.out.println(testNumber+" "+j);
                    break;
                }
            }
            if (checkPrime == 0) countPrimeNumber++;
            if(testNumber == 1) countPrimeNumber--;
        }
        System.out.println(countPrimeNumber);
    }
}
