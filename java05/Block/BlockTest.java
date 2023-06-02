package java05.Block;

/*
 * 类的成员：代码块（初始化块）
 */

public class BlockTest {
    public static void main(String[] args) {
        // 静态属性(desc) 静态方法(info) 会随着类(person)的加载而加载
        String desc = Person.desc;
        // 此时，Run: -> Static Block
        // 静态方法被加载（未执行），静态代码块被执行（仅执行一次）

        Person p1 = new Person(); // Block
        // 此时，Run: -> Block
        // 方法被加载（未执行），代码块被执行（随着类的创建多次执行）


    }

}

class Person {
    // 属性
    String name;
    int age;
    static String desc = "Person";

    // 构造器
    public Person() {

    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // 代码块 -> 初始化類、對象
    // 只能使用static修饰
    {
        System.out.println("Block");

    }

    static{
        System.out.println("Static Block");

    }

    // 方法
    public void eat() {
        System.out.println("Eat");
    }

    // 只针对费静态属性，不包括desc
    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }

    public static void info(){
        System.out.println("Static func");

    }

}
