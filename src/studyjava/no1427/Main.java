import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		

		int[] inputs = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();

		Arrays.sort(inputs);

		// System.out.println(Arrays.toString(inputs));

		StringBuilder sb = new StringBuilder();

		for(int i = inputs.length - 1; i >= 0; i--) {
			sb.append(inputs[i]);
		}

		System.out.println(sb);
	}
}