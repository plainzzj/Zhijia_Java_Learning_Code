package JavaClass;

import org.junit.Test;

public class StringTest {
    private String s4;

    @Test
    public void test1(){
        /*
        Serializable 接口: 可序列化的
        Comparable 接口：可比较大小
        final char[] value用于存储字符串数据：不可变性
         */

        String s1 = "abc"; // 字面量 （不用new，可以直接赋值）
        String s2 = "abc"; // s1 s2 在内存中是同一个

        System.out.println(s1 == s2); // true （两个对象==对比地址值）
        s1 = "hello"; // -> 新造的


        System.out.println(s1); // hello
        System.out.println(s2); // abc

        String s3 = "abc";
        s3 += "def";
        System.out.println(s3); // abcdef -> 新造的

    }
    @Test
    public void test2(){
        /*
        实例化方式
         */
        // 声明在方法区的字符串常量池！
        String s1 = "JavaEE";
        String s2 = "JavaEE";
        // 数据在堆空间中开辟空间以后对应的地址值！
        String s3 = new String("JavaEE");
        String s4 = new String("JavaEE");

        System.out.println(s1 == s2); // true
        System.out.println(s3 == s4 || s1 == s3 || s1 == s4 || s2 == s4 );// false

        Person p1 = new Person(16,"Tom");
        Person p2 = new Person(16,"Tom");

        System.out.println(p1.name == p2.name); // true

    }
}

class Person{
    int age;
    String name;

    public Person() {
    }

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }
}

