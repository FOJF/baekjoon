import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		br.readLine();

		int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		int k = Integer.parseInt(br.readLine());

		int start = 0, end = 0;

		long sum = 0, count = 0;

		while (end < nums.length) {
		    sum += nums[end++];

		    while (sum > k) {
		        count += nums.length - end + 1;
		        sum -= nums[start++];
		    }
		}

		System.out.println(count);
	}
}