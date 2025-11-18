import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		for(int i = -999; i <= 999; i++) {
			for(int j = -999; j <= 999; j++) {
				if (i * inputs[0] + j * inputs[1] == inputs[2] && i * inputs[3] + j * inputs[4] == inputs[5]) {
					System.out.println(i + " " + j);
					return;
				}
			}	
		}
	}
}