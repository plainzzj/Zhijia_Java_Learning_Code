package java03;

import java.lang.annotation.Native;

// 测试类
public class PersonTest {
    // main方法中的变量： 局部变量
    // static：关键字
    public static void main(String[] args) {
        // 创建Person类实例（创建类的对象）
        // 变量类型 变量名 = 变量值
        // new的对象都存放在堆中
        Person p1 = new Person();
        // 等同于 Scanner scanner = new Scanner(System.in )

        // 调用对象的结构：属性 “对象.属性”
        // 赋值和调用
        p1.name = "Tom";
        p1.isMale = true;
        System.out.println(p1.name);
        System.out.println(p1.isMale);

        // 调用对象的方法：属性 “对象.方法”
        p1.eat();
        p1.sleep(5);
        p1.talk("Chinese");

        //***************************
        Person p2 = new Person();
        System.out.println(p2.name); // null
        System.out.println(p2.isMale); // false

        //***************************
        // 将p1变量保存的对象地址值赋给p3 -> p1/p3指向了堆空间中同一个对象实体
        Person p3 = p1;
        System.out.println(p3.name); // Tom
        System.out.println(p3.isMale); // 10

        //***************************
        NewPerson p4 = new NewPerson();
        p4.name = "Jerry";
        p4.age = 18;
        p4.sex = 1;

        // 此时为study的引用，而不是实现
        p4.study();
        p4.showAge();
        int newAge = p4.addAge(2);
        System.out.println(newAge);
    }

}

class Person{
    // 属性（成员变量）（field）（域、字段）
    String name;
    int age = 1;
    boolean isMale;

    // 方法（成员方法）（函数）（method）
    // 方法可以不包含形参
    // void：没有返回值
    public void eat(){
        System.out.println("Humen can eat");
    }
    public void sleep(int hour){
        System.out.println("Humen sleeps " + hour + "hours");
    }
    public void talk(String language){
        System.out.println("Humen can speak with " + language);
    }
    public String getName(){
        return name;
    }
    // 方法可以包含形参
    // String：返回值类型
    public String getNation(String nation){
        String info = "My nation is " + nation;
        return info;
    }

}

class Student{
    String name;
    int age = 1;
    String major;
    public String say(){
        return (name + age + major);
    }
}
// 如果前边加 public，那必须定义在自己命名的.java文件中
class NewPerson{
    String name;
    int age;
    /*
     * 1：man
     * 2：woman
     */
    int sex;

    public void study(){
        System.out.println("studying");
    }

    public void showAge(){
        System.out.println(age);
    }

    public int addAge(int i){
        age += i;
        return age;
    }
}


