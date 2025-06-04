package studyjava.no11724;

import java.io.*;
import java.util.*;

public class Main {
	static HashMap<Integer, HashSet<Integer>> vertices = new HashMap<>();
	static boolean[] isVisited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] ve = br.readLine().split(" ");

		int vertexCnt = Integer.parseInt(ve[0]);
		int edgeCnt = Integer.parseInt(ve[1]);

		isVisited = new boolean[vertexCnt];

		for(int i = 0; i < edgeCnt; i++) {
			String[] vertex = br.readLine().split(" ");
			addEdge(Integer.parseInt(vertex[0]), Integer.parseInt(vertex[1]));
		}
		// System.out.println("finished ADD EDGE");

		br.close();

		System.out.println(countConnectedComponent());

	}

	public static int countConnectedComponent() {
		int count = 0;
		for(int i = 0; i < isVisited.length; i++) {
			if(isVisited[i]) continue;
			// System.out.println("Start dfs("+(i+1)+")");

			if (dfs(i+1)) count++;

			// System.out.println("Finished dfs("+(i+1)+")");
		}
		return count;
	}

	public static void addEdge(int vertexA, int vertexB) {
		HashSet<Integer> hsA = vertices.get(vertexA);
		HashSet<Integer> hsB = vertices.get(vertexB);
		
		if (hsA == null)
			hsA = new HashSet<>(); 
		if (hsB == null) 
			hsB = new HashSet<>();

		hsA.add(vertexB);
		hsB.add(vertexA);

		vertices.put(vertexA, hsA);
		vertices.put(vertexB, hsB);
	}

	public static boolean dfs(int startVertex) {
		if(isVisited[startVertex-1]) return false;
		Queue<Integer> q = new LinkedList<>();

		q.add(startVertex);
		isVisited[startVertex-1] = true;

		while(!q.isEmpty()) {
			int vertex = q.poll();
			// System.out.println("탐색 : "+vertex);
			HashSet<Integer> linkedVertices = vertices.get(vertex);
			if(linkedVertices == null) return true;

			// System.out.println("linkedVertex");

			for(Integer linkedVertex : linkedVertices) {
			// System.out.println(linkedVertex);

				if(isVisited[linkedVertex-1]) continue;

				q.add(linkedVertex);
				isVisited[linkedVertex-1] = true;
			}
		}

		return true;
	}
}
