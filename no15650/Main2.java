import java.util.*;
import java.io.*;

public class Main2 {
	static int N;
	static int M;
	static List<Integer> pickedNums = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] NM = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		N = NM[0];
		M = NM[1];
		br.close();

		bt(1);

		System.out.println(sb);
	}

	public static void bt (int start) {
		if (pickedNums.size() == M) {
			for(int num : pickedNums) {
				sb.append(num).append(" ");
			}
			sb.append("\n");

			return;
		}

		for(int i = start; i <= N; i++) {
			pickedNums.add(i);
			bt(i+1);
			pickedNums.remove(pickedNums.size()-1);
		}
	}
}