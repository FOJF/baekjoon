import java.io.*;
import java.util.*;

public class Main {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		String[] input = br.readLine().split(" ");

		br.close();

		int[] tang = new int[input.length];

		for (int i = 0; i < input.length; i++) {
			tang[i] = Integer.parseInt(input[i]);
		}

		int max = 0;
		HashMap<Integer, Integer> hashMap = new HashMap<>();

		for (int i = 0; i < tang.length; i++) {
			for (int j = i+max; j < tang.length; j++) {
				hashMap.put(tang[j], hashMap.getOrDefault(tang[j], 0) + 1);

				if (hashMap.size() <= 2) {
					max = Math.max(max, j-i+1);
				} else {
					int v = hashMap.get(tang[i]);

					if (v == 1) hashMap.remove(tang[i]);
					else hashMap.put(tang[i], v-1);

					break;
				}
			}	
		}
		System.out.println(max);
	}
}