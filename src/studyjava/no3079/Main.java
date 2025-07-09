package studyjava.no3079;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken()); // 검사관 수
		int m = Integer.parseInt(st.nextToken()); // 입국심사해야할 인원 수 

		int[] immigration = new int[n];

		for (int i = 0; i < n; i++) {
			immigration[i] = Integer.parseInt(br.readLine());
		}

		br.close();

		long min = Arrays.stream(immigration).min().getAsInt();
		long max = min * m;
		long answer = 0;

		while(min <= max) {
			long mid = (min + max)/2;

			long passedCnt = Arrays.stream(immigration).mapToLong(i -> mid/i).sum();

			if (passedCnt >= m) {
				answer = mid;
				max = mid-1;
			} else {
				min = mid+1;
			}
		}

		System.out.println(answer);
	}
}