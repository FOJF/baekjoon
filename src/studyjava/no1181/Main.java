package studyjava.no1181;

import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] strs = new String[51]; // 문자열의 길이는 50을 넘지 않는다.
        Arrays.fill(strs, "");

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            strs[str.length()] += " " + str; // 문자열의 길이를 인덱스로 하여 추가
        }
        br.close();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < strs.length; i++) {


            if (strs[i].isEmpty()) continue;

            if(strs[i].length() == i + 1) {
                bw.write(strs[i].trim()+"\n");
                continue;
            }

            String[] sameLengthStrs = strs[i].trim().split(" ");
            Stream<String> strStream= Arrays.stream(sameLengthStrs).distinct().sorted();
            Iterator<String> it = strStream.iterator();
            while (it.hasNext()) {
                bw.write(it.next()+"\n");
            }
        }

        bw.flush();
        bw.close();
    }
}

// 인터넷에서 찾은 방법을 좀 더 개선시켜 봄

//import java.io.*;
//import java.util.Arrays;
//
//public class Main {
//    public static void main(String[] args) throws IOException {
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int n = Integer.parseInt(br.readLine());
//        String[] arr = new String[n];
//
//
//        for (int i = 0; i < n; i++) {
//            arr[i] = br.readLine();
//        }
//        br.close();
//
//        Arrays.sort(arr, (a, b) -> {
//            if (a.length() == b.length()) { // 단어 길이가 같을 경우
//                return a.compareTo(b);
//            } else { // 그 외의 경우
//                return a.length() - b.length();
//            }
//        });
//
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        bw.write(arr[0]+"\n");
//        for (int i = 1; i < n; i++) {
//            // 중복되지 않는 단어만 출력
//            if (arr[i].equals(arr[i - 1])) continue;
//            bw.write(arr[i]+"\n");
//        }
//        bw.flush();
//        bw.close();
//    }
//}
