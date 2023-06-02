package java05.Static;

public class CirleTest{
    public static void main(String[] args) {
        Circle c1 = new Circle();
        Circle c2 = new Circle();

        System.out.println(c1.getId()); // 1001
        System.out.println(c2.getId()); // 1002

        System.out.println(Circle.getTotal()); // 2

        Circle c3 = new Circle(3.141);
    }

}

class Circle{
    private double radius;
    private int id; // 每次生成的对象的id属性依次+1

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public int getId() {
        return id;
    }

    // 属性是static，操作属性的方法自动生成：static（生命周期保持一致）
    public static int getTotal() {
        return total;
    }


    // 构造函数的重写，每次生成的对象的id属性依次+1
    // 记录的圆总数每次++
    public Circle(){
        id = init++;
        total++;
    }
    // 构造函数的重载
    public Circle(double radius){
        this(); // this -> 调用自己其他的构造方法
        this.radius = radius;
        // id = init++;
        // total++;
    }

    // 记录创建圆的个数
    private static int total;
    // 如果去掉static，那么每个对象的init都是1001
    // static声明的属性被所有对象所共享,id每次都在init上++，id是私有的
    private static int init = 1001;

    public double findArea(){
        return 3.14 * radius * radius;
    }


    
}