package studyjava.no11399;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] p = new int[n];
        String[] s = br.readLine().split(" ");
        br.close();

        for (int i = 0; i < n; i++) {
            p[i] = Integer.parseInt(s[i]);
        }


        Arrays.sort(p);

        int sum = 0;
        int a = 0;
        for (int t : p) {
            a += t;
            sum += a;
        }
        System.out.println(sum);
    }
}
