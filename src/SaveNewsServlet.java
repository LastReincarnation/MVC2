import Entity.News;
import service.NewsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "SaveNewsServlet")
public class SaveNewsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        News news = new News();
        news.setId(Integer.valueOf(request.getParameter("id")));
        news.setAuthor(request.getParameter("author"));
        news.setTitle(request.getParameter("title"));
        news.setContent(request.getParameter("content"));
        String time = request.getParameter("time");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try{
            date = simpleDateFormat.parse(time);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }

        news.setTime(date);
        NewsService service = new NewsService();
        service.UpdateNews(news);
        request.getRequestDispatcher("ShowNewsList").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
