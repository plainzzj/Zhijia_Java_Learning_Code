package Tree;
/*
在使用同一个软件包下的类时，不需要使用import语句来引入该类。
在同一个软件包下，所有的类都是可以直接访问的。
只有当你需要使用不同软件包下的类时，才需要使用import语句将需要的类引入到当前的java文件中。
import语句用于告诉编译器你希望使用其他软件包中的类。
 */

/*
在类或方法名上面出现 "新*" 表示这是一个新添加的类或方法。
这通常是由于使用版本控制系统（例如Git）进行代码管理时，其他开发人员或你自己在代码中添加了新的类或方法，而IDEA检测到这些新的代码变更。
当你从版本控制系统中更新代码或者切换到一个包含新代码的分支时，IDEA会自动检测并标记这些新添加的类或方法，以便你可以快速注意到这些变化。
这个功能可以帮助你追踪代码的变更，并且在代码协作中更容易识别新添加的代码部分。你可以通过查看这些标记来快速定位和了解代码中的新功能或改动。
 */
public class ThreadedBinaryTreeDemo {
    public static void main(String[] args) {

    }
}

// 创建结点
// 使用BinaryTreeDemo中的HeroNode

// 创建树（实现了线索化功能）
class ThreadedBinaryTree{
    private HeroNode root;
    // 为了实现线索化，需要创建一个指向当前结点的前驱结点的指针 -> pre总是保留前一个结点
    private HeroNode pre = null;
    // 根节点的设置
    public void setRoot(HeroNode root) {
        this.root = root;
    }
    // 编写对二叉树进行中序线索化的方法：

    /**
     *
     * @param node 当前需要线索化的结点
     */
    public void threadedNodes(HeroNode node){
        // 如果node == null, 不能线索化
        if(node == null){
            return;
        }
        // (1) 先线索化左子树
        threadedNodes(node.getLeft());
        // (2) 再线索化当前结点[有点难度]
            // 处理当前结点的前驱结点
        if(node.getLeft() == null){
            // 左指针为空 -> 指向前驱结点
            node.setLeft(pre);
            // 左指针为空 -> 修改当前结点的左指针的类型 -> 指向前驱结点
            node.setLeftType(1);
        }

        // (3) 最后线索化右节点
        threadedNodes(node.getRight());

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

