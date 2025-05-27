package studyjava.no2839;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();

        int countBigBags = n / 5;
        int countSmallBags = 0;

        while (countBigBags >= 0) {

            int leftKG = n - (5 * countBigBags);
            if (leftKG % 3 == 0) {
                countSmallBags = leftKG / 3;
                break;
            }
            countBigBags--;
        }

        if (5 * countBigBags + 3 * countSmallBags != n)
            System.out.println(-1);
        else
            System.out.println(countBigBags+countSmallBags);
    }
}
