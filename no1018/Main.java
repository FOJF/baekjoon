package studyjava.no1018;

import java.util.Scanner;

public class Main {
    static char[][] board;
    static int min = 64; // 최대 8x8 = 64칸 전체를 칠하는 경우

    // i, j 는 시작 좌표
    static void checkBoard(int x, int y) {
        int count1 = 0; // 'W'로 시작하는 경우
        int count2 = 0; // 'B'로 시작하는 경우

        for (int i = x; i < x + 8; i++) {
            for (int j = y; j < y + 8; j++) {
                // 현재 칸이 기대하는 색이 아닐 경우 count 증가
                if ((i + j) % 2 == 0) {
                    if (board[i][j] != 'W') count1++; // W 시작
                    if (board[i][j] != 'B') count2++; // B 시작
                } else {
                    if (board[i][j] != 'B') count1++;
                    if (board[i][j] != 'W') count2++;
                }
            }
        }

        min = Math.min(min, Math.min(count1, count2));
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 행
        int M = sc.nextInt(); // 열
        sc.nextLine();

        board = new char[N][M];

        // 보드 입력 받기
        for (int i = 0; i < N; i++) {
            board[i] = sc.nextLine().toCharArray();
        }

        // 8x8 보드를 잘라서 검사
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                checkBoard(i, j);
            }
        }

        System.out.println(min);
    }
}
