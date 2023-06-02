package Thread;

public class WindowTest1 { // 使用实现Runnable接口的方式
    public static void main(String[] args) {
        // 只有w一个类的实例，故只有100张票
        Window1 w = new Window1();;

        // 一个类的对象放到三个构造器中：一个对象三个线程执行了一个方法！
        // 将实现了Runnable的类的实例作为新创建的线程Thread的参数！
        // public Thread(Runnable target)
        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.start();
        t2.start();
        t3.start();
        // Thread-2  100
        // Thread-0  100
        // Thread-1  100
    }
}

class Window1 implements Runnable {
    // 这里不需要 + static，公用100张
    private int ticket = 100;

    // 创建object 类的对象 obj作为同步监视器
    // 要求：多个线程必须要公用同一把锁
    Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            // 使用同步代码块 synchronized 包裹操作共享数据的代码
            // ()内：同步监视器，俗称，锁。任何类的对象都可以充当锁。

            // 打开同步代码块后，只有0线程，1,2线程失效
            // 提升sleep睡眠数后，得到改善
            // 最方便的锁：当前对象！只需保证对象唯一即可！
            synchronized (this) {
                if (ticket > 0) {
                    // 每次暂停 100ms -> Thread-2  -1
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Thread.currentThread().getName() + "  " + ticket);
                    ticket--;
                } else break;
            }


        }
    }
}

// java: 进行语法分析时已到达文件结尾 -> 括号闭合、缺少分号
