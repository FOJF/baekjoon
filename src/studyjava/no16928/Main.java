import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] isVisited = new int[107];

        int[] board = new int[107];
        Arrays.setAll(board, i -> i);


        for (int i = 0; i < n + m; i++) {
            st = new StringTokenizer(br.readLine());
            board[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }

        br.close();

        int[] delta = {1, 2, 3, 4, 5, 6};

        Queue<Integer> bfsQ = new LinkedList<>();

        bfsQ.add(1);
        isVisited[1] = 0;

        while (!bfsQ.isEmpty()) {
            int now = bfsQ.poll();

            for (int dir : delta) {
                int realNext = board[now + dir];

                if (realNext == 100) {
                    System.out.println(isVisited[now] + 1);
                    return;
                }

                if (isVisited[realNext] == 0) {
                    bfsQ.add(realNext);
                    isVisited[realNext] = isVisited[now] + 1;

                }
            }
        }
    }
}