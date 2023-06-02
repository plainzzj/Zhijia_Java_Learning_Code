package Stack;

import java.util.Scanner;

public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(4);
        String key = "";
        boolean loop = true; // 控制是否退出菜单
        Scanner scanner = new Scanner(System.in); // 扫描器

        while (loop){
            System.out.println("show: 显示");
            System.out.println("exit: 退出");
            System.out.println("push: 添加(入栈)");
            System.out.println("pop: 取出(出栈)");
            System.out.println("请输入你的选择：");
            key = scanner.next();
            switch (key){
                case "show":
                    stack.list();
                    break;
                case "exit":
                    scanner.close(); // 资源流关闭
                    loop = false; // 程序退出！
                    break;
                case "push":
                    System.out.println("Please input a num:");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case "pop":
                    try {
                        int res = stack.pop();
                        System.out.printf("出栈的数据是%d\n", res);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;
            }

        }
        System.out.println("程序已退出");
    }
}
class ArrayStack{
    private int maxSize; // 大小
    private int[] stack; // 数组模拟栈
    private int top = -1; // 栈顶，初始化为-1

    // 构造器
    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        // 将大小传入数组模拟栈，创建一个新数组
        stack = new int[this.maxSize];
    }
    // 栈满
    public boolean isFull(){
        return top == maxSize - 1;
    }
    // 栈空
    public boolean isEmpty(){
        return top == - 1;
    }
    // 入栈 push
    public void push(int value){
        if(isFull()){
            System.out.println("Full");
            return;
        }
        top++;
        stack[top] = value;
    }
    // 出栈 pop
    public int pop(){
        if(isEmpty()){
            try {
                System.out.println("Empty");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            // 有返回值的情况下 return 不适用，建议抛出异常！ C + A + T
        }
        int value = stack[top];
        top--;
        return value;
    }
    // 遍历栈（从栈顶往下遍历）
    public void list(){
        if (isEmpty()){
            System.out.println("栈空，无数据");
            return;
        }
        for(int i = top; i >= 0; i--){
            System.out.printf("Stack[%d] = %d\n", i, stack[i]);
        }
    }

}
