import java.io.*;
import java.util.*;

public class Main {
	static class Point {
		int x;
		int y;
		int z;

		public Point(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}

	static int[][][] trays;
	static int[][][] distances;

	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		trays = new int[input[2]][input[1]][input[0]];
		distances = new int[input[2]][input[1]][input[0]];

		for (int i = 0; i < trays.length; i++) {
			for (int j = 0; j < trays[i].length; j++) {
				String[] line = br.readLine().split(" ");
				for (int k = 0; k < trays[i][j].length; k++) {
					int tomato = Integer.parseInt(line[k]);
					trays[i][j][k] = tomato;
					distances[i][j][k] = tomato != 0 ? tomato : Integer.MAX_VALUE;
				}
			}
		}

		br.close();

		// System.out.println(Arrays.deepToString(trays));

		for (int i = 0; i < trays.length; i++) {
			for (int j = 0; j < trays[i].length; j++) {
				for (int k = 0; k < trays[i][j].length; k++) {
					if (trays[i][j][k] == 1)
						bfs(new Point(i,j,k));
				}
			}
		} 

		// bfs(new Point(0,1,3));

		// System.out.println(Arrays.deepToString(distances));

		int max = 0;
		for (int i = 0; i < distances.length; i++) {
			for (int j = 0; j < distances[i].length; j++) {
				Arrays.sort(distances[i][j]);
				if(0 <= Arrays.binarySearch(distances[i][j], Integer.MAX_VALUE)) {System.out.println("-1"); return;}

				max = Math.max(max, distances[i][j][distances[i][j].length-1]);
			}
		}
		System.out.println(max-1);
	}

	public static void bfs(Point start) {
		int[][] delta = {{1,0,0},{-1,0,0},{0,1,0},{0,-1,0},{0,0,1},{0,0,-1}};
		Queue<Point> bfsQ = new LinkedList<>();

		bfsQ.offer(start);
		distances[start.x][start.y][start.z] = 1;

		int min = 0;

		while(!bfsQ.isEmpty()) {
			Point cur = bfsQ.poll();

			for (int[] dir : delta) {
				int newX = cur.x + dir[0];
				int newY = cur.y + dir[1];
				int newZ = cur.z + dir[2];


				// System.out.println(newX + " " + newY + " " + newZ);
				if (hasIdx(newX, newY, newZ) && trays[newX][newY][newZ] == -1) distances[newX][newY][newZ] = -1;

				if (isValidPoint(newX, newY, newZ) && distances[newX][newY][newZ] > distances[cur.x][cur.y][cur.z] + 1) {
					bfsQ.offer(new Point(newX, newY, newZ));
					distances[newX][newY][newZ] = distances[cur.x][cur.y][cur.z] + 1;
				}
			}
		}

	}

	public static boolean isValidPoint(int x, int y, int z) {
		return hasIdx(x, y, z) && trays[x][y][z] == 0;
	}

	public static boolean hasIdx(int x, int y, int z) {
		return (0 <= x && x < trays.length) && (0 <= y && y < trays[0].length) && (0 <= z && z < trays[0][0].length);
	}
}

/*
개선 버전 : 
trays와 distances를 따로 분리했었지만 bfs로 할 경우 이미 값이 기록되어있다면 그것이 가장 짧은 날이기 때문에 값이 갱신되야할 필요가 없다.
 -> trays 하나만을 이용, 처음부터 탐색을 시작할 모든 정점을 큐에 넣어놓고 탐색을 시작하게 되면 값이 기록되지 않고 0으로 남아있는 경우에만 탐색할 큐에 저장하면 됨
처음 입력 받을 때 1이면 bfsQ에 모두 담아 버렸고, 0일 경우에 Integer.MAX_VALUE를 저장하던 방식에서 입력받은 그대로 trays에 저장
공백을 기준으로 분리하기 때문에 split 대신 StringTokenizer를 사용해서 속도를 좀 더 개선시킴(처음에 입력받는 배열의 크기는 역순으로 이용하기 때문에 split을 그대로 사용)
*/

/*

import java.io.*;
import java.util.*;

public class Main {
	static class Point {
		int x;
		int y;
		int z;

		public Point(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}

	static int[][][] trays;
	static Queue<Point> bfsQ = new LinkedList<>();

	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		trays = new int[input[2]][input[1]][input[0]];

		for (int i = 0; i < trays.length; i++) {
			for (int j = 0; j < trays[i].length; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
				for (int k = 0; k < trays[i][j].length; k++) {
					trays[i][j][k] = Integer.parseInt(st.nextToken());
                    if (trays[i][j][k] == 1) bfsQ.add(new Point(i,j,k));
				}
			}
		}

		br.close();

		// System.out.println(Arrays.deepToString(trays));
        bfs();

		// bfs(new Point(0,1,3));

		// System.out.println(Arrays.deepToString(distances));

		int max = 0;
		for (int i = 0; i < trays.length; i++) {
			for (int j = 0; j < trays[i].length; j++) {
				for (int k = 0; k < trays[i][j].length; k++) {
                    if (trays[i][j][k] == 0) {System.out.println("-1");return;}
                    max = Math.max(max, trays[i][j][k]);
                }
			}
		}
		System.out.println(max-1);
	}

	public static void bfs() {
		int[][] delta = {{1,0,0},{-1,0,0},{0,1,0},{0,-1,0},{0,0,1},{0,0,-1}};

		while(!bfsQ.isEmpty()) {
			Point cur = bfsQ.poll();

			for (int[] dir : delta) {
				int newX = cur.x + dir[0];
				int newY = cur.y + dir[1];
				int newZ = cur.z + dir[2];


				// System.out.println(newX + " " + newY + " " + newZ);

				if (isValidPoint(newX, newY, newZ) && trays[newX][newY][newZ] == 0) {
					bfsQ.offer(new Point(newX, newY, newZ));
					trays[newX][newY][newZ] = trays[cur.x][cur.y][cur.z] + 1;
				}
			}
		}

	}

	public static boolean isValidPoint(int x, int y, int z) {
		return hasIdx(x, y, z) && trays[x][y][z] == 0;
	}

	public static boolean hasIdx(int x, int y, int z) {
		return (0 <= x && x < trays.length) && (0 <= y && y < trays[0].length) && (0 <= z && z < trays[0][0].length);
	}
}

*/