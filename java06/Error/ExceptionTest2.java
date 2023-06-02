package java06.Error;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionTest2 {
    // main方法向上抛 -> JVM虚拟机
    // 不应该继续上抛 -> 使用try catch
    public static void main (String[] args){ //throws FileNotFoundException,IOException {
        // void java06.Error.ExceptionTest2.method2() 
        // throws FileNotFoundException, IOException

        // Cannot make a static reference to the non-static method method2() 
        // from the type ExceptionTest2
        // 非static修饰的方法，需要产生一个类的实例对象才可以调用该方法。
        try{
            method2();
            // IOException 范围更大，需要放在上边
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }

    }
    // 向上抛出异常！ 谁调用，抛给谁 -> main方法，到头
    public static void method2()throws FileNotFoundException,IOException{
        // void java06.Error.ExceptionTest2.method1() 
        // throws FileNotFoundException, IOException
        method1();
    }

    // 向上抛出异常！ 谁调用，抛给谁
    public static void method1() throws FileNotFoundException,IOException{
        File file = new File("hello.txt");
        FileInputStream fis = new FileInputStream(file);
    
        // Syntax error on token ";", { expected after this token
        int data = fis.read();
        while(data != -1){
            System.out.println((char)data);
            data = fis.read();
    
        }
        fis.close();
    }
  

    
}
