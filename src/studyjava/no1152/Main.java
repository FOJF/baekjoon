package studyjava.no1152;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] words = (new Scanner(System.in).nextLine().split(" "));

        int emptyWordCount = 0;

        for (String word : words) {
            if (word.isEmpty()) emptyWordCount++;
        }
        System.out.println(words.length - emptyWordCount);
    }
}
