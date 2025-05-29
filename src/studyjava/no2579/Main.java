package studyjava.no2579;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] points = new int[n];
        int[] maxPoints = new int[n];

        for (int i = 0; i < n; i++) {
            points[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                maxPoints[i] = points[i];
                continue;
            } else if (i == 1) {
                maxPoints[i] = points[i - 1] + points[i];
                continue;
            } else if (i == 2) {
                maxPoints[i] = points[i] + Math.max(points[i - 2], points[i - 1]);
                continue;
            }

            maxPoints[i] = points[i] + Math.max(maxPoints[i - 3] + points[i - 1], maxPoints[i - 2]);

        }

        System.out.println(maxPoints[n-1]);
    }
}
