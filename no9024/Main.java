import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			int[] nk = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

			Arrays.sort(nums);

			int diff = Integer.MAX_VALUE;
			int answer = 0;

			int l = 0;
			int r = nums.length - 1;

			while(l < r) {
				int nDiff = Math.abs(nk[1] - (nums[l] + nums[r]));

				if (diff == nDiff) {
					answer++;
				} else if (nDiff < diff) {
					answer = 1;
					diff = nDiff;
				} 
				
				if (nums[l] + nums[r] < nk[1]) {
					l++;
				} else {
					r--;
				}
			}

			sb.append(answer).append("\n");
		}

		br.close();

		System.out.println(sb);
	}
}