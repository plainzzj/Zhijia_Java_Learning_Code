package File;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileTest {
    @Test
    public void test1() throws IOException {
        // mode : 访问模式 r/rw/rwd/rws
        // 直接作用于文件，既可以输入，也可以输出
        RandomAccessFile raf1= new RandomAccessFile(new File("src/File/img.png"), "r");
        RandomAccessFile raf2= new RandomAccessFile(new File("src/File/img_raf.png"), "rw");

        byte[] buffer = new byte[1024];
        int len;
        while((len = raf1.read(buffer)) != -1){
            raf2.write(buffer, 0, len);
        }

        raf1.close();
        raf2.close();
    }

    @Test
    public void test2() throws IOException {
        RandomAccessFile raf1 = new RandomAccessFile("src/File/hello_gbk.txt", "rw");
        raf1.seek(3); // 将指针调到角标为3（第四个字符）的位置
        raf1.write("xyz".getBytes());

        raf1.close();
    }
    /*
    112xyz4
    5566778
    ...
     */

    @Test
    public void test3() throws IOException {
        RandomAccessFile raf1 = new RandomAccessFile("src/File/hello_gbk.txt", "rw");
        raf1.seek(3); // 将指针调整到角标3的位置
        // 保存指针3后面的所有数据到StringBuilder中
        StringBuilder builder = new StringBuilder((int) new File("src/File/hello_gbk.txt").length());
        byte[] buffer = new byte[20];
        int len;
        while ((len = raf1.read(buffer)) != -1){
            builder.append(new String(buffer, 0, len));
        }
        // 调回指针，写入xyz
        raf1.seek(3);
        raf1.write("xyz".getBytes());

        // 将StringBuilder中的数组写入到文件中
        raf1.write(builder.toString().getBytes());

        raf1.close();
    }
    /*
    112xyzxyz4
    5566778
    ...
     */
}

