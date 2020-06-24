import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //连接数据库
        response.setContentType("text/html; charset=utf-8");
        request.setCharacterEncoding("utf-8");
        PrintWriter writer = response.getWriter();
        String strName = request.getParameter("txtName");
        String strPwd = request.getParameter("txtPwd");

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        PreparedStatement pstmt;
        try {
            // 注册驱动程序
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1434;DatabaseName=NEWS_SYSTEM",
                   "test", "123456");
            System.out.println("加载成功");
            stmt = conn.createStatement();

            String sql = "SELECT * FROM USERS WHERE NAME=? and PWD=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,strName);
            pstmt.setString(2,strPwd);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                Cookie cooUser = new Cookie("username", strName);
                cooUser.setMaxAge(60*60*24*7);
                response.addCookie(cooUser);

                Cookie cooPwd = new Cookie("pwd", strPwd);
                cooPwd.setMaxAge(60*60*24*7);
                response.addCookie(cooPwd);

                HttpSession session = request.getSession(true);
                session.setAttribute("username",strName);

                String path = request.getContextPath();
                String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
                String page = basePath+"yingLiang/index.html";
                System.out.println(basePath);
                response.sendRedirect(page);

            }
            else {
                writer.println("用户名或密码出现错误");
                response.sendRedirect("login.html");
            }
            rs.close();
            stmt.close();
            conn.close();
            pstmt.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
