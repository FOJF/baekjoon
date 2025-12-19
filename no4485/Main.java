import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] cave = new int[125][125];
        int[][] dist = new int[125][125];

        int pCnt = 1;

        StringBuilder sb = new StringBuilder();

        Queue<int[]> bfsQ = new PriorityQueue<>((o1, o2) -> o1[2]-o2[2]);

        int[][] delta = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while(true) {
            int n = Integer.parseInt(br.readLine());

            if (n == 0) break;

            for(int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j++) {
                    cave[i][j] = Integer.parseInt(st.nextToken());
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }

            bfsQ.add(new int[]{0, 0, cave[0][0]});
            dist[0][0] = cave[0][0];

            while(!bfsQ.isEmpty()) {
                int[] now = bfsQ.poll();

                if (dist[now[0]][now[1]] < now[2]) continue;

                for (int[] dir : delta) {
                    int nX = now[0] + dir[0];
                    int nY = now[1] + dir[1];

                    if (0 <= nX && nX < n && 0 <= nY && nY < n && dist[nX][nY] > now[2] + cave[nX][nY]) {
                        dist[nX][nY] = now[2] + cave[nX][nY];
                        bfsQ.add(new int[]{nX, nY, dist[nX][nY]});
                    }
                }
            }

            sb.append("Problem ").append(pCnt++).append(": ").append(dist[n-1][n-1]).append("\n");
        }

        System.out.println(sb);
    }
}