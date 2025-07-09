package studyjava.no7662;// import java.io.*;
// import java.util.*;

// public class Main {
// 	public static void main(String[] args) throws IOException {
// 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

// 		int t = Integer.parseInt(br.readLine());

// 		StringBuilder sb = new StringBuilder();

// 		for (int i = 0; i < t; i++) {
// 			int k = Integer.parseInt(br.readLine());

// 			PriorityQueue<Integer> reversePQ = new PriorityQueue<>(Comparator.reverseOrder());
// 			PriorityQueue<Integer> normalPQ = new PriorityQueue<>();

// 			for (int j = 0; j < k; j++) {
// 				StringTokenizer st = new StringTokenizer(br.readLine());
// 				if (st.nextToken().charAt(0) == 'I') {
// 					int num = Integer.parseInt(st.nextToken());
// 					reversePQ.add(num);
// 					normalPQ.add(num);
// 				} else if (st.nextToken().charAt(0) == '1'){
// 					normalPQ.remove(reversePQ.poll());
// 				} else {
// 					reversePQ.remove(normalPQ.poll());
// 				}
// 			}
// 			if (reversePQ.isEmpty()) sb.append("EMPTY\n");
// 			else sb.append(reversePQ.poll()).append(" ").append(normalPQ.poll()).append("\n");
// 		}

// 		System.out.println(sb);

// 		br.close();
// 	}
// }

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < t; i++) {
			TreeMap<Integer, Integer> treeMap = new TreeMap<>();
			int k = Integer.parseInt(br.readLine());
			for (int j = 0; j < k; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				if (st.nextToken().charAt(0) == 'I') {
					int num = Integer.parseInt(st.nextToken());
					treeMap.put(num, treeMap.getOrDefault(num,0)+1);
				} else if (treeMap.isEmpty()) {
					continue;
				} else if (st.nextToken().charAt(0) == '1'){
					int key = treeMap.lastKey();
					
					treeMap.put(key, treeMap.get(key)-1);
					if (treeMap.get(key) == 0) treeMap.pollLastEntry();
				} else {
					int key = treeMap.firstKey();
					
					treeMap.put(key, treeMap.get(key)-1);
					if (treeMap.get(key) == 0) treeMap.pollFirstEntry();
				}
			}
			if (treeMap.isEmpty()) sb.append("EMPTY\n");
			else sb.append(treeMap.lastKey()).append(" ").append(treeMap.firstKey()).append("\n");
		}

		System.out.println(sb);
	}
}