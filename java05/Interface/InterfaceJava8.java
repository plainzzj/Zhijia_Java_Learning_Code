package java05.Interface;

public interface InterfaceJava8 {

    // 在接口中也可以存在 静态方法 -> 直接可以通过接口调用
    public static void method1(){
        System.out.println("Java 8 public static");

    }

    // 在public的interface中定义public方法，public可以省略
    // 在接口中也可以存在 默认方法 -> 实现类后才能调用
    public default void method2(){
        System.out.println("Java 8 public default");
    }

    public static void main(String[] args) {
        SubClass s = new SubClass();
// The method method1() is undefined for the type SubClass
// 接口中定义的静态方法不能被实现类的对象调用
        // s.method1();
// 接口中定义的静态方法不能被实现类调用
        // SubClass.method1;
// 只能被接口类本身调用
        InterfaceJava8.method1(); // Java 8 public static
// 通过实现类的对象，可以调用接口中的默认方法
        s.method2(); // Java 8 public default
        
    }
    
}

// 接口的子类
class SubClass implements InterfaceJava8{

}