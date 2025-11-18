package studyjava.no15650;

import java.io.*;

public class Main {
    static int n;
    static int m;
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        br.close();


        isVisited = new boolean[n];

        getAnswer(1, 1, "");
    }

    static void getAnswer(int start, int depth, String answer) {
        if (depth == m) {
            for (int i = start; i <= n; i++) {
                System.out.println(answer + i);
            }
            return;
        }

        for (int i = start; i < n; i++) {
            getAnswer(i + 1, depth + 1, answer + i + " ");
        }
    }
}