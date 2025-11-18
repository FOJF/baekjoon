import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] infix = br.readLine().toCharArray();
		br.close();

		StringBuilder postfix = new StringBuilder();

		Stack<Character> opStack = new Stack();

		for(char c : infix) {
			if ('A' <= c && c <= 'Z') {postfix.append(c); continue;}

			if (c == '+' || c == '-') {
				while(!opStack.isEmpty() && opStack.peek() != '(') {
					postfix.append(opStack.pop());
				}
			} else if (c == '/' || c == '*') {
				while(!opStack.isEmpty() && (opStack.peek() == '/' || opStack.peek() == '*')) {
					postfix.append(opStack.pop());
				}
			} else if (c == ')') {
				while(!opStack.isEmpty()) {
					if (opStack.peek() == '(') {
						opStack.pop();
						break;
					}
					postfix.append(opStack.pop());
				}
			}

			if (c != ')') opStack.push(c);
		}

		while(!opStack.isEmpty()) {
			postfix.append(opStack.pop());
		}
		System.out.println(postfix);
	}
}