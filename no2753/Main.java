package studyjava.no2753;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int year = (new Scanner(System.in)).nextInt();
        // 윤년은 연도가 4의 배수이면서, 100의 배수가 아닐 때 또는 400의 배수일 때이다.
        if (((year % 4 == 0) && (year % 100 != 0)) || year % 400 == 0)
            System.out.println(1);
        else
            System.out.println(0);
    }
}
