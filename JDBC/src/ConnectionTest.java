import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionTest {

    // 方式一：
    @Test
    public void testConnetion1() throws SQLException {

        // Driver： 接口 -> MySQL具体的实现类
        // 获取Driver的实现类对象
        /*
        `com.mysql.jdbc.Driver`是第三方的API。
        这是MySQL提供的JDBC驱动程序，用于与MySQL数据库建立连接和执行数据库操作。
        在这段代码中，`com.mysql.jdbc.Driver`是MySQL JDBC驱动程序的具体实现类，
        用于提供与MySQL数据库的通信功能。
        它实现了JDBC API中的`java.sql.Driver`接口，通过连接字符串、用户名和密码等信息建立数据库连接。

        需要注意的是，在警告信息中提到，`com.mysql.jdbc.Driver`已经过时，
        新的驱动程序类是`com.mysql.cj.jdbc.Driver`。
        因此，建议使用新的驱动程序类来避免过时警告并保持与最新的MySQL驱动程序的兼容性。
         */
        Driver driver = new com.mysql.jdbc.Driver();
        /*
        jdbc: 主协议
        mysql: 子协议
        localhost: ip地址
        3306: 端口号
        test: 数据库
         */
        String url = "jdbc:mysql://localhost:3306/atguigudb";

        // 封装用户名和密码
        Properties info = new Properties();
        info.setProperty("user", "root");
        info.setProperty("password", "zhuzhijiaZZJ1994");

        Connection conn = driver.connect(url, info);

        System.out.println(conn);
        /*
        Loading class `com.mysql.jdbc.Driver'.
        This is deprecated. The new driver class is `com.mysql.cj.jdbc.Driver'.
        The driver is automatically registered via the SPI and manual loading of the driver class is generally unnecessary.

        com.mysql.cj.jdbc.ConnectionImpl@193f604a
         */
    }

    // 方式二：
    @Test
    public void testConnetion2() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        // 获取Driver的实现类对象 -> 使用反射 -> 没有出现任何第三方的API！
        Class clazz = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) clazz.newInstance();

        // 数据库地址
        String url = "jdbc:mysql://localhost:3306/atguigudb";

        // 封装用户名和密码
        Properties info = new Properties();
        info.setProperty("user", "root");
        info.setProperty("password", "zhuzhijiaZZJ1994");

        // 获取连接
        Connection conn = driver.connect(url, info);

        System.out.println(conn);
        /*
        Loading class `com.mysql.jdbc.Driver'.
        This is deprecated.
        The new driver class is `com.mysql.cj.jdbc.Driver'.
        The driver is automatically registered via the SPI and manual loading of the driver class is generally unnecessary.
        com.mysql.cj.jdbc.ConnectionImpl@193f604a
         */
    }

    // 方式三：DriverManager 替换 Driver
    @Test
    public void testConnetion3() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        // 获取Driver的实现类对象
        // 获取Driver的实现类对象 -> 使用反射 -> 没有出现任何第三方的API！
        Class clazz = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) clazz.newInstance();
        // 1. 注册Driver(驱动)
        DriverManager.registerDriver(driver);

        // 数据库地址 用户名 密码
        String url = "jdbc:mysql://localhost:3306/atguigudb";
        String name = "root";
        String password = "zhuzhijiaZZJ1994";
        // 2. 获取连接
        Connection conn = DriverManager.getConnection(url, name, password);
        System.out.println(conn);

        /*
        Loading class `com.mysql.jdbc.Driver'.
        This is deprecated.
        The new driver class is `com.mysql.cj.jdbc.Driver'.
        The driver is automatically registered via the SPI and manual loading of the driver class is generally unnecessary.
        com.mysql.cj.jdbc.ConnectionImpl@6babf3bf
         */

    }

    // 方式四：DriverManager 替换 Driver + 加载驱动，不需要注册驱动！
    @Test
    public void testConnetion4() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        // 获取Driver的实现类对象
        // 获取Driver的实现类对象 -> 使用反射 -> 没有出现任何第三方的API！
        // com.mysql.jdbc.Driver类的加载也可以省略！(仅在mysql中可以省略)
        // META-INF/services/java.sql.Driver -> com.mysql.cj.jdbc.Driver
        Class.forName("com.mysql.jdbc.Driver");
//        Driver driver = (Driver) clazz.newInstance();
        // 1. 注册Driver(驱动) -> 省略！ 在mysql的Driver实现类中实现了注册驱动
//        DriverManager.registerDriver(driver);

        // 数据库地址 用户名 密码
        String url = "jdbc:mysql://localhost:3306/atguigudb";
        String name = "root";
        String password = "zhuzhijiaZZJ1994";
        // 2. 获取连接
        Connection conn = DriverManager.getConnection(url, name, password);
        System.out.println(conn);

        /*
        com.mysql.cj.jdbc.ConnectionImpl@33990a0c
         */

    }

    // 方式五：配置信息最好不要以硬编码的方式写入！
    // 将数据库连接需要信息写入配置文件中 -> 解耦，数据与代码的分离
    // 如果需要修改配置文件信息，可以避免程序重新打包
    @Test
    public void testConnetion5() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {
        //1. 读取配置文件中的4个基本信息
        // 类的加载器！
        InputStream is = ConnectionTest.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties pro = new Properties();
        pro.load(is);

        String user = pro.getProperty("user");
        String password = pro.getProperty("password");
        String url = pro.getProperty("url");
        String driverClass = pro.getProperty("driverClass");
        // 2. 加载驱动
        Class.forName(driverClass);
        // 3. 获取连接
        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println(conn);
        /*
        com.mysql.cj.jdbc.ConnectionImpl@7ea9e1e2
         */
    }


}
