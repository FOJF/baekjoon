import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		br.readLine();

		int[] S = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		int N = Arrays.stream(S).sum();

		boolean[] sums = new boolean[N+2];
		bt(S, sums, 0);

		for(int i = 1; i < sums.length; i++) {
			if (!sums[i]) {
				System.out.println(i);
				break;
			}
		}
	}

	private static int sum = 0;

	public static void bt(int[] S, boolean[] sums, int start) {
		for (int i = start; i < S.length; i++) {
			sum += S[i];
			sums[sum] = true;
			bt(S, sums, i+1);
			sum -= S[i];
		}
	}
}