package jdbc;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.sql.*;

public class resultSet_test {
    public static void main(String[] args) throws SQLException {
        SQLServerDataSource DT1= new SQLServerDataSource();
        DT1.setUser("sa");
        DT1.setPassword("nobody");
        DT1.setServerName("DESKTOP-G6228EN\\SQLEXPRESS");
        DT1.setPortNumber(1444);
        DT1.setDatabaseName("testdb");

        Connection cn = DT1.getConnection();

        Statement state = cn.createStatement();
        ResultSet rs = state.executeQuery("select * from student");
        while (rs.next()){
            System.out.println(rs.getInt("id")+" "+rs.getString("name")+" "+rs.getString("address"));

        }

    }
}
