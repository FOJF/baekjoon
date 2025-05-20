package studyjava.no3052;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] remainders = new int[10];
        Arrays.fill(remainders, -1); // 나머지가 될 수 없는 -1로 나머지를 저장할 배열을 초기화

        for (int i = 0; i < 10; i++) {
            int remainder = sc.nextInt() % 42;
            if (!Arrays.asList(remainders).contains(remainder)) // 이미 나온 적이 있는 나머지를 제외하고 배열에 저장
                remainders[i] = remainder;
        }

        remainders = Arrays.stream(remainders).distinct().toArray(); // 배열의 중복 값 제거
        if (!Arrays.asList(remainders).contains(-1)) System.out.println(remainders.length); // 초기화했던 값인 -1의 존재여부를 파악 후 출력
        else System.out.println(remainders.length-1);
    }
}
