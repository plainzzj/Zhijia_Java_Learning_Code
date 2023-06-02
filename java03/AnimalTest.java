package java03;

public class AnimalTest {
    public static void main(String[] args) {

        Animal a = new Animal();
        a.name = "Tom";
        a.age = 14;
        // 暂时避免不了用户直接调用legs属性进行赋值 ->
        // The field Animal.legs is not visible
        // a.legs = 4;

        a.setLegs(-8);
        a.show();
        
    }
    
}


class Animal{
    String name;
    int age = 4;
    // 通过权限修饰符！对属性的暴露进行了封装！
    private int legs;

    public void eat(){
        System.out.println("eat");
    }

    // 对legs进行了封装（隐藏）-> 设置
    public void setLegs(int l){
        if(l >= 0 && l % 2 == 0){
            legs = l;
        }else{
            legs = 0;
            // 抛出一个异常
        }  
    }
    // 对legs进行了封装（隐藏）-> 获取
    public int getLegs(int l){
        return legs;
    }

    public void show(){
        System.out.println(name + age + legs);
    }
}