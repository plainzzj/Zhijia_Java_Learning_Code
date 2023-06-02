package JavaClass;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.util.Arrays;

public class StringTest1 {
/*
String <-> 包装类
 */
    public void test1(){
        String str = "Hello";
        int i = Integer.parseInt(str);

        int num = 12345;
        String s = String.valueOf(num);

    }
/*
String <-> char[]
toCharArray
String的构造器
 */
    @Test
    public void test2(){
        String str = "Hello";
        char[] chars = str.toCharArray();
        System.out.println(chars); // Hello

        char[] arr = new char[10];
        String s = new String(arr);
        System.out.println(s); // null...
    }
/*
String <-> byte[]
getBytes
    编码：字符串 -> 字节
    解码：字节 -> 字符串
 */
    @Test
    public void test3(){
        String str = "Hello中国";
        byte[] bytes = str.getBytes(); // 使用默认的编码 UTF-8
        System.out.println(bytes); // [B@256216b3
        System.out.println(Arrays.toString(bytes)); // [72, 101, 108, 108, 111, -28, -72, -83, -27, -101, -67]
        try {
            byte[] gbks = str.getBytes("gbk"); // 使用GBK字符集
            System.out.println(Arrays.toString(gbks)); // [72, 101, 108, 108, 111, -42, -48, -71, -6]
            String str2 = new String(gbks);
            System.out.println(str2); // Hello�й� -> 编码GBK，解码UTF-8，乱码
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }




    }
}
