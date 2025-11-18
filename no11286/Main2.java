import java.util.*;
import java.io.*;

public class Main2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		Queue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
			if (Math.abs(o1) == Math.abs(o2)) return o1 - o2;

			return Math.abs(o1) - Math.abs(o2);
		});

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine());

			if (x == 0) sb.append(pq.isEmpty() ? 0 : pq.poll()).append("\n");
			else pq.add(x);
		}

		br.close();

		System.out.println(sb);
	}
}