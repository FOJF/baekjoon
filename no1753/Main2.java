import java.util.*;
import java.io.*;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] VE = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int start = Integer.parseInt(br.readLine());

        List<List<int[]>> adjList = new ArrayList<>();

        for(int i = 0; i < VE[0]+1; i++) {
            adjList.add(new ArrayList<>());
        }

        for(int i = 0; i < VE[1]; i++) {
            int[] uvw = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            adjList.get(uvw[0]).add(new int[]{uvw[1], uvw[2]});
        }

        int[] dist = new int[VE[0]+1];

        Queue<int[]> bfsQ = new PriorityQueue<>((o1, o2) -> {
            return o1[1] - o2[1];
        });

        bfsQ.add(new int[]{start, 1});

        dist[start] = 1;

        while(!bfsQ.isEmpty()) {
            int[] now = bfsQ.poll();

            for(int[] next : adjList.get(now[0])) {
                if (dist[next[0]] != 0 && dist[next[0]] <= dist[now[0]] + next[1]) continue;

                dist[next[0]] = dist[now[0]] + next[1];
                bfsQ.add(new int[]{next[0], dist[next[0]]});
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 1; i < dist.length; i++) {
            sb.append(dist[i] == 0 ? "INF" : dist[i]-1).append("\n");
        }

        System.out.println(sb);
    }
}