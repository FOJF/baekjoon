package studyjava.no2920;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 문자열로 처리해보는 방법
        Scanner sc = new Scanner(System.in);
        String pitch = sc.nextLine().replaceAll(" ","");

        if(pitch.equals("12345678")) System.out.println("ascending");
        else if(pitch.equals("87654321")) System.out.println("descending");
        else System.out.println("mixed");

    }
}

//import java.util.Arrays;
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
            // int 배열로 처리해보는 방법
//        final int[] ASCENDING = {1, 2, 3, 4, 5, 6, 7, 8};
//        final int[] DESCENDING = {8, 7, 6, 5, 4, 3, 2, 1};
//
//        Scanner sc = new Scanner(System.in);
//
//        int[] pitch = new int[8];
//
//        for (int i = 0; i < 8; i++) {
//            pitch[i] = sc.nextInt();
//        }
//
//        if (Arrays.equals(pitch, ASCENDING)) System.out.println("ascending");
//        else if (Arrays.equals(pitch, DESCENDING)) System.out.println("descending");
//        else System.out.println("mixed");
//
//    }
//}