package studyjava.no11650;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] strs = new String[n];

        for (int i = 0; i < n; i++) {
            strs[i] = br.readLine();
        }
        br.close();

        Arrays.sort(strs, (o1, o2) -> {
            StringTokenizer st1 = new StringTokenizer(o1, " ");
            StringTokenizer st2 = new StringTokenizer(o2, " ");

            int n1 = Integer.parseInt(st1.nextToken());
            int n2 = Integer.parseInt(st2.nextToken());

            if (n1 != n2) return n1 - n2;

            n1 = Integer.parseInt(st1.nextToken());
            n2 = Integer.parseInt(st2.nextToken());

            return n1 - n2;
        });

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < n; i++) {
            bw.write(strs[i] + "\n");
        }

        bw.flush();
        bw.close();
    }
}
