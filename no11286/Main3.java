import java.util.*;
import java.io.*;

public class Main3 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		Queue<Integer> absHeap = new PriorityQueue<>((i1, i2) -> {
			if (Math.abs(i1) == Math.abs(i2)) return i1 - i2;

			return Math.abs(i1) - Math.abs(i2);
		});

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine());
			if (x == 0) {
				sb.append(absHeap.isEmpty() ? 0 : absHeap.poll()).append("\n");
			} else {
				absHeap.add(x);
			}
		}
		
		System.out.println(sb);
	}
}