package studyjava.no10250;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int i = sc.nextInt();

        for (; i > 0; i--) {
            int h = sc.nextInt();
            int w = sc.nextInt();
            int no = sc.nextInt();

            int x, y;

            if (no % h == 0) {
                x = h;
                y = no / h;
            } else {
                x = (no % h);
                y = no / h + 1;
            }

            System.out.printf("%d%02d\n",x,y);
        }
    }
}
