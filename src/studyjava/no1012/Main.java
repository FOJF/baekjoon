import java.io.*;
import java.util.*;

public class Main {

    public static class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int getX() {
            return this.x;
        }

        int getY() {
            return this.y;
        }

        int[] getXY() {
            int[] xy = new int[2];
            xy[0] = getX();
            xy[1] = getY();
            return xy;
        }

        Point plus(Point p) {
            return new Point(this.x + p.getX(), this.y + p.getY());
        }

        Point plus(int x, int y) {
            return new Point(this.x + x, this.y + y);
        }

        static boolean isValid(Point p, Point max) {
            if (p.getX() < 0 || p.getY() < 0 || max.getX() < p.getX() || max.getY() < p.getY()) return false;

            return true;
        }
    }

    public final static Point[] DELTA = {new Point(-1, 0), new Point(1, 0), new Point(0, -1), new Point(0, 1)};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);

            int answer = 0;
            int[][] farm = new int[n][m];
            boolean[][] isVisited = new boolean[n][m];
            Queue<Point> bfsQ = new LinkedList<>();

            int k = Integer.parseInt(input[2]);

            for (int i = 0; i < k; i++) {
                input = br.readLine().split(" ");
                farm[Integer.parseInt(input[0])][Integer.parseInt(input[1])] = 1;
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (isVisited[i][j]) continue;

                    isVisited[i][j] = true;

                    if (farm[i][j] == 0) continue;

                    bfsQ.offer(new Point(i, j));
                    answer++;

                    while (!bfsQ.isEmpty()) {
                        Point p = bfsQ.poll();
                        for (Point d : DELTA) {
                            Point nextP = p.plus(d);
                            if (!Point.isValid(nextP, new Point(n - 1, m - 1))) continue;

                            int x = nextP.getX();
                            int y = nextP.getY();

                            if (!isVisited[x][y] && farm[x][y] == 1) {
                                isVisited[x][y] = true;
                                bfsQ.offer(nextP);
                            }
                        }
                    }
                }
            }

            System.out.println(answer);
        }

        br.close();
    }
}
