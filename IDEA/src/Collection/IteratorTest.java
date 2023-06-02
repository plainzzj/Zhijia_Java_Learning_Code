package Collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

/*
集合元素的遍历
 */
public class IteratorTest {
    @Test
    public void test1(){
        Collection coll = new ArrayList(); // ArrayList -> 有序
        coll.add("AA");
        coll.add("BB");
        coll.add(123); // 自动装箱
        coll.add(456);
        coll.add(new Date()); // 当前日期

        // 遍历接口！
        Iterator iterator = coll.iterator();
        // next() : 1. 指针下移 2. 将下移以后集合位置上的元素返回
        // 方式一：
        /*
        AA
        BB
        123
        456
        Wed Mar 08 12:41:00 CST 2023
         */
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        // 方式二：
        for (int i = 0; i < coll.size(); i++) {
            System.out.println(iterator.next());
        }

        // hasNext() : 判断是否还有元素
        // 推荐方式三：
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }

    // remove()
    @Test
    public void test2(){
        Collection coll = new ArrayList(); // ArrayList -> 有序
        coll.add("AA");
        coll.add("BB");
        coll.add(123); // 自动装箱
        coll.add(456);
        coll.add(new Date()); // 当前日期

        // 删除集合中指定的元素(123)
        Iterator iterator = coll.iterator();
        while (iterator.hasNext()){
            Object obj = iterator.next();
            if (Integer.valueOf(123).equals(obj)){
                iterator.remove();
            }
        }
        // 重新遍历集合
        iterator = coll.iterator(); // 需要重新指定iterator！
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }

}
