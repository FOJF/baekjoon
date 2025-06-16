import java.io.*;

public class Main {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // n개의 'OI' 반복
		int m = Integer.parseInt(br.readLine()); // 문자열 s의 길이
		String s = br.readLine();
		br.close();

		System.out.println(getCnt(s, n));
	}

	public static int getCnt(String s, int n) {
		int count = 0;
		int patternCount = 0;
		int i = 1;

		while (i < s.length() - 1) {
			if (s.charAt(i - 1) == 'I' && s.charAt(i) == 'O' && s.charAt(i + 1) == 'I') {
				patternCount++;
				i += 2;

				if (patternCount >= n) {
					count++;
				}
			} else {
				i++;
				patternCount = 0;
			}
		}

		return count;
	}
}