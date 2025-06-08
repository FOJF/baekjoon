package studyjava.no1629;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);
        int c = Integer.parseInt(input[2]);

        br.close();

        long answer = 1;
        for (int i = 0; i < b; i++) {
            answer *= a;
            answer %= c;
        }
        System.out.println(answer);
    }
}