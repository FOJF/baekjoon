import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] counts = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		Set<String> strSet = new HashSet<>();

		for(int i = 0; i < counts[0]; i++) {
			strSet.add(br.readLine());
		}

		int answer = 0;
		for(int i = 0; i < counts[1]; i++) {
			if (strSet.contains(br.readLine()))
				answer++;
		}

		System.out.println(answer);
	}
}