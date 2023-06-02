package Thread;

public class WindowTest3 { // 使用实现Runnable接口的方式
    public static void main(String[] args) {
        // 只有w一个类的实例，故只有100张票
        Window3 w = new Window3();;

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

class Window3 implements Runnable {
    // 这里不需要 + static，公用100张
    private int ticket = 100;

    Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            // 使用同步方法 synchronized 包装操作共享数据的代码

            show();


        }
    }
    // 将整个实现的方法抽到一个新的方法中：show
    // 将show方法指定为synchronized
    // 默认的同步监视器：this！
    private synchronized void show(){
        if (ticket > 0) {
            // 每次暂停 100ms -> Thread-2  -1
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + "  " + ticket);
            ticket--;
        }
    }
}

// java: 进行语法分析时已到达文件结尾 -> 括号闭合、缺少分号
