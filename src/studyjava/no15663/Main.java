import java.io.*;
import java.util.*;

public class Main {

	static int[] numbers;
	static boolean[] isPicked;
	// static Set<String> answer = new LinkedHashSet<>();
	static List<Integer> temp = new ArrayList<>();
	static StringBuilder answer = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		br.close();

		Arrays.sort(numbers);
		isPicked = new boolean[numbers.length];

		getAnswer(0,nm[1]);
			
		System.out.println(answer);
	}

	public static void getAnswer(int start, int length) {
		if (temp.size() == length) {

			for (int num : temp) {
				answer.append(num).append(" ");
			}
			answer.append("\n");
			return;
		}

		int lastPick = 0;
		for (int i = 0; i < numbers.length; i++) {
			if (isPicked[i] || lastPick == numbers[i]) continue;

			lastPick = numbers[i];
			temp.add(numbers[i]);
			isPicked[i] = true;
			getAnswer(i+1, length);
			isPicked[i] = false;
			temp.remove(temp.size()-1);
		}
 	}
}