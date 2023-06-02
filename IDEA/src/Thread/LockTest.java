package Thread;

import java.util.concurrent.locks.ReentrantLock;

// 解决线程安全的方式三：lock锁（接口） ---JDK5.0
class Window4 implements Runnable{
    private int ticket = 100;
    // 1. 重入锁ReentrantLock -> 一个类的对象
    // ctrl + p -> 查看构造器的实现方法
    // fair : 是否公平，true：让线程保持来时候的顺序，每一个都轮到
    private ReentrantLock lock = new ReentrantLock(true);
    @Override
    public void run() {
        while(true){
            try{
                // 2. 调用lock方法（锁定）
                lock.lock();
                if(ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Thread.currentThread().getName() + ": 售票，票号为：" + ticket);
                    ticket--;
                }else{
                    break;
                }

            }finally{
                // 3. 调用unlock方法（解锁）
                lock.unlock();
            }

        }
    }
}
public class LockTest {
    public static void main(String[] args) {
        Window4 w = new Window4();

        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();

    }
}
