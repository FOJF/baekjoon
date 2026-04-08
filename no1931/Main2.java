import java.io.*;
import java.util.*;

public class Main2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		List<int[]> times = new ArrayList<>();

		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			times.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
		}

		times.sort((a1, a2) -> {
			if (a1[1] == a2[1]) return a1[0] - a2[0];
			return a1[1] - a2[1];
		});

		int answer = 0;
		int finishedT = 0;

		for (int[] time : times) {
			if (finishedT <= time[0]) {
				answer++;
				finishedT = time[1];
			}
		}

		System.out.println(answer);
	}
}