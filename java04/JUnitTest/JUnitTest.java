package java04.JUnitTest;
import org.junit.*;
public class JUnitTest {
    int num = 10;


    @Test
    public void testEquals(){
        String s1 = "mm";
        String s2 = "mm";
        System.out.println(s1.equals(s2));

        // 这是一个普通方法，而不是static方法，故 num可以直接使用而不用造对象 
        System.out.println(num);

    }



    // 下属的run|debug是 Test Runner for Java扩展插件实现的
    public static void main(String[] args) {
        
        
    }
}