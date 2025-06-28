import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] max = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int[] min = Arrays.copyOf(max, max.length);

		for (int i = 0; i < n-1; i++) {
			int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

			int[] newMax = new int[3];
			int[] newMin = new int[3];

			newMax[0] = input[0] + Math.max(max[0], max[1]);
			newMax[1] = input[1] + Math.max(max[0], Math.max(max[1], max[2]));
			newMax[2] = input[2] + Math.max(max[1], max[2]);

			newMin[0] = input[0] + Math.min(min[0], min[1]);
			newMin[1] = input[1] + Math.min(min[0], Math.min(min[1], min[2]));
			newMin[2] = input[2] + Math.min(min[1], min[2]);

			max = newMax;
			min = newMin;
		}

		System.out.println(Arrays.stream(max).max().getAsInt() + " " + Arrays.stream(min).min().getAsInt());
	}
}