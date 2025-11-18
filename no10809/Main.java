package studyjava.no10809;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String word = (new Scanner(System.in).nextLine());

        for (int i = 'a'; i < 'z' + 1; i++) {
            System.out.print((word.indexOf(i)) + " ");
        }
    }
}
