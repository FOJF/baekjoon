import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] NM = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int[] rcd = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		int[][] room = new int[NM[0]][];

		for(int i = 0; i < room.length; i++) {
			room[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}

		int x = rcd[0];
		int y = rcd[1];
		int d = rcd[2];

		int answer = 0;

		int[][] delta = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
		whileA:
		while(true) {
			if (room[x][y] == 0) {
				room[x][y] = 2;
				answer++;
			}

			for(int i = 0; i < delta.length; i++) {
				int newD = (d+3-i) % 4;
				int newX = x + delta[newD][0];
				int newY = y + delta[newD][1];

				if (room[newX][newY] == 0) {
					x = newX;
					y = newY;
					d = newD;
					continue whileA;
				}
			}

			if (room[x-delta[d][0]][y-delta[d][1]] != 1) {
				x -= delta[d][0];
				y -= delta[d][1];
			} else {
				break;
			}
		}

		System.out.println(answer);
	}
}