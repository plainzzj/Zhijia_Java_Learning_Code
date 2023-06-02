package Thread;

/*
线程通信的例子：两个线程打印1-100，两个线程交替打印
 */
class Number implements Runnable{
    private int number = 1;
    @Override
    public void run() {
        while (true){
            // 同步代码块（ctrl + alt + T）

            synchronized (this) {
                notify(); // 唤醒一个线程
                notifyAll(); // 唤醒所有线程
                if(number <= 100){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Thread.currentThread().getName() + ":" + number);
                    number++;

                    try {
                        // 使得调用如下wait()方法的线程进入阻塞状态 -> 同时释放锁
//                        线程2:1
//                        线程1:2
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }else {
                    break;
                }
            }
        }
    }
}

public class CommunicationTest {
    public static void main(String[] args) {
        Number n1 = new Number();
        Thread t1 = new Thread(n1);
        Thread t2 = new Thread(n1);

        t1.setName("线程1");
        t2.setName("线程2");

        t1.start();
        t2.start();
    }
}
