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
            if (!lastRealNumber.endsWith("z")) break;
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
