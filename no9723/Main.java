import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
        	int[] sides = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).map(side -> side*side).toArray();

        	sb.append("Case #").append(i+1).append(": ");

        	if (sides[0] == sides[1]+sides[2] || sides[1] == sides[0]+sides[2] || sides[2] == sides[1]+sides[0])
        		sb.append("YES");
        	else
        		sb.append("NO");

        	sb.append("\n");
        }

        System.out.println(sb);
	}
}