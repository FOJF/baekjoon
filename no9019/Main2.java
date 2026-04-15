import java.io.*;
import java.util.*;

public class Main2 {
	static final int MAX_VALUE = 10000;
	static final char[] CMD = { 'D', 'S', 'L', 'R' };
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		Queue<Integer> bfsQ = new ArrayDeque<>();

		StringBuilder sb = new StringBuilder();

		while(T-- > 0) {
			int[] visited = new int[MAX_VALUE];
			StringTokenizer st = new StringTokenizer(br.readLine());

			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			bfsQ.add(A);
			visited[A] = -1;

			while(!bfsQ.isEmpty()) {
				int cur = bfsQ.poll();

				if (cur == B) {
					bfsQ.clear();
					int r = B;
					StringBuilder ssb = new StringBuilder();
					while(visited[r] != -1) {
						ssb.append(CMD[visited[r]%10]);
						r = visited[r]/10;
					}
					sb.append(ssb.reverse()).append("\n");
					break;
				}

                int d = (cur << 1) % MAX_VALUE;
                if (visited[d] == 0) {
                    visited[d] = cur * 10 + 0;
                    bfsQ.add(d);
                }

                int s = cur == 0 ? MAX_VALUE - 1 : cur - 1;
                if (visited[s] == 0) {
                    visited[s] = cur * 10 + 1;
                    bfsQ.add(s);
                }

                int l = cur / 1000 + (cur % 1000) * 10;
                if (visited[l] == 0) {
                    visited[l] = cur * 10 + 2;
                    bfsQ.add(l);
                }

                int r = (cur % 10) * 1000 + cur / 10;
                if (visited[r] == 0) {
                    visited[r] = cur * 10 + 3;
                    bfsQ.add(r);
                }
			}
		}
		System.out.println(sb);
	}
}