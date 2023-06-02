package Queue;

import java.util.Scanner;

public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        // 创建队列的实例！
        CircleArray circleArray = new  CircleArray(4); // 其队列的有效数据为3
        char key; // 接收用户输入
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
                    circleArray.showQueue();
                    break;
                case 'a':
                    System.out.println("请输入要插入的数据：");
                    int n = scanner.nextInt();
                    circleArray.addQueue(n);
                    break;

                case 'g':
                    try {
                        int res = circleArray.getQueue();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch(Exception e){
                        // TODO: handle exception
                        System.out.println(e.getMessage()); // 拋出异常信息！
                    }
                    break;
                case 'h':
                    // 包裹代码快捷键： ctrl + alt + t
                    try {
                        int res = circleArray.headQueue();
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

class CircleArray{
    private int maxSize; // 最大容量
    private int front; // 队列头 arr[front]指向头 -> 初始值为0
    private int rear; // 队列尾 -> 指向队列的最后一个元素的后一个位置（空一个位置）
    private int[] arr; // 模拟队列

    // 创建队列的构造器 -> 传入最大容量即可
    public CircleArray(int maxSize) {
        // 初始化最大容量
        this.maxSize = maxSize;
        // 初始化队列
        arr = new int[maxSize];
        front = 0;
        rear = 0;
    }

    public boolean isFull(){
        return (rear + 1) % maxSize == front;
    }
    public boolean isEmpty(){
        return rear == front;
    }
    // 添加数据
    public void addQueue(int n){
        // 判断队列是否满？
        if(isFull()){
            System.out.println("队列满，不能加入数据");
            return; // 这里缺少一个返回语句，导致即使队列无法添加数据，也会执行下面的添加指令！ TODO 0405
        }
        //rear 本身就指向数据的后一个位置，因此直接将数据加入即可
        arr[rear] = n;
        // 再将rear后移 -> 环形队列这里必须考虑取模(防止下标越界！)
        rear = (rear + 1) % maxSize;
    }
    // 出队列
    public int getQueue(){
        // 判断队列是否空？
        if(isEmpty()){
            // 通过抛出异常来处理！
            throw new RuntimeException("队列为空，不能取数据");
        }
        //front -> 指向队列的第一个元素
        /*
        1. 先把front对应的值保留到一个临时变量
        2. 将front后移（考虑取模，防止索引越界）
        3. 将临时保存的变量返回
         */
        int temp = arr[front];
        front = (front + 1) % maxSize;
        return temp;
    }

    // 显示队列的所有数据()
    public void showQueue(){
        if (isEmpty()){
            System.out.println("队列为空");
        }
        /*
        从front开始遍历，遍历有效数据个元素
         */
        for (int i = front; i < front + size(); i++) {
            // 下标应为 i % maxSize
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
            }
        }

    // 返回队列中有效元素的个数
    public int size(){
        return (rear + maxSize - front) % maxSize;
    }

    // 显示队列的头部数据（不是取数据）
    public int headQueue(){
        if (isEmpty()) {
            System.out.println("队列为空");
            throw new RuntimeException("队列为空，没有数据");
        }
        return arr[front];
    }

}