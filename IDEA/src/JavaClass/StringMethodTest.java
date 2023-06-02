package JavaClass;

import org.junit.Test;

public class StringMethodTest {
    @Test
    public void test1(){
        String s1 = "HelloWorld";
        // 输出长度 -> 底层数组的长度
        System.out.println(s1.length());
        // 输出底层数组的指定元素(0-9)
        System.out.println(s1.charAt(1));
        // 判断是否为空字符串
        System.out.println(s1.isEmpty());
        // 转换为大小写 -> s1本身不可变
        System.out.println(s1.toUpperCase());
        System.out.println(s1.toLowerCase());
        // trim(修剪/调整): 忽略首尾所有空白 -> s3本身不可变
        String s3 = "   h  e   l   l   o   w   o   r   l   d    ";
        System.out.println(s3.trim());

    }
    @Test
    public void test2(){
        String s1 = "HelloWorld";
        String s2 = "helloworld";
        // equalsIgnoreCase: 比较内容是否相同/不区分大小写
        System.out.println(s1.equalsIgnoreCase(s2));
        // 连接字符串, 等价于"="
        System.out.println(s1.concat(s2));
        // 比较两个字符串的大小
        String s5 = "abc";
        String s6 = new String("abe");
        System.out.println(s5.compareTo(s6)); // -2
        // 取现有字符串的子串
        System.out.println(s1.substring(5)); // World
        System.out.println(s1.substring(5,6)); // W [5,6)
    }

    @Test
    public void test3(){
        String s1 = "HelloWorld";
        // 是否包含后缀
        System.out.println(s1.endsWith("orld")); // true
        // 是否包含前缀
        System.out.println(s1.startsWith("he")); // false
        // 从指定索引开始的子字符串是否以指定前缀开始
        System.out.println(s1.startsWith("ello", 1)); // true
        // 是否包含
        System.out.println(s1.contains("Wor")); // true
        // 返回第一次出现的索引 (未找到，返回-1)
        System.out.println(s1.indexOf("ll")); // 2
        // 返回第一次出现的索引，从指定位置开始
        System.out.println(s1.indexOf("ll", 5)); // -1
        // 从后往前查找
        System.out.println(s1.lastIndexOf("ll"));
        System.out.println(s1.lastIndexOf("ll", 5));
    }
    @Test
    public void test4(){
        String s1 = "HelloWorld";
        // 替换对应子字符串(或char)
        System.out.println(s1.replace("Hello", "Hi")); // HiWorld


    }
}
