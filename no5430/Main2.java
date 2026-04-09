import java.io.*;
import java.util.*;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < T; i++) {
            String p = br.readLine();
           	br.readLine();
            String s = br.readLine();
            
            StringTokenizer st = new StringTokenizer(s, "[],");
            while (st.hasMoreTokens()) {
                dq.add(Integer.parseInt(st.nextToken()));
            }

            boolean reverse = false;
            boolean error = false;

            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == 'R') {
                    reverse = !reverse;
                    continue;
                } 

                if (dq.isEmpty()) {
                    error = true;
                    break;
                } 
        
        	    if (reverse) dq.pollLast();
                else dq.pollFirst();
            }

			if (error) {
			    sb.append("error\n");
			} else {
			    sb.append("[");
			    
			    if (!dq.isEmpty()) { 
			        sb.append(reverse ? dq.pollLast() : dq.pollFirst());
			        
			        while (!dq.isEmpty()) {
			            sb.append(",").append(reverse ? dq.pollLast() : dq.pollFirst());
			        }
			    }
			    
			    sb.append("]\n");
			}
        }
        System.out.println(sb);
    }
}