import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();

		int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		int x = Integer.parseInt(br.readLine());
		br.close();

		Arrays.sort(nums);

		int l = 0;
		int r = nums.length - 1;

		int answer = 0;
		while(l < r) {
			int sum = nums[l] + nums[r];
			
			if (sum == x) {
				answer++;
				l++;
			} else if (sum < x) {
				l++;
			} else {
				r--;
			}
		}

		System.out.println(answer);
	}
}