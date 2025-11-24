import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		long[][] points = new long[N+1][];

		for (int i = 0; i < N; i++) {
			points[i] = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
		}

		points[N] = Arrays.copyOf(points[0], 2);

		long sum = 0;
		for (int i = 0; i < N; i++) {
			sum += points[i][0]*points[i+1][1] - points[i+1][0]*points[i][1];
		}

		System.out.printf("%.1f\n", Math.abs(sum/2.0));
	}
}