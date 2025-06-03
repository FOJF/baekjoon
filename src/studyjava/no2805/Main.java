import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] nmStr = br.readLine().split(" ");
		int n = Integer.parseInt(nmStr[0]);
		int target = Integer.parseInt(nmStr[1]);

		String[] treeHeightStrs = br.readLine().split(" ");
		br.close();

		int[] trees = new int[n];

		for(int i = 0; i < n; i++) {
			trees[i] = Integer.parseInt(treeHeightStrs[i]);
		}

		Arrays.sort(trees);

		int max = Math.max(0,trees[n-1]-target);
		int testHeight = max;

		while(true) {
			if (isPossible(trees, testHeight, target)) 
				max = testHeight++;
			else break;
		}

		System.out.println(max);
	}

	public static boolean isPossible(int[] trees, int height, int target) {
		int sum = 0;
		for(int tree : trees) {
			if(tree > height) {
				sum += tree-height;
			}
		}
		return sum >= target;
	}
}
