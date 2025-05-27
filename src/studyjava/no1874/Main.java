package studyjava.no1874;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] stack;
    static int lastIndex = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] answerStack = new int[n];
        stack = new int[n];

        for (int i = 0; i < n; i++) {
            answerStack[i] = Integer.parseInt(br.readLine());
        }

        br.close();

        StringBuilder sb = new StringBuilder();
        int nextNum = 1;

        for(int answer : answerStack) {
            for (int i = nextNum; i <= answer; i++) {
                // 빼야할 값이 현재 스택에 들어있지 않으면 추가
                push(i);
                nextNum++;
                sb.append("+\n");
            }

            // 들어있으면 뽑아서
            int poppedNum = pop();
            sb.append("-\n");
            if(poppedNum != answer) { // 뽑아서 맞게 뽑았는지 비교
                sb.setLength(0);
                sb.append("NO");
                break;
            }
        }
        System.out.println(sb);
    }

    static void push(int number) {
        if (lastIndex > stack.length) return;
        stack[++lastIndex] = number;
    }

    static int pop() {
        int val = stack[lastIndex];
        stack[lastIndex--] = 0;
        return val;
    }
}
