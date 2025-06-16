import java.io.*;
import java.util.*;

public class Main {
	static HashMap<Integer, HashSet<Integer>> hashMap = new HashMap<>();

	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);


		for (int i = 0; i < m; i++) {
			input = br.readLine().split(" ");
			addEdge(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
		}

		br.close();

		int minIdx = 1;
		int minVal = getKevinBaconCnt(1);
		for (int i = 2; i <= n; i++) {
			int cntKB = getKevinBaconCnt(i);
			if (minVal > cntKB) {
				minVal = cntKB;
				minIdx = i;
			}
		}

		System.out.println(minIdx);
	}

	public static void addEdge(int v1, int v2) {
		HashSet<Integer> hs1 = hashMap.getOrDefault(v1, new HashSet<Integer>());
		HashSet<Integer> hs2 = hashMap.getOrDefault(v2, new HashSet<Integer>());

		hs1.add(v2);
		hs2.add(v1);

		hashMap.put(v1, hs1);
		hashMap.put(v2, hs2);
	}


	public static int getKevinBaconCnt (int start) {
		int[] distances = new int[hashMap.size()];
		Arrays.fill(distances, Integer.MAX_VALUE);
		int kevinBaconCnt = 0;

		Queue<Integer> bfsQ = new LinkedList<>();
		bfsQ.add(start);
		distances[start-1] = 0;
		while(!bfsQ.isEmpty()) {
			int cur = bfsQ.poll();
			for(int i : hashMap.get(cur)) {
				if (distances[i-1] > distances[cur-1]+1) {
					bfsQ.add(i);
					distances[i-1] = distances[cur-1]+1;
				}
			}
		}

		for (int i : distances) {
			kevinBaconCnt += i;
		}

		return kevinBaconCnt;
	}

}