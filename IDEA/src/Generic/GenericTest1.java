package Generic;

import org.junit.Test;

import java.util.List;

public class GenericTest1 {
    @Test
    public void test1(){
        // 如果实例化时没有指明类的泛型，则认为此泛型类型为object类型
        // 要求： 建议在实例化时要指明类的泛型
        Order<String> order = new Order<String>("orderAA", 1001, "lalala~~~");
        order.setOrderT("AA: HELLO~~~!!!");
    }
    @Test
    public void test2(){
        // 当继承的过程中指明了父类的泛型类型，则子类构建中不存在泛型 -> 普通的类
        SubOrder subOrder = new SubOrder();
    }
    @Test
    public void test3(){
        // 当继承的过程中未指明父类的泛型类型，则子类构建中存在泛型 -> 泛型的类
        SubOrder1<String> subOrder1 = new SubOrder1<String>();
        subOrder1.setOrderT("BB: HELLO~~~!!!");
    }

    @Test
    public void test4(){
        Order<String> order = new Order<>();
        Integer[] arr = new Integer[]{1,2,3,4};
        // 泛型方法的调用！ -> 指明泛型参数的类型（与类的泛型无关）
        // 泛型方法可以声明为static：泛型参数是在调用方法时确定的，并非在实例化时确定
        List<Integer> list = order.copyFromArrayToList(arr);

        System.out.println(list);
    }
}
