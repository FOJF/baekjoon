package studyjava.no2675;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testTimes = Integer.parseInt(sc.nextLine());

        for(; testTimes > 0; testTimes--) { // 테스트 횟수만큼 반복
            String[] testCase = sc.nextLine().split(" ");
            int repeatTimes = Integer.parseInt(testCase[0]); // 문자열을 반복할 횟수
            String str = testCase[1]; // 반복할 문자열

            for(int i = 0; i < str.length(); i++) { // 한 글자씩 순회
                for(int j = 0; j < repeatTimes; j++) { // 반복할 횟수만큼 반복
                    System.out.print(str.charAt(i)); // 개행 없이 출력
                }
            }
                System.out.println(); // 다음 테스트를 위한 개행
        }
    }
}
