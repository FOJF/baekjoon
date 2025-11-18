package studyjava.no16401;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int m = Integer.parseInt(st.nextToken()); // 조카 인원 수 
		int n = Integer.parseInt(st.nextToken()); // 과자의 수 

		int[] snacks = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		br.close();

		int min = 1;
		int max = Arrays.stream(snacks).max().getAsInt();
		int answer = 0;

		while(min <= max) {
			int mid = (min+max)/2;

			int cnt = Arrays.stream(snacks).map(i -> i/mid).sum();

			if (cnt >= m) {
				answer = mid;
				min = mid+1;
			} else {
				max = mid-1;
			}
		}

		System.out.println(answer);
	}
}