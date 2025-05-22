package studyjava.no2869;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int upSpeed = sc.nextInt();
        int downSpeed = sc.nextInt();
        int goal = sc.nextInt();

        sc.close();
//
//        int now = 0;
//        int day = 0;
//
//        while (true) {
//            day++;
//
//            now += upSpeed;
//
//            if (goal <= now) break;
//
//            now -= downSpeed;
//        }
//        System.out.println(day);
//

        // https://codingwonny.tistory.com/280 보고 품
        System.out.println((int)(Math.ceil((double)(goal - downSpeed)/ (upSpeed-downSpeed))));
    }
}
