import java.io.*;
import java.util.*;

public class Main {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		
		br.close();
		
		int[] arr = new int[n];

		Set<Integer> treeSet = new TreeSet<>();
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(input[i]);
			treeSet.add(num);
			arr[i] = num;
		}
		List<Integer> list = new ArrayList<>(treeSet);

		StringBuilder sb = new StringBuilder();

		for(int num : arr) {
			sb.append(Collections.binarySearch(list, num)).append(" ");
		}
		
		System.out.println(sb);
	}
}