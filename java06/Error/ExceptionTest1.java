package java06.Error;

import org.junit.Test;

public class ExceptionTest1 {
    
    @Test
    public void test1(){
        String str = "123";
        str = "abc";
        // ava.lang.NumberFormatException: For input string: "abc"
        // at java.base/java.lang.NumberFormatException.forInputString
        // 实际开发中，对于运行时异常，不使用try-catch-finally处理！（没有意义）
        try{
            int num = Integer.parseInt(str);
            System.out.println("位置1");
            
        // 捕获异常处理对象
        }catch(NumberFormatException e){
            System.out.println("数值转换异常……"); // 数值转换异常……
            // 获取错误信息
            System.out.println(e.getMessage()); // For input string: "abc"            
            // 打印堆栈信息
            e.printStackTrace(); // -> 一大串错误的信息及其发生的位置……

        // finally中是一定会执行的代码
        // 即使存在return，结束try-catch-finally结构，其中的代码也依旧会被执行！
        }finally{
            System.out.println("一定会被执行的代码！"); // 一定会被执行的代码！
        }
        
        // 继续执行代码
        System.out.println("位置2"); // 位置2

        // System.out.println(num);
    }
}
