package jdbc;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.sql.*;

public class jdbc_test {
    public static void main(String[] args) {
       SQLServerDataSource dt = new SQLServerDataSource();
       dt.setUser("sa");
       dt.setPassword("nobody");
       dt.setServerName("DESKTOP-G6228EN\\SQLEXPRESS");
       dt.setPortNumber(1444);
       dt.setDatabaseName("testdb");

       try {
           Connection cn = dt.getConnection();
           Statement state = cn.createStatement();

           String sql = "select * from student";
           //PreparedStatement preState = cn.prepareStatement(sql);
           ResultSet rs = state.executeQuery(sql);
           while (rs.next()){
               System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
           }
       }catch (SQLServerException throwables){
           System.out.println("fail");
       } catch (SQLException throwables) {
           throwables.printStackTrace();
       }


    }
}
