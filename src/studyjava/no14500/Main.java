package studyjava.no14500;

import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[][] board;
    final static int TETRO_SIZE = 4;

    static boolean[][] isVisited;
    static int max = 0;
    static int sum = 0;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        isVisited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        br.close();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sum += board[i][j];
                count++;
                isVisited[i][j] = true;
                dfs(i, j);
                isVisited[i][j] = false;
                count--;
                sum -= board[i][j];
            }
        }

        System.out.println(max);
    }

    public static void dfs(int x, int y) {
        if (count == TETRO_SIZE) {
            max = Math.max(max, sum);
            return;
        }

        int[][] delta = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int[] dir : delta) {
            int nextX = x + dir[0];
            int nextY = y + dir[1];

            if ((0 <= nextX && nextX < n) && (0 <= nextY && nextY < m) && !isVisited[nextX][nextY]) {
                if (count == 2) { // ㅗ
                    sum += board[nextX][nextY];
                    count++;
                    isVisited[nextX][nextY] = true;
                    dfs(x, y);
                    isVisited[nextX][nextY] = false;
                    count--;
                    sum -= board[nextX][nextY];
                }

                sum += board[nextX][nextY];
                count++;
                isVisited[nextX][nextY] = true;
                dfs(nextX, nextY);
                isVisited[nextX][nextY] = false;
                count--;
                sum -= board[nextX][nextY];
            }
        }
    }
}