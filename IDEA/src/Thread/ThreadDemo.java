package Thread;

/*
Thread-1:1
Thread-0:0
Thread-1:3
Thread-0:2
Thread-1:5
...
 */
public class ThreadDemo {
    public static void main(String[] args) {
        MyThread1 m1 = new MyThread1();
        MyThread2 m2 = new MyThread2();

        m1.start();
        m2.start();


    // 创建Thread类的匿名子类的方式：不需要创建一个只会用一次的类
        /*
        Thread-1:99
        Thread-2:192
        Thread-0:52
        Thread-2:194
        Thread-3:169
         */
    new Thread(){
        @Override
        public void run() {
            for (int i = 100; i < 200; i++) {
                if (i % 2 == 0) {
                    System.out.println(Thread.currentThread().getName() + ":" + i);
                }
            }
        }
    }.start();
        new Thread(){
            @Override
            public void run() {
                for (int i = 100; i < 200; i++) {
                    if (i % 2 == 1) {
                        System.out.println(Thread.currentThread().getName() + ":" + i);
                    }
                }
            }
        }.start();
    }
}

class  MyThread1 extends  Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ":" +i);
            }
        }
    }
}
class  MyThread2 extends  Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 1) {
                System.out.println(Thread.currentThread().getName() +":" + i);
            }

        }
    }
}