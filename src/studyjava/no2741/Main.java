package studyjava.no2741;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int i = new Scanner(System.in).nextInt();
        int j = i + 1;
        for (; i > 0; i--) { // 5 4 3 2 1
            System.out.println(j - i);
        }
    }
}
