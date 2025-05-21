package studyjava.no4153;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x, y, z;

        while (true) {
            String[] xyz = sc.nextLine().split(" ");
            x = Integer.parseInt(xyz[0]);
            y = Integer.parseInt(xyz[1]);
            z = Integer.parseInt(xyz[2]);

            if (x == 0 & y == 0 & z == 0) break;

            if (x * x + y * y == z * z) System.out.println("right");
            else if (y * y + z * z == x * x) System.out.println("right");
            else if (x * x + z * z == y * y) System.out.println("right");
            else System.out.println("wrong");


        }
    }
}
