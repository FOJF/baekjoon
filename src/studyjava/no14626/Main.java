package studyjava.no14626;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();
        br.close();

        int isbmChecker = 0;
        int starIndex = 0;

        for (int i = 0; i < input.length; i++) {
            if (input[i] == '*') {
                starIndex = i;
                continue;
            }

            if (i % 2 == 0)
                isbmChecker += input[i] - '0';
            else
                isbmChecker += 3 * (input[i] - '0');
        }

        int starMulti = starIndex % 2 == 0 ? 1 : 3;

        for (int i = 0; i < 10; i++) {
            if ((isbmChecker + i * starMulti) % 10 == 0) {
                System.out.println(i);
                break;
            }

        }
    }
}
