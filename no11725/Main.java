package studyjava.no11725;

import java.io.*;
import java.util.*;

public class Main {
	static List<List<Integer>> adjList;
	static int[] parents;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		adjList = new ArrayList<>();

		int k = Integer.parseInt(br.readLine());
        
		for (int i = 0; i < k+1; i++) {
            adjList.add(new ArrayList<>());
        }

		for (int i = 0; i < k-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
            
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            adjList.get(a).add(b);
            adjList.get(b).add(a);
		}

		br.close();

		parents = new int[k+1];

		getParents();

		StringBuilder sb = new StringBuilder();

		for (int i = 2; i < parents.length; i++) {
			sb.append(parents[i]).append("\n");
		}

		System.out.println(sb);
	}

	public static void getParents() {
		Queue<Integer> bfsQ = new LinkedList<>();
		boolean[] isVisited = new boolean[adjList.size()];
		
		bfsQ.add(1);
		isVisited[1] = true;

		while(!bfsQ.isEmpty()) {
			int now = bfsQ.poll();
            
            for (int next : adjList.get(now)) {
                if (isVisited[next]) continue;
                bfsQ.add(next);
				isVisited[next] = true;
                parents[next] = now;
            }
		}
	}
}