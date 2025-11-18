package studyjava.no2231;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int testNum = (new Scanner(System.in)).nextInt();
        int digitLong = (testNum + "").length();

        int min = 0;

        for (int i = -(digitLong * 10 - digitLong + 2); i < 0; i++) {
            int check = testNum + i;
            int[] checkArray = new int[digitLong];

            for (int j = digitLong - 1; j >= 0; j--) {
                checkArray[j] = check % 10;
                check /= 10;
            }

            check = testNum+i;

            if (check + Arrays.stream(checkArray).sum() == testNum) {
                min = check;
                break;
            }
        }

        System.out.println(min);
    }
}
