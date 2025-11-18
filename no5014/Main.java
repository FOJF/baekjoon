import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] FSGUD = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		br.close();

		if (FSGUD[1] == FSGUD[2]) {
			System.out.println(0);
			return;
		}

		int[] delta = {FSGUD[3], -FSGUD[4]};
		int[] dist = new int[FSGUD[0]+1];

		Queue<Integer> q = new LinkedList<>();

		q.add(FSGUD[1]);
		dist[FSGUD[1]] = 1;

		while(!q.isEmpty()) {
			int cur = q.poll();

			for(int dir : delta) {
				int next = cur + dir;
				if (1 > next || next > FSGUD[0] || dist[next] != 0) continue;

				if (next == FSGUD[2]) {
					System.out.println(dist[cur]);
					return;
				}

				q.add(next);
				dist[next] = dist[cur] + 1;
			}
		}

		System.out.println("use the stairs");
	}
} 