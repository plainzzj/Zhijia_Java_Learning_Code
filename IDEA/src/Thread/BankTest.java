package Thread;

/*
使用同步机制将单例模式中的懒汉式改写为线程安全的
 */
public class BankTest {
}

class Bank {
    // 1. 私有化类的构造器（仅类内部可使用构造器创建类的对象）
    private Bank() {

    }

    // 2. 内部创建类的对象
    private static Bank instance = null;

    // 锁：bank类本身
    // synchronized：解决线程安全问题
    public static synchronized Bank getInstance() {
        // 两个线程 + 共享数据 -> 可能存在的线程安全问题！
        // 方式一： 效率稍差
//        synchronized (Bank.class) {
//        if(instance == null){
//            instance = new Bank();
//
//        }
//        return instance;
//        }

        // 方式二： 效率较高
        if (instance == null) {

            synchronized (Bank.class) {
                if (instance == null) {
                    instance = new Bank();
                }
            }
        }
        return instance;
    }
}
