package Stack;

/*
 使用链表实现栈结构！
 */
public class LinkedListStackDemo {
    public static void main(String[] args) {
        LinkedListStack linkedListStack = new LinkedListStack(5);
        linkedListStack.push(10);
        linkedListStack.push(20);
        linkedListStack.push(30);
        linkedListStack.push(40);
        linkedListStack.push(50);
        linkedListStack.list();
        linkedListStack.pop();
        linkedListStack.pop();
        linkedListStack.pop();
        linkedListStack.pop();
        System.out.println("************************");
        linkedListStack.list();



    }
}
class LinkedListStack {
    private int Maxsize; // 栈空间
    private int size; // 存储的大小
    private LinkedListUnit head; // 单链表模拟栈 -> 创建栈头
//    private int top = -1; // 栈顶，初始化为-1

    // 构造器 -> 创造一个链接的栈

    public LinkedListStack(int maxsize) {
        this.Maxsize = maxsize;
    }

    // 栈满
    public boolean isFull() {
        return (size >= Maxsize);
    }

    // 栈空
    public boolean isEmpty() {
        return size == -1;
    }

    // 入栈 push
    public void push(int value) {
        if (isFull()) {
            System.out.println("Full");
            return;
        }
        LinkedListUnit node = new LinkedListUnit(value); // 创建新的结点
        node.next = head;
        head = node; // 栈顶，动态变化！
        size++;
    }

    // 出栈 pop
    public int pop() {
        if (isEmpty()) {
            try {
                System.out.println("Empty");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            // 有返回值的情况下 return 不适用，建议抛出异常！ C + A + T
        }
        int num = head.no;
        head = head.next;
        size--;
        return num;
    }

    // 遍历栈（从栈顶往下遍历）
    public void list() {
        if (isEmpty()) {
            System.out.println("栈空，无数据");
            return;
        }
        LinkedListUnit temp = head;
        int i = 0;
        while (temp != null) {
                System.out.printf("Stack[] = %d\n", temp.no);
                temp = temp.next; // temp为最后一个Node时，temp.next即为空
        }
    }
}


// 一个链表的结点
class LinkedListUnit{
    public int no;
    public LinkedListUnit next; // 指向下一结点

    // 构造函数中不需要有节点信息！
    public LinkedListUnit(int no) {
        this.no = no;
        this.next = null;
    }
}
