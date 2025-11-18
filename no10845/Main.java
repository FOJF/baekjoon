package studyjava.no10845;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] stack;
    static int firstIndex = -1;
    static int lastIndex = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        stack = new int[2 * n];

        for (int i = 0; i < n; i++) {
            String command = br.readLine();

            if (command.startsWith("push")) {
                push(Integer.parseInt(command.split(" ")[1]));
            } else if (command.equals("pop")) {
                System.out.println(pop());
            } else if (command.equals("size")) {
                System.out.println(size());
            } else if (command.equals("empty")) {
                System.out.println(isEmpty());
            } else if (command.equals("front")) {
                System.out.println(front());
            } else if (command.equals("back")) {
                System.out.println(back());
            }
        }

        br.close();
    }

    static void push(int num) {
        if (firstIndex == -1)
            firstIndex++;

        stack[++lastIndex] = num;
    }

    static int pop() {
        if (isEmpty() == 1) return -1;

        return stack[firstIndex++];
    }

    static int size() {
        return firstIndex == -1 ? 0 : lastIndex - firstIndex + 1;
    }

    static int isEmpty() {
        return (firstIndex == -1 || firstIndex > lastIndex) ? 1 : 0;
    }

    static int front() {
        if (isEmpty() == 1) return -1;

        return stack[firstIndex];
    }

    static int back() {
        if (isEmpty() == 1) return -1;

        return stack[lastIndex];
    }
}
