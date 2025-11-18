package studyjava.no14002;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();

		int[] numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		br.close();


		List<List<Integer>> list = new ArrayList<>();

		list.add(new ArrayList<>());
		list.get(0).add(numbers[0]);

		for (int i = 1; i < numbers.length; i++) {
			int maxIdx = -1; // 가능한 것 중에 가장 긴 수열을 가진 인덱스
			int maxSize = 0; // 가능한 것 중 가장 긴 수열의 길이

			for (int j = 0; j < i; j++) {
				if (numbers[j] < numbers[i] && maxSize < list.get(j).size()) { // j가 가능하다면
					maxIdx = j;
					maxSize = list.get(j).size();
				}
			}

			List<Integer> temp = null;
			if (maxIdx == -1) { // 가능한 것이 없었다면
				temp = new ArrayList<>();
			} else { // 가능한 것의 인덱스를 찾았다면
				temp = new ArrayList<>(list.get(maxIdx));
			}

			temp.add(numbers[i]);
			list.add(temp);
		}

		int maxIdx = 0;
		for (int i = 1; i < list.size(); i++) {
			if (list.get(i).size() > list.get(maxIdx).size())
				maxIdx = i;
		}

		// System.out.println(list);

		StringBuilder sb = new StringBuilder();

		sb.append(list.get(maxIdx).size()).append("\n");

		for (int n : list.get(maxIdx)) {
			sb.append(n).append(" ");
		}
		System.out.println(sb);
	}
}

/*
6
10 20 10 30 20 50
*/