package studyjava.no11727;

import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		br.close();

		if(n == 1) {
			System.out.println(1);
			return;
		}

		int[] answers = new int[]{1,3};

		for(int i = 3; i <= n; i++) {
			int answer = (answers[0]*2 + answers[1])%10007;
			answers[0] = answers[1];
			answers[1] = answer;
		}


		System.out.println(answers[1]);

	}
}

// 정답 보고 품