//import java.sql.Connection;
import java.sql.*;

public class DatabaseConnection {
    public static Connection getConnection() throws SQLException {

        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/employee_db",
                "root",
                "java@123"


        );

        return con;

    }
}