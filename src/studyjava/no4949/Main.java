package studyjava.no4949;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while (!(s = br.readLine()).equals(".")) {

            Stack<Character> characterStack = new Stack<>();

            boolean isCatched = false;

            for (char c : s.toCharArray()) {
                if (c == '(' || c == '[')
                    characterStack.push(c);
                else if (c == ')') {
                    if (characterStack.isEmpty() || characterStack.pop() != '(') {
                        isCatched = true;
                        break;
                    }
                } else if (c == ']') {
                    if (characterStack.isEmpty() || characterStack.pop() != '[') {
                        isCatched = true;
                        break;
                    }
                }
            }
            if (!isCatched && characterStack.isEmpty())
                System.out.println("yes");
            else
                System.out.println("no");

        }
        br.close();
    }
}
