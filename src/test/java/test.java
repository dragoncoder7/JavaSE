import org.junit.Test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class test {
    @Test
    public void timeDiff(){
//        String dateTimeString = "2024-11-09 8:00";
//
//        // 定义输入的日期时间格式
//        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd H:mm");
//        // 解析日期时间字符串
//        LocalDateTime dateTime = LocalDateTime.parse(dateTimeString, inputFormatter);
//
//        // 定义输出的日期时间格式
//        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
//        // 格式化为所需格式的字符串
//        String formattedDateTime = dateTime.format(outputFormatter);
//
//        System.out.println("Formatted DateTime: " + formattedDateTime);


        String startTime = "2024-11-09 8:00",endTime = "2024-11-09 20:00";
        // 定义时间格式
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd H:mm");
        LocalDateTime start;
        // 开始时间和结束时间
        try {
            start = LocalDateTime.parse(startTime, formatter1);
        } catch (DateTimeParseException e) {
            start = LocalDateTime.parse(startTime, formatter2);
        }
        LocalDateTime end;
        try {
            end = LocalDateTime.parse(endTime, formatter1);
        } catch (DateTimeParseException e) {
            end = LocalDateTime.parse(endTime, formatter2);
        }

        // 计算两个时间的差值
        Duration duration = Duration.between(start, end);

        // 将差值转换为小时，分钟部分也换算为小时

        // 用变量表示时间差
        System.out.println((float) (duration.toMinutes() / 60.0));
    }
}
