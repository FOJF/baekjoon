package studyjava.no1436;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();

        int i = 0;
        int answer = 665; // 첫번째 값인 666부터 체크

        while (i < n) { // n번째 666포함 숫자를 찾을때 까지 숫자를 1씩 늘려가며 체크
                answer++;
            if ((answer + "").contains("666"))
                i++;
        }

        System.out.println(answer);
    }
}
