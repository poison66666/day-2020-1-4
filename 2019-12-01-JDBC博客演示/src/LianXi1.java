import java.sql.*;

public class LianXi1 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost/java_11?useSSL=false",
                "root",
                "yiqieanhao520"
        );

        //如果向日葵班已经有了，就不再插入
        try(Statement statement = connection.createStatement()){
            statement.executeUpdate(
                    "INSERT INTO classes (name) VALUES ('xiangrikui')"
            );
        }

        int classId;
        try(Statement statement = connection.createStatement()){
            try (ResultSet resultSet = statement.executeQuery(
                    "SELECT id FROM classes WHERE name = 'xiangrikui'"
            )){
                resultSet.next();
                classId = resultSet.getInt(1);
            }
        }

        try (Statement statement = connection.createStatement()){
            String sql = "INSERT INTO students (sn, class_id, name)"
                    + " VALUES ('10086', " + classId + ", 'labixiaoxin'),"
                    + " ('10087', " + classId + ", 'maidou'),"
                    + " ('10088', " + classId + ", 'sunwukong')";
            System.out.println(sql);
            statement.executeUpdate(sql);
        }
        connection.close();
    }
}
