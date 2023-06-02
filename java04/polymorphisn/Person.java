package java04.polymorphisn;

import java.io.Serializable;

// 接口Serializable，标识接口，没有需要重写的方法，目的是标识类Person可序列化
public class Person implements Serializable {
    // 属性（成员变量）（field）（域、字段）

    // 可序列化的要求二： 必须要有如下属性（序列版本号）
    static final long serialVersionUID = 11223345566778L;
    public String name;
    public int age = 1;
    public boolean isMale;
    public int id = 1111;
    private String school = "USTC";

    // 方法（成员方法）（函数）（method）
    // 方法可以不包含形参
    // void：没有返回值
    public void eat(){

        System.out.println("Humen can eat");
    }
    public void sleep(int hour){

        System.out.println("Humen sleeps " + hour + "hours");
    }
    public void talk(String language){

        System.out.println("Humen can speak with " + language);
    }
    public String getName(){

        return name;
    }
    public void setName(
            String name){
        this.name = name;
    }
    // 方法可以包含形参
    // String：返回值类型
    public String getNation(String nation){
        String info = "My nation is " + nation;
        return info;
    }

    public Person() {
    }

    public Person(String name, int age, boolean isMale, int id) {
        this.name = name;
        this.age = age;
        this.isMale = isMale;
        this.id = id;
    }

    // Person pt = new Man()
    // 声明了一个person，但是new了一个man/woman -> 多态性
    // 如果没有多态性，只能new一个person，对于man,woman还需重写它们的func方法！
    public void func(Person person){
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        person.eat();
        person.talk("ABC");
        
    }
    /*
    私有构造器！
     */
    public Person(String school) {
        this.school = school;
    }

    // 对于这个方法，只要是个类的实例，都可以对它进行调用！！！
    // 不用每个类都单独实现一次！
    public void func1(Object obj){
        System.out.println("多态性真好呀！！！");

    }

    private void func2(){
        System.out.println("这是一个私有方法");
    }

    public void func3(){
        System.out.println("在反射中调用函数相关方法！");
    }

    // 重写equals方法-> 原则：比较两个对象的实体内容(属性)是否相同
    // The method equals() of type EqualsTest must override
    // or implement a supertype method
    // 必须重写或实现父类型，写完return之后报错消失
    // 重写的方法必须放在类下面？

    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj instanceof Person){
            Person p = (Person)obj;
            // 比较两个Person的属性是否相同
            // Syntax error on tokens, delete these tokens -> 中文字符/括号/引号不匹配
            // id cannot be resolved or is not a field -> 无法解析或不是一个字段
            // obj -> p 解决问题！
            if(this.id == p.id && this.age == p.age 
            && this.name.equals(p.name) && this.isMale == p.isMale);
            // Exception in thread "main" java.lang.NullPointerException: 
            // Cannot invoke "String.equals(Object)" because "this.name" is null
            // 必须赋值才可进行对比！ null无法进行对比！-> 空指针！
            return true;
        }
        return false;       
      }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", isMale=" + isMale +
                ", id=" + id +
                ", school='" + school + '\'' +
                '}';
    }


}