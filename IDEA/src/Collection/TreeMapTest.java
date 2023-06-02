package Collection;

import org.junit.Test;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapTest {
    // Key: 同类对象(要按照Key进行排序) -> 自然排序
    @Test
    public void test1(){
        TreeMap<Object, Object> map = new TreeMap<>();
        // Key: 自定义类User
        map.put(new User(12,"Tom"), 123);
        map.put(new User(15,"Jerry"), 456);
        map.put(new User(55,"Tim"), 789);
        map.put(new User(27,"John"), 1011);
        // 遍历 -> 姓名从大到小排序（自然排序）
        for (Map.Entry<Object, Object> entry : map.entrySet()) {
            System.out.println(entry);
            /*
            User{age=15, name='Jerry'}=456
            User{age=27, name='John'}=1011
            User{age=55, name='Tim'}=789
            User{age=12, name='Tom'}=123
             */
        }

    }
    // 定制排序 -> 按照年龄排序
    @Test
    public void test2(){
        TreeMap map = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof User && o2 instanceof User){
                    User u1 = (User)o1;
                    User u2 = (User)o2;
                    return  Integer.compare(u1.getAge(), u2.getAge() );

            }
                throw new RuntimeException("类型输入不匹配");
        }

            });
        // Key: 自定义类User
        map.put(new User(12,"Tom"), 123);
        map.put(new User(15,"Jerry"), 456);
        map.put(new User(55,"Tim"), 789);
        map.put(new User(27,"John"), 1011);
        // 遍历 -> 姓名从大到小排序（定制排序）
        for (Object obj: map.entrySet()) {
            System.out.println(obj);
            /*
            User{age=12, name='Tom'}=123
            User{age=15, name='Jerry'}=456
            User{age=27, name='John'}=1011
            User{age=55, name='Tim'}=789
             */
        }

    }
}
