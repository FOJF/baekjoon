package studyjava.no30802;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        String[] strSizes = sc.nextLine().split(" ");

        int[] sizes = new int[strSizes.length];

        int t = sc.nextInt(); // 티셔츠 구매시 한 묶음 당 들어있는 티셔츠의 수
        int p = sc.nextInt(); // 펜 구매시 한 묶음 당 들어있는 펜의 수

        for (int i = 0; i < strSizes.length; i++) { // 사이즈별 필요한 티셔츠 수
            sizes[i] = Integer.parseInt(strSizes[i]);
        }

        int buyT = 0;
        for (int size : sizes) { // 사이즈 별로 필요한 티셔츠 묶음 수 체크
            buyT += (size / t);
            if (size % t > 0)
                buyT++;
        }
        System.out.println(buyT);
        System.out.println((n / p) + " " + (n % p)); // 펜 몇 묶음 사야하고 한 개씩 사야하는 지
    }
}

// 티셔츠와 펜이 각각 한 묶음에 들어있는 양이 정해져 있고, 모자르면 안될때 티셔츠는 n 장씩 몇 묶음을 시켜야 하나
// 펜은 딱 맞게 사려면 몇 묶음을 사고 한 개씩 몇개를 사야하냐