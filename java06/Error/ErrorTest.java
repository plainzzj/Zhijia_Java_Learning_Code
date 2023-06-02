package java06.Error;

public class ErrorTest {
    public static void main(String[] args) {
        // main方法中调用main，循环递归调用
        // Exception in thread "main" java.lang.StackOverflowError
        // 栈结构溢出！！！
        // main(args);


        // Exception in thread "main" java.lang.Error: Unresolved compilation problem: 
        // at java06.Error.ErrorTest.main(ErrorTest.java:4)
        // 未解决的编译问题 -> package的问题！！！
        // 包装类的数组

        // java.lang.NegativeArraySizeException 
        // 数组负长度异常
        // Integer[] arr = new Integer[1000000000*1000000000];



        Integer[] arr = new Integer[6];
    }
}