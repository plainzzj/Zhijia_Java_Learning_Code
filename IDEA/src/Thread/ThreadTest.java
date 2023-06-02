package Thread;

// 多线程的创建

// 1. 创建一个继承于Thread的子类
class MyThread extends Thread{
    // 2. 重写run()方法 -> 将此线程执行的操作声明在run方法中
    @Override
    public void run() {
//        super.run();
        // fori 直接回车，即可
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0){
                /* 两个线程的交替执行！
                Thread-1:0
                Thread-1:2
                Thread-1:4
                Thread-0:0
                Thread-1:6
                 */
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}

public class ThreadTest {
    public static void main(String[] args) {
        // 3. 创建Thread类的子类的对象
        // alt + enter
        MyThread t1 = new MyThread(); //->主线程执行

        // 4. 调用start方法(start定义在thread中)->对于线程来讲，只能start一次
        t1.start();//->主线程执行，创建分支线程
        // t1.run();//->主线程执行，依然在主线程执行，没有创建分支线程

        // 创建一个新的线程
        MyThread t2 = new MyThread();
        t2.start();

        for (int i = 0; i < 100; i++) {  // ->主线程执行
            if (i % 2 == 0) {
                System.out.println(i + " *****main*****");
            }
        }
    }
}
/*
主线程和分线程交替执行
3180 *****main*****
3182 *****main*****
7848
7850
 */