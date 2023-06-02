package ThreadNew;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/*
Callable 接口
 */
// Callable<V> -> 泛型
// 实现了Callable 方法，并没有Thread作为其父类，没有start()等方法
class NumThread implements Callable{

    // Callable必须实现call()方法 （回调方法！）
    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 101; i++) {
            if(i % 2 == 0){
                System.out.println(i);
                sum += i;
            }

        }
        // 返回sum, int类型不是Object的子类 -> 装箱操作 Integer
        return sum;
    }
}

public class ThreadNew {
    public static void main(String[] args) {
        NumThread numThread = new NumThread();
        // 需要new 一个FutureTask
        // FutureTask需要的实参： 实现了 Callable 的对象
        // futerTask类：实现了Runnable接口，可以作为实参传入Thread的构造器中
        FutureTask futureTask = new FutureTask(numThread);

        // 最终还是要创建Thread类的实例，并执行start()方法！
        // 分线程打印数据！
        new Thread(futureTask).start();

        try {
            // 使用.get()方法即可获得返回值 -> 对返回值不感兴趣可以不调用
            // 此方法同样要被try-catch 环绕！
            // 主线程打印总和！
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

    }
}
