// package studyjava.no11866;

// import java.io.*;

// public class Main {
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         String s = br.readLine();
//         br.close();

//         int n = Integer.parseInt(s.split(" ")[0]);
//         int k = Integer.parseInt(s.split(" ")[1]);

//         int[] numbers = new int[n];

//         for (int i = 0; i < n; i++) {
//             numbers[i] = i + 1;
//         }

//         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//         bw.write("<");

//         int size = numbers.length;
//         int index = -1;

//         while (size > 1) {
//             int countNotEmpty = 0;

//             while (countNotEmpty < k) {
//                 index = (index + 1) % numbers.length;

//                 if (numbers[index] != 0) countNotEmpty++;

//                 System.out.println("numbers[" + index + "] = " + numbers[index] + " " + countNotEmpty);
//             }
//             System.out.println("-------");

//             int removedNum = pop(numbers, index);
//             bw.write(removedNum + ", ");
//             size--;
//         }

//         for (int number : numbers) {
//             if (number != 0) {
//                 bw.write(number + ">");
//                 break;
//             }
//         }

// //        bw.write("\b\b>\n"); // 콘솔 출력 상황이 아니라면 예상한 것과 다르게 동작 가능함 -> 그래서 틀림
//         bw.flush();
//         bw.close();
//     }

//     static int pop(int[] targetArr, int index) {
//         int val = targetArr[index];
//         targetArr[index] = 0;
//         return val;
//     }
// }


// // \b는 모든 경우에 상상한 것처럼 작동 하지 않는다. 최대한 사용을 피해야할듯....


import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        br.close();

        int n = Integer.parseInt(s.split(" ")[0]);
        int k = Integer.parseInt(s.split(" ")[1]);

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            q.offer(i+1);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        while (!q.isEmpty()) {
            int curIdx = 1;
            while (curIdx++ < k) {
                q.offer(q.poll());
            }

            sb.append(q.poll()).append(", ");
        }

        sb.setLength(sb.length()-2);
        sb.append(">");
        System.out.println(sb);
    }
}