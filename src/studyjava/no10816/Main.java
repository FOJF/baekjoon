package studyjava.no10816;

import java.io.*;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        br.readLine();
        HashMap<Integer, Integer> deck = StrToIntHashMap(br.readLine());
        br.readLine();
        int[] numbers = StrToIntArr(br.readLine());

        br.close();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int number : numbers) {
            // 상근이가 가지고 있는 카드 중 입력 받은 숫자가 있는 지 확인
            Integer hasNumber = deck.get(number); // 상근이 카드 중에 있는 지
            if (hasNumber == null) hasNumber = 0; // 없으면 0, 있으면 그대로
            bw.write(hasNumber + " ");
        }
        bw.flush();
        bw.close();
    }

    static HashMap<Integer, Integer> StrToIntHashMap(String s) {
        String[] sSplit = s.split(" ");
        HashMap<Integer, Integer> integerHashMap = new HashMap<>();

        // k = 카드 숫자, v = 카드의 장수
        for (String a : sSplit) {
            int key = Integer.parseInt(a);
            Integer value = integerHashMap.get(key); // 카드가 저장이 된 적 있는 지 확인, null 값이 리턴 될 수 있어서 int가 아닌 Integer 사용
            value = (value == null) ? 1 : (value + 1); // 카드의 정보를 저장한 적이 없으면 1장, 있으면 +1장
            integerHashMap.put(key, value); // 카드의 정보 저장
        }

        return integerHashMap;
    }

    static int[] StrToIntArr(String s) {
        String[] sSplit = s.split(" ");
        int[] intArr = new int[sSplit.length];
        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = Integer.parseInt(sSplit[i]);
        }
        return intArr;
    }
}
