public class Josephu {
    public static void main(String[] args) {
        // 1. 构建
        CircleSingleLinedList circleSingleLinedList = new CircleSingleLinedList();
        circleSingleLinedList.addBoy(5); // 5个小孩 -> 只显示4个小孩

        // 2. 显示
        circleSingleLinedList.showBoy();

        // 3. 出圈
        circleSingleLinedList.countBoy(1,2,5); // 2-4-1-5-3
        /*
        小孩2出圈
        小孩4出圈
        小孩3出圈
        最后留在圈中的小孩编号1
         */


    }
}
// 创建一个环形的单向链表
class CircleSingleLinedList{
    // 1. 创建first结点，没有编号
    private Boy first = null;
    // 2. 添加小孩节点，构建成一个环形的链表 (nums:需要创建的结点的个数)
    public void addBoy(int nums){
        if(nums < 1){
            System.out.println("数据不正确");
            return;
        }
        // 辅助指针，帮助构建环形链表
        Boy curBoy = null;
        // 使用for循环创建环形链表
        for (int i = 1; i <= nums; i++) { // ************这里缺一个等号！**************************
            // 根据编号：创建小孩结点 -> 需要辅助变量 curBoy 帮助构建环形摘要
            Boy boy = new Boy(i);
            // 如果是第一个小孩：
            if ( i == 1){
                first = boy;
                first.setNext(first); // 构成环，自己指向自己
                curBoy = first; // 让curBoy指向第一个小孩 -> first不能动
            }else{
                curBoy.setNext(boy); // cur指向新添加的boy
                boy.setNext(first); // 新添加的boy回环至first
                curBoy = boy; // curBoy = boy;
            }

        }

    }
    // 遍历当前环形链表 -> curBoy
    public void showBoy(){
        if(first == null){
            System.out.println("链表为空");
            return;
        }
        // first不动，使用辅助指针
        Boy curBoy = first;
        while (true){
            /*
            %d    十进制整数
            %f     十进制浮点数
            %u    无符号十进制
            %o    八进制数
            %x    十六进制
            %s    字符串
            %c    单个字符
            %e    指数形式输出
            %g    自动选择 %f 格式或 %e 格式中较短的一种输出，且不输出无意义的零
            %%   输出百分号
            %n    换行  相当于 \n``
             */
            System.out.printf("小孩的编号 %d \n", curBoy.getNo());
            if(curBoy.getNext() == first){ // curBoy链接到first -> 遍历完毕
                break;
            }
            curBoy = curBoy.getNext(); // 遍历
        }
    }
    // 输入 /** 快速注释方法
    // 计算出圈顺序

    /**
     *
     * @param startNo 表示从第几个小孩开始数
     * @param countNum 表示数几下
     * @param nums 表示最初有多少个小孩在圈中
     */
    public void countBoy(int startNo, int countNum, int nums) {
        if (first == null || startNo < 1 || startNo > nums) { // first的值在addBoy中已经进行了更改！
            System.out.println("InputError");
            return;
        }
        // 辅助指针-> 帮助小孩出圈 指向环形链表最后的节点（第一个结点之前）
        // first 指向环形链表的第一个结点
        // 即 first比helper快一个结点！
        Boy helper = first;
        while (true) {
            if (helper.getNext() == first) { // 此时已经指向了最后一个结点 循环到 heplper指向first！
                break;
            } //
            helper = helper.getNext();
        }
        // 将first移动到游戏开始时的小孩处 startNo - 1，helper移动到游戏开始时的小孩前一位
        for(int j = 0; j < startNo -1; j++){
            first = first.getNext();
            helper = helper.getNext();
        }
        // 当小孩报数时，让first和helper指针同时移动 countNum-1次，然后出圈-> 循环，直到圈中只有一个元素
        while (true){
            if(helper == first){ // 当helper == first时，说明圈中只有一个人
                break;
            }
            // 否则，first 和 helper 同时移动 countNum-1次，然后出圈
            for(int j = 0; j < countNum -1; j++){
                first = first.getNext();
                helper = helper.getNext();
            }
                // first -> 要出圈的小孩
                System.out.printf("小孩%d出圈\n", first.getNo());
                first = first.getNext();
                helper.setNext(first);
        }
        System.out.printf("最后留在圈中的小孩编号%d", first.getNo());

    }
}

// Boy类，表示一个Node
class Boy{
    private int no;
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
