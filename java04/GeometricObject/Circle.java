package java04.GeometricObject;

public class Circle extends GeometricObject {
    // private：类内部
    private double radius;

    // 重载构造方法
    public Circle() {

    }

    public Circle(double radius) {
        this.radius = radius;

    }

    public Circle(double radius, String color, double weight) {
        // 父类中已经定义了,直接调用父类构造器即可
        super(color, weight);
        this.radius = radius;
        // this.color = color;
        // this.weight = weight;

    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double findArea() { // 面积
        return radius * radius * Math.PI;
    }

    @Override
    public boolean equals(Object obj) { // 比较两个圆的面积是否相等
        // obj是父类，父类不含有子类的属性！
        Circle c = (Circle) obj; // 向上强制转换
        return this.radius == c.radius;

    }

    @Override
    public String toString() {
        return "radius:" + radius;
    }

}
