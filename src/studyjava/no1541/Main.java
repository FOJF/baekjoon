package studyjava.no1541;

import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] splitedByMinus = br.readLine().split("-");
		br.close();

		int sum = 0;
		int i = 0;
		for(String varMinus : splitedByMinus) {
			if(varMinus.isEmpty()) continue;
			String[] splitedByPlus = varMinus.split("\\+");
			int sumPlus = 0;
			for(String varPlus : splitedByPlus) {
				sumPlus += Integer.parseInt(varPlus);
			}
			if(i++ == 0) sum += sumPlus;
			else sum -= sumPlus;
		}
		System.out.println(sum);
	}
}
