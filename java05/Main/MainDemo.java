package java05.Main;

public class MainDemo {
    // 可以在控制台中（设置命令行参数）来给main方法赋参数值
    public static void main(String[] args) {

        for(int i = 0; i < args.length; i++){
            System.out.println("***" + args[i]);
        }
        
    }
    
}
