package java04;

import java.sql.Date;

import java04.polymorphisn.Man;
import java04.polymorphisn.Person;

public class ToString {
    public static void main(String[] args) {
        Person p1 = new Person();
        // 输出对象的引用 -> 调用当前对象的toString()方法
        // 内存地址：JVM，虚拟地址
        // 重写toString方法后：name:  null  age:    1
        System.out.println(p1.toString()); // java04.polymorphisn.Person@5305068a
        System.out.println(p1); // java04.polymorphisn.Person@5305068a
        
        // toString()方法被重写，返回实体内容信息
        String str = new String("MM");
        System.out.println(str); // MM 
        Date date = new Date(1122334455667788L);
        System.out.println(date); // 7535-05-14

        //父类person重写了两个方法（和setName方法），子类同样可以使用！
        Man m1 = new Man();
        Man m2 = new Man();
        m1.setName("Tom");
        m2.setName("Tom");
        System.out.println(m1.equals(m2)); // true
        System.out.println(m1.toString()); // ame:  null  age:    1
    }
    
}
