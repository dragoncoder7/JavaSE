package RegularClass;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDemo {
    public static void main(String[] args) {
        String strDate, strTime;
        Date objDate = new Date();
        System.out.println(objDate);
        long time = objDate.getTime();
        System.out.println(time);
        strDate = objDate.toString();
        System.out.println(strDate);
        strTime = strDate.substring(11,(strDate.length()-9));
        System.out.println(strTime);
        strTime = strTime.substring(0, 8);
        System.out.println(strTime);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(format.format(objDate));
    }
}
