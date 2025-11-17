import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int X = Integer.parseInt(br.readLine());

		int tFloors = 0;
		int sum = 0;

		while(sum < X) {
			sum += ++tFloors;
		}

		int offset = sum - X;

		StringBuilder sb = new StringBuilder();

		if (tFloors % 2 == 0)
			sb.append(tFloors-offset).append("/").append(1+offset);
		else
			sb.append(1+offset).append("/").append(tFloors-offset);

		System.out.println(sb);
	}
}