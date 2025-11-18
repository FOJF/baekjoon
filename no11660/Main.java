package studyjava.no11660;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int[][] preSum = new int[nm[0]][nm[0]];

		for (int i = 0 ; i < preSum.length; i++) {
			int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			for (int j = 0; j < preSum[i].length; j++) {

				if (j!= 0) input[j] = input[j-1] + input[j];

				if (i == 0) preSum[i][j] = input[j];
				else preSum[i][j] = input[j] + preSum[i-1][j];
			}
		}


		// System.out.println(Arrays.deepToString(preSum));

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < nm[1]; i++) {
			int[] xyxy = Arrays.stream(br.readLine().split(" ")).mapToInt(s -> Integer.parseInt(s)-1).toArray();
			int answer = 0;
			
			if (xyxy[0] == 0 && xyxy[1] == 0) {
				answer = preSum[xyxy[2]][xyxy[3]];
			} else if (xyxy[0] == 0) {
				answer = preSum[xyxy[2]][xyxy[3]] - preSum[xyxy[2]][xyxy[1]-1];
			} else if (xyxy[1] == 0) {
				answer = preSum[xyxy[2]][xyxy[3]] - preSum[xyxy[0]-1][xyxy[3]];
			} else {
				answer = preSum[xyxy[2]][xyxy[3]]- preSum[xyxy[0]-1][xyxy[3]]- preSum[xyxy[2]][xyxy[1]-1] + preSum[xyxy[0]-1][xyxy[1]-1];
			}

			sb.append(answer).append("\n");

		}
		br.close();
		System.out.println(sb);
	}
}

/*

2 6
1 2
3 4
1 1 1 1
1 2 1 2
2 1 2 1
2 2 2 2
1 1 2 2
1 2 2 2
*/