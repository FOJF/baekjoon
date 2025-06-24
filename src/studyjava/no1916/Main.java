import java.io.*;
import java.util.*;

public class Main {
	
	static int[] min;
	// k = 출발지, v = 출발지에서 가능한 도착지, 비용을 저장, v_k = 도착지, v_v = 출발지에서 도착지까지 가는 비용
	static Map<Integer, Map<Integer, Integer>> 버스경로랑비용들;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		busTable = new HashMap<>();

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
		System.out.println(Arrays.toString(min));
	}

	public static void addEdge(int 출발지, int 도착지, int 비용) {
		// k = 도착지, v = 비용
		Map<Integer, Integer> 갈수있는도시와비용들 = 버스경로랑비용들.getOrDefault(출발지, new HashMap<>());

		도착지까지의비용모음.put(도착지, 비용);

		버스경로랑비용들.put(출발지, 도착지까지의비용모음);
	}

	public static void findMinFee(int from, int to) {
		Queue<Integer> bfsQ = new LinkedList<>();

		bfsQ.add(from);
		min[from-1] = 0;

		while(!bfsQ.isEmpty()) {
			int now = bfsQ.poll();
			Map<Integer, Integer> nowMap = busTable.get(now);
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