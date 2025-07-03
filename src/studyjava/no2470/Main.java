import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] liquids = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();

        br.close();

        int start = 0;
        int end = liquids.length-1;

        int abs = Math.abs(liquids[start] + liquids[end]);
        int[] answer = {liquids[start], liquids[end]};

        while (start < end) {
            int sum = liquids[start] + liquids[end];
            if (Math.abs(sum) < abs) { // 답의 가능성이 있는 경우
                answer[0] = liquids[start];
                answer[1] = liquids[end];
                abs = Math.abs(sum);

            }

            if (sum < 0) {
                start++;
            } else {
                end--;
            }
        }
        System.out.println(answer[0] + " " + answer[1]);
    }
}