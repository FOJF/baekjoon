import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] input = br.readLine().toCharArray();

		Deque<Character> stack = new ArrayDeque<>();

		for (char c : input) {
			if (c == ')' && !stack.isEmpty() && stack.getFirst() == '(') stack.removeFirst();
			else stack.addFirst(c);
		}

		System.out.println(stack.size());
	}
}