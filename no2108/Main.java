package studyjava.no2108;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        TreeMap<Integer, Integer> intTreeMap = new TreeMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int key = Integer.parseInt(br.readLine());
            int value = 1;
            if (intTreeMap.containsKey(key)) value = intTreeMap.get(key) + 1;
            intTreeMap.put(key, value);
        }
        br.close();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(average(intTreeMap) + "\n");
        bw.write(median(intTreeMap) + "\n");
        bw.write(mode(intTreeMap) + "\n");
        bw.write(range(intTreeMap) + "\n");

        bw.flush();
        bw.close();
    }

    static int average(TreeMap<Integer, Integer> tm) {
        int sum = 0;
        int size = 0;

        for (Integer key : tm.keySet()) {
            sum += key * tm.get(key);
            size += tm.get(key);
        }

        return (int) Math.round((double) sum / size);
    }

    static int median(TreeMap<Integer, Integer> tm) {
        int count = 0;
        int total = 0;
        for (int freq : tm.values()) total += freq;

        int mid = (total + 1) / 2;

        for (Map.Entry<Integer, Integer> entry : tm.entrySet()) {
            count += entry.getValue();
            if (count >= mid) return entry.getKey();
        }
        return 0;
    }

    static int mode(TreeMap<Integer, Integer> tm) {
        int key = 0;
        int maxValue = 0;

        TreeMap<Integer, Integer> modes = new TreeMap<>();
        for (Map.Entry<Integer, Integer> entry : tm.entrySet()) {
            int k = entry.getKey();
            int v = entry.getValue();

            if (maxValue < v) {
                modes.clear();
                key = k;
                maxValue = v;
                modes.put(key, maxValue);
            } else if (maxValue == v) {
                modes.put(k, v);
            }
        }

        if (modes.size() > 1) {
            key = modes.higherKey(key);
        }

        return key;
    }

    static int range(TreeMap<Integer, Integer> tm) {

        return tm.lastKey() - tm.firstKey();
    }
}
