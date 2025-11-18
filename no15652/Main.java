package studyjava.no15652;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		br.close();

		getAnswer(1,0,nm[0],nm[1], "");
	}

	public static void getAnswer(int start, int depth, int n, int m, String s) {
		if (depth == m) {
			System.out.println(s);
			return;
		}
		for (int i = start; i <= n; i++) {
			getAnswer(i, depth+1, n, m, s + i + " ");
		}
	}	
}