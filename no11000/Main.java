import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		List<int[]> cTimes = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			cTimes.add(Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray());
		}

		cTimes.sort((o1, o2) -> {
			if (o1[0] == o2[0]) return o2[1]-o1[1];
			return o1[0]-o2[0];
		});

		Queue<Integer> pq = new PriorityQueue<>();

		pq.add(0);

		for(int[] time : cTimes) {
			int end = pq.poll();

			if (time[0] >= end) {
				end = time[1];
			} else {
				pq.add(time[1]);
			}

			pq.add(end);
		}

		System.out.println(pq.size());
	}
}