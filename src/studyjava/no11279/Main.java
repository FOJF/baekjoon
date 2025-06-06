package studyjava.no11279;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input != 0) maxHeap.add(input);
            else if (maxHeap.isEmpty()) System.out.println(0);
            else System.out.println(maxHeap.poll());
        }
        br.close();
    }
}