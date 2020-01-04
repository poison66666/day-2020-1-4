import java.sql.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1.注册Driver
        Class.forName("com.mysql.jdbc.Driver");
        //2.通过DriverManager获取数据库连接
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/java_11?useSSL=false",
                "root",
                "yiqieanhao520"
        );
        //System.out.println(connection);
        Statement statement = connection.createStatement();
        statement.executeUpdate("INSERT INTO sunflower (sn,name) VALUES('10086','labixiaoxin')");
        statement.executeUpdate("INSERT INTO sunflower (sn,name) VALUES('10039','maidou')");
        statement.executeUpdate("INSERT INTO sunflower (sn,name) VALUES('10028','sumwukong')");

        //System.out.println(rows);
        /*Statement statement = connection.createStatement();
        int rows = statement.executeUpdate("create table sunflower (sn int primary key not null,name varchar(20) not null);");
        System.out.println(rows);*/
       /* Statement statement = connection.createStatement();
        int rows = statement.executeUpdate("INSERT INTO classes (name) VALUES('java11班')");
        System.out.println(rows);*/

       /* statement = connection.createStatement();
        rows = statement.executeUpdate("UPDATE classes SET name = 'C++11班' WHERE name = 'java11班'");
        statement.close();*/
       /* Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SHOW TABLES");
        while (resultSet.next()){
            //JDBC,列是从1开始的
            String tableName = resultSet.getString(1);
            System.out.println(tableName);
        }
        resultSet.close();
        //关闭statement
        statement.close();*/
        //最后关闭连接
        connection.close();
    }
}
