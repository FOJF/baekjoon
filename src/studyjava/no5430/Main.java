package studyjava.no5430;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        loop:
        for (int i = 0; i < t; i++) {
            String cmd = br.readLine();
            int arrLength = Integer.parseInt(br.readLine());
            String arrInput = br.readLine();

            if (arrLength > 0) {
                int[] arr = Arrays.stream(arrInput.substring(1, arrInput.length() - 1).split(",")).mapToInt(Integer::parseInt).toArray();
                Deque<Integer> dq = new ArrayDeque<>();

                for (int num : arr) {
                	dq.addLast(num);
                }

	            boolean isFirst = true;
	            StringBuilder sbSub = new StringBuilder();
	            sbSub.append("[");
	            for (char c : cmd.toCharArray()) {
	            	if (c == 'R') isFirst = !isFirst;
	            	else {
	            		if (dq.size() == 0) {
	            			sb.append("error\n");
	            			continue loop;
	            		}
	            		else {
	            			if(isFirst) dq.pollFirst();
	            			else dq.pollLast();
	            		}
	            	}
	            }
	            sb.append(dequeToString(dq, isFirst));
            } else {
                if (cmd.indexOf('D') < 0) sb.append("[]\n");
                else sb.append("error\n");
                // sb.append("error\n");
            }
        }
        System.out.println(sb);
        br.close();
    }

    public static String dequeToString(Deque<Integer> dq, boolean isFirst) {
    	// if (dq.isEmpty()) return "error\n";
    	if (dq.isEmpty()) return "[]\n";

    	StringBuilder sb = new StringBuilder();
    	sb.append("[");

    	while(!dq.isEmpty()) {
    		sb.append(isFirst?dq.pollFirst():dq.pollLast()).append(",");
    	}

    	sb.setLength(sb.length()-1);
    	sb.append("]\n");

    	return sb.toString();
    }
}