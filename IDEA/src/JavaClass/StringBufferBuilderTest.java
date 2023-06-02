package JavaClass;

import org.junit.Test;

public class StringBufferBuilderTest {
    @Test
    public void test1(){
        StringBuffer sb1 = new StringBuffer("abc");
        sb1.setCharAt(0,'m');
        System.out.println(sb1); // mbc -> 可变！
        StringBuilder sb2 = new StringBuilder("ABC");
        sb2.setCharAt(0,'M');
        System.out.println(sb2); // MBC -> 可变！

/*
增   删   改   查   插！
 */
    }
    @Test
    public void test2(){
        StringBuffer s1 = new StringBuffer("abcdefg");
        System.out.println(s1.append(1)); // abcdefg1
        System.out.println(s1.delete(0,2)); // cdefg1
        System.out.println(s1.replace(2,4,"Hello")); // cdHellog1
        System.out.println(s1.insert(0,"啦啦啦")); // 啦啦啦cdHellog1
        System.out.println(s1.reverse()); // 1golleHdc啦啦啦

        // 方法链：
        System.out.println(s1.reverse().append(1).delete(0,2)); // 啦cdHellog11


    }
}
