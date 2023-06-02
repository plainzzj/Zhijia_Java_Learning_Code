package Generic;

import org.junit.Test;

import java.util.*;

public class GenericTest {

    // 在集合中使用泛型之前的情况 -> 不方便
    @Test
    public void test1() {
        ArrayList list = new ArrayList();
        // 成绩
        list.add(78);
        list.add(89);
        list.add(34);
        list.add(67);
        list.add("Tom"); // 1. 类型不安全

        // list.for -> 增强for循环快捷键
        for (Object o : list) { // 类型是Object
            // 需要的类型：int 提供的类型：object -> 2. 强制类型转换
            int studentScore = (int) o;
            System.out.println(studentScore);
        }


    }

    // 在集合中使用泛型的情况 -> 方便
    @Test
    public void test2() {
        // 泛型：必须添加类型，而不能是int(基本数据类型)
        ArrayList<Integer> list = new ArrayList<Integer>();
        // 成绩
        list.add(78);
        list.add(89);
        list.add(34);
        list.add(67);
        // 方式一：
        // add(E e)方法，用到了类申明时候的E，限制了添加的类型方法
//        list.add("Tom"); // 1. 类型不安全 -> 编译时类型检查保证数据安全
        for (Integer integer : list) {
            // 避免了强制类型转换
            int studentScore = integer;
            System.out.println(studentScore);

        }
        // 方式二：
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            Integer next = iterator.next();
            /*
            java.lang.ClassCastException:
            JVM在检测到两个类型间转换不兼容时引发的运行时异常 -> Tom
            class java.lang.String cannot be cast to class java.lang.Integer
            (java.lang.String and java.lang.Integer are in module java.base of loader 'bootstrap')
             */
            System.out.println(next);
            /*
            78
            89
            34
            67
             */
        }
    }
    // 在集合中使用泛型的情况: 以HashMap为例
    @Test
    public void test3(){
        // K: String V: Integer
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("Tom", 12);
        map.put("Jerry", 34);
        map.put("Tim", 56);
        map.put("Zhijia", 1);

        // 返回值类型： Set<Entry<String, Integer>>
        // 返回set，set中存放的是entry，entry内部是string和integer -> 泛型的嵌套
        // engry：内部接口，如果 improt java.util.map.*, 则可以省略Map.
        Set<Map.Entry<String, Integer>> entry = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entry.iterator();

        while (iterator.hasNext()){
//            System.out.println(iterator.next()); -> 每个next都会指向下一个！
            Map.Entry<String, Integer> next = iterator.next();
            String key = next.getKey();
            Integer value = next.getValue();
            System.out.println(key + "******" + value);
            /*
            Tom******12
            Zhijia******1
            Tim******56
            Jerry******34
             */
        }
    }

}
