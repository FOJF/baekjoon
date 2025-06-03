package studyjava.no1927;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		PriorityQueue<Integer> minHeap = new PriorityQueue<>();

		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++) {

			int input = Integer.parseInt(br.readLine());

			if(input == 0) {
				Integer min = minHeap.poll();
				System.out.println(min==null?0:min);

			} else minHeap.add(input);
		}

		br.close();

	}
}
