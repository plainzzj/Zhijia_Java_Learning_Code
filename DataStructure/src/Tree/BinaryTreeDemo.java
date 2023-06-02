package Tree;

public class BinaryTreeDemo {
    public static void main(String[] args) {

        BinaryTree binaryTree = new BinaryTree();
        HeroNode root= new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "卢俊义");
        HeroNode node4 = new HeroNode(4, "林冲");
        HeroNode node5 = new HeroNode(5, "关胜");
        //先手动创建该二叉树，后续使用递归创建
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);

        binaryTree.setRoot(root);

        // 测试：
//        System.out.println("前序遍历"); // 1,2,3,5,4
//        binaryTree.preOrder();
        /*
        前序遍历
        HeroNode{no=1, name='宋江'}
        HeroNode{no=2, name='吴用'}
        HeroNode{no=3, name='卢俊义'}
        HeroNode{no=5, name='关胜'}
        HeroNode{no=4, name='林冲'}
         */
//        System.out.println("中序遍历"); // 2,1,3,5,4
//        binaryTree.infixOrder();
        /*
        中序遍历
        HeroNode{no=2, name='吴用'}
        HeroNode{no=1, name='宋江'}
        HeroNode{no=3, name='卢俊义'}
        HeroNode{no=5, name='关胜'}
        HeroNode{no=4, name='林冲'}
         */

        // 前序查找
//        System.out.println("前序查找~~~");
//        int serchno = 5;
//        HeroNode resNode = binaryTree.preOrderSearch(serchno);
//        if(resNode != null){
//            System.out.printf("找到了，信息为no=%d, name=%s", resNode.getNo(), resNode.getName());
//        }else{
//            System.out.printf("未找到no=%d的英雄", serchno);
//        }
        // -> 共查找4次
        /*
        前序查找~~~
        进入前序查找~
        进入前序查找~
        进入前序查找~
        进入前序查找~
        找到了，信息为no=5, name=关胜
         */
        // 中序查找
//        System.out.println("中序查找~~~");
//        int serchno = 5;
//        HeroNode resNode = binaryTree.infixOrderSearch(serchno);
//        if(resNode != null){
//            System.out.printf("找到了，信息为no=%d, name=%s", resNode.getNo(), resNode.getName());
//        }else{
//            System.out.printf("未找到no=%d的英雄", serchno);
//        }
        // -> 共查找3次
        /*
        中序查找~~~
        进入中序查找~
        进入中序查找~
        进入中序查找~
        找到了，信息为no=5, name=关胜
         */
        // 后序查找
//        System.out.println("后序查找~~~");
//        int serchno = 5;
//        HeroNode resNode = binaryTree.postOrderSearch(serchno);
//        if(resNode != null){
//            System.out.printf("找到了，信息为no=%d, name=%s", resNode.getNo(), resNode.getName());
//        }else{
//            System.out.printf("未找到no=%d的英雄", serchno);
//        }
        // -> 共查找2次
        /*
        后序查找~~~
        进入后序查找~
        进入后序查找~
        找到了，信息为no=5, name=关胜
         */

        // 删除结点测试
        // 删除前：
//        binaryTree.postOrder();
        // 删除后：
        binaryTree.delNode(5);
//        binaryTree.postOrder();
        binaryTree.delNode(3);
        binaryTree.postOrder();
        /*
        HeroNode{no=2, name='吴用'}
        HeroNode{no=1, name='宋江'}
         */



    }
}

// 先创建结点
class HeroNode{
    private int no;
    private String name;
    private HeroNode left; // 默认为空
    private HeroNode right; // 默认为空

    // 指针类型！
    // 规定： 如果leftType == 0； 表示指向的是左子树
    // 规定： 如果leftType == 1； 表示指向的是前驱结点
    // 规定： 如果rightType == 0； 表示指向的是右子树
    // 规定： 如果rightType == 1； 表示指向的是后继结点
    private int leftType;
    private int rightType;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    // 新增两个属性的get() set()方法
    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
    // 递归删除结点
    // 如果删除的结点是叶子结点，则删除该结点
    // 如果删除的结点是非叶子结点，则删除该子树
    public void delNode(int no){
        if(this.left != null && this.left.no == no){
            this.left = null;
            return;
        }
        if(this.right != null && this.right.no == no){
            this.right = null;
            return;
        }
        // 开始递归：
        if(this.left != null){
            this.left.delNode(no);
        }
        if(this.right != null){
            this.right.delNode(no);
        }

    }
    // 前序遍历方法
    public void preOrder(){
        System.out.println(this); // 先输出父节点
        // 递归向左子树
        if(this.left != null){
            this.left.preOrder(); // 遍历
        }
        // 递归向右子树
        if(this.right != null){
            this.right.preOrder();
        }
    }
    // 中序遍历方法
    public void infixOrder(){
        // 先递归向左子树
        if(this.left != null){
            this.left.preOrder(); // 遍历
        }
        System.out.println(this); // 输出父节点
        // 递归向右子树
        if(this.right != null){
            this.right.preOrder();
        }
    }
    // 后续遍历方法
    public void postOrder(){
        // 先递归向左子树
        if(this.left != null){
            this.left.preOrder(); // 遍历
        }
        // 递归向右子树
        if(this.right != null){
            this.right.preOrder();
        }
        System.out.println(this); // 输出父节点
    }

    // 前序遍历查找
    public HeroNode preOrderSearch(int no){
        System.out.println("进入前序查找~");
        // 比较当前结点是否为要查找的结点
        if(this.no == no){
            return this;
        }
        HeroNode resNode = null; // 结果结点
        if(this.left != null){
            resNode = this.left.preOrderSearch(no); // 遍历左子树
        }
        if(resNode != null){ // 说明我们左子树找到了
            return resNode;
        }
        if(this.right != null){
            resNode = this.right.preOrderSearch(no); // 遍历右子树
        }
        return resNode;
    }
    // 中序遍历查找
    public HeroNode infixOrderSearch(int no){
        HeroNode resNode = null; // 结果结点
        if(this.left != null){
            resNode = this.left.infixOrderSearch(no); // 遍历左子树
        }
        if(resNode != null){ // 说明我们左子树找到了
            return resNode;
        }
        System.out.println("进入中序查找~");
        // 比较当前结点是否为要查找的结点
        if(this.no == no){
            return this;
        }
        if(this.right != null){
            resNode = this.right.infixOrderSearch(no); // 遍历右子树
        }
        return resNode;
    }
    // 后序遍历查找
    public HeroNode postOrderSearch(int no){
        HeroNode resNode = null; // 结果结点
        if(this.left != null){
            resNode = this.left.postOrderSearch(no); // 遍历左子树
        }
        if(resNode != null) { // 说明我们左子树找到了
            return resNode;
        }
        if(this.right != null){
            resNode = this.right.postOrderSearch(no); // 遍历右子树
        }
        if(resNode != null) { // 说明我们右子树找到了
            return resNode;
        }
        // 比较当前结点是否为要查找的结点
        System.out.println("进入后序查找~");
        if(this.no == no){
            return this;
        }
        return resNode;
    }

}

// 再创建树
class BinaryTree{
    private HeroNode root;
    // 根节点的设置
    public void setRoot(HeroNode root) {
        this.root = root;
    }
    // 前序遍历
    public void preOrder(){
        if(this.root != null){
            this.root.preOrder();
        }else{
            System.out.println("当前二叉树为空，无法遍历！");
        }
    }
    // 中序遍历
    public void infixOrder(){
        if(this.root != null){
            this.root.infixOrder();
        }else{
            System.out.println("当前二叉树为空，无法遍历！");
        }
    }
    // 后序遍历
    public void postOrder(){
        if(this.root != null){
            this.root.postOrder();
        }else{
            System.out.println("当前二叉树为空，无法遍历！");
        }
    }

    //前序查找
    public HeroNode preOrderSearch(int no){
        if(root != null){
            return root.preOrderSearch(no);
        }else{
            return null;
        }
    }
    //中序查找
    public HeroNode infixOrderSearch(int no){
        if(root != null){
            return root.infixOrderSearch(no);
        }else{
            return null;
        }
    }
    //后序查找
    public HeroNode postOrderSearch(int no){
        if(root != null){
            return root.postOrderSearch(no);
        }else{
            return null;
        }
    }

    // 删除结点
    public void delNode(int no){
        if(root != null){
            // 判断root是否为要删除的结点，后续无法回到root
            if(root.getNo() == no){
                root = null;
            }else{
                // 否则，进行递归删除
                root.delNode(no);
            }
        }else{
            System.out.println("空树，不能删除");
        }
    }
}