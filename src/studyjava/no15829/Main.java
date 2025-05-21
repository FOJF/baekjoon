package studyjava.no15829;

import java.math.BigInteger;
import java.util.Scanner;

//public class Main {
//    public static void main(String[] args) {
//        final BigInteger R = new BigInteger("31");
//        final BigInteger M = new BigInteger("1234567891");
//
//        Scanner sc = new Scanner(System.in);
//
//        int length = Integer.parseInt(sc.nextLine());
//        String str = sc.nextLine();
//
//        sc.close();
//
//        BigInteger hash = new BigInteger("0");
//
//        for (int i = 0; i < length; i++) {
//            BigInteger a = R.pow(i).multiply(BigInteger.valueOf(str.charAt(i) - 'a' + 1));
//            hash = hash.add(a);
//        }
//
//        hash = hash.remainder(M);
//
//        System.out.println(hash);
//    }
//}
// int나 long으로 계산 했을 때 테스트케이스가 긴 경우 31의 n제곱 값이 너무 커져(오버플로우 발생)
// hash값이 음수로 나오게 되는 오류가 있어값이 너무 커서 50점 밖에 얻지 못했었음
// int나 long으로 처리할 수 없는 경우 BigInteger를 활용하는 방법이 있는 것을 알게 됨


public class Main {
    public static void main(String[] args) {
        final int R = 31;
        final int M = 1234567891;

        Scanner sc = new Scanner(System.in);

        int length = Integer.parseInt(sc.nextLine());
        String str = sc.nextLine();

        sc.close();

        long hash = 0;
        long pow = 1;

        for (int i = 0; i < length; i++) {
            hash += pow * (str.charAt(i)-'a'+1) % M;
            pow = pow * R % M;
        }

        System.out.println(hash%M);
    }
}

// 문제 풀고 인터넷에 찾아보니 long으로 모듈러 연산을 n제곱값에도 해줘서 푸는 방식 발견, 생각은 해봤는데 어차피 곱하기 연산이라 상관이 없나보다
// 메모리는 112kb, 속도는 4ms 좋다