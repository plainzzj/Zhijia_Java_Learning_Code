package java02;

public class Array {
    public static void  main(String[] args) {
    // Syntax error on token ";", , expectedJava(1610612940)
    // java中变量的声明可以不在方法中，但语句只能出现在方法中；
    // 写入main函数即可。
    int num;// 声明
    num = 10; // 初始化
    int num1 = 10; // 声明 + 初始化    

    int[] ids; // 声明（中括号表明数组，数组元素类型为int）
    ids = new int[]{1001, 1002, 1003, 1004}; // 静态初始化
    String[] names = new String[]{"a", "b", "c", "d"}; // 声明 + 静态初始化
    String[] names1 = new String[4]; // 声明 + 动态初始化

    names1[0] = "数据一";
    // Ljava.lang.String;@28a418fc -> 地址
    System.out.println(names1);
    // 数据一
    System.out.println(names1[0]);
    // null
    System.out.println(names1[1]);
    // 4
    System.out.println(names1.length);


    }
}
