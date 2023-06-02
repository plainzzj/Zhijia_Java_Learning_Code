package ThreadNew;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


// 输出偶数
class NumberTread implements Runnable{
    @Override
    public void run(){
        for (int i = 0; i <= 100; i++) {
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName() +"  " +i);
            }

        }

    }
}

// 输出奇数
class NumberTread1 implements Runnable{
    @Override
    public void run(){
        for (int i = 0; i <= 100; i++) {
            if(i % 2 == 1){
                System.out.println(Thread.currentThread().getName() +"  " + i);
            }

        }

    }
}


// 测试类主方法中创建线程并执行相应的代码
public class ThreadPool {
    public static void main(String[] args) {
        // 1. 提供指定线程数量的线程池
        // ExecutorService : 接口
        // service : 接口实现类的对象（多态）
        // 创建10个线程
        ExecutorService service = Executors.newFixedThreadPool(10);

        // 设置线程池的属性

        // 2. 执行指定线程的操作。需要一个实现Runnable接口或Callable接口实现类的对象
        // 形参：有Runnable实现的类的对象
//        service.execute(new NumberTread());// 适合使用于 Runnable
        service.execute(new NumberTread1());// 适合使用于 Runnable
        // 形参
//        service.submit(); // 适合使用于 Callable

        // 3. 线程池的关闭
        service.shutdown();
    }
}
