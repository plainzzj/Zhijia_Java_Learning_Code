package File;

import java04.polymorphisn.Person;
import org.junit.Test;

import java.io.*;


/*
对象流
 */
public class ObjectInputOutputStream {
    /*
    序列化过程：Java对象 -> 传输出去
     */
    @Test
    public void testObjectOutputStream() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/File/hello.txt"));
        // 被写入 文件中，不会被内存回收！-> 持久化
        oos.writeObject(new String("我爱北京天安门"));
        // 自定义类的序列化！
        oos.writeObject(new Person("Tom",16,true,1001));

        oos.flush(); // 刷新操作
        oos.close();
        /*
        �� t 我爱北京天安门 -> 需要使用反序列化机制去读取
         */

    }

    @Test
    public void testObjectInputStream() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/File/hello.txt"));
        // 两个对象，一个字符串，一个Person类
        Object o = ois.readObject();
        Object s = ois.readObject();

        System.out.println(o);
        System.out.println("*********************");
        System.out.println(s);
        // 使用反序列化机制去读取 -> 内存中的Java对象

        /*
        我爱北京天安门
        *********************
        name:  Tom  age:    16
         */

        ois.close();

    }

}
