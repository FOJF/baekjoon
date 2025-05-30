package studyjava.no11720;

// N개의 숫자가 공백 없이 쓰여있다. 이 숫자를 모두 합해서 출력하는 프로그램을 작성하시오.

// 첫째 줄에 숫자의 개수 N (1 ≤ N ≤ 100)이 주어진다. 둘째 줄에 숫자 N개가 공백없이 주어진다.

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine()) - 1;
        String numbers = sc.nextLine();

        int sum = 0;

        for (; n >= 0; n--) {
            sum += Integer.parseInt(String.valueOf(numbers.charAt(n)));
//            System.out.println(numbers.charAt(n));
            numbers = numbers.substring(0, n);
//            System.out.println(numbers);
        }
        System.out.println(sum);
    }
}
