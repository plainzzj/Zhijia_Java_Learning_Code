package java04.GeometricObject;

public class GeometricObject {
    // 属性
    // protected权限修饰符 -> 类、包、不同包的子类（不在同一个包下，但是是子类）
    protected String color;
    protected double weight;

    // 构造函数
    protected GeometricObject(){

    }
    protected GeometricObject(String color, double weight){
        this.color = "white";
        this.weight = 1.0;
    }

    public String getColor(){
        return color;
    }
    public double getWeight(){
        return weight;
    }
    public void setColor(String color){
        this.color = color;
    }
    public void setWeight(double weight){
        this.weight = weight;
    }

}
