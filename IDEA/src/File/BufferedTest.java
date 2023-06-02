package File;

import org.junit.Test;

import java.io.*;

public class BufferedTest {
    /*
    缓冲流：提升流的读取、写入速度
    flush -> 刷新缓冲区
     */
    @Test
    public void BufferedStreamTest(){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            // 1. 文件
            File srcFile = new File("src/File/testvedio.avi");
            File destFile = new File("src/File/testvedioBuffered.avi");
            // 2. 流
            // 节点流
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);
            // 缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);
            // 3. 复制
            byte[] buffer = new byte[5];
            int len;
            while ((len = bis.read(buffer)) != -1){
                bos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                // 4. 资源关闭 -> 从外向内 -> b-f
                if(bos != null)
                bos.close();
                if(bis != null)
                bis.close();
                // 关闭外层流时，内层刘会自动关闭
//                fos.close();
//                fis.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public void copyFileWithBufferd(String s, String d){
        FileInputStream fis;
        FileOutputStream fos;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            // 1. 文件
            File srcFile = new File(s);
            File destFile = new File(d);
            // 2. 流
            // 节点流
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);
            // 缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);
            // 3. 复制
            byte[] buffer = new byte[5];
            int len;
            while ((len = bis.read(buffer)) != -1){
                bos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                // 4. 资源关闭 -> 从外向内 -> b-f
                if(bos != null)
                    bos.close();
                if(bis != null)
                    bis.close();
                // 关闭外层流时，内层刘会自动关闭
//                fos.close();
//                fis.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    @Test
    public void test(){
        long start = System.currentTimeMillis();
        copyFileWithBufferd("src/File/testvedio.avi","src/File/testvediocopy_Buffer.avi");
        long end = System.currentTimeMillis();
        System.out.println(end - start); // Vedio : 2325 -> 28
    }

    // BufferedReader BufferedWriter -> 文本文件
    @Test
    public void testBufferedReaderBufferedWriter(){
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            // 1. 创建文件和相应的流
            br = new BufferedReader(new FileReader(new File("src/File/hello.txt")));
            bw = new BufferedWriter(new FileWriter(new File("src/File/helloBuffered.txt")));
            // 2. 读写操作
            // 方式一：使用String
//            char[] buffer = new char[5];
//            int len;
//            while ((len = br.read(buffer)) != -1){
//                bw.write(buffer, 0, len);
    //            bw.flush();
            // 方式二：使用String
            /*
            11223345566778lulalulalulalulalulalulalulaI have a dreamYou need to have a dream中国人
            没有包含换行符
             */
            String data;
            while ((data = br.readLine()) != null){
                bw.write(data); // data中不包含换行符
                bw.newLine(); // 换行！
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                // 3. 关闭资源
                bw.close();
                br.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }





}
