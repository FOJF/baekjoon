import java.io.*;
import java.util.*;

public class Main {
	
	static int[] min;
	// k = 출발지, v = 출발지에서 가능한 도착지, 비용을 저장, v_k = 도착지, v_v = 출발지에서 도착지까지 가는 비용
	static Map<Integer, Map<Integer, Integer>> busInfos;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		busInfos = new HashMap<>();

		int cityCnt = Integer.parseInt(br.readLine());

		min = new int[cityCnt];
		Arrays.fill(min, Integer.MAX_VALUE);

		int busCnt = Integer.parseInt(br.readLine());

		for (int i = 0; i < busCnt; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			addEdge(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		int from = Integer.parseInt(st.nextToken());
		int to = Integer.parseInt(st.nextToken());

		br.close();

		findMinFee(from, to);

		System.out.println(min[to-1]);
		// System.out.println(Arrays.toString(min));
	}

	public static void addEdge(int from, int to, int fee) {
		// k = 도착지, v = 비용
		Map<Integer, Integer> toFeeMap = busInfos.getOrDefault(from, new HashMap<>());

		int originFee = toFeeMap.getOrDefault(to, Integer.MAX_VALUE);
		if (originFee > fee)
			toFeeMap.put(to, fee);

		busInfos.put(from, toFeeMap);
	}

	public static void findMinFee(int from, int to) {
		Queue<Integer> bfsQ = new LinkedList<>();

		bfsQ.add(from);
		min[from-1] = 0;

		while(!bfsQ.isEmpty()) {
			int now = bfsQ.poll();
			Map<Integer, Integer> nowMap = busInfos.get(now);
			if (nowMap == null) continue;
			for (int next : nowMap.keySet()) {
				if (min[next-1] > min[now-1] + nowMap.get(next)) {
					bfsQ.add(next);
					min[next-1] = min[now-1] + nowMap.get(next);
				}
			}
		}
	}
}

/*

5
8
1 2 21
1 3 32
1 4 10
1 5 10
2 4 23
3 4 12
3 5 10
4 5 30
1 5

*/