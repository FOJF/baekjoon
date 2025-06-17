import java.io.*;
import java.util.*;

public class Main {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[][] times = new int[n][2];

		for (int i = 0; i < n; i++) {
			times[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}

		br.close();

		Arrays.sort(times, (time1, time2) -> {
			if (time1[1] == time2[1]) return time1[0] - time2[0];

			return time1[1] - time2[1];
		});

		int cnt = 1;
		int endTime = times[0][1];
		for (int i = 1; i < times.length; i++) {
			if (times[i][0] < endTime) continue;

			cnt++;
			endTime = times[i][1];
		}
		System.out.println(cnt);
	}
}

/*
11
1 4
3 5
0 6
5 7
3 8
5 9
6 10
8 11
8 12
2 13
12 14
*/