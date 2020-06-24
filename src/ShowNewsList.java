import Entity.News;
import service.NewsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ShowNewsList",urlPatterns = "/ShowNewsList")
public class ShowNewsList extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        NewsService newsService = new NewsService();
        try
        {
            List<News> lstNews = newsService.QueryNews();
            request.setAttribute("lstNews",lstNews);
            request.getRequestDispatcher("yingLiang/ShowNewsList.jsp").forward(request, response);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
