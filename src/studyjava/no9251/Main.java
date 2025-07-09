package studyjava.no9251;

import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String a = br.readLine();
		String b = br.readLine();

		br.close();

		int[][] lcs = new int[b.length()+1][a.length()+1];

		for (int i = 1; i < lcs.length; i++) {
			char nowB = b.charAt(i-1);
			for (int j = 1; j < lcs[i].length; j++) {
				char nowA = a.charAt(j-1);
				
				lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
				
				if (nowB == nowA) lcs[i][j] = lcs[i-1][j-1]+1;
				else lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
			}
		}

		System.out.println(lcs[b.length()][a.length()]);
		// System.out.println(Arrays.deepToString(lcs));
	}
}

/*
[[0, 0, 0, 0, 0, 0, 0],
 [0, 0, 1, 1, 1, 1, 1],
 [0, 1, 1, 2, 2, 2, 2],
 [0, 1, 1, 2, 2, 2, 3],
 [0, 1, 2, 2, 2, 2, 3],
 [0, 2, 2, 3, 3, 3, 3],
 [0, 2, 2, 3, 3, 4, 4]]
*/