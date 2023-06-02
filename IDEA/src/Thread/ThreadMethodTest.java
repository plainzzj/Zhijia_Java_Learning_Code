package Thread;

public class ThreadMethodTest {
    public static void main(String[] args) {
        HelloThread h1 = new HelloThread();
        // 通过构造器给线程命名：
//        HelloThread h1 = new HelloThread("Thread: 1")
        // 给线程起名：
        h1.setName("线程一");
        // 修改线程优先级
        h1.setPriority(Thread.MAX_PRIORITY); // -> 仅仅是从概率上比较高，并不是一定会优先执行
        h1.start();

        // 给主线程命名：
        Thread.currentThread().setName("主线程");
        // 修改主线程优先级
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                // java: 未报告的异常错误java.lang.InterruptedException;
                // 必须对其进行捕获或声明以便抛出
//                try {
//                    Thread.currentThread().sleep(1);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
                System.out.println(Thread.currentThread().getName() + ":" + i);
                System.out.println(Thread.currentThread().getPriority());
            }
//            if(i  == 20){
//                try{
//                    // join 插队！此时需要h1线程执行完毕后，才会分配main线程的执行！
//                    h1.join();
//                } catch (InterruptedException e){
//                    e.printStackTrace();
//                }
//            }
        }
        // 判断h1线程是否还存活
//        System.out.println(h1.isAlive());
    }
}
// 在文件 'D:\桌面\VSCODE\Java\IDEA\src\Thread\ThreadTest.java' 中找到重复类
class HelloThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0){
                // 手动阻塞1s
                // sleep必须被try-catch包裹
//                try {
//                    // IDEA中，静态的方法和属性是斜体的！
//                    sleep(1);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
                // 在当前线程的类内，可以省略：Thread.currentThread().
                System.out.println(getName() + ":" + i);
                System.out.println(getPriority());
            }
//            if(i % 20 == 0){
//                //  this代表线程HelloThread的实例对象
//                // this == Thread.currentThread()
//                //  （要调用称为 yield 的方法，请通过接收方或类型名称限定 yield）
//
//                // yield： 释放当前CPU的执行权 -> 需要抢
//                this.yield();
//            }
        }

    }
}
/*
主线程:88
线程一:97
线程一:98
主线程:89
线程一:99
 */