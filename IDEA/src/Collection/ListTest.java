package Collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/*
List -> '动态'数组
ArrayList
LinkedList
Vector
 */
public class ListTest {
    @Test
    public void test1(){
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("aa");
        list.add("bb");
        list.add(false);
        list.add(456);

        System.out.println(list); // [123, 456, aa, bb, false, 456]
        // add() :
        list.add(1, "BB"); //[123, 456, aa, bb, false, 456]
        System.out.println(list);

        // addAll() :
        List list1 = Arrays.asList(1, 2, 3);
        list.addAll(list1);
        // 每次调用addAll都会添加一次 -> 一共添加了两次
        System.out.println(list.addAll(list1)); // true -> boolean
        System.out.println(list); //[123, BB, 456, aa, bb, false, 456, 1, 2, 3, 1, 2, 3]

        // get() : 获取指定index位置的元素
        System.out.println(list.get(4)); // bb

        // indexOf : 获取指定元素首次出现的位置
        System.out.println(list.indexOf(456)); // 2

        // lastIndexOf : 获取指定元素最后一次出现的位置
        System.out.println(list.lastIndexOf(456)); // 6
        System.out.println("*********************************************************");
        // remove : (重载) 可按索引，也可按对象去删除
        Object obj = list.remove(3);
        System.out.println(obj); // aa -> 被删除的元素
        System.out.println(list);  // [123, BB, 456, bb, false, 456, 1, 2, 3, 1, 2, 3]

        // set() : 设置
        System.out.println(list.set(1, "first")); // BB -> 被设置的元素
        System.out.println(list); // [123, first, 456, bb, false, 456, 1, 2, 3, 1, 2, 3]

        // sublist() : 左闭右开的子集
        List list2 = list.subList(2, 5);
        System.out.println(list2); // [456, bb, false]

        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");

        // 遍历一 : Iterator
            // 1. 构建一个iterator对象
        Iterator iterator = list.iterator();
            // 2. hasNext()
        while (iterator.hasNext()){
            // 3. next()
            System.out.println(iterator.next());
        }

        // 遍历二 : 增强for循环 -> 需要的类型必须是obj
        for(Object object : list){
            System.out.println(object);
        }

        // 遍历三 : 普通for循环
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        /*
        123
        first
        456
        bb
        false
        456
        1
        2
        3
        1
        2
        3
         */

        }
    }






}
