package java04.polymorphisn;

public class Woman extends Person{
    boolean isBeauty;
    
    public void goShopping(){
        System.out.println("go shopping!");
    }

    @Override
    public void eat() {
        System.out.println("eat less");
    }
    
}
