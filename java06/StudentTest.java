package java06;

import java.lang.Exception;

import java06.MyException.MyException;

public class StudentTest {
    public static void main(String[] args) {
        try{
            Student s = new Student();
            // s.regist(1001);
            // System.out.println(s); // Student [id=1001]
            s.regist(-1001);
            System.out.println(s); // print时：入数据非法！Student [id=0]
            // Exception in thread "main" java.lang.RuntimeException: 输入数据非法！
        }catch(Exception e){
            // e.printStackTrace();
            System.out.println(e.getMessage());
        } 
    }

    
}

class Student{
    private int id;

    public void regist(int id) throws Exception {
        if(id > 0){
            this.id = id;
        }else{
            // System.out.println("输入数据非法！");
            // 手动的抛出(throw)一个异常(通常选择 Exception / RuntimeException)

            // 此时是运行时异常，不需要显式的处理！
            // throw new RuntimeException("输入数据非法！");

            // 此时是编译时异常，需要处理！
            // 注意和Exception.java中定义的类区别开
            // Constructs a new exception with the specified detail message. 
            // The cause is not initialized, and may subsequently be initialized by a call to initCause.
            // 每次只能 throw一个异常，多了被报错

            // Unhandled exception type ExceptionJava(16777384)
            // 未处理的异常类型ExceptionJava（16777384）
            // 需要在regist方法中处理！ 如，throws
            // throw new Exception("输入数据非法！");


            // throw我们自己创建的错误类
            throw new MyException("自己创建的：输入数据非法！"); // 自己创建的：输入数据非法！

        }
    }

    // 重写被打印的信息！
    @Override
    public String toString() {
        return "Student [id=" + id + "]";
    }

    

}

