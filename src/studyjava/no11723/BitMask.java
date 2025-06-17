import java.io.*;

public class BitMask {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int bit = 0;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            switch (s[0]) {
                case "add" -> bit |= 1 << Integer.parseInt(s[1])-1;
                case "remove" -> bit &= ~(1<<Integer.parseInt(s[1])-1);
                case "check" -> {
                    int x = Integer.parseInt(s[1])-1;
                    sb.append((bit & (1 << x)) == 0 ? 0 : 1).append("\n");
                }
                case "toggle" -> bit ^= 1 << (Integer.parseInt(s[1]) - 1);
                case "all" -> bit = 33554431;
                case "empty" -> bit = 0;
            }
        }
        System.out.println(sb);

        br.close();
    }

}