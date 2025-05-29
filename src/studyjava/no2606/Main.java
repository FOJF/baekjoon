package studyjava.no2606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static HashMap<Integer, HashSet<Integer>> computersGraph = new HashMap<>();
    static Queue<Integer> nextComputer = new LinkedList<>();
    static boolean[] hasVirus;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int computerCount = Integer.parseInt(br.readLine());
        hasVirus = new boolean[computerCount];

        int n = Integer.parseInt(br.readLine());


        for (int i = 0; i < n; i++) {
            String[] inputVertices = br.readLine().split(" ");
            int computerA = Integer.parseInt(inputVertices[0]);
            int computerB = Integer.parseInt(inputVertices[1]);
            addCable(computerA, computerB);
        }

        br.close();

        spreadVirus();

        System.out.println(getInfectedComputersCount());
    }

    private static void addCable(int computerA, int computerB) {
        HashSet<Integer> linkedComputersA;
        HashSet<Integer> linkedComputersB;

        if (computersGraph.containsKey(computerA))
            linkedComputersA = computersGraph.get(computerA);
        else linkedComputersA = new HashSet<>();

        if (computersGraph.containsKey(computerB))
            linkedComputersB = computersGraph.get(computerB);
        else linkedComputersB = new HashSet<>();

        linkedComputersA.add(computerB);
        linkedComputersB.add(computerA);

        computersGraph.put(computerA, linkedComputersA);
        computersGraph.put(computerB, linkedComputersB);
    }

    private static void spreadVirus() {
        nextComputer.add(1);
        hasVirus[0] = true;
        while (!nextComputer.isEmpty()) {
            HashSet<Integer> linkedComputers = computersGraph.get(nextComputer.poll());
            if (linkedComputers == null) return; // null 이면 아래 for Each에서 NullPointerException 발생
            linkedComputers.forEach((i) -> {
                if (!hasVirus[i - 1]) {
                    nextComputer.add(i);
                    hasVirus[i - 1] = true;
                }
            });
        }
    }

    private static int getInfectedComputersCount() {
        int infectedComputersCount = 0;
        for (boolean isInfectedComputer : hasVirus) {
            if (isInfectedComputer) infectedComputersCount++;
        }
        return infectedComputersCount-1;
    }
}
