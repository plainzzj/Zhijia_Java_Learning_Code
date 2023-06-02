package Tree;

public class ArrBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};

        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        arrBinaryTree.preOrder(); // 调用的是重载方法，自动补index = 0;
        /*
        1 2 4 5 3 6 7
         */


    }
}

class ArrBinaryTree{
    private int[] arr; // 存储数据结点的数组

    // 构造函数
    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    // 重载方法：preOrder
    public void preOrder(){
        this.preOrder(0);
    }


    // 顺序存储二叉树的前序遍历 -> index 数组的下标
    public void preOrder(int index){
        // 如果数组为null或为空
        if(arr == null || arr.length == 0){
            System.out.println("数组为空，不能按照二叉树的前序遍历");
        }
        // 如果不为空，先输出自己
        System.out.println(arr[index]);
        // 向左递归遍历
        if((index * 2 + 1) < arr.length){
            preOrder(2 * index + 1);
        }
        // 向左递归遍历
        if((index * 2 + 2) < arr.length){
            preOrder(2 * index + 2);
        }

    }
}
