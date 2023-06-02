import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

/*
 使用PreparedStatement来替换Statement，实现对数据的增删改查操作
 增删改：不需要返回 void
 查：需要返回
 */
public class PreparedStatementUpdateTest {
    // 添加一条数据：
    @Test
    public void testInsert(){
        Connection conn = null;
        PreparedStatement ps = null;
        try {
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
            conn = DriverManager.getConnection(url, user, password);
//        System.out.println(conn);
        /*
        com.mysql.cj.jdbc.ConnectionImpl@7ea9e1e2
         */
            // 4. 预编译SQL语句，返回PreparedStatement实例
            // ? -> 占位符
            String sql = "insert into employees(id,name)values(?,?)";
            ps = conn.prepareStatement(sql);
            // 5. 填充占位符
            ps.setInt(1, 1004); // int parameterIndex, int x
            ps.setString(2, "March 7th");

            // 6. 执行操作
            ps.execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            // 7. 资源的关闭
            try {
                if(ps != null)
                    ps.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                if(conn != null)
                    conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        /*
        java.lang.RuntimeException: java.sql.SQLSyntaxErrorException: Table 'dbtest1.dbtest1' doesn't exist
        这是一个运行时异常，指示表名为'dbtest1.dbtest1'的表不存在。
        您的代码尝试执行SQL语句，但目标表在数据库中不存在。
        请确保在运行代码之前，已在数据库中创建了名为'dbtest1.dbtest1'的表。

        数据库名为 dbtest1
        表名为： employees
         */

    }
}
