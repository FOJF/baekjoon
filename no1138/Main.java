import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		br.close();

		List<List<Integer>> inputs = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			int input = Integer.parseInt(st.nextToken());
			
			for (int j = inputs.size(); j <= input; j++) {
				inputs.add(new ArrayList());
			}

			inputs.get(input).add(i+1);
		}

		List<Integer> answer = new LinkedList<>();

		for (int i = 0; i < inputs.size(); i++) {
			for (int j = 0; j < inputs.get(i).size(); j++) {
				answer.add(0, inputs.get(i).get(j));

				int cnt = 0;

				for (int k = 0; k < answer.size()-1; k++) {
					if (answer.get(k) < answer.get(k+1) && cnt == i) break;

					if (answer.get(k) < answer.get(k+1)) cnt++;

					int tmp = answer.get(k);
					answer.set(k, answer.get(k+1));
					answer.set(k+1, tmp);
				}
			}
		}

		StringBuilder sb = new StringBuilder();

		for (int i : answer) {
			sb.append(i).append(" ");
		}

		System.out.println(sb);
	}
}