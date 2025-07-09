package studyjava.no2230;

import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] numbers = new int[n];

		for (int i = 0; i < n; i++) {
			numbers[i] = Integer.parseInt(br.readLine());
		}

		br.close();

		Arrays.sort(numbers);

		int s = 0;
		int e = 0;

		int answer = Integer.MAX_VALUE;

		while(s <= e && e < n) {
			int gap = numbers[e] - numbers[s];

			if (gap == m) {
				answer = gap;
				break;
			} else if (gap > m) {
				answer = Math.min(answer, gap);
				s++;
			} else {
				e++;
			}
		}

		System.out.println(answer);
	}
}