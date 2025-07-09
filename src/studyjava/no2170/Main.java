package studyjava.no2170;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		List<int[]> lines = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] tmp = new int[2];
			tmp[0] = Integer.parseInt(st.nextToken());
			tmp[1] = Integer.parseInt(st.nextToken());
			lines.add(tmp);
		}

		br.close();

		lines.sort((o1, o2) -> {
			if (o1[0] == o2[0]) return o2[1]-o1[1];
			return o1[0] - o2[0];
		});


		// System.out.println(Arrays.deepToString(lines));
		int[] last = lines.get(0);
		int length = lines.get(0)[1]-lines.get(0)[0];


		for (int i = 1; i < lines.size(); i++) {
			if (last[0] <= lines.get(i)[0] && last[1] >= lines.get(i)[1]) continue; // 이미 그려져있는 선의 내부에 있는 선을 중복으로 그리려고 할 때

			if (last[1] > lines.get(i)[0]) { // 중복으로 그리긴 하는데 선이 연장될 때
				length += lines.get(i)[1]-last[1];
				last[1] = lines.get(i)[1];
			} else { // 중복되게 선을 긋지 않을 때
				length += lines.get(i)[1] - lines.get(i)[0];
				last[0] = lines.get(i)[0];
				last[1] = lines.get(i)[1];
			}
		}
		System.out.println(length);
	}
}

/*

4
-1000000000 1000000000
1 5
3 5
6 7

*/