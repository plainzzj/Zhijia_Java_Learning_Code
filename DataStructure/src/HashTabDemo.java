import java.util.Scanner;

// 哈希表：同时管理多条链表！
public class HashTabDemo {
    public static void main(String[] args) {

        // 创建hash表
        HashTab hashTab = new HashTab(7);
        // 菜单
        String key = "";
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("add: 添加雇员");
            System.out.println("list: 显示雇员");
            System.out.println("find: 查找雇员");
            System.out.println("exit: 退出系统");

            key = scanner.next();
            switch (key){
                case "add":
                    System.out.println("输入id");
                    int id = scanner.nextInt();
                    System.out.println("输入名字");
                    String name = scanner.next();
                    // 创建雇员
                    Emp emp = new Emp(id, name);
                    hashTab.add(emp);
                    break;
                case "list":
                    hashTab.list();
                    break;
                case"find":
                    System.out.println("请输入要查找的id");
                    id = scanner.nextInt();
                    hashTab.findEmpById(id);
                case "exit":
                    scanner.close();
                    System.exit(0);
                default:
                    break;
            }

        }


    }
}

// class 哈希表
class HashTab{
    private EmpLinkedList[] empLinkedListArray; // 数组
    private int size; // 表示有多少条链表

    // 构造函数
    public HashTab(int size) {
        this.size = size;
        empLinkedListArray = new EmpLinkedList[size];

        // 不要忘记分别初始化每一条链表
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i] = new EmpLinkedList();
        }
    }
    // 添加Emp
    public void add(Emp emp){
        // 根据员工的id，确定 该插入哪条链表？
        int empLinkedListNo = hashFun(emp.id);
        // 将emp添加到对应的链表中
        empLinkedListArray[empLinkedListNo].add(emp);
        /*
        Exception in thread "main" java.lang.ArithmeticException: / by zero
        at HashTab.hashFun(HashTabDemo.java:66)
        at HashTab.add(HashTabDemo.java:53)
        at HashTabDemo.main(HashTabDemo.java:26)
         */
    }
    // 遍历所有的链表（遍历hashtab）
    public void list(){
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i].list(i);
            
        }
    }
    // 根据输入的id查找雇员
    public void findEmpById(int id){
        // 使用散列函数确定到哪条列表？
        int empLinkedListNo = hashFun(id);
        Emp emp = empLinkedListArray[empLinkedListNo].findEmpById(id);
        if(emp != null){ // 找到
            System.out.printf("在第%d条链表中找到该雇员 id = %d\n", empLinkedListNo, id);
        }else{
            System.out.println("在hash表中没有找到该雇员");
        }
    }
    // 编写散列函数（简单的取模法）
    public int hashFun(int id){
        return id % size;
    }
}

// 链表中的一个结点
class Emp{
    public int id;
    public String name;
    public Emp next;

    public Emp(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
}
// 链表
class EmpLinkedList{
    // 头指针：指向第一个Emp
    private Emp head;
    // 添加Emp至链表的最后
    public void add(Emp emp){
        // 如果是添加第一个Emp：
        if(head == null){
            head = emp;
            return;
        }
        // 如果添加后面的Emp
        Emp curEmp = head; // 辅助指针
        while (true){
            if(curEmp.next == null){
                break;
            }
            curEmp = curEmp.next;
        }
        // 退出时直接将emp加入链表
        curEmp.next = emp;
    }

    // 遍历链表的雇员信息
    public void list(int no){
        if(head == null){
            System.out.println("第"+ no +"链表为空");
            return;
        }
        System.out.println("第"+ no +"链表的信息为：");
        Emp curEmp = head;
        while (true){
            System.out.println("  "+ curEmp.id + curEmp.name);
            if (curEmp.next == null){
                break;
            }
            curEmp = curEmp.next;
        }
        System.out.println();
    }

    // 根据id查找雇员
    public Emp findEmpById(int id){
        // 判断链表是否为空
        if(head == null){
            System.out.println("链表空");
            return null;
        }
        Emp curEmp = head;
        while (true){
            if(curEmp.id == id){ // 找到
                break; //  此时curEmp指向要查找的雇员
            }
            if(curEmp.next == null){
                curEmp = null;
                break; // 需要退出循环！
            }
            curEmp = curEmp.next;
        }

        return curEmp;
    }
}