package studyjava.no10989;

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
            bw.write(intArray[i]+"\n");
        }

        bw.flush();
        bw.close();
    }
}

// BufferedReader와 BufferedWritter가 기존에 사용하던 Scanner와 sout보다 속도가 빠르다는 점을 알게 됨
// BufferedReader와 BufferedWritter의 사용법을 알게됨.
// BufferedWritter는 버퍼를 잡아놓은 상태이기 때문에 꼭 flush(), close()를 해야한다.