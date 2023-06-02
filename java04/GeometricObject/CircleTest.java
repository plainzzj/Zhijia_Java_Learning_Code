package java04.GeometricObject;

public class CircleTest {
    public static void main(String[] args) {
        Circle c = new Circle(9.1);
        System.out.println(c.findArea()); // 260.15528764377075
        System.out.println(c.toString()); // radius:9.1
        System.out.println(c.equals(c)); // true
    }
    
}
