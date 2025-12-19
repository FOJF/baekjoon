import java.io.*;
import java.util.*;

public class Main2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long[] input = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

		Set<Long> visited = new HashSet<>();

		Queue<long[]> bfsQ = new LinkedList<>();

		bfsQ.add(new long[]{input[0], 1});
		visited.add(input[0]);

		while(!bfsQ.isEmpty()) {
			long[] now = bfsQ.poll();

			long[] next = {now[0]*2, now[0]*10+1};

			for(long n : next) {
				if (visited.contains(n) || n > input[1]) continue;

				if (n == input[1]) {
					System.out.println(now[1] + 1);
					return;
				}

				bfsQ.add(new long[]{n, now[1]+1});
				visited.add(n);
			}
		}

		System.out.println(-1);
	}
}