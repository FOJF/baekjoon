package studyjava.no11047;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nk = br.readLine().split(" ");

        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);

        int[] coinTypes = new int[n];

        for (int i = 0; i < n; i++) {
            coinTypes[i] = Integer.parseInt(br.readLine());
        }

        br.close();

        System.out.println(countMinCoins(coinTypes, k));
    }

    static int countMinCoins(int[] coinTypes, int price) {
        int count = 0;

        for (int i = coinTypes.length-1; i >= 0 ; i--) {
            int c = price/coinTypes[i];
            if (c == 0) continue;

            count += c;
            price = price % coinTypes[i];
            if (price == 0) break;
        }

        return count;
    }
}
