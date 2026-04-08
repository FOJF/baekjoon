import java.io.*;
import java.util.*;

public class Main2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int answer = 0;

		while(N-- > 0) {
			
			int half = (1 << N);
			
			int q = 0;
			if (r >= half) {
				r -= half;
				q += 2;
			}
			if (c >= half) {
				c -= half;
				q += 1;
			}
			answer += q * half * half;

			// System.out.println(r + ", " + c);
			// System.out.println("(" + 0 + ", " + 0 + ")" + " -> " + 0 * half * half);
			// System.out.println("(" + 0 + ", " + half + ")" + " -> " + 1 * half * half);
			// System.out.println("(" + half + ", " + 0 + ")" + " -> " + 2 * half * half);
			// System.out.println("(" + half + ", " + half + ")" + " -> " + 3 * half * half);
			// System.out.println(half + ", " + q);
		}

		System.out.println(answer);
	}
}

//0  0,0 -> 0 * 2^(N-1)
//1  0, 2^(N-1) -> 1 * (2^(N-1))^2
//2  2^(N-1), 0 -> 2 * (2^(N-1))^2
//3  2^(N-1), 2^(N-1) -> 3 * (2^(N-1))^2

// 2^(2*N-2)

// 1 << (N-1)
// 1 << (2*N-2)