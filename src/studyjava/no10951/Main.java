package studyjava.no10951;

//두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.

//입력은 여러 개의 테스트 케이스로 이루어져 있다.
//각 테스트 케이스는 한 줄로 이루어져 있으며, 각 줄에 A와 B가 주어진다. (0 < A, B < 10)

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strs;

        while (true) {
            try {

                strs = sc.nextLine().split(" ");
                if (strs.length != 2) break;
                System.out.println(Integer.parseInt(strs[0]) + Integer.parseInt(strs[1]));
            } catch (NumberFormatException | NoSuchElementException e) {
                break;
            }
        }
    }
}
