package studyjava.no1008;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strs = sc.nextLine().split(" ");

        System.out.println(Double.parseDouble(strs[0]) / Double.parseDouble(strs[1]));
    }
}
