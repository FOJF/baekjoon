package studyjava.no1764;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        TreeSet<String> haventMet = new TreeSet<>();
        TreeSet<String> haventHeard = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            haventHeard.add(br.readLine());
        }

        for (int i = 0; i < m; i++) {
            haventMet.add(br.readLine());
        }

        br.close();

        haventHeard.retainAll(haventMet);

        System.out.println(haventHeard.size());

        for(String s : haventHeard) {
            System.out.println(s);
        }
    }
}
