package studyjava.no2577;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        x *= sc.nextInt();
        x *= sc.nextInt();

        int[] count = new int[10];

        // 결과값에 나온 정수 개수 카운트
        while (true) {
            if(x < 10)  {
                count[x]++;
                break;
            }
            count[(x%10)]++;
            x/=10;
        }

        // 출력
        for(int i : count) {
            System.out.println(i);
        }
    }
}
