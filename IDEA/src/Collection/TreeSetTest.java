package Collection;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetTest {
    @Test
    public void test1() {
        TreeSet<Object> set = new TreeSet<>();
        set.add(456);
        set.add(123);
        /*
         java.lang.ClassCastException: class java.lang.
         Integer cannot be cast to class java.lang.String (java.lang.Integer and java.lang.String
         are in module java.base of loader 'bootstrap')

         TreeSet -> 按照指定的属性排序 -> 要求同一个类的对象
        */
//        set.add("aa");
//        set.add("bb");
        set.add(1011);
        set.add(789);
        Iterator<Object> iterator = set.iterator();
        // 遍历 -> 从小到大(自然排序)
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        /*
        123
        456
        789
        1011
         */


    }

    // 比较自定义类
    @Test
    public void test2() {
        // class Collection.User cannot be cast to class java.lang.Comparable
        // (Collection.User is in unnamed module of loader 'app';
        // java.lang.Comparable is in module java.base of loader 'bootstrap')
        // 未说明如何排序！
        // 自然排序(implement Comparable)
        // 定制排序
        TreeSet set = new TreeSet();
        set.add(new User(12, "Tom"));
        set.add(new User(15, "Jerry"));
        set.add(new User(62, "Tim"));
        set.add(new User(72, "Bob"));
        set.add(new User(77, "Bob")); // 按照compareTo比较，发现是一样的，需要进行二轮排序


        Iterator<Object> iterator = set.iterator();
        // 遍历 -> 从小到大(自然排序)(姓名)+(年龄)
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            /* -> 没有重写toString方法！
            Collection.User@1120e
            Collection.User@4427490
            Collection.User@153bb
            Collection.User@14e67

            User{age=72, name='Bob'}
            User{age=15, name='Jerry'}
            User{age=62, name='Tim'}
            User{age=12, name='Tom'}

            加入二轮年龄排序后：
            User{age=72, name='Bob'}
            User{age=77, name='Bob'}
            User{age=15, name='Jerry'}
            User{age=62, name='Tim'}
            User{age=12, name='Tom'}
             */


        }
    }

    @Test
    public void test3() {
        Comparator com = new Comparator() {
            // 按照年龄从小到大
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof User && o2 instanceof User) {
                    User u1 = (User) o1;
                    User u2 = (User) o2;
                    return Integer.compare(u1.getAge(), u2.getAge());
                } else {
                    throw new RuntimeException("类型不匹配！");
                }
            }
        };
        // Ctrl + P 提示方法的参数
        // 构造器中指明比较方式 -> com(定制排序) -> 空参(自然排序)
        TreeSet<Object> set = new TreeSet<>(com);
        set.add(new User(12, "Tom"));
        set.add(new User(15, "Jerry"));
        set.add(new User(62, "Tim"));
        set.add(new User(72, "Bob"));
        set.add(new User(77, "Bob"));

        Iterator<Object> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            /*
            User{age=12, name='Tom'}
            User{age=15, name='Jerry'}
            User{age=62, name='Tim'}
            User{age=72, name='Bob'}
            User{age=77, name='Bob'}
             */


        }
    }
}
