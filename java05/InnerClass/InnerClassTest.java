package java05.InnerClass;

public class InnerClassTest {
    
}

class Person{
    // 成员内部类 -> 可以是静态的、非静态的
    class Dog{

    }

    public void method(){
        // 局部内部类 -> 申明在类的方法中
        class AA{

        }

    }
    {
        // 局部内部类 -> 申明在类的代码块中
        class BB{

        }
    }
    public Person(){
        // 局部内部类 -> 申明在类的构造器中
        class CC{

        }

    }
}


