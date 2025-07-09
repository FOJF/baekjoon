package studyjava.no1074;

import java.io.*;
import java.util.*;

public class Main {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		br.close();

		// for (int n = 1; n <= 30; n++)
		// 	System.out.println((int) Math.pow(2,n)/2);

		System.out.println(getIdx(Integer.parseInt(input[0]), Integer.parseInt(input[1]), Integer.parseInt(input[2])));

	}

	static int getIdx(int n, int x, int y) {
		if (n < 0) return 0;
		int splitIdx = (int) Math.pow(2,n-1);
		// System.out.println(splitIdx);

		int partX = x < splitIdx ? 0 : 1;
		int partY = y < splitIdx ? 0 : 1;
		// System.out.println(partX + " " + partY);

		int part = partX*2 + partY;

		int newX = x - partX*splitIdx;
		int newY = y - partY*splitIdx;
		// System.out.println((int)Math.pow(2, 2*(n-1)) * part);
		return (int)Math.pow(2, 2*(n-1)) * part + getIdx(n-1, newX, newY);
	}
}