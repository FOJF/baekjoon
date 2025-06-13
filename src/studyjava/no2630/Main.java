import java.io.*;
import java.util.*;

public class Main {
	static int[][] paper;
	static HashSet<String> answer = new HashSet<>();
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		paper = new int[n][n];

		for(int i = 0; i < n; i++) {
			String[] strArr = br.readLine().split(" ");
			for(int j = 0; j < n; j++) {
				paper[i][j] = Integer.parseInt(strArr[j]);
			}
		}
		br.close();

		// System.out.println(checkSameColor(new int[1][1]));
		checkSameColor(0,0,n);
		int count0 = 0;
		int count1 = 0;

		for(String s : answer) {
			if(s.endsWith("1")) count1++;
			else count0++;
		}

		System.out.println(count0);
		System.out.println(count1);

	}

	// public static int countColoredPapers(int[][] paper) {
	// 	if(!checkSameColor(paper,0,0,paper.length)) {
	// 		return checkSameColor(paper, startIdx, ) + checkSameColor(paper, , ) + checkSameColor(paper, , ) + checkSameColor(paper, , );
	// 	}
	// 	return 1;
	// }

	public static void checkSameColor(int idxI, int idxJ, int size) {
		int firstColor = paper[idxI][idxJ];
		StringBuilder sb = new StringBuilder();
		sb.append(idxI).append(idxJ).append(size).append(firstColor);

		System.out.println(sb.toString());
		if(answer.contains(sb.toString())) {System.out.println("이미 해");return;}
		
		// 그냥 여기 로직이 잘못된 거 같음
		for (int i = idxI; i < idxI+size; i++) {
			for(int j = idxJ; j < idxJ+size; j++) {
				if (paper[i][j] != firstColor) {
					int newIdxI = (idxI+size)/2;
					int newIdxJ = (idxJ+size)/2;
					size /= 2;
		System.out.println("실");
					checkSameColor(idxI, idxJ, size);
					checkSameColor(idxI, newIdxJ, size);
					checkSameColor(newIdxI, idxJ, size);
					checkSameColor(newIdxI, newIdxJ, size);
					return;
				}
			}
		}

		System.out.println("통과");

		answer.add(sb.toString());
	}
}