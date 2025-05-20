package studyjava.no8958;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int i = Integer.parseInt(sc.nextLine());

        for (; i > 0; i--) {
            String oxs = sc.nextLine();
            int score = 0;
            int point = 1;

            for (int j = 0; j < oxs.length(); j++) {
                if (oxs.charAt(j) == 'O')
                    score += point++;
                else
                    point = 1;
            }
            System.out.println(score);
        }
    }
}
