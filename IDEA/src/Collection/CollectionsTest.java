package Collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionsTest {
    @Test
    public void test1(){
        ArrayList list = new ArrayList();
        list.add(456);
        list.add(1011);
        list.add(1213);
        list.add(789);
        list.add(123);
        System.out.println(list); // [456, 1011, 1213, 789, 123]
        // Collections.reverse()
        Collections.reverse(list);
        System.out.println(list); // [123, 789, 1213, 1011, 456]

        // Collections.shuffle()
        Collections.shuffle(list);
        System.out.println(list); // [456, 789, 1213, 123, 1011]

        // Collections.sort() 自然排序/定制排序
        Collections.sort(list); // 需要的类型是list，而不是ArrayList，去掉泛型即可？
        System.out.println(list); // [123, 456, 789, 1011, 1213]

        // Collections.swap()  交换
        Collections.swap(list,0,1);
        System.out.println(list); // [456, 123, 789, 1011, 1213]

        // Collections.frequency() 出现的频率
        System.out.println(Collections.frequency(list,123)); // 1

        // Collections.copy() 把list中的内容复制到dest当中
//        ArrayList dest = new ArrayList();
        /*
         java.lang.IndexOutOfBoundsException:
         Source does not fit in dest
         dest.size()的长度不能小于srcSize()；目标列表必须至少与源列表一样长。
         如果更长，则目标列表中的其余元素不受影响。

        */
        // 数组，长度为list.size(), 每个元素都为null
        // asList -> 将数组转换为集合
        List dest = Arrays.asList(new Object[list.size()]);
        Collections.copy(dest,list);
        System.out.println(dest); // [456, 123, 789, 1011, 1213]

        // replaceAll()

        // Arraylist Hashmap 线程不安全：synchronizedXXX()
        // list1 -> 线程安全！
        List list1 = Collections.synchronizedList(list);

    }




}
