package studyjava.no2798;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] cards = new int[n];

        for (int i = 0; i < n; i++) {
            cards[i] = sc.nextInt();
        }

        int result = 0;

        for (int i = 0; i < cards.length; i++) {
            for (int j = 0; j < cards.length; j++) {
                for (int k = 0; k < cards.length; k++) {
                    if (i == j | i == k | k == j) break;
                    if (result < cards[i] + cards[j] + cards[k] && cards[i] + cards[j] + cards[k] <= m) {
                        result = cards[i] + cards[j] + cards[k];
                    }
                }
            }
        }
        System.out.println(result);
    }
}


