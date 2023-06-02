package Reflection;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

// 可以修饰属性、方法、变量……
@Target({TYPE, FIELD, METHOD, PARAMETER,CONSTRUCTOR})
// 注解的生命周期
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    String value() default "hello";

}
