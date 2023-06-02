package File;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputOutputStreamTest {
    @Test
    public void testFileInputStream(){
        FileInputStream fis = null;
        try {
            // 1. 文件
            File file = new File("src/File/hello.txt");
            // 2. 流
            fis = new FileInputStream(file);
            // 3. 数据 -> 字节流 -> 字节的数组
            byte[] buffer = new byte[5];
            int len; // 每次读取数据字节的个数
            while ((len = fis.read(buffer)) != -1) {
                String str = new String(buffer, 0, len);
                System.out.print(str);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(fis != null)
                // 4. 关
                fis.close();
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
        中国��
        -> 对于英文和数字来说，用字节来存储已经就够用了
        -> 中文用一个字节不是很够（一个汉字三个字符）
            中国可以正常读出，但是人被分到了不同的流中
         */
    }
    // 实现对图片的复制
    @Test
    public void testFileInputOutputStream(){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File srcFile = new File("src/File/img.png");
            File destFile = new File("src/File/imgcopy.png"); // dest: 操作

            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);
            // 复制
            byte[] buffer = new byte[5];
            int len;
            while ((len = fis.read(buffer)) != -1){
                fos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fis.close();
                fos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    // 指定路径下文件的复制：
    public void copyFile(String srcPath, String destPath){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File srcFile = new File(srcPath);
            File destFile = new File(destPath); // dest: 操作

            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);
            // 复制
            byte[] buffer = new byte[5];
            int len;
            while ((len = fis.read(buffer)) != -1){
                fos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fis.close();
                fos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Test
    public void testCopy(){
        long start = System.currentTimeMillis();
        copyFile("src/File/testvedio.avi","src/File/testvediocopy.avi");
        long end = System.currentTimeMillis();
        System.out.println(end - start); // JK 1236 Vedio : 2325
    }
}
