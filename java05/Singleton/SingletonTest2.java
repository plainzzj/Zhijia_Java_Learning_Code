package java05.Singleton;

public class SingletonTest2 {
    
}

// 单例类 -> 懒汉式
class Order{

    // 1. 私有化类的构造器（仅类内部可使用构造器创建类的对象）
    private Order(){

        Bank b1 = Bank.getInstance();
        Bank b2 = Bank.getInstance(); // b1 b2是同一个对象 -> 单例设计模式！

    }

    // 2. 内部创建类的对象
    // 先声明类的实例（不创建），没有初始化
    private static Order instance = null;

    // 3. 提供公共(静态)方法，返回类的对象
    // 需定义为static方法：使得不需要创建类的对象也能调用类的方法
    public static Order getInstance(){
        // static方法中只能调用static结构
        // 避免创建多个当前类的对象
        if(instance == null){
            instance = new Order();
        }
        return instance;
    }

}
