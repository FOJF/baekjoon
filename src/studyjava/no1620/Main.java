package studyjava.no1620;

import java.io.*;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nm = br.readLine().split(" ");

        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        HashMap<String, String> illustratedGuide = new HashMap<>();

        for (int i = 0; i < n; i++) { // 도감 등록
            String s = br.readLine();
            illustratedGuide.put(String.valueOf(i + 1), s);
            illustratedGuide.put(s, String.valueOf(i + 1));
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < m; i++) {
            String s = br.readLine();
            bw.write(illustratedGuide.get(s)+"\n");
        }

        br.close();

        bw.flush();
        bw.close();
    }
}
