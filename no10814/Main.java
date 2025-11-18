package studyjava.no10814;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] users = new String[n];

        for (int i = 0; i < n; i++) {
            users[i] = br.readLine();
        }

        br.close();

        Arrays.sort(users,(a,b) -> {
            int aAge = Integer.parseInt(a.split(" ")[0]);
            int bAge = Integer.parseInt(b.split(" ")[0]);

            return aAge - bAge;
        });

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < n; i++) {
            bw.write(users[i]+"\n");
        }
        bw.flush();
        bw.close();
    }
}

//315992	1572
