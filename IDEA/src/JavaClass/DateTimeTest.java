package JavaClass;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateTimeTest {
    @Test
    public void test1(){
        // 1970/1/1/0/0/0 -> 至今 时间差 -> 时间戳
        long time = System.currentTimeMillis();
        System.out.println(time); // 1677651839706


    }
    @Test
    public void test2(){
        // 构造器一： Date() -> 当前时间的Date对象
        Date date1 = new Date();
        System.out.println(date1.toString()); // Wed Mar 01 14:32:50 CST 2023
        System.out.println(date1.getTime()); // 1677652411319

        // 构造器二：Date(long) -> 创建指定毫秒数的Date对象
        Date date2 = new Date(11223345566778l);
        System.out.println(date2.toString()); // Fri Aug 28 03:59:26 CST 2325

        // Date子类 ->java.sql.Date
        java.sql.Date date3 = new java.sql.Date(11223345566778l);
        System.out.println(date3.toString()); // 2325-08-28

    }
/*
SimpleDateFormat -> 对日期Date类的格式化和解析
 */
    @Test
    public void test3() throws ParseException {
        // 1. 实例化 -> 默认的构造器
        SimpleDateFormat sdf = new SimpleDateFormat();
        Date date = new Date();
        System.out.println(date); // Wed Mar 01 15:13:50 CST 2023
        // 2. 格式化
        String format = sdf.format(date);
        System.out.println(format); // 2023/3/1 下午3:13

        // 3. 解析
        String str = "2023/3/1 下午3:13";
        Date date1 = sdf.parse(str);
        System.out.println(date1); // Wed Mar 01 15:13:00 CST 2023


        // 1. 实例化 -> 其他类型的构造器
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyy.MMMMM.dd GGG hh:mm aaa");
        Date date2 = new Date();
        System.out.println(date2); // Wed Mar 01 15:20:08 CST 2023

        // 2. 格式化
        String format1 = sdf1.format(date2);
        System.out.println(format1); // 02023.三月.01 公元 03:20 下午

        // 3. 解析
        String str1 = "02023.三月.01 公元 03:20 下午";
        Date date3 = sdf1.parse(str1);
        System.out.println(date3); // Wed Mar 01 15:20:00 CST 2023
    }
/*
Calendar类（抽象类）
    Calendar.getInstance()方法
    GregorianCalendar子类
 */
    @Test
    public void testCalendar(){
        GregorianCalendar gc = new GregorianCalendar();
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getClass()); // class java.util.GregorianCalendar

        // get()操作
        int days = calendar.get(Calendar.DAY_OF_YEAR);
        System.out.println(days); // 60

        // set()操作
        calendar.set(Calendar.DAY_OF_YEAR, 22);
        days = calendar.get(Calendar.DAY_OF_YEAR);
        System.out.println(days); // 22

        // add()操作
        calendar.add(Calendar.DAY_OF_YEAR, 33);
        days = calendar.get(Calendar.DAY_OF_YEAR);
        System.out.println(days); // 55

        // getTime()操作 日历 -> Date
        Date time = calendar.getTime();
        System.out.println(time); // Fri Feb 24 16:12:37 CST 2023

        // getTime()操作 Date -> 日历
        Date date1 = new Date();
        calendar.setTime(date1);
        days = calendar.get(Calendar.DAY_OF_YEAR);
        System.out.println(days); // 60




    }
}
