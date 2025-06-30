import java.io.*;
import java.util.*;

public class Main {
    static List<List<Integer>> vertices;
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] ve = br.readLine().split(" ");

        int vertexCnt = Integer.parseInt(ve[0]);
        int edgeCnt = Integer.parseInt(ve[1]);

        isVisited = new boolean[vertexCnt + 1];

        vertices = new ArrayList<>();
        for (int i = 0; i < vertexCnt + 1; i++) {
            vertices.add(new ArrayList<>());
        }

        for (int i = 0; i < edgeCnt; i++) {
            String[] vertex = br.readLine().split(" ");
            int a = Integer.parseInt(vertex[0]);
            int b = Integer.parseInt(vertex[1]);
            vertices.get(a).add(b);
            vertices.get(b).add(a);
        }

        br.close();

        System.out.println(countConnectedComponent());

    }

    public static int countConnectedComponent() {
        int count = 0;
        for (int i = 1; i < isVisited.length; i++) {
            if (isVisited[i]) continue;
            bfs(i);
            count++;
        }
        return count;
    }

    public static void bfs(int startVertex) {
        Queue<Integer> q = new LinkedList<>();

        q.add(startVertex);
        isVisited[startVertex] = true;

        while (!q.isEmpty()) {
            int vertex = q.poll();
            List<Integer> linkedVertices = vertices.get(vertex);

            for (Integer linkedVertex : linkedVertices) {
                if (isVisited[linkedVertex]) continue;

                q.add(linkedVertex);
                isVisited[linkedVertex] = true;
            }
        }
    }
}
