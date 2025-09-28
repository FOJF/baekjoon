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
		int size = NM[0];
		
		for (int i = 0; i < arr.length; i++) {

			int mvCnt = 0;
			
			if (idx != arr[i]){
		        int right = (arr[i] - idx + size) % size;
		        int left = (idx - arr[i] + size) % size;
		        mvCnt = Math.min(right, left);
			}

			answer += mvCnt;
			size--;

			idx = arr[i] == size ? 0 : arr[i];

			for(int j = i+1; j < arr.length; j++) {
				if (arr[j] > arr[i]) arr[j]--;
			}
		}

		System.out.println(answer);
	}
}