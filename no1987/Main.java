package studyjava.no1987;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int R;
    static int C;
    static char[][] map;
    static boolean[] visitedAlphabet = new boolean[26]; // A-Z
    static int[][] delta = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        // (0,0)에서 시작, 시작 칸의 알파벳 방문 처리
        visitedAlphabet[map[0][0] - 'A'] = true;
        dfs(0, 0, 1); // x, y, count

        System.out.println(answer);
    }

    public static void dfs(int x, int y, int count) {
        answer = Math.max(answer, count);

        for (int[] dir : delta) {
            int nx = x + dir[0];
            int ny = y + dir[1];

            // 맵 범위 체크
            if (nx >= 0 && ny >= 0 && nx < R && ny < C) {
                int nextAlphabet = map[nx][ny] - 'A';
                // 아직 방문하지 않은 알파벳인 경우
                if (!visitedAlphabet[nextAlphabet]) {
                    visitedAlphabet[nextAlphabet] = true;
                    dfs(nx, ny, count + 1);
                    visitedAlphabet[nextAlphabet] = false; // 백트래킹
                }
            }
        }
    }
}
