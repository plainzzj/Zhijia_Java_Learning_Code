package java05.Abstract;

public class AbstractTest {
    public static void main(String[] args) {
        // Cannot instantiate the type Person
        // Person p1 = new Person();
        // p1.eat();

    }
    
}

// 抽象类：不能被实例化
// 有抽象方法的类必须声明为抽象类
abstract class Person{
    String name;
    int age;

    // 虽然父类Person不能直接使用构造器实例化
    // 但是子类的实例化中也会加载父类的构造器
    public Person(){

    }
    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    // 抽象方法：只有方法的声明，没有方法体
    public abstract void eat();
    public void sleep(){
        System.out.println("sleep");
    }
}

// The type Student must implement the inherited abstract method Person.eat()
class Student extends Person{
    // 子类默认继承父类的属性和方法，但不会继承父类的构造器，而是在子类被实例化时会默认调用父类的空构造器。
    // 子类在创建的时候会调用自己的空构造器，并在空构造器会隐式调用super()，即父类的空构造器。
    // 如果父类的构造器被重载，那么子类中的构造器也必须初始化父类的构造器，否则会报编译错误。
    public Student(){
        super();
    }
    // 重写父类的构造器
    public Student(String name, int age){
        // 继承父类的构造器
        super(name, age);
    }

    // 必须重写父类的抽象方法！
    public void eat(){

    }

}
