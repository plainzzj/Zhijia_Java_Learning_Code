package java03;

public class Constructor {
    public static void main(String[] args) {
        // 构造器的作用：创建类的对象
        // Person2() -> 构造器
        // 创建类的实例时，调用了构造器，执行了构造器的语句
        Person2 p = new Person2();
        // 构造器的重载
        Person2 pp = new Person2("Tom");
    }
    
}

class Person2{
    // 属性
    String name;
    int age;

        // 构造器 -> 默认构造器
    // public Person2(){}
    // 自定义构造器
    public Person2(){
        System.out.println("Person()......");
    }
    // 构造器的重载（形参不一样）
    public Person2(String n){
        name = n;
    }
    public Person2(int n){
        age = n;
    }

    // 方法
    public void eat(){
        System.out.println("eat");
    }

    public void study(){
        System.out.println("study");
    }
    
}

