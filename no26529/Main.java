import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        int[] f = new int[46];
        
        f[0] = 1;
        f[1] = 1;
        
        int fIdx = 2;
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
                        
            for (; fIdx <= n; fIdx++) {
                f[fIdx] = f[fIdx-1] + f[fIdx-2];
            }

            sb.append(f[n]).append("\n");
        }
        
        System.out.println(sb);
    }
}