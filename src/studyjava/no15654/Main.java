import java.io.*;
import java.util.*;

public class Main {
	
	private static int[] numbers;
	private static boolean[] visited;
	

	private static int[] temp;

	private static List<int[]> answer = new ArrayList<>();
	private static int tempIdx = 0;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		visited = new boolean[nm[0]];

		temp = new int[nm[1]];

		br.close();

		Arrays.sort(numbers);

		getAnswer(nm[1]);

		StringBuilder sb = new StringBuilder();

		for (int[] arr : answer) {
			for (int i : arr) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}

	private static void getAnswer(int target) {
		if (tempIdx == target) {
			answer.add(Arrays.copyOf(temp, temp.length));
			return;
		}

		for (int i = 0; i < numbers.length; i++) {
			if (visited[i]) continue;

			temp[tempIdx++] = numbers[i];
			visited[i] = true;
			getAnswer(target);
			tempIdx--;
			visited[i] = false;

		}
	}
}