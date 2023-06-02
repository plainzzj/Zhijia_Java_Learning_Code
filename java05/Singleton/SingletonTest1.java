package java05.Singleton;

public class SingletonTest1 {
    
}

// 单例类 -> 饿汉式
class Bank{

    // 1. 私有化类的构造器（仅类内部可使用构造器创建类的对象）
    private Bank(){

        Bank b1 = Bank.getInstance();
        Bank b2 = Bank.getInstance(); // b1 b2是同一个对象 -> 单例设计模式！

    }

    // 2. 内部创建类的对象
    // 类的对象：此时可以理解为类的属性（必须申明为静态结构）
    private static Bank instance = new Bank();

    // 3. 提供公共(静态)方法，返回类的对象
    // 需定义为static方法：使得不需要创建类的对象也能调用类的方法
    public static Bank getInstance(){
        // static方法中只能调用static结构
        return instance;
    }

}
