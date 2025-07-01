import java.io.*;
import java.util.*;

class Edge {
    int to;
    int weight;

    public Edge(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }
}

public class Main {
    static List<List<Edge>> adjList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        adjList = new ArrayList<>();

        for (int i = 0; i < n+1; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            adjList.get(a).add(new Edge(b, dist));
            adjList.get(b).add(new Edge(a, dist));
        }

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        br.close();

        int sum1 = getShortestStopOver(new int[]{1,a,b,n}, n);
        int sum2 = getShortestStopOver(new int[]{1,b,a,n}, n);

        int min = Math.min(sum1,sum2);

        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }

    public static int getShortestStopOver(int[] ways, int nodeCnt) {
        int sum = 0;
        for (int i = 0; i < ways.length-1; i++) {
            int shortest = getShortest(ways[i], ways[i+1], nodeCnt);

            if (shortest == Integer.MAX_VALUE) {
                sum = Integer.MAX_VALUE;
                break;
            } else {
                sum += shortest;
            }
        }
        return sum;
    }

    public static int getShortest(int from, int to, int nodeCnt) {
        if (from == to) return 0;

        boolean[] visited = new boolean[nodeCnt+1];

        Queue<int[]> q = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        q.add(new int[]{from,0});

        while(!q.isEmpty()) {
            int[] now = q.poll();

            if (now[0] == to) return now[1];
            if (visited[now[0]]) continue;
            visited[now[0]] = true;

            for (Edge next : adjList.get(now[0])) {
                q.add(new int[]{next.to, next.weight + now[1]});
            }
        }

        return Integer.MAX_VALUE;
    }
}

/*
4 6
1 2 3
2 3 3
3 4 1
1 3 5
2 4 5
1 4 4
2 3
*/