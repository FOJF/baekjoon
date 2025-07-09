package studyjava.no10815;

import java.io.*;
import java.util.*;

public class Main {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input;

		br.readLine();

		input = br.readLine().split(" ");

		Set<String> hashSet = new HashSet<>();
		for(String s : input) {
			hashSet.add(s);
		}

		br.readLine();

		input = br.readLine().split(" ");
		br.close();

		StringBuilder sb = new StringBuilder();
		for(String s : input) {
			sb.append(hashSet.contains(s) ? "1" : "0").append(" ");
		}

		System.out.println(sb);
	}
}