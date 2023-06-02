package java03;

public class CircleTest {  
    public static void main(String[] args) {
        // Circle c1 = new Circle();
        // c1.radius = 2.25;
        // double a1 = c1.findArea();
        // System.out.println(a1); // 15.904312808798327

        Circle c2 = new Circle();
        System.out.println(c2.findArea(2.25));  // 15.904312808798327
    }
}

// class Circle{
//     // 属性
//     double radius;

//     // 求圆的面积
//     public double findArea(){
//         double area = Math.PI * radius * radius;
//         return area;
//     }
// }

class Circle{
    // 去掉属性
    // double radius;

    // 求圆的面积
    // 在方法中指明形参
    public double findArea(double radius){
        double area = Math.PI * radius * radius;
        return area;
    }
}
