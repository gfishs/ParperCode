package Utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author kang
 * @create 2021-11-08-11:26
 */
public class ConnectionUtils {
    private static Connection connection = null;

    static {
        try {
            // 1 加载 jdbc 资源文件
            InputStream ins = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
            Properties prop = new Properties();
            prop.load(ins);
            // 2 获取 相应的属性
            String url = prop.getProperty("url");
            String username = prop.getProperty("username");
            String password = prop.getProperty("password");
            String driverClass = prop.getProperty("driverClass");
            // 3 创建连接 注册驱动。
            Class.forName(driverClass);
            // 4 获取连接
            connection = DriverManager.getConnection(url, username, password);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        return connection;
    }

    public static void close(){
        try {
            connection.close();
            System.out.println("连接关闭");
        } catch (SQLException e) {

        }
    }

    public static void main(String[] args) {
        System.out.println(ConnectionUtils.getConnection());
    }
}
