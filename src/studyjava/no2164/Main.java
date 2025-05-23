package studyjava.no2164;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        br.close();

        Queue<Integer> intQue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            intQue.add(i);
        }

        while (intQue.size()>1) {
            intQue.poll(); // 뽑아서 버리기
            intQue.add(intQue.poll()); // 뽑아서 맨 아래에 다시 넣기
        }

        System.out.println(intQue.poll());
    }
}
