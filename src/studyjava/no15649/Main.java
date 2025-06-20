
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		br.close();

		int[] nums = new int[nm[0]];
		Arrays.setAll(nums, i -> i+1);

		boolean[] visited = new boolean[nm[0]];

		int[][] answers = new int[getSize(nm[0], nm[1])][nm[1]];

		int[] temp = new int[nm[1]];

		getAnswers(nm[1], nums, temp, answers, visited);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < answers.length; i++) {
			for (int j = 0; j < answers[i].length; j++) {
				sb.append(answers[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static int lastIdx = 0;
	static int tempIdx = 0;
	public static void getAnswers(int target, int[] nums, int[] temp, int[][] answers, boolean[] visited) {
		if (target == tempIdx) {
			answers[lastIdx++] = Arrays.copyOf(temp, temp.length);
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (visited[i]) continue;

			temp[tempIdx++] = nums[i];
			visited[i] = true;
			getAnswers(target, nums, temp, answers, visited);
			tempIdx--;
			visited[i] = false;
		}
	}

	public static int getSize(int n, int m) {
		int size = 1;

		for(int i = 0; i < m; i++) {
			size *= n--;
		}

		return size;
	}
}