import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] NM = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(s -> Integer.parseInt(s) - 1).toArray();

		br.close();

		int answer = 0;

		int idx = 0;
		int lastIdx = NM[0] - 1;
		
		for (int i = 0; i < arr.length; i++) {

			int mvCnt = 0;
			
			if (idx != arr[i]){
				// 오른쪽으로 갔을 때 이동 횟수 계산	
				if (idx > arr[i]) { // 현재 index보다 작은 수인 경우는 마지막까지 갔다가 다시 0번 부터 뺄 곳 까지 이동	
					mvCnt = (lastIdx - idx) + 1 + arr[i];
				} else {
					mvCnt = arr[i] - idx;
				}

				// 왼쪽으로 갔을 때 이동 횟수 계산
				if (idx > arr[i]) {
					mvCnt = Math.min(mvCnt, idx - arr[i]);
				} else {
					mvCnt = Math.min(mvCnt, idx + 1 + (lastIdx - arr[i]));
				}
			}

			answer += mvCnt;

			if (arr[i] == lastIdx) idx = 0;
			else idx = arr[i];
			
			lastIdx--;

			for(int j = i+1; j < arr.length; j++) {
				if (arr[j] > arr[i]) arr[j]--;
			}
		}

		System.out.println(answer);

	}
}