package studyjava.no1260;

import java.io.*;
import java.util.*;

public class Main {
	// 각 정점과 연결된 정점들을 저장하는 인접 리스트 (TreeSet을 사용해 항상 정점 번호 오름차순 유지)
	static HashMap<Integer, TreeSet<Integer>> vertices = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 첫 줄 입력: 정점 수(N), 간선 수(M), 시작 정점(V)
		int[] nmv = strArr2intArr(br.readLine().split(" "));
		int m = nmv[1];  // 간선 수

		// M개의 간선을 입력받아 그래프에 추가
		for (int i = 0; i < m; i++) {
			int[] vertexAB = strArr2intArr(br.readLine().split(" "));
			addEdge(vertexAB[0], vertexAB[1]);  // 양방향 간선 추가
		}

		// DFS 수행
		dfs(nmv[2]);
		System.out.println();

		// BFS 수행
		bfs(nmv[2]);
	}

	// 양방향 간선을 그래프에 추가
	private static void addEdge(int vertexA, int vertexB) {
		// 해당 정점이 없으면 TreeSet 생성, 이후 정점 추가
		vertices.computeIfAbsent(vertexA, key -> new TreeSet<>()).add(vertexB);
		vertices.computeIfAbsent(vertexB, key -> new TreeSet<>()).add(vertexA);
	}

	// 문자열 배열을 정수 배열로 변환
	private static int[] strArr2intArr(String[] strArr) {
		int[] intArr = new int[strArr.length];
		for (int i = 0; i < strArr.length; i++) {
			intArr[i] = Integer.parseInt(strArr[i]);
		}
		return intArr;
	}

	// 너비 우선 탐색(BFS)
	private static void bfs(int startVertex) {
		boolean[] isVisited = new boolean[1001];  // 정점 방문 여부 (정점 번호는 1 이상 1000 이하로 가정)
		Queue<Integer> bfsQ = new LinkedList<>();

		bfsQ.add(startVertex);  // 시작 정점을 큐에 추가

		while (!bfsQ.isEmpty()) {
			int vertex = bfsQ.poll();  // 큐에서 하나 꺼냄

			if (isVisited[vertex]) continue;  // 이미 방문한 정점이면 스킵
			isVisited[vertex] = true;         // 방문 처리
			System.out.print(vertex + " ");   // 출력

			if (!vertices.containsKey(vertex)) continue;  // 연결된 정점이 없으면 스킵

			TreeSet<Integer> linkedVertices = vertices.get(vertex);  // 연결된 정점들 (오름차순)

			// 방문하지 않은 정점들을 큐에 추가
			for (Integer i : linkedVertices) {
				if (isVisited[i]) continue;
				bfsQ.add(i);
			}
		}
	}

	// 깊이 우선 탐색(DFS) - 스택 기반
	private static void dfs(int startVertex) {
		boolean[] isVisited = new boolean[1001];  // 정점 방문 여부
		Stack<Integer> dfsS = new Stack<>();

		dfsS.push(startVertex);  // 시작 정점을 스택에 push

		while (!dfsS.isEmpty()) {
			int vertex = dfsS.pop();  // 스택에서 하나 꺼냄

			if (isVisited[vertex]) continue;  // 이미 방문한 정점이면 스킵
			isVisited[vertex] = true;         // 방문 처리
			System.out.print(vertex + " ");   // 출력

			if (!vertices.containsKey(vertex)) continue;  // 연결된 정점이 없으면 스킵

			// 내림차순으로 순회하여 스택에 넣으면 출력은 오름차순이 됨
			NavigableSet<Integer> linkedVertices = vertices.get(vertex).descendingSet();

			// 방문하지 않은 정점들을 스택에 추가
			for (Integer i : linkedVertices) {
				if (isVisited[i]) continue;
				dfsS.push(i);
			}
		}
	}
}