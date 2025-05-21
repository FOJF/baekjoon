package studyjava.no15829;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final BigInteger R = new BigInteger("31");
        final BigInteger M = new BigInteger("1234567891");

        Scanner sc = new Scanner(System.in);

        int length = Integer.parseInt(sc.nextLine());
        String str = sc.nextLine();

        sc.close();

        BigInteger hash = new BigInteger("0");

        for (int i = 0; i < length; i++) {
            BigInteger a = R.pow(i).multiply(BigInteger.valueOf(str.charAt(i) - 'a' + 1));
            hash = hash.add(a);
        }

        hash = hash.remainder(M);

        System.out.println(hash);
    }
}

// int나 long으로 계산 했을 때 테스트케이스가 긴 경우 31의 n제곱 값이 너무 커져
// hash값이 음수로 나오게 되는 오류가 있어값이 너무 커서 50점 밖에 얻지 못했었음
// int나 long으로 처리할 수 없는 경우 BigInteger를 활용하는 방법이 있는 것을 알게 됨