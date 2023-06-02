package LinkedList;/*
^\s*\n 正则表达式 -> 全部空行
 */

public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        System.out.println("双向列表的测试！");
        // 进行测试
        // 1. 创建结点
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 hero4 = new HeroNode2(4, "林冲", "豹子头");
        //2. 创建双向列表
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
//        doubleLinkedList.add(hero1);
//        doubleLinkedList.add(hero2);
//        doubleLinkedList.add(hero3);
//        doubleLinkedList.add(hero4);
//
//        doubleLinkedList.list();
        doubleLinkedList.addByOrder(hero4);
        doubleLinkedList.addByOrder(hero2);
        doubleLinkedList.addByOrder(hero1);
        doubleLinkedList.addByOrder(hero3);
        doubleLinkedList.list();
        /*
        双向列表的测试！
        LinkedList.HeroNode{no=1, name='宋江', nickname='及时雨'}
        LinkedList.HeroNode{no=2, name='卢俊义', nickname='玉麒麟'}
        LinkedList.HeroNode{no=3, name='吴用', nickname='智多星'}
        LinkedList.HeroNode{no=4, name='林冲', nickname='豹子头'}
        addByOrder:
        LinkedList.HeroNode{no=1, name='宋江', nickname='及时雨'}
        LinkedList.HeroNode{no=2, name='卢俊义', nickname='玉麒麟'}
        LinkedList.HeroNode{no=3, name='吴用', nickname='智多星'}
        LinkedList.HeroNode{no=4, name='林冲', nickname='豹子头'}
         */

        //3. 修改测试
        doubleLinkedList.update( new HeroNode2(4, "公孙胜", "入云龙"));
        doubleLinkedList.list();
        /*
        LinkedList.HeroNode{no=1, name='宋江', nickname='及时雨'}
        LinkedList.HeroNode{no=2, name='卢俊义', nickname='玉麒麟'}
        LinkedList.HeroNode{no=3, name='吴用', nickname='智多星'}
        LinkedList.HeroNode{no=4, name='公孙胜', nickname='入云龙'}
         */

        //4. 删除测试
        System.out.println("******************************");
        doubleLinkedList.del(3);
        doubleLinkedList.list();
        /*
        LinkedList.HeroNode{no=1, name='宋江', nickname='及时雨'}
        LinkedList.HeroNode{no=2, name='卢俊义', nickname='玉麒麟'}
        LinkedList.HeroNode{no=4, name='公孙胜', nickname='入云龙'}
         */
    }
}
 class DoubleLinkedList{
    // 1. 初始化头节点，头节点不能动（与单项链表相同）
    private HeroNode2 head = new HeroNode2(0, "", "");
    // 2. 返回头结点
     public HeroNode2 getHead(){
         return head;
     }
     // 3. 遍历双向链表的方法（与单项链表相同）
     public void list() {
         if (head.next == null) {
             System.out.println("链表为空");
             return;
         }
         // 头结点不能动，需要一个辅助变量来遍历
         HeroNode2 temp = head.next;
         while (true) {
             // 判断链表是否到最后
             if (temp == null) {
                 break;
             }
             // 输出节点的信息
             System.out.println(temp);
             // 将temp后移
             temp = temp.next;
         }
     }
     // 4. 添加（默认添加到队尾）
     public void add(HeroNode2 heroNode) {
         // 由于头节点不能动，我们使用辅助结点temp
         // temp 继承于 head头节点
         HeroNode2 temp = head;
         // 遍历链表
         while (true) {
             // 构造器中未指明next的值，默认为null -> 找到链表的末尾
             if (temp.next == null) {
                 break;
             }
             // 如果没有找到，则temp后移
             temp = temp.next;
         }
         // 当退出while循环式，temp指向了链表的最后
         // 将最后这个结点的next指向新的结点，新的结点的pre指向最后这个节点 -> 形成双向链表
         temp.next = heroNode;
         heroNode.pre = temp;
     }
     // 5. 修改（与单项链表相同）
     public void update(HeroNode2 newHeroNode) {
         if (head.next == null) {
             System.out.println("链表为空");
             return;
         }
         // 根据no编号找到需要修改的节点
         // 定义一个辅助结点
         HeroNode2 temp = head.next;
         boolean flag = false; // 表示是否找到
         while (true) {
             if (temp == null) {
                 break; // 链表已经遍历完成
             }
             if (temp.no == newHeroNode.no) {
                 flag = true;
                 break;
             }
             temp = temp.next;
         }
         // 根据flag判断是否找到需要修改的结点
         if (flag) {
             temp.name = newHeroNode.name;
             temp.nickname = newHeroNode.nickname;
         } else {
             System.out.printf("没有找到编号为%d 的节点，不能修改\n", newHeroNode.no);
         }
     }
     // 6. 删除
     /*
     对于双向链表，可以直接找到要删除的结点，自我删除
      */
     public void del(int no) {
         if(head.next == null){
             // 空链表
             System.out.println("链表为空，不能删除");
             return;
         }
         HeroNode2 temp= head.next ; // 辅助变量(指针)，起始指向头结点的下一个结点
         boolean flag = false; // 标志是否已找到待删除结点
         while (true) {
             if (temp == null) { // 已经到链表最后
                 break;
             }
             // 不需要使用next，用本身去匹配+删除即可
             if (temp.no == no) {
                 flag = true;
                 break;
             }
             temp = temp.next; // 后移，实现遍历
         }
         if (flag) {
             // 找到，可以删除(没有被链起来的node会被JVM自动回收！)
             temp.pre.next = temp.next;
             // 如果temp是最后一个结点，则不需要执行下述语句（空指针异常）
             if(temp.next != null) {
                 temp.next.pre = temp.pre;
             }
         } else {
             System.out.printf("要删除的%a 结点不存在\n", no);
         }
     }
     // 7. 新方法. 添加节点到双向链表（有序）
     public void addByOrder(HeroNode2 heroNode) {
         // 由于头节点不能动，我们使用辅助结点temp（初始化为head结点）
         // 由于是双向链表，因此temp位于添加位置（有next，也有before）
         HeroNode2 temp = head;
         boolean flag = false; // 标识添加的编号是否存在，默认为false
         // 遍历链表
         while (true) {
             // 构造器中未指明next的值，默认为null -> 找到链表的末尾
             if (temp.next == null) {
                 break; // 添加位置位于最后
             }
             // 如果辅助结点的索引值 > 要添加节点的索引值 -> 位置找到，temp后边
            /*
            LinkedList.HeroNode heroNode 需要添加在 temp 和 temp.next之间！
             */
             if (temp.next.no > heroNode.no) {
                 break;
             }
             // 如果辅助结点的索引值 == 要添加节点的索引值 -> 索引已然存在，不能添加
             if (temp.next.no == heroNode.no) {
                 flag = true; // 将flag置true
                 break;
             }
             // 做完上述三种判断后，都不满足，即辅助结点的索引值 < 要添加节点的索引值, 链表后移，继续寻找需要插入的位置
             temp = temp.next;

         }
         // 退出while循环后
         if (flag) {
             System.out.printf("准备插入的英雄的编号%d已经存在， 不能插入\n", heroNode.no);
         } else {
             // 将HeroNode heroNode 插入temp后, temp.next前
             heroNode.next = temp.next;
             temp.next = heroNode;
             heroNode.pre = temp;

         }


     }
 }
 class HeroNode2 {
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next; // 指向下一结点，默认为Null
    public HeroNode2 pre; // 指向前一结点，默认为Null
     // 构造函数中不需要有节点信息！
    public HeroNode2(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }
     @Override
    public String toString() {
        return "LinkedList.HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
