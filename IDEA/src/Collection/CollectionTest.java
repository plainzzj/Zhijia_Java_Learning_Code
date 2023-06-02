package Collection;

import org.junit.Test;

import java.util.*;

public class CollectionTest {
    @Test
    public void test1(){
        // Collection : 接口
        // Arraylist : 具体的实现类, extends Collection
        Collection coll = new ArrayList(); // ArrayList -> 有序
        // 1. add()
        coll.add("AA");
        coll.add("BB");
        coll.add(123); // 自动装箱
        coll.add(new Date()); // 当前日期

        // 2. size()
        System.out.println(coll.size()); // 4

        // 3. addAll()
        Collection coll1 = new ArrayList();
        coll1.add(456);
        coll1.add("CC");
        coll1.addAll(coll);
        // ArrayList中重写了toString方法
        System.out.println(coll1); // [456, CC, AA, BB, 123, Wed Mar 08 09:21:36 CST 2023]

        // isEmpty():
        System.out.println(coll.isEmpty()); // false
        System.out.println(coll1.isEmpty()); // false

        // clear():
//        coll.clear();
        System.out.println(coll.isEmpty()); // true

        System.out.println("**********************************");

        // contains()
        System.out.println(coll1.contains("CC")); // true
        System.out.println(coll1.contains(234)); // false
        // ture -> 判断的不是地址，而是内容 -> equals方法
        System.out.println(coll1.contains(new String("AA")));
        // 自定义类的比较，需要重写 equals()方法

        // containsAll(): coll中的所有元素是否都存在于coll1中
        System.out.println(coll1.containsAll(coll)); // true

        // remove()
        coll1.remove(123);
        System.out.println(coll1); // [456, CC, AA, BB, Wed Mar 08 10:19:59 CST 2023]

        // removeAll() : 差集
//        coll1.removeAll(coll);
        System.out.println(coll1); // [456, CC]

        // retrainAll() : 交集
        System.out.println(coll1.retainAll(coll)); // true
        System.out.println(coll1); // [AA, BB, Wed Mar 08 10:34:13 CST 2023]

        // equals() : 比较两个对象所有元素是否相等 (ArrayList有序，顺序不一样也是false)
        System.out.println(coll1.equals(coll)); // false

        // hashCode() : 计算哈希值 -> 可以理解为随机数
        System.out.println(coll.hashCode()); // -1023825555

        // toArray() : 集合 -> 数组
        Object[] arr = coll1.toArray();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        /*
        AA
        BB
        Wed Mar 08 10:46:14 CST 2023
         */

        // asList() : 数组 -> 集合 Arrays类的静态方法
        List<Object> list = Arrays.asList(arr);
        System.out.println(list); // [AA, BB, Wed Mar 08 10:49:00 CST 2023]

        List arr1 = Arrays.asList(new int[]{123, 456});
        System.out.println(arr1.size()); // 1 -> 整个数组被当做一个元素
        // 正确写法1：
        List arr2 = Arrays.asList(123, 456);
        System.out.println(arr2.size()); // 2 -> 两个元素
        List arr3 = Arrays.asList(new Integer[]{123, 456});
        System.out.println(arr2.size()); // 2 -> 两个元素

        // iterator() : 返回Iterator接口的实例，用于遍历
    }
}
