import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        br.close();

        int[] arr = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
        int[] set = Arrays.stream(input).mapToInt(Integer::parseInt).distinct().sorted().toArray();

        StringBuilder sb = new StringBuilder();

        for (int num : arr) {
            sb.append(Arrays.binarySearch(set, num)).append(" ");
        }

        System.out.println(sb);
    }
}