package Compare;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class CompareTest {
/*
Comparable（可比较的）接口的使用举例
 */
    @Test
    public void test1(){
        String[] arr = new String[]{"DD","BB","AA","CC","ZZ","XX","GG","MM"};
        Arrays.sort(arr); // -> String 实现了 comparable接口
        // [AA, BB, CC, DD, GG, MM, XX, ZZ]
        System.out.println(Arrays.toString(arr));


    }
    @Test
    public void test2(){
        Goods[] arr = new Goods[4];
        arr[0] = new Goods("小米13",4000);
        arr[1] = new Goods("魅族20",5000);
        arr[2] = new Goods("苹果15",8000);
        arr[3] = new Goods("三星S30",7000);

        // 排序
        Arrays.sort(arr);
        // java.lang.ClassCastException: class Compare.Goods cannot be cast to class java.lang.Comparable
        // (Compare.Goods is in unnamed module of loader 'app'; java.lang.Comparable is in module java.base of loader 'bootstrap')
        System.out.println(Arrays.toString(arr));
        /*
        [Goods{name='小米13', price=4000.0},
        Goods{name='魅族20', price=5000.0},
        Goods{name='三星S30', price=7000.0},
        Goods{name='苹果15', price=8000.0}]
         */

    }
    @Test
    public void test3(){
        String[] arr = new String[]{"DD","BB","AA","CC","ZZ","XX","GG","MM"};
        // 定制排序，除了输入需要排序的object类的实现外
        // 还需要输入一个 Comparator的实现！
        // 创建Comparator实现的时候，必须重写compare方法！(抽象方法?)
        Arrays.sort(arr, new Comparator<Object>() {
            @Override
            // 指明两个对象 o1 o2 如何排序(泛型知识，可直接写String)
            public int compare(Object o1, Object o2) {
                // 判断o1 o2是否为String类型，并强制转换
                if(o1 instanceof String && o2 instanceof String){
                    String s1 = (String) o1;
                    String s2 = (String) o2;
                    // 从大 -> 小排序
                    return -s1.compareTo(s2);
                }
                return 0; // 也可抛出异常
            }
        });
        System.out.println(Arrays.toString(arr));
        // [ZZ, XX, MM, GG, DD, CC, BB, AA]


    }

    @Test
    public void test4(){
        Goods[] arr = new Goods[4];
        arr[0] = new Goods("小米13",4000);
        arr[1] = new Goods("魅族20",5000);
        arr[2] = new Goods("苹果15",8000);
        arr[3] = new Goods("三星S30",7000);

        Arrays.sort(arr, new Comparator<Goods>() {
            @Override
            // 先按照产品从低到高，再按照价格从高到低
            public int compare(Goods o1, Goods o2) {
                if(o1 instanceof Goods && o2 instanceof Goods){
                    Goods g1 = (Goods)o1;
                    Goods g2 = (Goods)o2;
                    if(g1.getName().equals(g2.getName())){
                        return -Double.compare(g1.getPrice(), g1.getPrice());
                    }else{
                        return g1.getName().compareTo(g2.getName());
                    }
                }
                return 0;
            }
        });
        System.out.println(Arrays.toString(arr));
        /*
        [Goods{name='三星S30', price=7000.0},
        Goods{name='小米13', price=4000.0},
        Goods{name='苹果15', price=8000.0},
        Goods{name='魅族20', price=5000.0}]
         */

    }
}
