package Internet;

import java.net.InetAddress;
import java.net.UnknownHostException;

// 本地回路地址：127.0.0.1 -> localhost
public class InetAddressTest {
    public static void main(String[] args) {
        try {
            InetAddress inet1 = InetAddress.getByName("36.152.44.95");
            System.out.println(inet1); // /36.152.44.95

            InetAddress inet2 = InetAddress.getByName("www.baidu.com");
            System.out.println(inet2); // www.baidu.com/36.152.44.95
            // 获取本机ip
            System.out.println(InetAddress.getLocalHost()); // DESKTOP-KONS3AB/192.168.0.18 其实还是我自己，局域网地址

            // 获取域名和地址
            System.out.println(inet2.getHostName()); // www.baidu.com
            System.out.println(inet2.getHostAddress()); // 36.152.44.96

            InetAddress inet3 = InetAddress.getByName("8.8.8.8");
            System.out.println(inet3.getHostName()); // dns.google

            // www.baidu.com
            // -> 不知道这样的主机。java.net.UnknownHostException (57.162.404.95)


        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }

    }
}
