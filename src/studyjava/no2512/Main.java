import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		br.readLine();

		int[] requests = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int n = requests.length;
		int budget = Integer.parseInt(br.readLine());

		br.close();

		int min = Arrays.stream(requests).min().getAsInt();
		int max = Arrays.stream(requests).max().getAsInt();
		
		int start = budget/n > min ? min : budget/n;
		int end = max;

		int answer = 0;

		while (start <= end) {
			int mid = (start+end)/2;
			int bdgt = budget;

			for(int request : requests) {
				bdgt -= (request > mid) ? mid : request;
			}

			if (bdgt == 0) { // 예산 알맞게 다 씀
				answer = mid;
				break;
			} else if (bdgt > 0) { // 예산 남음
				answer = mid;
				start = mid+1;
			} else { // 예산이 부족
				end = mid-1;
			}
		}
		System.out.println(answer);
	}
}