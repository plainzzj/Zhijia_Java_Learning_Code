package Queue;

import java.util.Scanner;
public class ArrayQueueDemo {
    // 测试
    public static void main(String[] args) {
        // 创建队列的实例！
        ArrayQueue arrayQueue = new ArrayQueue(3);
        char key = ' '; // 接收用户输入
        Scanner scanner = new Scanner(System.in); // 扫描器的实例，万事万物皆对象
        boolean loop = true; // 循环开关
        while (loop){
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头的数据");
            // key 已经在上面声明过了！
            key = scanner.next().charAt(0); // 接收用户输入的下一个char
            switch(key){
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("请输入要插入的数据：");
                    int n = scanner.nextInt();
                    arrayQueue.addQueue(n);
                    break;

                case 'g':
                    try {
                        int res = arrayQueue.getQueue();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch(Exception e){
                        // TODO: handle exception
                        System.out.println(e.getMessage()); // 拋出异常信息！
                    }
                    break;
                case 'h':
                    // 包裹代码快捷键： ctrl + alt + t
                    try {
                        int res = arrayQueue.headQueue();
                        // 快捷键 souf
                        System.out.printf("队列头的数据是%d\n", res);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;

                case 'e':
                    scanner.close(); // 退出前，需要把scanner关闭
                    loop = false;
                    System.out.println("程序退出");
                    break;


            }
        }
    }
}

// 使用数组模拟队列 - 编写一个ArrayQueue类 - 尾进头出 -> 使用算法改进成环形的队列
class ArrayQueue{
    private int maxSize; // 最大容量
    private int front; // 队列头
    private int rear; // 队列尾
    private int[] arr; // 模拟队列

    // 创建队列的构造器 -> 传入最大容量即可
    public ArrayQueue(int maxSize) {
        // 初始化最大容量
        this.maxSize = maxSize;
        // 初始化队列
        arr = new int[maxSize];
        front = -1; // 指向队列头前一个位置
        rear = -1; // 指向队列的尾部（即队列最后的一个数据）
    }

    public boolean isFull(){
        return rear == maxSize -1;
    }
    public boolean isEmpty(){
        return rear == front;
    }
    // 添加数据
    public void addQueue(int n){
        // 判断队列是否满？
        if(isFull()){
            System.out.println("队列满，不能加入数据");
        }
        //rear 后移
        rear++;
        arr[rear] = n;
    }
    // 出队列
    public int getQueue(){
        // 判断队列是否空？
        if(isEmpty()){
            // 通过抛出异常来处理！
            throw new RuntimeException("队列为空，不能取数据");
        }
        //front 后移
        front++; // 从队列的头部出队列！
        int num = arr[front];
        return num;
    }

    // 显示队列的所有数据()
    public void showQueue(){
        if (isEmpty()){
            System.out.println("队列为空");
            return;
        }else{
            for (int i = front + 1; i < arr.length; i++) {
                System.out.printf("arr[%d]=%d\n", i, arr[i]);

            }
        }
    }

    // 显示队列的头部数据（不是取数据）
    public int headQueue(){
        if (isEmpty()) {
            System.out.println("队列为空");
            throw new RuntimeException("队列为空，没有数据");
        }
        return arr[front + 1];

    }

}