package Collection;

import java.util.Objects;

public class User implements Comparable{
    // static 后： 静态变量(类变量) -> 属于类，而不是类的对象
    private int age;
    private String name;

    public User() {
    }

    public User(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // 重写 equals方法
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && Objects.equals(name, user.name);
    }

    // 重写 hashCode方法
    @Override
    public int hashCode() {
        return Objects.hash(age, name);
    }

    // 按照姓名从小到大排列
    @Override
    public int compareTo(Object o) {
        if (o instanceof User){
            User user = (User) o; // 强转
            if(this.name.compareTo(user.name) != 0){
                return this.name.compareTo(user.name);
            }else {
                // int数据的比较：使用Integer.compare
                return Integer.compare(this.age, user.age);
            }
        }else{
            throw new RuntimeException("输入的类型不匹配！");
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
