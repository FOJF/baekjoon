package studyjava.no1920;

import java.io.*;
import java.util.HashSet;

public class Main {
    static HashSet<Integer> strArrToIntHashSet(String[] strArray) {
        // String 배열을 받아서 int HashSet으로 만들어 리턴
        HashSet<Integer> intHS = new HashSet<>();
        for (String s : strArray) {
            intHS.add(Integer.parseInt(s));
        }
        return intHS;
    }

    static int[] strArrToIntArr(String[] strArray) {
        // String 배열을 받아서 int배열로 만들어 리턴
        int[] intArr = new int[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            intArr[i] = Integer.parseInt(strArray[i]);
        }
        return intArr;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N과 M은 사용하지 않아 따로 저장하지 않고 흘려준다.
        // 필요한 데이터들은 공백을 기준으로 분리해 String 배열로 만들어준다.
        br.readLine(); // N
        String[] a = br.readLine().split(" ");
        br.readLine(); // M
        String[] b = br.readLine().split(" ");
        br.close();

        // 처음으로 입력받은 수들은 존재하는 지 여부만 파악하면 되기때문에
        // HashSet을 사용하면 좋을 것이라고 생각
        HashSet<Integer> aSet = strArrToIntHashSet(a);
        // 두번째로 입력받은 수들은 모두 한번씩 검사해줘야해서
        // 배열로 저장해도 충분하다고 생각
        int[] bArr = strArrToIntArr(b);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i : bArr) {
            // 두번째로 받은 수를 하나씩 꺼내서 처음으로 받았던 수의 집합 중에 존재하는 지 판별
            if (aSet.contains(i)) bw.write("1\n"); // Set의 contains 메서드를 사용해 존재하는지 확인
            else bw.write("0\n");
        }

        bw.flush();
        bw.close();
    }
}
