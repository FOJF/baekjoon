import java.util.*;
import java.io.*;

public class Main2 {

	static List<Integer> picked = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();
	static int n;
	static int m;

	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] NM = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		br.close();

		n = NM[0];
		m = NM[1];

		bt(1);

		System.out.println(sb);

	}

	public static void bt(int start) {
		if (picked.size() == m) {
			for(int i : picked) {
				sb.append(i).append(" ");
			}
			sb.append("\n");

			return;
		}

		for (int i = start; i <= n; i++) {
			picked.add(i);

			bt(i);

			picked.remove(picked.size()-1);
		}
	}
}