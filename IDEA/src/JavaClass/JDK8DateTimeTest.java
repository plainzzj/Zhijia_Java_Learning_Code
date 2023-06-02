package JavaClass;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class JDK8DateTimeTest {
    @Test
    public void test1(){
        // now: 获取当前
        // 年月日
        LocalDate localDate = LocalDate.now();
        // 时分秒
        LocalTime localTime = LocalTime.now();
        // 年月日时分秒
        LocalDateTime localDateTime = LocalDateTime.now();

        // of: 指定日期时间 -> 没有偏移量！
        LocalDateTime localDateTime1 = LocalDateTime.of(2020, 10, 6, 13, 30, 30);
        System.out.println(localDateTime1); // 2020-10-06T13:30:30

        // getXxx(): 获取
        System.out.println(localDateTime.getDayOfYear()); // 60

        // 不可变性！withXxx(): 设置
        System.out.println(localDateTime.withDayOfMonth(20)); // 2023-03-20T16:39:52.446720900
        System.out.println(localDateTime); // 2023-03-01T16:40:48.750594700

        // 不可变性！plusXxx: 增加
        System.out.println(localDateTime.plusDays(2000)); // 2028-08-21T16:42:44.721906700
        // 不可变性！minusXxx: 减少
    }
   /*
   Instant（瞬时） 的使用
    */
    @Test
    public void test2(){
        Instant instant = Instant.now();
        // 差8个小时…… -> 本初子午线
        System.out.println(instant); // 2023-03-01T08:47:02.888629700Z

        // atOffset -> 设置偏移量
        OffsetDateTime offset = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offset); // 2023-03-01T16:54:06.038853300+08:00

        // 使用ofEpochMilli来创建Instant对象
        System.out.println(Instant.ofEpochMilli(11223345566778L)); // 2325-08-27T19:59:26.778
    }
/*
DateTimeFormatter：格式化或解析日期、时间
类似于SimpleDateFormat
 */
    @Test
    public void test3(){
        // 预定义的标准格式：
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        LocalDateTime localDateTime = LocalDateTime.now();
        String str1 = formatter.format(localDateTime);
        // 格式化之前 -> DataTime类型
        System.out.println(localDateTime); // 2023-03-02T13:11:03.091878500
        // 格式化之后 -> String类型
        System.out.println(str1); // 2023-03-02T13:11:03.0918785


    }
}
