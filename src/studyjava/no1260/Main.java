package studyjava.no1260;

import java.io.*;
import java.util.*;

public class Main {
	static HashMap<Integer, TreeSet<Integer>> vertices = new HashMap<>();
	static boolean[] dfsVisited;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] nmv = strArr2intArr(br.readLine().split(" "));

		int m = nmv[1];

		for(int i = 0; i < m; i++) {
			int[] vertexAB = strArr2intArr(br.readLine().split(" "));

			addEdge(vertexAB[0],vertexAB[1]);
		}
		dfsVisited = new boolean[vertices.size()+1];

		dfs(nmv[2]);
		System.out.println();
		bfs(nmv[2]);
	}

	private static void addEdge(int vertexA, int vertexB) {
		TreeSet<Integer> hsA;
		TreeSet<Integer> hsB;
		
		if (vertices.containsKey(vertexA)) hsA = vertices.get(vertexA);
		else hsA = new TreeSet<>();
		
		if (vertices.containsKey(vertexB)) hsB = vertices.get(vertexB);
		else hsB = new TreeSet<>();

		hsA.add(vertexB);
		hsB.add(vertexA);

		vertices.put(vertexA, hsA);
		vertices.put(vertexB, hsB);
	}

	private static int[] strArr2intArr(String[] strArr) {
		int[] intArr = new int[strArr.length];
		for(int i = 0; i < strArr.length; i++) {
			intArr[i] = Integer.parseInt(strArr[i]);
		}
		return intArr;
	}

	private static void bfs(int startVertex) {
		boolean[] isVisited = new boolean[1001];

		Queue<Integer> bfsQ = new LinkedList<>();
		
		bfsQ.add(startVertex);

		while(!bfsQ.isEmpty()) {
			int vertex = bfsQ.poll();
			if(isVisited[vertex]) continue;

			isVisited[vertex] = true;

			System.out.print(vertex + " ");

			if(!vertices.containsKey(vertex)) continue;

			TreeSet<Integer> linkedVertices = vertices.get(vertex);

			for(Integer i : linkedVertices) {
				if (isVisited[i]) continue;
				
				bfsQ.add(i);
			}
		}

	}

	private static void dfs(int startVertex) {
		boolean[] isVisited = new boolean[1001];

		Stack<Integer> dfsS = new Stack<>();
		
		dfsS.push(startVertex);

		while(!dfsS.isEmpty()) {
			int vertex = dfsS.pop();
			if(isVisited[vertex]) continue;

			isVisited[vertex] = true;

			System.out.print(vertex + " ");

			if(!vertices.containsKey(vertex)) continue;

			NavigableSet<Integer> linkedVertices = vertices.get(vertex).descendingSet();

			for(Integer i : linkedVertices) {
				if (isVisited[i]) continue;
				
				dfsS.push(i);
			}
		}
	}
}

// 문제를 잘 읽자 제발, 방문할 수 있는 정점이 여러 개면 정점 번호가 작은 거 부터 방문한다고 잘 적혀 있다.