package Generic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/*
泛型在继承方面的体现

通配符的使用
 */
public class GenericTest2 {

    @Test
    public void test1(){
        Object obj = null;
        String str = null;
        // 子类 -> 父类：多态的体现
        obj = str;
        // 子类 -> 父类：多态的体现(数组)
        Object[] arr1 = null;
        String[] arr2 = null;
        arr1 = arr2;

        List<Object> list1 = null;
        List<String> list2 = null;

//        list1 = list2; // list1 list2不具备子父类关系！完全并列的两个类！

        Date date = new Date();
//        str = date; // 类型完全没有子父类关系，不可以相互赋值！

        show(list1);
//        show(list2); // 形参：List<Object> 不能使用实参：List<String>


    }

    public void show(List<Object> list){
    }

    // 通配符 ？ -> List<?> 是 List<Object>和List<String>的共同父类
    @Test
    public void test2(){
        List<Object> list1 = null;
        List<String> list2 = null;

        List<?> list = null;

        list = list1;
        list = list2;

        print(list1);
        print(list2); // 均可调用！

        ArrayList<String> list3 = new ArrayList<>();
        list3.add("AA");
        list3.add("BB");
        list3.add("CC");
//      List<?> list = null;
        list = list3;

        // 添加 -> 需要的类型：capture of ?
        // 对于List<?> 不能向其内部添加数据 -> 可以增加null
//        list.add("DD");
        list.add(null);

        // 获取 -> 可以获取，读取的数据类型是object
        list.get(0);

    }

    public void print(List<?> list){
        // 增强for
        for (Object o : list) {
            System.out.println(o);
        }

        // 迭代器
        Iterator<?> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }


    }

    @Test
    public void test3(){

    }
}
