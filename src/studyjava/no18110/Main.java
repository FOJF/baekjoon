package studyjava.no18110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        TreeMap<Integer, Integer> tm = new TreeMap<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int key = Integer.parseInt(br.readLine());
            int value = 1;

            if (tm.containsKey(key))
                value = tm.get(key) + 1;

            tm.put(key, value);
        }
        br.close();

        final int CUTOFF = (int) Math.round(n * 0.15);

        int countFrontCutoffed = 0;
        int countBackCutoffed = 0;

        while (countFrontCutoffed < CUTOFF) {
            int key = tm.firstKey();
            int v = tm.get(key);

            if (v > CUTOFF - countFrontCutoffed) {
                tm.put(key, v - (CUTOFF - countFrontCutoffed));
                countFrontCutoffed = CUTOFF;
            } else {
                tm.pollFirstEntry();
                countFrontCutoffed += v;
            }

        }

        while (countBackCutoffed < CUTOFF) {
            int key = tm.lastKey();
            int v = tm.get(key);

            if (v > CUTOFF - countBackCutoffed) {
                tm.put(key, v - (CUTOFF - countBackCutoffed));
                countBackCutoffed = CUTOFF;
            } else {
                tm.pollLastEntry();
                countBackCutoffed += v;
            }

        }

        int sum = sumTreeMap(tm);

        double avg = Math.round((double) sum / (n - 2 * CUTOFF));

        System.out.println((int) avg);
    }

    static int sumTreeMap(TreeMap<Integer,Integer> tm) {
        int sum = 0;

        for (Integer key : tm.keySet()) {
            sum += key * tm.get(key);
        }
        return sum;
    }
}
