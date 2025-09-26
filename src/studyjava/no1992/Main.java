import java.util.*;
import java.io.*;

public class Main {
	static int[][] grid;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		grid = new int[N][];

		for (int i = 0; i < N; i++) {
			grid[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
		}

		br.close();

		comp(0, 0, N);

		System.out.println(sb);
	}

	public static void comp(int x, int y, int area) {
		if (area == 1) {
			sb.append(grid[x][y]);
			return;
		}


		if (isSameColors(x, y, area)) {
			sb.append(grid[x][y]);
		} else {
		sb.append("(");
			comp(x, y, area/2);
			comp(x, y + area/2, area/2);
			comp(x + area/2, y, area/2);
			comp(x + area/2, y + area/2, area/2);
		sb.append(")");
		}

	}

	public static boolean isSameColors(int x, int y, int area) {
		int start = grid[x][y];

		for (int i = 0; i < area; i++) {
			for (int j = 0; j < area; j++) {
				if (grid[x+i][y+j] != start) return false;
			}
		}

		return true;
	}
}