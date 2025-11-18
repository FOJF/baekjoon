import java.io.*;
import java.util.*;

public class DFS {
    static List<List<Integer>> adjList;
    static int[] parents;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        adjList = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());

        parents = new int[n + 1];
        visited = new boolean[n + 1];
        for (int i = 0; i < n + 1; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adjList.get(a).add(b);
            adjList.get(b).add(a);
        }

        br.close();

        dfs(1);

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i < parents.length; i++) {
            sb.append(parents[i]).append("\n");
        }

        System.out.println(sb);
    }

    public static void dfs(int start) {
        if (visited[start]) return;
        visited[start] = true;

        for (int next : adjList.get(start)) {
            if (visited[next]) continue;
            parents[next] = start;
            dfs(next);
        }
    }
} 