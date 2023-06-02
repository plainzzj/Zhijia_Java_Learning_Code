package Reflection;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class MethodTest {
    @Test
    public void test1(){
        Class<NewPerson> clazz = NewPerson.class;

        Method[] method = clazz.getMethods();
        for (Method m : method) {
            System.out.println(m);
            /*
            获取当前运行时类与父类中声明为public的方法
            public int Reflection.NewPerson.compareTo(java.lang.String)
            public int Reflection.NewPerson.compareTo(java.lang.Object)
            public void Reflection.NewPerson.info()
            public java.lang.String Reflection.NewPerson.display(java.lang.String)
            public final void java.lang.Object.wait(long,int) throws java.lang.InterruptedException
            public final void java.lang.Object.wait() throws java.lang.InterruptedException
            public final native void java.lang.Object.wait(long) throws java.lang.InterruptedException
            public boolean java.lang.Object.equals(java.lang.Object)
            public java.lang.String java.lang.Object.toString()
            public native int java.lang.Object.hashCode()
            public final native java.lang.Class java.lang.Object.getClass()
            public final native void java.lang.Object.notify()
            public final native void java.lang.Object.notifyAll()
             */

            }
        System.out.println("***************************************\n");
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method n : declaredMethods) {
            System.out.println(n);
            /*
            获取当前运行时类中(所有)的方法
            public int Reflection.NewPerson.compareTo(java.lang.String)
            public int Reflection.NewPerson.compareTo(java.lang.Object)
            public void Reflection.NewPerson.info()
            public java.lang.String Reflection.NewPerson.display(java.lang.String)
            private java.lang.String Reflection.NewPerson.show(java.lang.String)
             */
        }

    }

    @Test
    public void test2(){
        Class<NewPerson> clazz = NewPerson.class;
        Method[] method = clazz.getDeclaredMethods();
        for (Method m : method) {
            //1. 获取方法声明的注解
            Annotation[] annotations = m.getAnnotations();
            for (Annotation annotation : annotations) {
                System.out.println(annotation);
                /*
                @Reflection.MyAnnotation("hello")
                 */
            }
        }

        for (Method n : method) {
            // 2. 获取方法的权限修饰符
            System.out.println(n.getModifiers());
            /*
            1
            4161, 包括 1，64和4096：public合成桥方法
            1
            1
            2
             */

        }

        for (Method o : method) {
            // 3. 返回值类型
            System.out.println(o.getReturnType());
            /*
            int
            int
            void
            class java.lang.String
            class java.lang.String
             */

        }

        for (Method p : method) {
            // 4. 方法名
            System.out.println(p.getName());
            /*
            compareTo
            compareTo
            info
            display
            show
             */

        }

        for (Method q : method) {
            // 5. 参数列表
            System.out.println(q.getParameterTypes());
            /*
            [Ljava.lang.Class;@4ec6a292
            [Ljava.lang.Class;@1b40d5f0
            [Ljava.lang.Class;@ea4a92b
            [Ljava.lang.Class;@3c5a99da
            [Ljava.lang.Class;@47f37ef1
             */
        }
    }
}
