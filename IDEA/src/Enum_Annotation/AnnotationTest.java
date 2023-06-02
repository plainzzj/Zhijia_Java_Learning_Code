package Enum_Annotation;

public class AnnotationTest {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.walk();
        @SuppressWarnings("unused") // 抑制编译器警告！
        // 变量num变色正常！
        int num = 10; // 变量num灰色：定义后没有使用
    }

}

@MyAnnotation(value = "hello") // 使用自定义注解！(有成员 -> 注解)
        // 后续通过 反射 读取注解 -> 信息处理流程才有意义
/*
 可重复注解
 1. 在MyAnnotation 上声明@Repeatable, 成员值为MyAnnotations.class
 2. MyAnnotation的Target和Retention和MyAnnotations相同
 */
@MyAnnotation(value = "abc")
class Person {
    private String name;
    private int age;

    // 别忘了空参构造器！
    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Deprecated // 表示过时
    public void walk() {
        System.out.println("walk");
    }

    public void eat() {
        System.out.println("eat");
    }
}

class Student extends Person {

    @Deprecated // 表示过时或结构危险！
    @Override // 重写！加上注解后可编译时校验 (没有成员 -> 标记)
    public void walk() {
        super.walk();
        System.out.println("student");
    }
}

// 自定义注解：参照@SuppressWarnings

