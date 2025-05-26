package studyjava.no1929;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        br.close();

        int first = Integer.parseInt(s.split(" ")[0]);
        int last = Integer.parseInt(s.split(" ")[1]);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = first; i <= last; i++) {
            if(isPrime(i))
                bw.write(i+"\n");
        }
        bw.flush();
        bw.close();
    }
    // 소수 판별 함수 출처 : 혜성님
    public static boolean isPrime(int n) {
        // 소수는 1보다 큰 자연수 중 1과 자기 자신만을 약수로 가지는 수이기에 1과 음수는 소수가 아니다.
        if (n < 2){
            return false;
        }
        // 어떤 자연수가 합성수라면 반드시 그 약수 중 하나는 √n 이하에 존재한다는 성질 덕분에,
        // 소수 판별은 √n까지만 검사해도 충분하다.
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
