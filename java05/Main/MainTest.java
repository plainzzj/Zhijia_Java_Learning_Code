package java05.Main;

// 每个源文件(.java)文件中智能生成一个public的类，且类与文件名相同
public class MainTest {
    // main 本质是一个普通的静态方法
    // 通过类的对象调属性 -> 静态方法main只能调静态属性
    // public: 作为入口，权限要大
    public static void main(String[] args) {
        Main.main(new String[100]);
        
    }
    
}

// 每个类中都可以有自己的main方法
class Main{
    public static void main(String[] args) {
        for(int i = 0; i < args.length; i++){
            args[i] = "args_" + i;
            System.out.println(args[i]); // args_0...args_99
        }
        
    }
}
