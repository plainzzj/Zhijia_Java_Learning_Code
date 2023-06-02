package java02;

public class ArrayTest2 {
public static void main(String[] args) {
    // 一维数组的声明和初始化
    int[] arr = new int[]{1,2,3};
    int[] arr2 = new int[5];
    // 类型推断
    int[] arr4 = {1,2,3}; 
    // 二维数组的声明和初始化
    int[][] arr1 = new int[][]{{1,2,3}, {4,5}, {6,7}}; 
    // 动态初始化1
    // 三个元素构成的一维数组，每个数组元素是一个五个元素的一维数组
    // 4 行 5 列
    int[][] arr3 = new int[4][5];
    // 动态初始化2，未赋值之前无法调用指定元素
    int[][] arr5 = new int[4][];
    // [[I@28a418fc
    System.out.println(arr5);
    arr5[1] = new int[4];
    // [I@5305068a 
    // [ 代表一维， I代表int，@后为地址值
    System.out.println(arr5[1]);
    // 0
    System.out.println(arr5[1][0]);
    // 这种写法也是正确的
    int arr6[][] = new int[4][]; 
    //类型推断
    int arr8[][] = {{1,2}, {3,4}, {5,6}};


    // 调用二维数组指定位置的元素
    // Syntax error on token ".", @ expected after this tokenJava(1610612967)
    // 输出语句应该放在main函数之中
    System.out.println(arr1[0][1]); //2

    // 获取数组的长度
    // 4
    System.out.println(arr3.length); // int[4][5]
    // 5
    System.out.println(arr3[0].length + "\n");

    // 如何遍历二维数组
    // 嵌套循环
    for(int i = 0; i < arr1.length; i++){
        for(int j = 0; j < arr1[i].length; j++){
            System.out.print(arr1[i][j]);
        }
        System.out.println();
    }



    }

    
           
}
