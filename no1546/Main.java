package studyjava.no1546;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] scores = new int[n]; // 점수를 받을 배열 선언

        for (int i = 0; i < n; i++) { // 점수 입력
            scores[i] = sc.nextInt();
        }

        sc.close();

        int highestScore = Arrays.stream(scores).max().getAsInt(); // 최고 점수 파악
        double sum = 0; // 새로운 계산 후 점수들의 총점을 저장할 변수 선언

        for (int i = 0; i < n; i++) { // 새로운 계산 후 점수들의 총점 파악
            sum += (double)scores[i]/highestScore*100;
        }

        System.out.println(sum /n); // 평균 값 출력
    }
}
