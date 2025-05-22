package studyjava.no28702;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n; // 처리해야할 숫자
        int i = 0; // 처리해야할 숫자를 파악하기 위한 변수
        String lastRealNumber = ""; //

        for (; i < 3; i++) { // 진짜 숫자가 들어오면 break
            lastRealNumber = br.readLine();
            if (!lastRealNumber.endsWith("z")) break; // z로 끝나면 Fizz, Buzz, FizzBuzz, 기다리는 진짜 숫자가 아님
        }

        br.close();

        n = Integer.parseInt(lastRealNumber) + (3 - i);

        // 출력할 값 처리
        if (n % 15 == 0)
            System.out.println("FizzBuzz");
        else if (n % 3 == 0)
            System.out.println("Fizz");
        else if (n % 5 == 0)
            System.out.println("Buzz");
        else
            System.out.println(n);
    }
}

// 3의 배수와 5의 배수는 세번 연속으로 나열되는 일이 없음, 문제에 오류가 없으려면 숫자만 먼저 발견해서 계산후 출력하면 끝
// 3개의 연속된 숫자 중 3의 배수는 무조건 한 개가 있고, 5의 배수는 한 개나 없을 수 밖에 없으므로
// 프로그램 돌려봤을때 162024764까지는 없었음.

//        int j = 1;
//        int count = 0;
//        while(true) {
//            if (j%3==0) count++;
//            else if (j%5==0) count++;
//            else count = 0;
//
//            if(count >= 3) {
//                break;
//            }
//            System.out.println("count = " + count);
//                System.out.println("j = " + j); //j = 162024764
//            j++;
//        }