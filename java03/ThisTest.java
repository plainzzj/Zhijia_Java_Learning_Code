package java03;

public class ThisTest {
    public static void main(String[] args) {
        PersonT pt = new PersonT();
        pt.setAge(1);
        pt.setName("Tom");
        System.out.println(pt.getAge());

        // Type mismatch: cannot convert from new PersonT(){} to Person
        // 前后的名称要一致
        PersonT pt1 = new PersonT("Jarry");
        System.out.println(pt1.getAge());
    }   
}

class PersonT{
    // 封装
    private String name;
    private int age;


    // 构造器
    // 构造器private时，在ThisTest类内调用时：
    // The constructor PersonT() is not visible Java(134217859)
    // private -> public
    public PersonT(){
    
    }
    // 构造器中的形参如与属性同名：使用this
    // this -> 正在构造的类的实例化（对象）
    public PersonT(int age){
        this.age = age;
    }

    // 在构造器中调用另外的构造器
    public PersonT(String name){
        // 如果在此时需要执行另一个构造器的代码，则可以用this来调用另一个构造器
        this(50);
        this.name = "Tom";

    }

    // 封装后的赋值/调用方法 
    // public void setName(String n){
    //     name = n;
    // }
    // -> 形参名称与属性名称一致时
    public void setName(String name){
        // 属性中有name, 形参中有name -> 此时，就近原则，都是形参name
        name = name;
        // this 表示当前对象！
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setAge(int n){
        age = n;
    }
    public int getAge(){
        return age;
    }

    // 在方法eat中调用study -> this表示当前对象 -> this即pt
    private void eat(){
        System.out.println("eat");
        this.study();
    }
    private void study(){
        System.out.println("study");
    }
}
