package Reflection;

/*
静态代理
 */

interface ClothFactory{
    // 抽象方法
    void produceCloth();

}

// 代理类
class ProxyClothFactory implements ClothFactory{
    /*
    用被代理类的对象进行实例化
     */
    private ClothFactory factory; // 类属性，被代理类的对象

    public ProxyClothFactory(ClothFactory factory) {
        this.factory = factory;
    }

    @Override
    public void produceCloth() {
        System.out.println("代理工厂做一些准备工作");

        factory.produceCloth();

        System.out.println("代理工厂做一些后续的收尾工作");

    }
}

// 被代理类
class NikeClothFactory implements ClothFactory{

    @Override
    public void produceCloth() {
        System.out.println("Nike工厂生产一批运动服");
    }
}
public class StaticProxyTest {
    public static void main(String[] args) {
        //1. 被代理类对象
        NikeClothFactory nike = new NikeClothFactory();
        //2. 代理类对象
        ProxyClothFactory proxy = new ProxyClothFactory(nike);
        // 通过代理类的对象执行了Nike中的相关实现 -> 静态代理
        // 编译期间 代理类与被代理类都已经确定
        proxy.produceCloth();
        /*
        代理工厂做一些准备工作
        Nike工厂生产一批运动服
        代理工厂做一些后续的收尾工作
         */
    }

}

