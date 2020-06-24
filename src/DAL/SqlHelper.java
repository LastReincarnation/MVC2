package DAL;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.sql.Connection;
import java.sql.DriverManager;
import  java.sql.ResultSet;
import  java.sql.Statement;

public class SqlHelper{
    static Connection conn = null;
    private static Connection getCoonection()
    {
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1434;DatabaseName=NEWS_SYSTEM",
                    "test", "123456");
            return conn;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("--------连接失败");
        }
        return null;
    }

    public  static  ResultSet executeQuery(String SQL)
    {
        try
        {
            Connection conn = getCoonection();
            System.out.println("---------连接成功");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            return rs;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("--------查询失败");
        }
        return null;
    }

    public static boolean executUpdate(String SQL)
    {
        try
        {
            Connection conn = getCoonection();
            System.out.println("----------连接成功");
            Statement stmt = conn.createStatement();
            int reslut = stmt.executeUpdate(SQL);
            if(reslut>0)
            {
                return true;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("--------更新失败");
        }
        return false;
    }
}