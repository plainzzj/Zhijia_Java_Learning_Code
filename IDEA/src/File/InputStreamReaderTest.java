package File;

import org.junit.Test;

import java.io.*;

/*
使用转换流！
指明了存储的字符集编码
txt(字符) -> 使用字节流读取 -> 通过转换流更改为字符流
字节 -> 字符：解码操作
 */
public class InputStreamReaderTest {
    @Test
    public void test1() throws IOException {
        FileInputStream fis = new FileInputStream("src/File/hello.txt");
        // 参数2 指明了字符集：字符集取决于txt保存时使用的字符集
        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
        char[] cbuf = new char[5];
        int len;
        while((len = isr.read(cbuf)) != -1){
            String str = new String(cbuf, 0, len);
            System.out.print(str);
        }
        /*
        1122334
        5566778
        lulalulalulalu
        lalulalulalula
        I have a dream
        You need to have a dream
        中国人
         */
        isr.close();
    }

    @Test
    public void test2() throws IOException {
        File file1 = new File("src/File/hello.txt");
        File file2 = new File("src/File/hello_gbk.txt");
        FileInputStream fis = new FileInputStream(file1);
        FileOutputStream fos = new FileOutputStream(file2);

        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
        OutputStreamWriter osw = new OutputStreamWriter(fos,"gbk");

        char[] cbuf = new char[5];
        int len;
        while((len = isr.read(cbuf)) != -1){
            osw.write(cbuf, 0, len);
        }
        isr.close();
        osw.close();

        /* -> 以gbk加载！
        1122334
        5566778
        lulalulalulalu
        lalulalulalula
        I have a dream
        You need to have a dream
        中国人
         */

    }
}
