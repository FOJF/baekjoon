package studyjava.no1259;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String testCase = sc.nextLine();
            if (testCase.equals("0")) break; // 종료 먼저 처리

            String answer = "yes";
            int testCaseLength = testCase.length();

            for (int i = 0; i < testCaseLength / 2 + 1; i++) {
                // 맨 처음, 마지막 숫자부터 한 칸씩 이동하며 비교, 중간에서 만나면 종료되게 조건식 설정
                if (testCase.charAt(i) != testCase.charAt(testCaseLength - i - 1)) {// 다른 부분이 발견되면 false
                    answer = "no";
                    break;
                }
            }
            System.out.println(answer);
        }
        sc.close();
    }
}
