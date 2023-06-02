package Reflection;

import java04.polymorphisn.Person;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static java.lang.Class.forName;

// Ctrl + N 全局搜索文件、类、符号、操作……
public class ReflactionTest {
    // 反射之前：对于类Person
    @Test
    public void test1(){
        // 1. 创建类的对象
        Person tom = new Person("Tom", 16, true, 1001);
        // 2. 通过对象，调用器内部的方法/属性
        tom.eat(); // Humen can eat
        tom.getName();
        tom.age = 25;
        System.out.println(tom.toString()); // name:  Tom  age:    25
        // 3.  不可以通过Person类的对象调用其内部私有结构，如school和func2()
    }
    // 反射之后：对于类Person
    @Test
    public void test2() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        // Class类的对象 -> 反射的源头！
        Class<Person> personClass = Person.class;
        // 得到Person类的构造器
        Constructor<Person> constructor = personClass.getConstructor(String.class, int.class, boolean.class, int.class);
        // 1. 创建Person类的对象 -> 通过反射，创建Person类的对象
        Person tom = constructor.newInstance("Tom", 12, true, 1002);
        // 2. 通过反射，调用对象指定的属性、方法：
        Field age = personClass.getDeclaredField("age");
        // 将Person对象tom的属性age更改为10
        age.set(tom, 10);
        // 调用Person对象tom的方法func1
        /*
        字段（Field），是 Java 编程语言中类的一个成员.
        主要用来存储对象的状态（如同某些编程语言中的变量）.
        所以有时也可称为成员字段或成员变量. -> 属性

        方法（Method）
         */
        Method func1 = personClass.getDeclaredMethod("func3"); // 在反射中调用函数相关方法！

        /*
        invoke : 调用
         */
        func1.invoke(tom);
        System.out.println("****************************************************");

        // 通过反射，可以调用Person类的私有结构，如私有的构造器、方法、属性
         // -> 使用私有构造器
        Constructor<Person> constractor1 = personClass.getDeclaredConstructor(String.class);
        constractor1.setAccessible(true);
        Person hfut = constractor1.newInstance("HFUT");
        System.out.println(hfut); // name:  null  age:    1(ToString方法中没有写明school)
        // -> 使用私有的属性
        Field school = personClass.getDeclaredField("school");
        school.setAccessible(true);
        school.set(hfut, "AHU");
        System.out.println(hfut); // -> 将私有属性进行了更改
        /*
        Person{name='null', age=1, isMale=false, id=1111, school='AHU'}
         */
        // 使用私有的方法
        Method func2 = personClass.getDeclaredMethod("func2");
        func2.setAccessible(true);
        func2.invoke(hfut); // 相当于 -> hfut.func2

        /*
        从对象调用方法
        -> 方法的对象(Method func2)调用方法类的方法(invoke())，参数是对象(Person hfut)

        // 这是一个私有方法
         */
    }
    // 创建Class类的实例
    @Test
    public void test3() throws ClassNotFoundException {
        // 方式一：调用运行时类的属性：.class -> 无法体现动态性
        Class<Person> class1 = Person.class;
        System.out.println(class1);
        // class java04.polymorphisn.Person -> 类本身

        // 方式二：通过运行时类的对象
        Person p1 = new Person();
        Class<? extends Person> class2 = p1.getClass();
        System.out.println(class2);
        // class java04.polymorphisn.Person -> 类本身

        // 方式三：调用Class的静态方法：forName(String classPath) -> 用的多
        Class<?> class3 = forName("java04.polymorphisn.Person");
        System.out.println(class3);
        // class java04.polymorphisn.Person -> 类本身

        System.out.println(class1 == class2);
        // true -> 指向的是同一个对象

        // 方式四：使用类的加载器：ClassLoader
        ClassLoader classLoader = ReflactionTest.class.getClassLoader();
        System.out.println(classLoader.loadClass("java04.polymorphisn.Person"));
        // class java04.polymorphisn.Person -> 类本身
    }
}
