package java06.MyException;

// 1. 一般继承 Exception/RuntimeException
public class MyException extends Exception {
    // 2. 提供serialVersionUID
    static final long serialVersionUID = -3387516993124000048L;

    // 3. 提供重载的构造器
    public MyException(){

    }
    public MyException(String msg){
        super(msg);
        
    }
}
