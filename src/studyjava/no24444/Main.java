import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] NMR = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		List<Set<Integer>> adjustList = new ArrayList<>();

		for(int i = 0; i < NMR[0]+1; i++) {
			adjustList.add(new TreeSet<>());
		}

		for(int i = 0; i < NMR[1]; i++) {
			int[] edge = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

			adjustList.get(edge[0]).add(edge[1]);
			adjustList.get(edge[1]).add(edge[0]);
		}

		br.close();

		int[] answer = new int[NMR[0]+1];

		Queue<Integer> bfsQ = new LinkedList<>();

		int visitNo = 1;
		
		bfsQ.add(NMR[2]);
		answer[NMR[2]] = visitNo++;

		while(!bfsQ.isEmpty()) {
			int now = bfsQ.poll();

			for(int next : adjustList.get(now)) {
				if (answer[next] != 0) continue;

				bfsQ.add(next);
				answer[next] = visitNo++;
			}
		}

		StringBuilder sb = new StringBuilder();
		for(int i = 1; i < answer.length; i++) {
			sb.append(answer[i]).append("\n");
		}
		System.out.println(sb);
	}
}