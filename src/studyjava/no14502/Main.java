package studyjava.no14502;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    // 좌표를 저장하기 위한 Point 클래스
    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N, M; // 연구소의 세로, 가로 크기
    static int[][] grid; // 연구소 지도 (0: 빈 칸, 1: 벽, 2: 바이러스)
    static List<Point> virus = new ArrayList<>(); // 초기 바이러스 위치 리스트
    static int maxSafeAreaCount = 0; // 최대 안전 영역 크기
    static int[][] delta = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; // 상하좌우 탐색을 위한 delta 배열

    public static void main(String[] args) throws IOException {
        // 입력을 받기 위한 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 연구소 크기 입력
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        grid = new int[N][M];

        // 연구소 지도 정보 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                // 바이러스 초기 위치 저장
                if (grid[i][j] == 2) {
                    virus.add(new Point(i, j));
                }
            }
        }

        // 벽을 3개 세우는 모든 경우의 수 탐색 시작
        setWall(0, 0);

        // 최종 결과 출력
        System.out.println(maxSafeAreaCount);
    }

    /**
     * 백트래킹을 사용하여 연구소에 벽을 3개 세우는 모든 조합을 탐색하는 함수
     * @param wallCnt 현재까지 세운 벽의 개수
     * @param start 탐색을 시작할 위치 (1차원 인덱스)
     */
    public static void setWall(int wallCnt, int start) {
        // 벽을 3개 모두 세웠을 경우
        if (wallCnt == 3) {
            // 현재 상태에서 안전 영역 크기를 계산하여 최댓값 갱신
            maxSafeAreaCount = Math.max(maxSafeAreaCount, getSafeAreaCnt());
            return;
        }

        // 연구소 전체를 순회하며 벽을 세울 위치 탐색
        for (int i = start; i < N * M; i++) {
            int r = i / M; // 1차원 인덱스를 2차원 행으로 변환
            int c = i % M; // 1차원 인덱스를 2차원 열로 변환

            // 해당 위치가 빈 칸일 경우
            if (grid[r][c] == 0) {
                grid[r][c] = 1; // 벽 세우기
                setWall(wallCnt + 1, i + 1); // 다음 벽 세우러 가기 (현재 위치 다음부터 탐색)
                grid[r][c] = 0; // 백트래킹: 세웠던 벽 다시 허물기
            }
        }
    }

    /**
     * 현재 지도 상태에서 바이러스를 퍼뜨리고 안전 영역의 크기를 계산하는 함수
     * @return 안전 영역의 크기
     */
    public static int getSafeAreaCnt() {
        // 원본 grid를 유지하기 위해 grid 복사
        int[][] gridCopy = new int[N][];
        for (int i = 0; i < N; i++) {
            gridCopy[i] = Arrays.copyOf(grid[i], M);
        }

        // BFS를 위한 큐 생성 및 초기 바이러스 위치 추가
        Queue<Point> q = new LinkedList<>(virus);

        // BFS를 통해 바이러스 확산 시뮬레이션
        while (!q.isEmpty()) {
            Point now = q.poll();

            for (int[] d : delta) {
                int nextX = now.x + d[0];
                int nextY = now.y + d[1];

                // 연구소 범위를 벗어나지 않고, 빈 칸일 경우 바이러스 확산
                if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < M && gridCopy[nextX][nextY] == 0) {
                    gridCopy[nextX][nextY] = 2; // 바이러스 감염
                    q.add(new Point(nextX, nextY));
                }
            }
        }

        // 안전 영역(0인 칸) 개수 계산
        int safeAreaCnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (gridCopy[i][j] == 0) {
                    safeAreaCnt++;
                }
            }
        }

        return safeAreaCnt;
    }
}