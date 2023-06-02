package Reflection;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/*
获取当前运行时类的所有属性
 */
public class FiledTest {
    @Test
    public void test1(){
        Class<NewPerson> clazz = NewPerson.class;

        // 获取属性结构
        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            System.out.println(field);
            /*
            getFields()：
            仅能获取当前运行时类及其父类中声明为public的权限的属性
            public int Reflection.NewPerson.id
            public double Reflection.Creature.weight
             */
        }
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
            /*
            getDeclaredFields()：
            获取当前运行时类自己的（不区分权限）属性
            private java.lang.String Reflection.NewPerson.name
            int Reflection.NewPerson.age
            public int Reflection.NewPerson.id
             */
        }
    }
    // 权限修饰符 数据类型 变量名
    @Test
    public void test2(){
        Class<NewPerson> clazz = NewPerson.class;
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field f: declaredFields) {
            // Modifiers 修饰符 -> 返回int
            System.out.println(Modifier.toString(f.getModifiers()));
            /*
            2 -> private
            0 -> 默认
            1 -> public
             */
            // Type 类型 -> 返回class
            System.out.println(f.getType());
            /*
            class java.lang.String
            int
            int
             */
            // Name 变量名 -> 返回String
            System.out.println(f.getName());
            /*
            name
            age
            id
             */

        }
    }
}
