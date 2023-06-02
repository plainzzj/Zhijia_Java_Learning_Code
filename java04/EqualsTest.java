package java04;

import java04.polymorphisn.Person;
import java04.polymorphisn.PersonTest;

// == & equals

public class EqualsTest {
    public static void main(String[] args) {
        // 基本数据类型不是对象，不能使用equals
        int i = 10;
        int j = 10;
        double d = 10.0;
        System.out.println(i == j); // ture
        System.out.println(i == d); // true -> 类型提升

        String str1 = new String("abc");
        String str2 = new String("abc");
        String st3 = "abc";
        System.out.println(str1 == str2); // 引用类型 -> 地址值
        System.out.println("******************************************");
        // boolean java.lang.String.equals(Object anObject)
        // 相当于object类中对原方法的重写
        System.out.println(str1.equals(st3)); // true
        System.out.println("******************************************");


        Person pt1 = new Person();
        pt1.setName("Tom");
        Person pt2 = new Person();
        pt2.setName("Tom");
        // boolean java.lang.Object.equals(Object obj)
        System.out.println(pt1.equals(pt2)); // false -> ture
    }
      

    
}
