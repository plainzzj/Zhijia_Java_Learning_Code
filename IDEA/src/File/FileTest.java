package File;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class FileTest {
    // File类的实例的构建
    @Test
    public void test1() {
        /*
         File(String pathname, int prefixLength)
         File(String child, File parent)
         File(String pathname)
         File(String parent, String child)
         File(File parent, String child)
         File(URI uri)
         */
        // 构造器一： String
        // 此时仅仅是内存层面的对象，不需要实际存在这个文件！
        // 相对路径 -> 相对于module
        File file1 = new File("hello.txt");
        // \ 代表转义， \\ 代表 \
        File file2 = new File("D:\\桌面\\VSCODE\\Java\\IDEA\\src\\File\\hello.txt");
        System.out.println(file1); // hello.txt
        System.out.println(file2); // D:\桌面\VSCODE\Java\IDEA\src\File\hello.txt

        // 构造器二： 创建文件目录！ String + String
        File file3 = new File("D:\\桌面\\VSCODE\\Java", "IDEA\\src\\File");
        System.out.println(file3); // D:\桌面\VSCODE\Java\IDEA\src\File

        // 构造器三： File + String
        File file4 = new File(file3, "hi.txt");
        System.out.println(file4); // D:\桌面\VSCODE\Java\IDEA\src\File\hi.txt

    }

    @Test
    public void test2() {
        // 此时仅仅是内存层面的对象，不需要实际存在这个文件！
        File file1 = new File("hello.txt");
        System.out.println(file1.getAbsoluteFile()); // 获取绝对路径
        System.out.println(file1.getName()); // 获取名字
        System.out.println(file1.getPath()); // 获取路径
        System.out.println(file1.getParent()); // 父级地址
        System.out.println(file1.length()); // 长度
        System.out.println(file1.lastModified()); // 最近修改时间
        /*
        D:\桌面\VSCODE\Java\IDEA\hello.txt  -> 相对于当前module
        hello.txt
        hello.txt
        null
        0
        0
         */

        File file2 = new File("src/File/hello.txt");
        System.out.println(file2.getAbsoluteFile()); // 获取绝对路径
        System.out.println(file2.getName()); // 获取名字
        System.out.println(file2.getPath()); // 获取路径
        System.out.println(file2.getParent()); // 父级地址
        System.out.println(file2.length()); // 长度
        System.out.println(new Date(file2.lastModified())); // 最近修改时间
        /*
        hello.txt
        src\File\hello.txt
        src\File
        7
        1678887143012 -> Wed Mar 15 21:32:23 CST 2023
         */
    }

    // 文件必须存在
    @Test
    public void test3() {
        File file = new File("D:\\桌面\\VSCODE\\Java\\IDEA\\src");

        String[] list = file.list();
        for (String s : list) {
            System.out.println(s);
            /*
            Collection
            Compare
            Enum_Annotation
            File
            Generic
            IDEA01
            JavaClass
            Thread
            ThreadNew
             */
        }
        File[] files = file.listFiles();
        for (File file1 : files) {
            System.out.println(file1); // -> file的ToString方法
            /*
            D:\桌面\VSCODE\Java\IDEA\src\Collection
            D:\桌面\VSCODE\Java\IDEA\src\Compare
            D:\桌面\VSCODE\Java\IDEA\src\Enum_Annotation
            D:\桌面\VSCODE\Java\IDEA\src\File
            D:\桌面\VSCODE\Java\IDEA\src\Generic
            D:\桌面\VSCODE\Java\IDEA\src\IDEA01
            D:\桌面\VSCODE\Java\IDEA\src\JavaClass
            D:\桌面\VSCODE\Java\IDEA\src\Thread
            D:\桌面\VSCODE\Java\IDEA\src\ThreadNew
             */

        }
    }

    // 重命名
    @Test
    public void test4() {
        // file1 必须存在
        // file2 必须不存在
        File file1 = new File("src/File/hello.txt");
        File file2 = new File("src/File/hi.txt");
        // 返回一个Boolean型的变量！
        System.out.println(file1.renameTo(file2)); // true
        System.out.println(file2.renameTo(file1));
    }

    @Test
    public void test5() {
        File file1 = new File("src/File/hello.txt");
        // 文件目录？
        System.out.println(file1.isDirectory()); // false
        // 文件？
        System.out.println(file1.isFile()); // true
        // 存在？
        System.out.println(file1.exists()); // true
        // 可读？
        System.out.println(file1.canRead()); // true
        // 可写？
        System.out.println(file1.canWrite()); // true
        // 是否隐藏？
        System.out.println(file1.isHidden());// false
    }

    @Test
    public void test6() throws IOException {
        // 文件的创建/删除
        File file1 = new File("src/File/hello1.txt");
        if (!file1.exists()) {
            file1.createNewFile();
            System.out.println("Success!");
        } else { // 文件存在
            file1.delete();
            System.out.println("Delete!");
        }
    }
    @Test
    public void test7(){
        File file1 = new File("src/File0316/FileTest");
        boolean mkdir = file1.mkdir();
        System.out.println(mkdir); // false
        boolean mkdirs = file1.mkdirs();
        System.out.println(mkdirs); // true


    }
}