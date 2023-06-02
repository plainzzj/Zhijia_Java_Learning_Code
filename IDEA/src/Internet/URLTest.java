package Internet;

import java.net.MalformedURLException;
import java.net.URL;

public class URLTest {
    public static void main(String[] args) throws MalformedURLException {
        /*
        https://www.bilibili.com/video/BV1Kb411W75N/?p=629
         */
        URL url = new URL("https://www.bilibili.com/video/BV1Kb411W75N/?p=629&vd_source=d4293f71c9edeea66ab0ba50f2e38db9");
        // 协议名 -> https
        System.out.println(url.getProtocol());
        // 主机名 -> www.bilibili.com
        System.out.println(url.getHost());
        // 端口号 -> -1
        System.out.println(url.getPort());
        // 文件路径 -> /video/BV1Kb411W75N/
        System.out.println(url.getPath());
        // 文件名 -> /video/BV1Kb411W75N/?p=629
        System.out.println(url.getFile());
        // 查询名 -> p=629
        System.out.println(url.getQuery());
        /*
        https
        www.bilibili.com
        -1
        /video/BV1Kb411W75N/
        /video/BV1Kb411W75N/?p=629&vd_source=d4293f71c9edeea66ab0ba50f2e38db9
        p=629&vd_source=d4293f71c9edeea66ab0ba50f2e38db9
         */

    }
}
