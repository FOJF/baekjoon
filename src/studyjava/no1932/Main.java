import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[][] triangle = new int[n][];

		for (int i = 0; i < triangle.length; i++) {
			triangle[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}

		br.close();

		// System.out.println(Arrays.deepToString(triangle));

		for (int i = triangle.length-1; i > 0; i--) {
			for (int j = 0; j < triangle[i].length-1; j++) {
				System.out.println(triangle[i-1][j] + " " + Math.max(triangle[i][j], triangle[i][j+1]));
				triangle[i-1][j] += Math.max(triangle[i][j], triangle[i][j+1]);
			}
		}

		System.out.println(triangle[0][0]);

	}
}