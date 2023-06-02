package Enum_Annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Retention(RetentionPolicy.RUNTIME) // -> 指定註解的生命週期
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE, MODULE})
// -> 执行注解可以修饰的类型 (TYPE即类、接口、枚举类)，默认都可以
public @interface MyAnnotations {
    // MyAnnotation 类型的数组
    MyAnnotation[] value();
}
