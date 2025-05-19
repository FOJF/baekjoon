package studyjava.no2749;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int n = (new Scanner(System.in)).nextInt();

        for (int i = 1; i <= 9; i++) {
            System.out.println(n + " * " + i + " = " + (n * i));
        }
    }
}
