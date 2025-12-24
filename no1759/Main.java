import java.io.*;
import java.util.*;

public class Main {
	static Set<String> answers = new TreeSet<>();
	
	static final int minV = 1;
	static final int minC = 2;

	static int idx = 0;
	static int vCnt = 0;
	static int cCnt = 0;

	static char[] picked;
	static char[] c;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] LC = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		picked = new char[LC[0]];

		c = br.readLine().toCharArray();

		Arrays.sort(c);

		c = Arrays.copyOfRange(c, c.length-LC[1], c.length);

		bt(0);

		StringBuilder sb = new StringBuilder();

		for(String s : answers) {
			sb.append(s).append("\n");
		}

		System.out.println(sb);
	}

	static void bt(int start) {
		if (idx == picked.length) {
			if (vCnt >= minV && cCnt >= minC) {
				answers.add(new String(picked));
			}
			return;
		}

		for(int i = start; i < c.length; i++) {
			picked[idx++] = c[i];

			if (c[i] == 'a' || c[i] == 'e' || c[i] == 'i' || c[i] == 'o' || c[i] == 'u') vCnt++;
			else cCnt++;

			bt(i+1);

			if (c[i] == 'a' || c[i] == 'e' || c[i] == 'i' || c[i] == 'o' || c[i] == 'u') vCnt--;
			else cCnt--;

			idx--;
		}
	}
}