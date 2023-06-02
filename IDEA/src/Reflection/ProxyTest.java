package Reflection;

/*
动态代理
 */

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Human {
    String getBelief();

    void eat(String food);
}

// 被代理类
class SuperMan implements Human {
    @Override
    public String getBelief() {
        return "I believe I can fly!";
    }

    @Override
    public void eat(String food) {
        System.out.println("我喜欢吃" + food);
    }
}

class HumanUtil{  // -> invoke(调用)
    // 动态代理增加的通用方法1
    public void method1(){
        System.out.println("=====通用方法一=====");
    }
    // 动态代理增加的通用方法2
    public void method2(){
        System.out.println("=====通用方法二=====");
    }
}

// 动态代理类！
/*
1. 如何根据加载到内存中的被代理类，动态的创建一个代理类及其对象
当通过代理类的对象调用方法时，如何动态的去调用被代理类中的同名方法
 */
class ProxyFactory {
    // 调用此(静态)方法，返回一个代理类的对象！ 问题1
    public static Object getProxyInstance(Object obj) { // obj: 被代理类的对象
        MyInvocationHandler handler = new MyInvocationHandler();
        // obj.getClass().getClassLoader() 被代理类的加载器
        // obj.getClass().getInterfaces() 被代理类的接口
        // InvocationHandler,问题2
        handler.bind(obj); // -> 被代理的对象的赋值！
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), handler);


    }
}

class MyInvocationHandler implements InvocationHandler {
    private Object obj; // 需要使用被代理类的对象进行赋值

    public void bind(Object obj) {

        this.obj = obj;
    }

    // 当通过代理类的对象，调用方法a时，会自动的调用如下的方法： invoke()
    // 解决问题2
    // 将被代理类要执行的方法a的功能声明在invoke()中
    // Object proxy 代理类的对象 -> obj
    // Method method 代理类对象需要调用的被代理类的方法 -> getBeleif
    //
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // method即为代理类对象调用的方法，此方法也作为了被代理类对象要调用的方法
        HumanUtil util = new HumanUtil();
        util.method1();
        /*
        Cannot invoke "Object.getClass()" because "obj" is null -> 实例化obj即可
         */
        // 回调目标对象的方法！！！ -> 不确定的方法
        Object returnValue = method.invoke(obj, args);
        util.method2();
        return returnValue;
    }
}

public class ProxyTest {
    public static void main(String[] args) {
        //
        SuperMan superMan = new SuperMan();
        //1.  proxyInstance -> 代理类的对象
        Human proxyInstance = (Human) ProxyFactory.getProxyInstance(superMan);
        System.out.println(proxyInstance.getBelief());
        proxyInstance.eat("四川麻辣烫");
        System.out.println("**************************");

        NikeClothFactory nikeClothFactory = new NikeClothFactory();
        ClothFactory proxyInstance1 = (ClothFactory)ProxyFactory.getProxyInstance(nikeClothFactory);
        proxyInstance1.produceCloth();
        /*
        I believe I can fly!
        我喜欢吃四川麻辣烫
         */

        /*
        =====通用方法一=====   -> getBelief方法的调用，没有sout任何东西
        =====通用方法二=====
        I believe I can fly!
        =====通用方法一=====
        我喜欢吃四川麻辣烫
        =====通用方法二=====
        **************************
        =====通用方法一=====
        Nike工厂生产一批运动服
        =====通用方法二=====
         */

    }
}
