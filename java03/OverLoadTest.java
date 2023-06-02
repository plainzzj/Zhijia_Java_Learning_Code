package java03;

// 类OverLoadTest
public class OverLoadTest {
    // 如下的三个方法构成重载
    // static修饰的方法，无须产生类的实例对象就可以调用该方法
    // 即satic变量是存储在静态存储区的，不需要实例化
    // 非static修饰的方法，需要产生一个类的实例对象才可以调用该方法。
    public static int mOL(int a){
        return a * a;
    }
    public  int mOL(int a, int b){
        return a*b;
    }
    public static String mOL(String a){
        return "a";
    }

    public static void main(String[] args) {
        int a = 5;
        int b = 10, c;
        String d = "this is overload";
        // Cannot make a static reference to the non-static method mOL(int) 
        // from the type OverLoadTest
        // 上述方法增加“static”关键字即可
        // 或者先进行类的实例化

        
        // 使用static修饰符修饰
        c = mOL(a);
        System.out.println(c);

        // 先进行类的实例化
        OverLoadTest ol = new OverLoadTest();
        c = ol.mOL(a,b);
        System.out.println(c);
        
        d = mOL(d);
        System.out.println(d); 

    }
}
