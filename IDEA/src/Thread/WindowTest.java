package Thread;

// 代码上到下移动：shift + alt + ↑ ↓

// 使用同步代码块解决继承Thread类的线程安全问题
class Window extends Thread { // 继承Thread类的方式
    // 属性 ticket:实例变量！
//    private int ticket = 100;

    // static：静态变量！ 共享一百张票！
    // 每一个类的实例对静态变量的改变都会影响其他实例中静态变量的值！
    private static int ticket = 100;

    // 锁也必须是static的，才能保证每一个线程对象的锁是同一个！
    // 锁的要求：唯一即可！
    static String str = new String();

    @Override
    public void run() {
        // 最方便的锁：当前对象！但是在extends Thread的情况下，当前对象不唯一！
        // 可以使用：Window.class，类本身！ -> 类也是对象！ -> 类只会加载一次
        synchronized (Window.class) {
            while (true) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                if (ticket > 0) {
                    System.out.println(getName() + ":" + "卖票！票号为：" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}

    public class WindowTest {
        public static void main(String[] args) {
            Window w1 = new Window();
            Window w2 = new Window();
            Window w3 = new Window();

            w1.setName("窗口1");
            w2.setName("窗口2");
            w3.setName("窗口3");

        /*窗口2:卖票！票号为：100
          窗口3:卖票！票号为：100
          窗口1:卖票！票号为：100
          线程安全存在问题！
          */
            w1.start();
            w2.start();
            w3.start();

        }
    }

