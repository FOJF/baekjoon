package studyjava.no1629;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        long a = Integer.parseInt(input[0]);
        long b = Integer.parseInt(input[1]);
        long c = Integer.parseInt(input[2]);

        br.close();

        System.out.println(aPowbModc(a,b,c));
    }
    
    public static long aPowbModc(long a, long b, long c) {
        if (b < 2) return a%c;
        
        long bb = aPowbModc(a,b/2,c);
        
        if (b%2 == 0) {
            return ((bb%c) * (bb%c)) % c;
        } else {
            return ((((bb%c)*(bb%c))%c)*(a%c))%c;
        }
    }
}