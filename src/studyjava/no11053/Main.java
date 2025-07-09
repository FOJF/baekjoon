package studyjava.no11053;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        br.readLine();

        int[] numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        br.close();

        int[] length = new int[numbers.length];

        int max = 1;

        for (int i = 0; i < numbers.length; i++) {
            int maxLength = 1;
            for (int j = 0; j < i; j++) {
                if (numbers[j] < numbers[i]) {
                    maxLength = Math.max(maxLength, length[j] + 1);
                }
            }
            length[i] = maxLength;
            max = Math.max(max, maxLength);
        }

        System.out.println(max);
    }
}