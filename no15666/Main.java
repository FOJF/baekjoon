package studyjava.no15666;

import java.io.*;
import java.util.*;

public class Main {

	static int[] nums;
	static StringBuilder answer = new StringBuilder();
	static List<Integer> temp = new ArrayList<>();
	static int cnt;
	static int lastNum = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).distinct().sorted().toArray();

		br.close();

		cnt = nm[1];

		getAnswer();
		System.out.println(answer);
	}

	public static void getAnswer() {
		if (temp.size() == cnt) {
			for(int num : temp) {
				answer.append(num).append(" ");
			}
			answer.append("\n");
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (lastNum > nums[i]) continue;

			int t = lastNum;
			temp.add(nums[i]);
			lastNum = nums[i];
			getAnswer();
			temp.remove(temp.size()-1);
			lastNum = t;
		}
	}
}