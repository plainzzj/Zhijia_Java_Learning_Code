package java03;

public class TriAngleTest{
    public static void main(String[] args) {
        TriAngle ta = new TriAngle(13, 25);
        System.out.println(ta.getArea()); 
    }
}

class TriAngle{
    // 私有属性
    private double base, height;

    // 类必要的构造器
    public TriAngle(){
    }
    public TriAngle(double b, double h){
        base = b;
        height = h;

    }

    public double getBase(){
        return base;
    }
    public double getHeight(){
        return height;
    }

    public double getArea(){
        return base * height /2;
    }
}

