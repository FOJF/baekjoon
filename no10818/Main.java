package studyjava.no10818;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int max = -1000001;
        int min = 1000001;

        for (; n > 0; n--) {
            int intVar = sc.nextInt();
            if (max < intVar) max = intVar;
            if (min > intVar) min = intVar;
        }

        System.out.println(min + " " + max);
    }
}
