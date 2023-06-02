package java04.Wrapper;

import javax.swing.plaf.basic.BasicInternalFrameUI.InternalFramePropertyChangeListener;

import org.junit.Test;

public class WrapperTest {
    // String类型 -> 基本数据类型、包装类：调用包装类的parseXXX()
    @Test
    public void test5(){
        String str1 = "123";
        // 错误示范：
        // int num1 = (int)str1;
        // Integer in1 = (Integer)str1; // Interger 与 String没有子父类关系，不能强制转换
        int num1 = Integer.parseInt(str1);
        System.out.println(num1); // 123
        Integer in1 = Integer.parseInt(str1); 
        System.out.println(in1); // 123

    }

    // 基本数据类型、包装类 -> String类型：调用String重载的valueOf(Xxx xxx)
    @Test
    public void test4(){
        int num1 = 10;
        // 方式一： 连接运算
        String str1 = num1 + ""; // 通过自动类型提升将 int -> String
        // 方式二： valueOf
        String str2 = String.valueOf(num1); // "10"
        System.out.println(str2);
        
    }

    @Test
    public void test3() {
        int num1 = 10;
        // 此时想使用属性 num1 调用 method方法：
        Integer in11 = Integer.valueOf(num1);
        method(in11);

        // 但是： num1放入后，不报错：
        method(num1);
        // JDK 5.0新特性：自动装箱与自动拆箱
        Integer in111 = num1; // 自动装箱
        int num11 = in111; // 自动拆箱
    }

    public void method(Object obj) {
    }

    // 包装类 -> 基本数据类型: 调用包装类的XXXvalue
    @Test
    public void test2() {
        Integer in1 = Integer.valueOf(12);
        int num1 = in1.intValue(); // 转换后可做运算
        System.out.println(num1 + 1); // 13
    }

    // 基本数据类型 -> 包装类: 调用包装类的构造器(调用xxx类的valueOf)
    @Test
    public void test1() {
        int num1 = 10;
        // The constructor Integer(int) has been deprecated since version 9 and marked
        // for removal
        // 从jdk1.9开始就不建议用Integer构建包了
        Integer in1 = new Integer(num1);
        // 官方建议：使用ValueOf方法来构建包
        Integer in11 = Integer.valueOf(num1);
        System.out.println(in1.toString()); // 10
        System.out.println(in11.toString()); // 10
        // 提取string中的数值
        Integer in2 = Integer.valueOf("123");
        System.out.println(in2.toString()); // 123

        Float f1 = new Float(12.3f);
        // 如果数字后不加f,则默认调用形参为string类型的构造函数
        Float f2 = Float.valueOf(12.3f);

        // 只要不是true，都是false
        Boolean b1 = Boolean.valueOf("TRUE123"); // false

    }

}

class order {
    boolean isMale; // 打印结果为：false
    Boolean isFemale; // 打印结果为：null
}
