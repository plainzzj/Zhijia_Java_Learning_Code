package Reflection;

@MyAnnotation(value = "hi!")
public class NewPerson extends Creature<String> implements Comparable<String>, MyInterface{
    private String name;
    int age;
    public int id;

    public NewPerson(){}
    @MyAnnotation(value = "abc!")
    private NewPerson(String name){
        this.name = name;
    }
        NewPerson(String name, int age){
        this.name = name;
        this.age = age;
        }
    @MyAnnotation
    private String show(String nation){
        System.out.println("我的国籍是" + nation);
        return nation;
    }
    public String display(String interests){
        return interests;
    }

    @Override
    // 必须重写或实现接口中的抽象方法
    public void info() {
        System.out.println("我是一个人");
    }

    @Override
    public int compareTo(String o) {
        return 0;
    }
}
