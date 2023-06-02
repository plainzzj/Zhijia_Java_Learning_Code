package Collection;

import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapTest {
    @Test
    public void test1(){
        HashMap<Object, Object> map = new HashMap<>();

        // put()
        map.put(null, null);
        map.put("AA", 123);
        map.put("AA", 112233); // AA 只能有一个 -> 修改
        map.put("BB", 456);
        map.put("CC", 789);
        map.put("DD", 1011);
        System.out.println(map); // ToString 方法
        // {null=null, AA=112233, BB=456, CC=789, DD=1011}

        HashMap<Object, Object> map1 = new HashMap<>();
        map1.put("ee", 1213);
        map1.put("ff", 1415);
        // putAll()
        map.putAll(map1);
        System.out.println(map);
        // {null=null, AA=112233, BB=456, CC=789, DD=1011, ee=1213, ff=1415}

        //remove()
        Object aa = map.remove("AA"); // 被移除的键值对的值
        System.out.println(aa); // 112233
        System.out.println(map); // {null=null, BB=456, CC=789, DD=1011, ee=1213, ff=1415}

        //clear()
//        map.clear();
        System.out.println(map); // {}
        System.out.println(map.size()); // 0 -> map不是null，map还在，只是没有数据

        //get() -> Key
        System.out.println(map.get(456)); // null(不存在Key为456的HashMap)

        //containsKye()
        //containsValue()
        System.out.println(map.containsKey("CC")); // true
        System.out.println(map.containsValue(456));// true

        //isEmpty()
        System.out.println(map.isEmpty()); // false


    }
    @Test
    // Map的迭代
        // K: Set
        // V: Collection
        // K+V: entry 存放于 Set中
    public void test2(){
        HashMap<Object, Object> map = new HashMap<>();
        map.put(null, null);
        map.put("AA", 123);
        map.put("AA", 112233); // AA 只能有一个 -> 修改
        map.put("BB", 456);
        map.put("CC", 789);
        map.put("DD", 1011);

        //KeySet() -> 遍历所有的Key
        Set<Object> set = map.keySet();
        // 迭代
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
            /*
            null
            AA
            BB
            CC
            DD
             */
        }
        //values() -> 遍历所有的Values(遍历顺序与Key一致)
        // 增强for方法
        for (Object value : map.values()) {
            System.out.println(value);
            /*
            null
            112233
            456
            789
            1011
             */
        }

        // 方式一 : entyrSet -> 遍历所有的K-V(Set)
        for (Map.Entry<Object, Object> entry : map.entrySet()) {
            System.out.println(entry);
            /*
            null=null
            AA=112233
            BB=456
            CC=789
            DD=1011
             */
            // 在entry内也定义了两种get方法用以获取对应的KV
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            /*
            null=null
                null
                null
            AA=112233
                AA
                112233
            BB=456
                BB
                456
            CC=789
                CC
                789
            DD=1011
                DD
                1011
             */
        }
    // 方式二 : 通过key来找value
    }
}
