package Reflection;

import java04.polymorphisn.Person;
import org.junit.Test;

import java.util.Random;

public class NewInstanceTest {
    @Test
    public void test1() throws InstantiationException, IllegalAccessException {
        // 类的泛型决定了 getInstcance方法
        Class<Person> class1 = Person.class;
        Person person = class1.newInstance(); // 空参构造器->过时了
        /*
        newInstance(): 调用此方法，创建对应的运行时类的对象
        内部调用了运行时类的空参构造器
         */

        System.out.println(person);
        // Person{name='null', age=1, isMale=false, id=1111, school='USTC'}
    }
    /*
    编译时不能确定造的类的对象是哪一个
    只能在运行时通过确定的随机数确定造的是哪一个类的对象 -> 反射的动态性！
     */
    @Test
    public void test2() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        int num = new Random().nextInt(3);// 0,1,2 随机数
        String classPath = "";
        switch (num){
            case 0:
                classPath = "java.util.Date";
                break;
            case 1:
                classPath = "java.lang.Object";
                break;
            case 2:
                classPath = "java04.polymorphisn.Person";
                break;
        }
        Object obj = getInstance(classPath);
        System.out.println(obj);
        /*
        Person{name='null', age=1, isMale=false, id=1111, school='USTC'}
        InstantiationException: java.sql.Date -> sql下的Date没有空参构造器！
         */

    }
    /*
    此方法创建一个指定类的对象
    classPath：指定类的全类名
     */
    public Object getInstance(String classPath) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class<?> aClass = Class.forName(classPath);
        return aClass.newInstance();
    }

}
