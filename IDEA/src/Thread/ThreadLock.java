package Thread;

// 两个类的方法：两个类的同步监视器 -> 可能存在死锁
public class ThreadLock {
    public static void main(String[] args) {

        // 两把锁
        StringBuffer s1 = new StringBuffer();
        StringBuffer s2 = new StringBuffer();
        // 线程1
        // 匿名类的对象 -> 继承类Thread()
        new Thread(){
            @Override
            public void run() {
                // 同步监视器，锁s1
                synchronized (s1){
                    s1.append("a");
                    s2.append("1");

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    // 同步监视器，锁s2
                    synchronized (s2){
                        s1.append("b");
                        s2.append("2");

                        System.out.println(s1);
                        System.out.println(s2);
                    }
                }
            }
        }.start();
        // 线程2
        // 匿名类的对象 -> 实现Runnable接口
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (s2) {
                    s1.append("c");
                    s2.append("3");

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    // 同步监视器，锁s2
                    synchronized (s1) {
                        s1.append("d");
                        s2.append("4");

                        System.out.println(s1);
                        System.out.println(s2);
                    }

                }
            }
        }).start();

    }
}

/*
ab
12
abcd
1234
*/
