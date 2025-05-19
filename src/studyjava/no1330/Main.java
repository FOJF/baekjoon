package studyjava.no1330;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strs = sc.nextLine().split(" ");

        int x = Integer.parseInt(strs[0]);
        int y = Integer.parseInt(strs[1]);

        System.out.println(x > y ? ">" : (x == y ? "==" : "<"));
    }
}
