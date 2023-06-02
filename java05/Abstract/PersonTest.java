package java05.Abstract;

public class PersonTest {
    public static void main(String[] args) {

        // 有名的类，有名的对象！
        Student s1 = new Student();
        method(s1);

        // 对于静态方法可以不创建类的对象，直接调用
        // The constructor Student() is undefined
        // 有名的类，匿名的对象！
        method(new Student()); 

        // 匿名的类，有名的对象！
        // Person: 抽象类，无法创建对象，new的是一个子类的匿名对象-> p!
        Person p = new Person(){
            @Override
            public void eat() {
                // TODO Auto-generated method stub  
            }   
        };
        method(p);

        // 匿名的类，匿名的对象！
        method(new Person() {
            @Override
            public void eat() {
                // TODO Auto-generated method stub  
            }  
        });
    }
    
    // static -> 静态方法
    public static void method(Person s){
        System.out.println("我是一个小学生！");

    }
    
}
