import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] costs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		for (int i = 0; i < n-1; i++) {
			int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int[] newCosts = new int[3];

			newCosts[0] = Math.min(costs[1], costs[2]) + input[0];
			newCosts[1] = Math.min(costs[0], costs[2]) + input[1];
			newCosts[2] = Math.min(costs[0], costs[1]) + input[2];

			costs = newCosts;
		}

		br.close();
		System.out.println(Arrays.stream(costs).min().getAsInt());
	}
}