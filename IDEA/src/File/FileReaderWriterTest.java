package File;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderWriterTest {
    public static void main(String[] args) {
        File file = new File("src/File/hello.txt");// 相较于当前工程下
        System.out.println(file.getAbsoluteFile());
        // D:\桌面\VSCODE\Java[默认从Java(工程)下开始找]\src\File\hello.txt

    }
    // 读-入-文-件
    @Test
    /*
    抛出文件未找到错误 FileNotFoundException
    IO错误 IOException
     */
    public void testFileReader(){
        // 1. 实例化File类的对象
        File file = new File("src/File/hello.txt");// 相较于当前module下
        System.out.println(file.getAbsoluteFile());
        // D:\桌面\VSCODE\Java\IDEA[默认从IDEA(模块)下开始找]\src\File\hello.txt

        // 2. 实例化流的对象
        FileReader fr = null;
        try {
            fr = new FileReader(file);
        // 3. 数据的读入 （Ctrl + alt + space -> 查看方法的重载）
        /*
        read():返回值, 读入的字符或-1
        The character read,
        or -1 if the end of the stream has been reached
         */
            int data = fr.read();
            while (data != -1){
                System.out.print((char)data); // int -> char , 97 -> 'a'
                data = fr.read(); // 继续读下一个
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(fr != null)
                fr.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        // 4. 流的关闭操作 -> 必须手动关闭！
        // 当在创建FileReader对象和使用read方法时，可能抛出异常
        //  -> 此时fr.close()没有关闭，导致内存泄漏！
        //  ->  try-catch-finally (ctrl + alt + T)
        /*
        1122334
        5566778
        lulalulalulalu
        lalulalulalula
         */
    }
    /*
    对read()操作升级： read的重载
     */
    @Test
    public void testFileReader1(){
        FileReader fr = null;
        try {
            // 1. File类的实例化
            File file = new File("src/File/hello.txt");
            // 2. FileReader流的实例化
            fr = new FileReader(file);
            // 3. 读入的操作
            char[] cbuf = new char[7]; // char buffer
            int len;
            while ((len = fr.read(cbuf)) != -1){ // 返回值是每次读入的字符的数量，达到文件末尾，返回-1
//                错误的写法：
//                for (int i = 0; i < cbuf.length; i++) {
                // 正确的写法：读进去几个，遍历几个
                for (int i = 0; i < len; i++) {
                    System.out.print(cbuf[i]);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if(fr != null){
                // 4. 资源的关闭
                try {
                    fr.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        /*
        错误的写法：
        1122334
        5566778
        lulalulalulalu
        lalulalulalulau -> 出现问题，多了一个u

        正确的写法：
        1122334
        5566778
        lulalulalulalu
        lalulalulalula
         */
    }
    // 写-出-文-件
    /*
    如不存在，会自动创建文件
    如存在，是对原有文件的覆盖（需要指定参数append = true则是追加）
     */
    @Test
    public void testFileWriter(){
        // 1. 提供File类的对象，指明写出到的文件
        FileWriter fw = null;
        try {
            File file = new File("src/File/hello.txt");
            // 2. 提供FileWriter的对象，用于数据的写出
            fw = new FileWriter(file, true);
            // 3. 写出的操作
            fw.write("\nI have a dream\n");
            fw.write("You need to have a dream");

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            // 4. 资源流的操作
            try {
                fw.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
            /*
            1122334
            5566778
            lulalulalulalu
            lalulalulalula
            I have a dream
            You need to have a dream
             */
    }
    @Test
    public void testFileReaderFileWriter(){
        // 1. File 类的独享 -> 读、写
        FileReader fr = null;
        FileWriter fw = null;
        try {
            File srcfile = new File("src/File/hello.txt");
            File destfile = new File("src/File/hellocopy.txt");
            // 2. 输入流/输出流的对象
            fr = new FileReader(srcfile);
            fw = new FileWriter(destfile);
            // 3. 数据的读入和写出操作
            char[] cbuf = new char[5];
            int len; // 记录每次读入到cbuf数组中的字符的个数
            while ((len = fr.read(cbuf)) != -1){
                // 每次写出len个字符
               fw.write(cbuf, 0, len);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try { // try-catch中，即使fr抛出异常，fw也依然会执行
                fr.close();
                fw.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        // 4. 关闭资源流

    }
}
