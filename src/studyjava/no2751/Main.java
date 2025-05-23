package studyjava.no2751;


import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] intArray = new int[n];

        for (int i = 0; i < n; i++) {
            intArray[i] = Integer.parseInt(br.readLine());
        }

        br.close();

        Arrays.sort(intArray);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < n; i++) {
            bw.write(intArray[i] + "\n");
        }
        bw.flush();
        bw.close();

    }
}
