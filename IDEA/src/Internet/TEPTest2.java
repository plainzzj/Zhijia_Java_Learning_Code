package Internet;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/*
客户端发送文件给服务端，服务端将文件保存在本地
 */
public class TEPTest2 {
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

        // 3. 使用输出流写出数据，使用输入流读取数据
        byte[] buffer = new byte[1024];
        int len;
        while((len = fis.read(buffer)) != -1){
            os.write(buffer, 0, len);
        }
        // 4. 关闭流
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
        FileOutputStream fos = new FileOutputStream("src/Internet/zzj1.JPG");


        byte[] buffer = new byte[20];
        int len;
        while ((len = is.read(buffer)) != -1){
            fos.write(buffer, 0, len);
        }
        // 5. 关闭资源
        fos.close();
        is.close();
        socket.close();
        ss.close();
    }
}
