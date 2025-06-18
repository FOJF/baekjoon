import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(getPrintCnt(n, true) + " "+ getPrintCnt(n, false));
        }

        br.close();
    }

    static int getPrintCnt(int n, boolean isZero) {
        int[] beforeNumbers;
        if (isZero) beforeNumbers = new int[]{1, 0};
        else beforeNumbers = new int[]{0, 1};
        
        if (n == 0) return beforeNumbers[0];

        for (int i = 2; i <= n; i++) {
            int newNumber = beforeNumbers[0] + beforeNumbers[1];
            beforeNumbers[0] = beforeNumbers[1];
            beforeNumbers[1] = newNumber;
        }
        return beforeNumbers[1];
    }
}