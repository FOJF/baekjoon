import java.io.*;
import java.util.*;

public class Main {
	static int[] distance = new int[100001];
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");

		br.close();

		int n = Integer.parseInt(input[0]);
		int k = Integer.parseInt(input[1]);

		System.out.println(bfs(n,k));
	}

	public static int bfs(int start, int target) {
		if (start == target) return 0;
		Queue<Integer> q = new LinkedList<>();

		q.add(start);
		distance[start] = 1;

		while(!q.isEmpty()) {
			int cur = q.poll();

			if (cur+1 == target || cur-1 == target || cur*2 == target)
				return distance[cur];

			if (0 <= cur+1 && cur+1 <= 100000 && distance[cur+1] == 0) {
				q.add(cur+1);
				distance[cur+1] = distance[cur]+1;
			}
			if (0 <= cur-1 && cur-1 <= 100000 && distance[cur-1] == 0) {
				q.add(cur-1);
				distance[cur-1] = distance[cur]+1;
			}
			if (0 <= cur*2 && cur*2 <= 100000 && distance[cur*2] == 0) {
				q.add(cur*2);
				distance[cur*2] = distance[cur]+1;
			}
		}

		return -1;
	}
}