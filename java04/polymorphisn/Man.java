package java04.polymorphisn;

public class Man extends Person{
    int id = 2222;
    boolean isSmoking;

    public void earnMoney(){
        System.out.println("make money!");
    }

    @Override
    public void eat() {
        System.out.println("eat more!");
    }
    
}
