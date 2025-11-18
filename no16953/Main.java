package studyjava.no16953;

import java.io.*;
import java.util.*;

public class Main {
	static Map<Long, Long> visited = new HashMap<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long[] input = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
		br.close();

		bfs(input[0], input[1]);

		System.out.println(visited.getOrDefault(input[1],-1L));
	}

	public static void bfs(long start, long target) {
		Queue<Long> bfsQ = new LinkedList<>();

		bfsQ.add(start);
		visited.put(start, 1L);

		while(!bfsQ.isEmpty()) {
			long now = bfsQ.poll();

			long next = now*10+1;
			if (next <= target && visited.get(next) == null) {
				bfsQ.add(next);
				visited.put(next, visited.get(now)+1);
			}
			next = now*2;
			if (next <= target && visited.get(next) == null) {
				bfsQ.add(next);
				visited.put(next, visited.get(now)+1);
			}
		}
	}
}