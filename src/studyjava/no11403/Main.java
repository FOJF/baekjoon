import java.io.*;
import java.util.*;

public class Main {

	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		boolean[][] ways = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			String[] input = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				ways[i][j] = (input[j].charAt(0) == '1');
			}
		}

		br.close();
		// System.out.println(Arrays.deepToString(ways));

		int[][] answer = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				answer[i][j] = isPossible(ways, i, j);
			}
		}

		// System.out.println(Arrays.deepToString(answer));
		// System.out.println(isPossible(ways,0,0));

		StringBuilder sb = new StringBuilder();

		for (int[] arr : answer) {
			for (int num : arr) {
				sb.append(num).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}

	public static int isPossible(boolean ways[][], int start, int end) {
		// if (start == end) return 1;
		// System.out.println("---------"+start+" "+end+"----------");
		Queue<Integer> bfsQ = new LinkedList<>();
		boolean[] isVisited = new boolean[ways.length];
		bfsQ.offer(start);

		while (!bfsQ.isEmpty()) {
			int vertex = bfsQ.poll();

			for (int i = 0; i < ways[vertex].length; i++) {
					// System.out.println("way = " + ways[vertex][i] + ", " + "isVisited : " + isVisited[i]);
				if (ways[vertex][i] && !isVisited[i]) {
					if (i == end) return 1;
					bfsQ.offer(i);
					isVisited[i] = true;
					// System.out.println(vertex + " -> " + i);
				}
			}
		}
		return 0;
	}
}