package studyjava.no2884;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH mm");

        String strTime = (new Scanner(System.in).nextLine());

        if (Integer.parseInt(strTime.split(" ")[0]) == 0)
            strTime = "24 " + strTime.substring(strTime.length() - 2);

        Date realWakeUpTime = dateFormat.parse(strTime);
        long earlyWakeUpTime = realWakeUpTime.getTime() - dateFormat.parse("00 45").getTime();

        earlyWakeUpTime /= 1000;
        int hour = (int) earlyWakeUpTime / (60 * 60);
        int minute = (int) earlyWakeUpTime / 60 % 60;
        System.out.println((hour == 24 ? 0 : hour) + " " + minute);
    }
}
