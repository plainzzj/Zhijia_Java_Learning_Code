package Internet;

import org.junit.Test;

import java.io.IOException;
import java.net.*;

public class UDPTest {
    // 发送端
    @Test
    public void sender() throws IOException {
        /*
             Datagram: 数据报通过网络传输的数据的基本单元
                 包含一个报头（header）和数据本身
                 其中报头描述了数据的目的地以及和其它数据之间的关系。
             Socket: 套接字，对网络中不同主机上的应用进程之间进行双向通信的端点的抽象。
                 一个套接字就是网络上进程通信的一端，
                 提供了应用层进程利用网络协议交换数据的机制。
             Packet: 数据包
            */
        DatagramSocket socket = new DatagramSocket();
        String str = "我是UDP方式发送的导弹";
        byte[] data = str.getBytes();
        InetAddress inet = InetAddress.getLocalHost();
        // 封装数据包！
        DatagramPacket packet = new DatagramPacket(data, 0, data.length,inet, 9090);

        socket.send(packet);
        socket.close();
    }
    // 接收端
    @Test
    public void receiver() throws IOException {
        DatagramSocket socket = new DatagramSocket(9090);

        byte[] buffer = new byte[100];
        DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);

        socket.receive(packet);

        System.out.println(new String(packet.getData(), 0, packet.getLength()));

        socket.close();


    }
}
