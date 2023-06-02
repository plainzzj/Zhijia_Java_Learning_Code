package Thread;

// 实现多线程的方式二：实现Runnable接口


// 1. 创建一个实现了Runnable接口的类
class MThread implements Runnable{
    // alt + enter -> 实现方法操作
    @Override
    // 2. 实现类去实现Runnable中的抽象方法：run()
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0){
                System.out.println(Thread.currentThread().getName() +"  "+ i);
            }
        }
    }
}
public class TreadTest1 {
    public static void main(String[] args) {
        // 3. 创建类的实例对象
        MThread m1 = new MThread();
        // 4. 将此对象作为参数传递到 Thread类的构造器中，创建Thread类的对象
        // 多态： Runnable m1 = new MThread
        Thread t1 = new Thread(m1);
        // 5. 通过Thread类的实例化对象的start方法来启动线程
        // ① 启动线程 ② 调用当前线程的run() -> 调用了Runnable类型的target的run()
        // 使用m1对 target进行赋值 -> 重写的run
        t1.start();

        // 再启动一个线程，遍历100以内的偶数：
        Thread t2 = new Thread(m1);
        t2.start();

    }
}
