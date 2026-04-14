import java.io.*;
import java.util.*;

public class Main2 {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();

		while(T-- > 0) {
			TreeMap<Integer, Integer> treeMap = new TreeMap<>();
			int k = Integer.parseInt(br.readLine());

			for (int i = 0; i < k; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
			
				if (st.nextToken().charAt(0) == 'I') {
					int num = Integer.parseInt(st.nextToken());
					treeMap.put(num, treeMap.getOrDefault(num,0)+1);
				} else {
					if (treeMap.isEmpty()) continue;

					boolean c = st.nextToken().charAt(0) == '1';
					int key = c ? treeMap.lastKey() : treeMap.firstKey();

					int count = treeMap.get(key); 

					if (count == 1) {
					    treeMap.remove(key);
					} else {
					    treeMap.put(key, count - 1);
					}
				}
			}

			if (treeMap.isEmpty()) sb.append("EMPTY\n");
			else sb.append(treeMap.lastKey()).append(" ").append(treeMap.firstKey()).append("\n");
		}
		System.out.println(sb);
	}
}