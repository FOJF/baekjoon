import java.io.*;
import java.util.*;

public class Main {

	static int[] numbers;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();
		numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		br.close();

		visited = new boolean[numbers.length];

		getLength(0);

		System.out.println(max);
	}

	static int length = 0;
	static int max = 0;
	static int lastNum = 0;

	public static void getLength(int start) {
		for (int i = start; i < numbers.length; i++) {
			if (numbers[i] > lastNum && (length + numbers.length-i) > max) {
				length++;
				int tmp = lastNum;
				lastNum = numbers[i];
				max = Math.max(length, max);
				getLength(i+1);
				length--;
				lastNum = tmp;
			}
		}
	}
}