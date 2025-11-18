import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Deque<Integer> deque = new ArrayDeque<>();

		int N = Integer.parseInt(br.readLine());

		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			switch (st.nextToken()) {
				case "1" -> deque.addFirst(Integer.parseInt(st.nextToken()));
				case "2" -> deque.addLast(Integer.parseInt(st.nextToken()));
				case "3" -> System.out.println(deque.peekFirst() == null ? "-1" : deque.pollFirst());
				case "4" -> System.out.println(deque.peekLast() == null ? "-1" : deque.pollLast());
				case "5" -> System.out.println(deque.size());
				case "6" -> System.out.println(deque.isEmpty() ? "1" : "0");
				case "7" -> System.out.println(deque.peekFirst() == null ? "-1" : deque.peekFirst());
				case "8" -> System.out.println(deque.peekLast() == null ? "-1" : deque.peekLast());
			}
		}  
	}
}