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
    // localhost:3306/dbtest1表中 添加一条数据：
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
        }
            // 7. 资源的关闭


        /*
        java.lang.RuntimeException: java.sql.SQLSyntaxErrorException: Table 'dbtest1.dbtest1' doesn't exist
        这是一个运行时异常，指示表名为'dbtest1.dbtest1'的表不存在。
        您的代码尝试执行SQL语句，但目标表在数据库中不存在。
        请确保在运行代码之前，已在数据库中创建了名为'dbtest1.dbtest1'的表。

        数据库名为 dbtest1
        表名为： employees
         */

    }

    // 修改localhost:3306/dbtest1表中的有关记录
    @Test
    public void testUpdate(){
        // 1. 获取数据库的连接 -> JDBCUtils
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtils.getConnection();
            // 2. 预编译SQL语句，返回preparedstatement语句
            String sql = "update employees set name = ? where id = ?";
            ps = conn.prepareStatement(sql);

            // 3. 填充占位符
            ps.setString(1, "Clara");
            ps.setObject(2, 1001);

            // 4. 执行
            ps.execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }finally {
            // 5. 资源的关闭
            JDBCUtils.closeResource(conn, ps);
        }

    }

    @Test
    public void testCommonUpdate(){
        String sql = "delete from employees where id = ?";
        update(sql, 1004);

    }
    // 通用的增删改操作
    // sql中占位符的个数与我们的可变形参长度一致
    public void update(String sql, Object ...args){
        // 1. 获取数据库的连接 -> JDBCUtils
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtils.getConnection();
            // 2. 预编译SQL语句，返回preparedstatement语句
            ps = conn.prepareStatement(sql);

            // 3. 填充占位符
            for (int i = 0; i < args.length; i++) {
                // 占位符从1开始，args数组的索引是0开始
                ps.setObject(i + 1, args[i]);
            }
            // 4. 执行
            ps.execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }finally {
            // 5. 资源的关闭
            JDBCUtils.closeResource(conn, ps);
        }

    }
}
