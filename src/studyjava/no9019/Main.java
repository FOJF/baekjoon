import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			// System.out.println("----------");
			// System.out.println(a);
			// System.out.println(d(a));
			// System.out.println(s(a));
			// System.out.println(l(a));
			// System.out.println(r(a));


			sb.append(bfs(a, b)).append("\n");
		}

		System.out.println(sb);
		br.close();
	}

	public static String bfs(int start, int target) {
		Queue<Integer> bfsQ = new LinkedList<>();
		String[] tried = new String[10000];

		bfsQ.add(start);
		tried[start] = "";

		while(!bfsQ.isEmpty()) {
			int now = bfsQ.poll();
			// System.out.println(now);
			for (int i = 0; i < 4; i++) {
				int next = 0;
				String cmd = null;
				switch(i) {
					case 0 -> {next =d(now); cmd = "D";}
					case 1 -> {next =s(now); cmd = "S";}
					case 2 -> {next =l(now); cmd = "L";}
					case 3 -> {next =r(now); cmd = "R";}
				}

				if (next == target) return tried[now] + cmd;

				if (tried[next] == null) {
					bfsQ.add(next);
					tried[next] = tried[now] + cmd;
				}
			}
		}		
		return "";
	}

	public static int d(int num) {
		return num * 2 % 10000;
	}

	public static int s(int num) {
		return num-1 == 0 ? 9999 : num-1;
	}

	public static int l(int num) {
		int count = 0;
		return num/1000 + num%1000*10;
	}

	public static int r(int num) {
		return num%10*1000 + num/10;
	}

	/*
	1234 - > 2341
*/
}