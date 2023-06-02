package java05.Static;

public class StaticTest {
    public static void main(String[] args) {

        // 静态变量的加载早于类实例的创建 -> 可以直接 类.静态变量 来赋值
        // 存在于方法区的静态域中
        Chinese.nation = "aaa";

        Chinese c = new Chinese();
        c.name = "ZZJ";
        c.age = 40;

        Chinese c1 = new Chinese();
        c1.name = "LL";
        c1.age = 18;

        c.nation = "CHN";
        System.out.println(c1.nation); // CHN

        c1.nation = "USA";
        System.out.println(c.nation); // USA

        Chinese.show(); // static!

        
    }
    
}

class Chinese{
    String name;
    int age;
    static String nation;

    // 通过对象调用
    public void eat(){
        System.out.println("eat");
        // 在非静态方法中可以调用静态方法
        show();
    }

    // 静态方法：随着类的加载而加载
    public static void show(){
        System.out.println("static!");
        // Cannot make a static reference to 
        // the non-static method eat() from the type Chinese
        // eat();

        // 在静态方法中可以调用静态属性：
        System.out.println(nation);
        System.out.println(Chinese.nation);
        // 在静态方法中可以调用静态方法
        show();

    }

}
