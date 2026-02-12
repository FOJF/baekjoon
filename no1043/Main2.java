import java.util.*;
import java.io.*;

public class Main2 {

	static int[] heads;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		heads = new int[N+1];

		for(int i = 1; i < heads.length; i++) {
			heads[i] = i;
		}

		st = new StringTokenizer(br.readLine());
		int tCnt = Integer.parseInt(st.nextToken());
		
		int[] truths = new int[tCnt];
		for(int i = 0; i < tCnt; i++) {
			truths[i] = Integer.parseInt(st.nextToken());
		}

		int[] hosts = new int[M];

		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int pCnt = Integer.parseInt(st.nextToken());
			hosts[i] = Integer.parseInt(st.nextToken());

			for(int j = 0; j < pCnt-1; j++) {
				union(hosts[i], Integer.parseInt(st.nextToken()));
			}
		}

		Set<Integer> truthHeads = new HashSet<>();

		for (int t : truths) {
			truthHeads.add(find(t));
		}

		int answer = 0;
		for(int i = 0; i < hosts.length; i++) {
			if (!truthHeads.contains(find(hosts[i]))) answer++;
		}

		System.out.println(answer);
	}

	public static int find(int num) {
		if (num == heads[num]) return num;

		return heads[num] = find(heads[num]);
	}

	public static void union(int a, int b) {
		int headA = find(a);
		int headB = find(b);

		if (headA < headB) {
			heads[headB] = headA;
		} else {
			heads[headA] = headB;
		}
	}
}