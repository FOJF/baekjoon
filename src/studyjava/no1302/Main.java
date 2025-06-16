import java.io.*;
import java.util.*;

public class Main {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		Map<String, Integer> sold = new HashMap<>();
		for (int i = 0; i < n; i++) {
			String bookName = br.readLine();
			sold.put(bookName, sold.getOrDefault(bookName, 0)+1);
		}

		br.close();


		String bestSeller = "";
		int max = 0;

		for (String name : sold.keySet()) {
			int cnt = sold.get(name);

			if (max == 0) bestSeller = name;

			if (max <= cnt) {
				if (max == cnt)
					bestSeller = bestSeller.compareTo(name) > 0 ? name : bestSeller;
				else bestSeller = name;
				max = cnt;
			}
		}

		System.out.println(bestSeller);
	}
}