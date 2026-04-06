import java.util.*;
import java.io.*;

public class Main2{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		char[] S = br.readLine().toCharArray();

		int answer = 0;

		int continuousIOI = 0;

		for(int i = 0; i < M; i++) {
			if (S[i] == 'I') {
				if (i+2 < M && S[i+1] == 'O' && S[i+2] == 'I') {
					continuousIOI++;
					i++;
				} else {
					if (continuousIOI >= N) answer += continuousIOI-N+1;
					continuousIOI = 0;
				}
			}
		}

		System.out.println(answer);
	}
}