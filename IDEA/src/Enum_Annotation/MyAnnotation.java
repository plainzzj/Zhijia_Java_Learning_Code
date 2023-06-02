package Enum_Annotation;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Repeatable(MyAnnotations.class) // -> 可重复注解！
// 通过@interface声明(与 interface接口没有关系)
@Retention(RetentionPolicy.RUNTIME) // -> 指定註解的生命週期
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE, MODULE})
// -> 执行注解可以修饰的类型 (TYPE即类、接口、枚举类)，默认都可以
public @interface MyAnnotation {

    String value();
}
