import java.io.*;
import java.util.*;

public class Main {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		String s = br.readLine();
		br.close();

		System.out.println(getCnt(s,n));
	}

	// public static int getCnt(String s, int n, int i) {
	// 	if (i == 0 || s.length()/2 < i) return 0;
	// 	String ioi = "IO".repeat(i)+"I";

	// 	String[] sArr = s.split(ioi);

	// 	int cnt = 0;
	// 	for (String ss : sArr) {
	// 		// System.out.println(i);
	// 		cnt += getCnt(ss, n, i-1);
	// 	}
	// 	return (sArr.length-1) * (i-n+1)+cnt;
	// }

	public static int getCnt(String s, int n) {
		StringBuilder sb = new StringBuilder();
		int total = 0;

		for (int i = 0; i < n; i++) {
			sb.append("IO");
		}
		sb.append("I");

		String original = sb.toString();

		// int i = s.indexOf(original);
		// while (i != -1) {
		// 	int cnt = 0;
		// 	for (int j = i + original.length(); j+2 <= s.length(); j += 2) {
		// 		if (s.charAt(j) == 'O' && s.charAt(j+1) == 'I') cnt++;
		// 		else break;
		// 	}
		// 	i = s.indexOf(original, i + original.length() + (cnt * 2));
		// 	total += (cnt + 1);
		// }

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != 'I') continue;

			int cnt = 0;
			
			if (!s.startsWith(original, i)) continue;

			for (int j = i + original.length(); j+2 <= s.length(); j += 2) {
				if (s.charAt(j) == 'O' && s.charAt(j+1) == 'I') cnt++;
				else break;
			}
			i = i + original.length() + (cnt * 2)-1;
			total += (cnt + 1);
		}

		return total;
	}
}
/*
1
13
IOIOIOIIIIIOI

2
13
IOIOIOOIOIOI

1
13
IOIOIOIOIOIOI
*/