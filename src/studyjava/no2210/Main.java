import java.io.*;
import java.util.*;

public class Main {
	static Set<Integer> set;
	static char[][] board;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		set = new HashSet<>();
		board = new char[5][5];

		for (int i = 0; i < board.length; i++) {
			char[] charArr = br.readLine().toCharArray();
			for (int j = 0; j < charArr.length; j += 2) {
				board[i][j/2] = charArr[j];
			}
		}

		br.close();

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				dfs(i,j,0);
			}
		}

		System.out.println(set.size());
	}

	static int tmp = 0;
	static int[][] delta = {{0,1},{0,-1},{1,0},{-1,0}};
	public static void dfs(int x, int y, int depth) {
		if (depth > 5) {
			set.add(tmp);
			return;
		}

		for (int[] dir : delta) {
			int nx = x + dir[0];
			int ny = y + dir[1];

			if ((0 <= nx && nx < 5) && (0 <= ny && ny < 5)) {
				tmp = tmp * 10 + board[x][y] - '0';
				dfs(nx, ny, depth+1);
				tmp /= 10;
			}
		}
	}
}