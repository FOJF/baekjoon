import java.io.*;
import java.util.*;

public class Main {

	static int[] numbers;
	static List<int[]> lotterys;
	static int[] temp;
	static int tempIdx = 0;

	final static int MAX_CNT = 6;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int k = Integer.parseInt(st.nextToken());
			if (k == 0) break;
	
			numbers = new int[k];
	
			for (int i = 0; i < numbers.length; i++) {
				numbers[i] = Integer.parseInt(st.nextToken());
			}
	
			Arrays.sort(numbers);
			
			temp = new int[MAX_CNT];
	
			lotterys = new ArrayList<>();
	
			pickLotterys(0);
	
			for (int i = 0; i < lotterys.size(); i++) {
				for (int j = 0; j < lotterys.get(i).length; j++) {
					sb.append(lotterys.get(i)[j]).append(" ");
				}
				sb.append("\n");
			}
			sb.append("\n");
		}
		System.out.println(sb);
		br.close();
	}


	public static void pickLotterys(int start) {
		if (tempIdx == MAX_CNT) {
			lotterys.add(Arrays.copyOf(temp, temp.length));
			return;
		}

		for (int i = start; i < numbers.length; i++) {
			temp[tempIdx++] = numbers[i];
			pickLotterys(i+1); // i+1임을 주의!! (사실상 순열이기 때문에)
			tempIdx--;
		}
	}
}