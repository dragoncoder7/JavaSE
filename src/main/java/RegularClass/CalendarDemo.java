package RegularClass;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class CalendarDemo {
    public static void main(String[] args) {
        TimeZone tzo = TimeZone.getTimeZone("PST");
        System.out.println(tzo);
        System.out.println(tzo.toString());
        TimeZone timeZone = TimeZone.getDefault();
        System.out.println(tzo);
        System.out.println(tzo.toString());
        Locale locale = new Locale("zh-cn","China");
        locale = Locale.CHINA;
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = dateFormat.format(new Date());
        System.out.println(str);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        System.out.println(calendar.getTime());
        str = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS")).format(calendar.getTime());
        System.out.println(str);
    }
}
