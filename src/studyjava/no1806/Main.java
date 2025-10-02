import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] NS = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		br.close();


		int l = 0;
		int r = 0;
		
		int sum = nums[0];
		int answer = Integer.MAX_VALUE;

		while(l <= r && r < nums.length) {
			if (sum >= NS[1]) {
				answer = Math.min(answer, r-l+1);
				sum -= nums[l++];
			} else {
				r++;
				if (r < nums.length) sum += nums[r];
					
			}

		}

		System.out.println(answer == Integer.MAX_VALUE ? 0 : answer);
	}
}