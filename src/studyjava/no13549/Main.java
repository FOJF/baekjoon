import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		br.close();

		System.out.println(getSecond(nm[0], nm[1]));

	}

	public static int getSecond(int from, int to) {
		Map<Integer, Integer> dist = new HashMap<>();
		Queue<Integer> bfsQ = new LinkedList<>();

		bfsQ.add(from);
		dist.put(from, 0);

		while(!bfsQ.isEmpty()) {
			int now = bfsQ.poll();

			// {다음으로 갈 수 있는 위치, 다음 위치에 도달했을 때 지금까지의 경로를 이용했을때 걸린 시간}들
			int[][] nexts = {{now-1, dist.get(now)+1}, {now+1, dist.get(now)+1}, {now*2, dist.get(now)}}; 

			for (int[] next : nexts) {
				// 범위를 벗어났거나, 이미 더 적은 시간이 걸리는 경로를 발견한 경우는 continue
				if (next[0] < 0 || next[0] > 100000 || dist.getOrDefault(next[0], Integer.MAX_VALUE) <= next[1]) continue;

				bfsQ.add(next[0]);
				dist.put(next[0], next[1]);
			}
		}
		return dist.get(to);
	}
}