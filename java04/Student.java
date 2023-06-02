package java04;

// 只能调用与文件名相同的类：一个文件中最多只创建一个类?
import java03.StudentTest;

// ST类继承S类 -> 获得了S类所有的属性和方法！
public class Student extends StudentTest{
    public static void main(String[] args) {
        Student s = new Student();
        // The field StudentTest.test1 is not visibleJava(33554503)
        // 跨包调用，需要public属性，需要在ST类中属性定义前增加关键字public
        System.out.println(s.test1); // 找不到 -> 1
        System.out.println(s.test2);  // 4
        
        // 如果要调用ST类的属性，使用super关键字？
        // Cannot use super in a static context -> 静态方法中，不可以使用super
        // System.out.println(super.test1);

        // 调用类的实例化后的方法，直接调用即可，由于返回值是void，不需要新建变量去接收值
        s.func1(); // father1
        s.func2(); // son

        s.func3();// 2 4 a

        Student s1 = new Student(10, 20);
        System.out.println("**************************");
        s1.func3(); // 20 4 a
        
    }
    // 属性不会覆盖，此时在内存中存在两个ID
    // int test1 = 3;
    int test2 = 4;

    // 构造函数
    public Student(){

    }
    // The constructor StudentTest(int, int) is undefined
    public Student(int test1, int test2){
        // 在子类中可以直接使用super(形参列表)来调用父类的构造函数中的构造方法
        super(test1, test2);
    }
    // 子类中也无法存在两个同名的构造函数
    // public Student(int test1, int test2){

    // }


    // 方法
    @Override
    public void func1() {
        // “自动生成方法(空函数)” -> 提示为编译器自动生成
        // TODO Auto-generated method stub
        super.func1(); // -> 直接继承父类方法
    }
    @Override
    public void func2(){
        System.out.println("son");
    }

    // 但是属性的调用可以明确是调用父类还是子类
    public void func3(){
        System.out.println(super.test2); // 2
        System.out.println(this.test2); // 4
        // 当子类没有定义（重写）的时候，会在父类中继续查找
        System.out.println(this.test3); // 'a' -> 97

    }


    
}
