import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] NM = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		Map<String, Integer> words = new HashMap<>();
		List<String> answer = new ArrayList<>();

		for(int i = 0; i < NM[0]; i++) {
			String word = br.readLine();
			if (word.length() >= NM[1]) {
				words.put(word, words.getOrDefault(word, 0) + 1);
			}
		}

		Set<Map.Entry<String,Integer>> sets = new TreeSet<>((e1, e2) -> {
			if (e2.getValue() == e1.getValue() && e2.getKey().length() == e1.getKey().length())
				return e1.getKey().compareTo(e2.getKey());

			if (e2.getValue() == e1.getValue())
				return e2.getKey().length() - e1.getKey().length();

			return e2.getValue() - e1.getValue();
		});

		for (Map.Entry<String, Integer> w : words.entrySet()) {
			sets.add(w);
		}
		// System.out.println(sets);

		StringBuilder sb = new StringBuilder();

		for(Map.Entry<String, Integer> w : sets) {
			sb.append(w.getKey()).append("\n");
		}

		System.out.println(sb);
	}
}