package Collection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

// 配置文件：工程下的 jdbc.properties
// TODO -> 20230602 將工程下的jdbc.properties文件移動，优化代码结构！
public class PropertiesTest {
    public static void main(String[] args) {
        Properties pro = new Properties();
        // 流
        try {
            FileInputStream fis = new FileInputStream("Z:\\VSCODE\\Java\\JDBC\\src\\jdbctest.properties");
            pro.load(fis); // 加载流对应的文件

            String name = pro.getProperty("name");
            String password = pro.getProperty("password");
            System.out.println(name + password); // Tomabc123

            // 关闭流
            fis.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
