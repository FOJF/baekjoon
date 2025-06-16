import java.io.*;
import java.util.*;

public class Main {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input;

		br.readLine();

		input = br.readLine().split(" ");

		Set<Integer> hashSet = new HashSet<>();
		for(String s : input) {
			hashSet.add(Integer.parseInt(s));
		}

		br.readLine();

		input = br.readLine().split(" ");
		br.close();

		StringBuilder sb = new StringBuilder();
		for(String s : input) {
			sb.append(hashSet.contains(Integer.parseInt(s)) ? "1" : "0").append(" ");
		}


		System.out.println(sb);
	}
}