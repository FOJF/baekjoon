package studyjava.no15686;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<int[]> chickens;
    static List<int[]> pickedChickens;
    static List<int[]> houses;
    static int maxChickenCnt;
    static int minCityChickenDist = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        maxChickenCnt = Integer.parseInt(st.nextToken());

        chickens = new ArrayList<>();
        pickedChickens = new ArrayList<>();
        houses = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());

                if (num == 1) houses.add(new int[]{i, j});
                else if (num == 2) chickens.add(new int[]{i, j});
            }
        }

        br.close();

        selectChickens(0);

        System.out.println(minCityChickenDist);
    }

    public static void selectChickens(int start) {
        if (pickedChickens.size() == maxChickenCnt) {

            int cityChickenDist = 0;

            for (int[] housePos : houses) {
                int houseChickenDist = Integer.MAX_VALUE;
                for (int[] chickenPos : pickedChickens) {
                    houseChickenDist = Math.min(houseChickenDist, getDist(chickenPos, housePos));
                }
                cityChickenDist += houseChickenDist;
            }

            minCityChickenDist = Math.min(minCityChickenDist, cityChickenDist);

            return;
        }

        for (int i = start; i < chickens.size(); i++) {
            pickedChickens.add(chickens.get(i));
            selectChickens(i+1);
            pickedChickens.remove(pickedChickens.size() - 1);
        }

    }

    public static int getDist(int[] posA, int[] posB) {
        return Math.abs(posA[0] - posB[0]) + Math.abs(posA[1] - posB[1]);
    }
}
