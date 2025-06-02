package studyjava.no9461;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		ArrayList<Long> answers = new ArrayList<>(Arrays.asList(1L,1L,1L,2L,2L));
		ArrayList<Integer> testCases = new ArrayList<>();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for(int i = 0; i < t; i++) {
			testCases.add(Integer.parseInt(br.readLine()));
		}

		br.close();

		for(int testCase : testCases) {
			int i = answers.size();
			while(i < testCase) {
				long answer = answers.get(i-5) + answers.get(i-1);
				answers.add(answer);
				i++;
			}

			long answer = answers.get(testCase-1);

			System.out.println(answer);

		}
	}
}
