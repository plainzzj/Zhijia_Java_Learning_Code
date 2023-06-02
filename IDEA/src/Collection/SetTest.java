package Collection;

import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class SetTest {
    @Test
    public void test1(){
        HashSet<Object> set = new HashSet<>();
        set.add(456);
        set.add(123);
        set.add(true);
        set.add("aa");
        set.add("bb");

        Iterator<Object> iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
            /* -> 无序性，不是随机性 -> LinkedList
            aa
            bb
            456
            123
            true
             */
        }
    }
    // LinkedHashSet() -> HashSet的子类，维护了两个引用(前/后) -> 对于频繁的遍历操作更有效率
    @Test
    public void test2(){
        HashSet<Object> set = new LinkedHashSet<>();
        set.add(456);
        set.add(123);
        set.add(true);
        set.add("aa");
        set.add("bb");

        Iterator<Object> iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
            /* -> 无序性(但遍历的顺序与添加的顺序一样)，不是随机性 -> LinkedList
            456
            123
            true
            aa
            bb
             */
        }
    }
}
