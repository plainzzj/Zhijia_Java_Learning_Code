package Internet;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPTest3 {
    @Test
    public void client() throws IOException {
        // IP
        InetAddress inet = InetAddress.getByName("127.0.0.1");
        // 查看构造方法提示：ctrl+P
        // 1. 创建Socked的对象，指明服务器端的IP和端口号
        Socket socket = new Socket(inet, 9999);
        // 2. 获取一个输出流，用于输出数据
        OutputStream os = socket.getOutputStream();
        // 3. 获取一个输入流，用于读取要传送的文件
        FileInputStream fis = new FileInputStream(new File("src/Internet/zzj.JPG"));

        // 4. 使用输出流写出数据，使用输入流读取数据
        byte[] buffer = new byte[1024];
        int len;
        while((len = fis.read(buffer)) != -1){
            os.write(buffer, 0, len);
        }
        // 5. 关闭流
//        fis.close();
//        os.close();
//        socket.close();

        // 关闭数据的输出！
        socket.shutdownOutput();

        // 5. 接受来自服务器端的数据，并显示到控制台上
        InputStream is = socket.getInputStream();
        // 为了显示不出现乱码 -> ByteArrayOutputStrem
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer1 = new byte[20];
        int len1;
        /*
        java.lang.OutOfMemoryError: Required array length 2147483640 + 20 is too large
         */
        while ((len1 = buffer1.length) != -1){
            baos.write(buffer1, 0, len1);
        }
        System.out.println(baos.toString());
        baos.close();
        fis.close();
        os.close();
        socket.close();
    }

    // 服务端 -> 先启动
    @Test
    public void server() throws IOException {

        // 1. 创建服务器端的 ServerSocket，指明自己的端口号
        ServerSocket ss = new ServerSocket(9999);
        // 2. 调用accept()表示接受来自于客户的socket
        Socket socket = ss.accept();
        // 3. 获取输入流，用于输入数据
        InputStream is = socket.getInputStream();
        // 4. 获取输出流，用于存放输入数据
        FileOutputStream fos = new FileOutputStream("src/Internet/zzj2.JPG");

        // 5. 写入数据！
        byte[] buffer = new byte[20];
        int len;
        /*
        java.net.SocketException: Connection reset
         */
        while ((len = is.read(buffer)) != -1){
            fos.write(buffer, 0, len);
        }
        // 6. 关闭资源
//        fos.close();
//        is.close();
//        socket.close();
//        ss.close();
        // 6.服务器端给予客户端反馈
        OutputStream os = socket.getOutputStream();
        String name = new File("src/Internet/zzj2.JPG").getName();
        System.out.println(name);
        os.write(("你好，服务器端已收到").getBytes());


        os.close();
        fos.close();
        is.close();
        socket.close();
        ss.close();
    }
}
