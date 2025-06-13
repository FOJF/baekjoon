import java.io.*;
import java.util.*;

public class Main {
	static int[][] paper;
	static int[] count = new int[2];

	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(br.readLine());
		paper = new int[size][size];

		for(int i = 0; i < size; i++) {
			String[] strArr = br.readLine().split(" ");
			for(int j = 0; j < size; j++) {
				paper[i][j] = Integer.parseInt(strArr[j]);
			}
		}
		br.close();

		countColorPapers(0,0,size);

		for(int answer : count) {
			System.out.println(answer);
		}
	}

	public static void countColorPapers(int x, int y, int searchArea) {
		int firstColor = paper[x][y];

		for (int i = x; i < x+searchArea; i++) {
			for (int j = y; j < y+searchArea; j++) {
				if(paper[i][j] != firstColor) { // 검사하는 로직이 뭐가 잘 못 된 거지? (x+searchArea)/2 가 아니라 x+searchArea/2가 맞는 거였네 너무 헷갈리고
					countColorPapers(x,y,searchArea/2);
					countColorPapers(x+searchArea/2,y,searchArea/2);
					countColorPapers(x,y+searchArea/2,searchArea/2);
					countColorPapers(x+searchArea/2,y+searchArea/2,searchArea/2);
					return;
				}
			}
		}
		count[firstColor]++;
	}
}