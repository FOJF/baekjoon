package studyjava.no7568;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] kgCmRank = new int[n][3]; // 0,1,2가 kg cm rank인 배열을 n개 가지는 이중배열

        for (int i = 0; i < n; i++) { // 입력 받은 값을 kg cm에 저장
            String[] kgCm = br.readLine().split(" ");
            kgCmRank[i][0] = Integer.parseInt(kgCm[0]);
            kgCmRank[i][1] = Integer.parseInt(kgCm[1]);
        }

        br.close();

        for (int i = 0; i < n; i++) {
            int rank = 1;
            for (int j = 0; j < n; j++) {
                if (i == j) continue; // 나 자신은 빼고

                if ((kgCmRank[i][0] < kgCmRank[j][0]) && (kgCmRank[i][1] < kgCmRank[j][1])) // 비교
                    rank++;
            }
            kgCmRank[i][2] = rank;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < n; i++) {
            bw.write(kgCmRank[i][2] + " ");
        }

        bw.flush();
        bw.close();
    }
}
//15848	120
