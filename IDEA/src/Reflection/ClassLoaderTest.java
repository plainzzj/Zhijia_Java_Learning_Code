package Reflection;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ClassLoaderTest {

    @Test
    public void test1(){
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);
        /*
        对于自定义类
        jdk.internal.loader.ClassLoaders$AppClassLoader@63947c6b
        AppClassLoader 应用(系统)类加载器
        @63947c6b 对象的地址
         */
        System.out.println(classLoader.getParent());
        /*
        jdk.internal.loader.ClassLoaders$PlatformClassLoader@256216b3
        PlatformClassLoader 扩展类加载器(平台类加载器)
         */
        System.out.println(classLoader.getParent().getParent());
        /*
        Java的核心类库
        无法获取引导类加载器：虚拟机内置的类加载器，通常以null表示，从引导类路径加载。
        null
         */
        System.out.println(String.class.getClassLoader());
        /*
        null
         */

    }
    /*
    Properties: 用来读取配置文件
     */
    @Test
    public void test2() throws IOException {
        // 此时的文件默认在当前的module下
        // 读取配置文件的方式一：
        Properties pros = new Properties();
        FileInputStream fis = new FileInputStream("src/Reflection/jdbc.properties");
        pros.load(fis);

        // 读取配置文件的方式二：使用ClassLoader
        // 配置文件默认识别为：当前module的src下
//        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
//        InputStream is = classLoader.getResourceAsStream("src/Reflection/jdbc.properties");
//        pros.load(is);
        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        System.out.println(user + password); // ???123

    }
}
