package studyjava.no2675;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testTimes = Integer.parseInt(sc.nextLine());

        for(; testTimes > 0; testTimes--) {
            String[] testCase = sc.nextLine().split(" ");
            int repeatTimes = Integer.parseInt(testCase[0]);
            String str = testCase[1];

            for(int i = 0; i < str.length(); i++) {
                for(int j = 0; j < repeatTimes; j++) {
                    System.out.print(str.charAt(i));
                }
            }
                System.out.println();
        }
    }
}
