package studyjava.no2775;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int floor = sc.nextInt();
            int room = sc.nextInt();

            int[][] people = new int[floor+1][room]; // 몇호에 몇명이 사는지 저장할 배열, 층은 0층부터 있어서 +1



            for (int j = 0; j <= floor; j++) { // 한 층씩 체크
                for (int k = 1; k <= room; k++) { // 한 집씩 체크
                    int l = k-1; // 배열은 0부터 시작하기 때문에 실제 기록해야할 인덱스 값은 k에 -1을 해줘야함
                    if(j == 0)
                        people[j][l] = k; // 0층에는 k호에 k명이 산다.
                    else if(k == 1)
                        people[j][l] = 1; // 1호에는 무조건 1명이 산다.
                    else
                        people[j][l] = people[j-1][l]+people[j][l-1]; // 위의 조건이 아닌 j층 k호에는 아래층 k호와 같은 층 k-1호의 합 만큼 산다
                }
            }
            System.out.println(people[floor][room-1]);
        }
    }
}

// 2층 : 1   4   10  20  ...
// 1층 : 1   3   6   10  15  ...
// 0층 : 1   2   3   4   5   6   ...