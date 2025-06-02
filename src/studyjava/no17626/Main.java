package studyjava.no17626;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		br.close();




		// int min = 4;
		// int testSQRT = (int)Math.sqrt(n);

		// while(n/(testSQRT*testSQRT) < 4) {
		// 	int testNumber = n - testSQRT*testSQRT;
		// 	int count = 1;

		// 	while(testNumber != 0) {
		// 		int sqrt = (int)Math.sqrt(testNumber);
		// 		testNumber -= sqrt*sqrt;
		// 		count++;
		// 	}
		// 	testSQRT--;
		// 	min = Math.min(min, count);
		// }
	

		// System.out.println(min);






		// int testSQRT = (int)Math.sqrt(n);

		System.out.println(getd(n));
	}

	public static int getd(int n) {
		if (n <= 1) return n;
		int testSQRT = (int)Math.sqrt(n);

		n -= testSQRT*testSQRT;
		
		return 1 + getd(n);	
	}
}
