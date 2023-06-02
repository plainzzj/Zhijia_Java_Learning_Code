package Thread;

/*
线程通信的应用
1. 多线程问题 生产者/消费者
2. 有共享数据 产品/店员
3. 解决线程安全问题 -> 同步机制
4. 涉及到线程的通信
 */
public class ProductTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();

        Productor p1 = new Productor(clerk);
        p1.setName("生产者1");
        Productor p2= new Productor(clerk);
        p2.setName("生产者2");
        Consumer c1 = new Consumer(clerk);
        c1.setName("消费者1");
        Consumer c2 = new Consumer(clerk);
        c2.setName("消费者2");

        p1.start();
        c1.start();
        p2.start();
        c2.start();
    }
}

class Clerk{
    private int productCount = 0;
    // 生产产品 -> 同步方法，解决线程安全问题 -> 同步器：Clerk对象，只造了一个
    public synchronized void produceProduct() {
        if(productCount < 20){
            productCount++;
            System.out.println(Thread.currentThread().getName() + "开始生产第" + productCount + "个产品");
            // 激活其他线程
            notifyAll();
        }else{
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    // 消费产品 -> 同步方法，解决线程安全问题 -> 同步器：Clerk对象，只造了一个
    public synchronized void consumeProduct() {
        if(productCount > 0){
            System.out.println(Thread.currentThread().getName() + "开始消费第" + productCount + "个产品");
            productCount--;
            // 激活其他线程(只要消费者有了消费，就可以激活生产者生产)
            notifyAll();
        }else{
            // wait()方法只能使用在同步代码器或者同步方法中
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
// 多线程的实现 -> 继承
class  Productor extends Thread{
    // 类 Clerk的实例
    private  Clerk clerk;

    // 构造函数
    public Productor(Clerk clerk) {
        this.clerk = clerk;
    }
    // 重写run方法
    @Override
    public void run() {
        // 由于是继承自Thread，Thread.currentThread可以省略掉
        System.out.println(getName() + "开始生产产品...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        while(true){
            clerk.produceProduct();
        }
    }
}

class Consumer extends Thread{
    private Clerk clerk;
    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }
    public void run() {
        System.out.println(getName() + "开始消费产品...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        while(true){
            clerk.consumeProduct();
        }

    }
}