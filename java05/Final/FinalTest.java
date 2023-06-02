package java05.Final;

public class FinalTest {
    public static void main(String[] args) {
        FinalB fb = new FinalB();
        // final num可以被打印出来，但此时在方法内只能被调用，不能被修改
        fb.show(20);
        fb.show(50);
    }
    // final 代表这个变量是常量，无法修改 -> 大写！
    final int WIDTH = 10;

    public void doWidth(){
        // The final field FinalTest.width cannot be assigned
        // width = 20;
    }
    
    
}

// final代表这个类是最终的，无法被继承
final class FinalA{

}

// The type FinalB cannot subclass the final class FinalA
// class FinalB extends FinalA{

// }

// final代表这个方法是最终的，无法被重写
class FinalB{
    final public void show(){

    }
    // final代表这个方法中的形参是常量，只能被调用，不能被修改
    final public void show(final int num){
        System.out.println(num);
        // The final local variable num cannot be assigned. 
        // It must be blank and not using a compound assignment
        // num = 20;

    }
}

class FinalC extends FinalB{
    // Cannot override the final method from FinalB
    // public void show(){

    // }
}

