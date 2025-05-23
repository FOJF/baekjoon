package studyjava.no11651;

import java.io.*;
import java.util.Arrays;

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
            String[] str1 = o1.split(" ");
            String[] str2 = o2.split(" ");

            int n1 = Integer.parseInt(str1[1]);
            int n2 = Integer.parseInt(str2[1]);

            if (n1 != n2) return n1 - n2;

            n1 = Integer.parseInt(str1[0]);
            n2 = Integer.parseInt(str2[0]);

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