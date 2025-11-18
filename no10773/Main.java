package studyjava.no10773;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());

        Stack<Integer> ledger = new Stack<>();

        for (int i = 0; i < k; i++) {
            int money = Integer.parseInt(br.readLine());
            if (money == 0)
                ledger.pop();
            else ledger.push(money);
        }
        br.close();

        int sum = 0;
        for (int i : ledger) {
            sum += i;
        }
        System.out.println(sum);
    }
}
