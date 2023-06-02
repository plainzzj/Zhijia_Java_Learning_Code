package java05.Interface;

public class InterfaceTest{
    public static void main(String[] args) {
        Plane p = new Plane();
        p.fly(); // Exception in thread "main" java.lang.UnsupportedOperationException: Unimplemented method 'fly'
        p.stop();
    }

    
}

// interface 关键字 -> 实现接口
interface Flyable{
    // 全局常量（static final） 
    // static表示不需要实例化就可以调用，final表示不可以更改
    public static final int MAX_SPEED = 7900;
    public static final int MIN_SPEED = 1;
    // public static final 都可以省略
    int test1 = 0;

    // 接口没有构造器 -> 不可以实例化

    // 抽象方法：不需要写方法的具体实现
    public abstract void fly();
    public abstract void stop();
    // public abstract 也可以省略
    void test2();

}
interface Attackable{
    void attack();
        
}

// 类 通过 implements 实现接口的功能
// The type Plane must implement the inherited abstract method Flyable.test2()
// -> 必须重写所有抽象方法，才可以实例化
// Illegal modifier for the class Plane; only public, abstract & final are permitted
// 仅允许public、abstract、final 修饰符，不能使用static
// 当me米有实现全的室友，必须增加 abstract
class Plane implements Flyable{

    @Override // 实现了接口的方法，而不是重写了接口的方法
    public void fly() {
        System.out.println("fly~~~");
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'fly'");
    }

    @Override
    public void stop() {
        System.out.println("stop~~~");
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'stop'");
    }

    @Override
    public void test2() {
        System.out.println("test~~~");
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'test2'");
    }

   
}

// 一个类 可以用实现多个 接口
// 继承在前，实现接口灾后
class Bullet extends Object implements Flyable,Attackable{

    @Override
    public void attack() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'attack'");
    }

    @Override
    public void fly() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'fly'");
    }

    @Override
    public void stop() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'stop'");
    }

    @Override
    public void test2() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'test2'");
    }
    
}


