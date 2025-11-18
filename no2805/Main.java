package studyjava.no2805;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nmStr = br.readLine().split(" ");
        int n = Integer.parseInt(nmStr[0]);
        int target = Integer.parseInt(nmStr[1]);

        String[] treeHeightStrs = br.readLine().split(" ");
        br.close();

        int[] trees = new int[n];

        int start = 0;
        int end = 0;

        for (int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(treeHeightStrs[i]);
            end = Math.max(end, trees[i] - 1);
        }

        start = Math.max(0, end - target);

        int answer = 0;

        while (start <= end) {
            int mid = (start + end) / 2;

            long sum = 0;
            for (int tree : trees) {
                if (tree > mid)
                    sum += tree - mid;
            }

            if (sum > target) {
                start = mid + 1;
                answer = mid;
            } else if (sum == target) {
                answer = mid;
                break;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(answer);
    }
}
