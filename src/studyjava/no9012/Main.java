package studyjava.no9012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {

            String test = br.readLine();

            System.out.println(isVPS(test) ? "YES" : "NO");
        }
        br.close();
    }

    static boolean isVPS(String s) {
        // Valid Parenthesis String 인지 판단하는 함수
        int vaild = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                vaild++;
            } else if (c == ')') {
                if (vaild == 0) return false;

                vaild--;
            }
        }
        return vaild == 0;
    }
}
