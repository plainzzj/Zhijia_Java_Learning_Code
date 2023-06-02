package LinkedList;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        // 进行测试
        // 1. 创建结点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        // 2. 创建链表
        SingleLinkedList singleLinkedList = new SingleLinkedList(); // 这里是默认的构造器
        // 3. 加入 -> 目前是按照顺序添加，没有按照排名添加
//        LinkedList.HeroNode .add(hero1);
//        LinkedList.HeroNode .add(hero2);
//        LinkedList.HeroNode .add(hero3);
//        LinkedList.HeroNode .add(hero4);

        // 3. [新方法] 加入 -> 按照排名添加 -> 在内存中完成添加！
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero3);
        // 4. 显示
        singleLinkedList.list();
        /*
        LinkedList.HeroNode{no=1, name='宋江', nickname='及时雨', next=LinkedList.HeroNode{no=2, name='卢俊义', nickname='玉麒麟', next=LinkedList.HeroNode{no=3, name='吴用', nickname='智多星', next=LinkedList.HeroNode{no=4, name='林冲', nickname='豹子头', next=null}}}}
        LinkedList.HeroNode{no=2, name='卢俊义', nickname='玉麒麟', next=LinkedList.HeroNode{no=3, name='吴用', nickname='智多星', next=LinkedList.HeroNode{no=4, name='林冲', nickname='豹子头', next=null}}}
        LinkedList.HeroNode{no=3, name='吴用', nickname='智多星', next=LinkedList.HeroNode{no=4, name='林冲', nickname='豹子头', next=null}}
        LinkedList.HeroNode{no=4, name='林冲', nickname='豹子头', next=null}
        ToString 中去掉next
        LinkedList.HeroNode{no=1, name='宋江', nickname='及时雨'}
        LinkedList.HeroNode{no=2, name='卢俊义', nickname='玉麒麟'}
        LinkedList.HeroNode{no=3, name='吴用', nickname='智多星'}
        LinkedList.HeroNode{no=4, name='林冲', nickname='豹子头'}
         */

        // 5. 修改结点
        singleLinkedList.update(new HeroNode(2, "小卢", "玉麒麟~~"));
        System.out.println("修改后:");
        singleLinkedList.list();
        /*
        修改后:
        LinkedList.HeroNode{no=1, name='宋江', nickname='及时雨'}
        LinkedList.HeroNode{no=2, name='小卢', nickname='玉麒麟~~'}
        LinkedList.HeroNode{no=3, name='吴用', nickname='智多星'}
        LinkedList.HeroNode{no=4, name='林冲', nickname='豹子头'}
         */

        // 6. 删除结点
        singleLinkedList.del(1);
        singleLinkedList.del(2);
        singleLinkedList.del(3);
        singleLinkedList.del(4);
        System.out.println("删除后:");
        singleLinkedList.list();
        /*
        删除后:
        链表为空
         */

    }
}

// 定义SingleLinkedList ->
class SingleLinkedList {
    // 1. 初始化头节点，头节点不能动
    private HeroNode head = new HeroNode(0, "", "");

    // 2. 添加节点到单项链表
    /*
    当不考虑编号的顺序时：
    1. 找到当前链表的最后节点
    2. 将最后这个节点的next指向新的节点
     */
    public void add(HeroNode heroNode) {
        // 由于头节点不能动，我们使用辅助结点temp
        // temp 继承于 head头节点
        HeroNode temp = head;
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
        // 将最后这个结点的next指向新的节点
        temp.next = heroNode;
    }

    // 2. 新方法. 添加节点到单项链表（有序）
    public void addByOrder(HeroNode heroNode) {
        // 由于头节点不能动，我们使用辅助结点temp（初始化为head结点）
        // 由于是单向链表，因此temp位于添加位置的前一个结点，否则插入不了（只有next，没有before）
        HeroNode temp = head;
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
            // 将HeroNode heroNode 插入temp后
            heroNode.next = temp.next; //  a = b
            temp.next = heroNode; // b = c
        }


    }

    // 3. 显示链表[遍历]
    public void list() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        // 头结点不能动，需要一个辅助变量来遍历
        HeroNode temp = head.next;
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

    // 4. 修改结点的信息 -> 根据no来修改
    public void update(HeroNode newHeroNode) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        // 根据no编号找到需要修改的节点
        // 定义一个辅助结点
        HeroNode temp = head.next;
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

    // 4. 删除结点的信息
    /*
    1. temp 找到待删结点的前一个结点
    2. 比较时，使用temp.next.no 和需要删除的节点的no作比较
     */
    public void del(int no) {
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break; // 链表已经便利完成
            }
            if (temp.next.no == no) {
                flag = true;
                break;
            }
            temp = temp.next; // 后移，实现遍历
        }
        if (flag) {
            // 找到，可以删除(没有被链起来的node会被JVM自动回收！)
            temp.next = temp.next.next;
        } else {
            System.out.printf("要删除的%a 结点不存在\n", no);
        }
    }
}
// LinkedList.HeroNode -> 每个HeroNode对象，就是一个节点
class HeroNode {
    public int no;
    public String name;
    public String nickname;
    public HeroNode next; // 指向下一结点

    // 构造函数中不需要有节点信息！
    public HeroNode(int no, String name, String nickname) {
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
