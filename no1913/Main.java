import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int target = Integer.parseInt(br.readLine());

		int[][] grid = new int[N][N];

		for(int i = 0; i < grid.length/2+1; i++) {
			fillOutline(grid, i);
		}

		int x = -1;
		int y = -1;

		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid.length; j++) {
				sb.append(grid[i][j]).append(" ");
				if (grid[i][j] == target) {
					x = i+1;
					y = j+1;
				}
			}
			sb.append("\n");
		}

		sb.append(x).append(" ").append(y).append("\n");

		System.out.println(sb);
	}

	public static void fillOutline(int[][] grid, int depth) {
		int d = 2 * depth;
		int startNumber = (grid.length - d) * (grid.length - d);

		int offset = grid.length-d-1;
		int outline = grid.length-depth-1;

		for (int i = depth; i < grid.length-depth; i++) {
			grid[i][depth] = startNumber;
			grid[outline][i] = startNumber - offset;
			grid[grid.length-i-1][outline] = startNumber - offset - offset;
			grid[depth][grid.length-i-1] = startNumber - offset - offset - offset;

			startNumber--;
		}

		grid[depth][depth] = (grid.length - d) * (grid.length - d);
	}
}