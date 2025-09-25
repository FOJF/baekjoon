import java.util.*;
import java.io.*;

public class Main {
  public static void main (String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      Map<Long, Integer> nums = new HashMap<>();
      
      int N = Integer.parseInt(br.readLine());
      for (int i = 0; i < N; i++) {
          long n = Long.parseLong(br.readLine());
          nums.put(n, nums.getOrDefault(n, 0) + 1);
      }
      br.close();
      List<Long> s = new ArrayList<>(nums.keySet());
      s.sort((o1, o2) -> {
          if (nums.get(o1).equals(nums.get(o2)))
              return o1.compareTo(o2);
          return nums.get(o2).compareTo(nums.get(o1));
      });
      System.out.println(s.get(0));
  }
}