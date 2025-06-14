import java.io.*;
import java.util.*;

public class Main {
	final static int REMOVE_TIME = 2;
	final static int PUT_TIME = 1;

	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");

		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		long blockCnt = Integer.parseInt(input[2]);

		int[][] ground = new int[n][m];


		int highest = 0;

		for (int i = 0; i < n; i++) {
			input = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				ground[i][j] = Integer.parseInt(input[j]);
				highest = Math.max(highest, ground[i][j]);
			}
		}

		br.close();
		
		long answerTime = Integer.MAX_VALUE;
		int answerLevel = highest;

		for (int i = highest; i >= 0; i--) {
			long timeToFlat = getTimeToFlat(ground, i, blockCnt);

			if (timeToFlat == -1) continue;

			if (answerTime > timeToFlat) {
				answerTime = timeToFlat;
				answerLevel = i;
			}
		}

		// System.out.println(answerTime + " " + answerLevel);
		
    	 StringBuilder sb = new StringBuilder();
    	 System.out.println(sb.append(answerTime).append(" ").append(answerLevel));
	}

	public static long getTimeToFlat (int[][] ground, int targetLevel, long blockCnt) {
		long time = 0;
		for (int[] arr : ground) {
			for (int i : arr) {
				if(i <= targetLevel) continue;

				time += REMOVE_TIME * (i - targetLevel);
				blockCnt += (i - targetLevel);
			}
		}

		for (int[] arr : ground) {
			for (int i : arr) {
				if(i >= targetLevel) continue;

				// if(blockCnt == 0) return -1;

				time += PUT_TIME * (targetLevel - i);
				blockCnt -= (targetLevel - i);
				if(blockCnt < 0) return -1;
			}
		}

		return time;
	}
}