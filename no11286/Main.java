package studyjava.no11286;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> absMinHeap = new PriorityQueue<>((i1, i2) -> {
            if (Math.abs(i1) == Math.abs(i2)) return i1 - i2;

            return Math.abs(i1) - Math.abs(i2);
        });

        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());

            if (input != 0) {
                absMinHeap.offer(input);
                continue;
            }

            System.out.println(absMinHeap.isEmpty() ? 0 : absMinHeap.poll());
        }

        br.close();
    }
}
