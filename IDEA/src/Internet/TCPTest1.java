package Internet;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/*
实现TCP的网络编程
实例1：客户端发送信息给服务端，服务端将数据显示在控制台上
 */
public class TCPTest1 {
    // 客户端
    @Test
    public void client() throws IOException {
        // IP
        InetAddress inet = InetAddress.getByName("127.0.0.1");
        // 查看构造方法提示：ctrl+P
        // 1. 创建Socked的对象，指明服务器端的IP和端口号
        Socket socket = new Socket(inet, 8899);
        // 2. 获取一个输出流，用于输出数据
        OutputStream os = socket.getOutputStream();
        // 3. 使用输出流写出数据
        os.write("你好，我是客户端！".getBytes());
        // 4. 关闭流
        os.close();
        socket.close();

    }

    // 服务端 -> 先启动
    @Test
    public void server() throws IOException {

        // 1. 创建服务器端的 ServerSocket，指明自己的端口号
        ServerSocket ss = new ServerSocket(8899);
        // 2. 调用accept()表示接受来自于客户的socket
        Socket socket = ss.accept();
        // 3. 获取输入流，用于输入数据
        InputStream is = socket.getInputStream();

        /*
        不建议这样写：有中文，可能会有乱码
        byte[] buffer = new byte[20];
        int len;
        while ((len = is.read(buffer)) != -1){
            System.out.println(new String(buffer, 0, len));
        }
        */
        // 4. 读取输入流中的数据
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer = new byte[20];
        int len;
        while ((len = is.read(buffer)) != -1) {
            baos.write(buffer, 0, len);
        }

        System.out.println(baos.toString());
        System.out.println(socket.getInetAddress().getHostAddress());


        // 5. 关闭资源
        baos.close();
        is.close();
        socket.close();
        ss.close();
    }
    /*
    你好，我是客户端！
    127.0.0.1
     */
}
