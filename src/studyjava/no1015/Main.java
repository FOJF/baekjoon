import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		br.close();

		List<int[]> inputs = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			inputs.add(new int[]{i, Integer.parseInt(st.nextToken())});
		}

		inputs.sort((o1, o2) -> o1[1] - o2[1]);

		int[] answer = new int[N];
		for (int i = 0; i < inputs.size(); i++) {
			int[] input = inputs.get(i);

			answer[input[0]] = i;
		}

		StringBuilder sb = new StringBuilder();

		for (int i : answer) {
			sb.append(i).append(" ");
		}

		System.out.println(sb);
	}
}