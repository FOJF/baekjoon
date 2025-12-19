import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];

        int[] babyPos = new int[2];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 9) {
                    map[i][j] = 0;
                    babyPos[0] = i;
                    babyPos[1] = j;
                }
            }
        }

        int[][] delta = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

        int exp = 0;
        int size = 2;
        int time = 0;

        Queue<int[]> bfsQ = new LinkedList<>();

        while(true) {
            int[] target = {N, N, Integer.MAX_VALUE};

            int[][] dist = new int[N][N];
            
            bfsQ.add(babyPos);
            dist[babyPos[0]][babyPos[1]] = 1;

            while(!bfsQ.isEmpty()) {
                int[] now = bfsQ.poll();

                if (dist[now[0]][now[1]] > target[2]) continue;

                for(int[] dir : delta) {
                    int nX = now[0] + dir[0];
                    int nY = now[1] + dir[1];

                    if (0 <= nX && nX < N && 0 <= nY && nY < N && map[nX][nY] <= size && dist[nX][nY] == 0) {
                        if (map[nX][nY] != 0 && map[nX][nY] < size && (target[0] > nX || (target[0] == nX && target[1] > nY))) {
                            target[0] = nX;
                            target[1] = nY;
                            target[2] = dist[now[0]][now[1]];
                        }

                        bfsQ.add(new int[]{nX, nY});
                        dist[nX][nY] = dist[now[0]][now[1]] + 1;
                    }
                }
            }

            if (target[2] == Integer.MAX_VALUE) break;

            time += target[2];

            map[target[0]][target[1]] = 0;

            babyPos[0] = target[0];
            babyPos[1] = target[1];

            // System.out.println(Arrays.toString(target));

            if (++exp == size) {
                size++;
                exp = 0;
            }
        }

        System.out.println(time);
    }
}