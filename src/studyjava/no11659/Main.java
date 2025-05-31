package studyjava.no11659;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nm = br.readLine().split(" ");
		int n = Integer.parseInt(nm[0]);
		int m = Integer.parseInt(nm[1]);

		String[] stringNumbers = br.readLine().split(" ");
		int[] intPreSum = new int[n];

		intPreSum[0] = Integer.parseInt(stringNumbers[0]);

		for(int i = 1; i < n; i++) {
			intPreSum[i] = intPreSum[i-1]+Integer.parseInt(stringNumbers[i]);
		}

		for(int i = 0; i < m; i++) {
			String[] stringJK = br.readLine().split(" ");
			int[] intJK = new int[stringJK.length];
			intJK[0] = Integer.parseInt(stringJK[0]);
			intJK[1] = Integer.parseInt(stringJK[1]);

			int sum = 0;

			if(intJK[0]-2<=-1)
				sum = intPreSum[intJK[1]-1];
			else
				sum = intPreSum[intJK[1]-1] - intPreSum[intJK[0]-2];

			System.out.println(sum);
		}

		br.close();
	}
}

// 누적합
