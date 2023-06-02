package Collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class ForTest {

    @Test
    public void test(){
        Collection coll = new ArrayList(); // ArrayList -> 有序
        coll.add("AA");
        coll.add("BB");
        coll.add(123); // 自动装箱
        coll.add(456);
        coll.add(new Date()); // 当前日期

        // 使用for循环遍历集合： -> 内部仍然调用迭代器
        // coll: 集合对象， Object obj: 变量
        for(Object obj : coll){
            System.out.println(obj);
        }
        /*
        AA
        BB
        123
        456
        Wed Mar 08 13:42:40 CST 2023
         */
    }
    @Test
    public void test2(){
        int[] arr = new int[]{1,2,3,4,5,6,7};
        // 使用for循环遍历数组： -> 内部仍然调用迭代器
        // arr: 数组对象， Object obj: 变量
        for(Object obj : arr){
            System.out.println(obj);
        }
        /*
        1
        2
        3
        4
        5
        6
        7
         */

    }
}
