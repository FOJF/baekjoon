package studyjava.no10828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] stack;
    static int lastIndex = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        stack = new int[n];

        for (int i = 0; i < n; i++) {
            String command = br.readLine();

            if (command.startsWith("push")) {
                push(Integer.parseInt(command.split(" ")[1]));
            } else if (command.equals("pop")) {
                System.out.println(pop());
            } else if (command.equals("size")) {
                System.out.println(size());
            } else if(command.equals("empty")) {
                System.out.println(isEmpty());
            } else if (command.equals("top")) {
                System.out.println(top());
            }
        }

        br.close();
    }

    static void push(int num) {
        stack[++lastIndex] = num;
    }

    static int pop() {
        if (lastIndex == -1) return -1;

        return stack[lastIndex--];
    }

    static int size() {
        return lastIndex+1;
    }

    static int isEmpty() {
        return lastIndex == -1 ? 1 : 0;
    }

    static int top() {
        if (lastIndex == -1) return -1;

        return stack[lastIndex];
    }
}
