package service;

import DAL.SqlHelper;
import Entity.News;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NewsService {
        public boolean AddNews(News news){
            String sql="INSERT INTO NEWS ( ID,Title,Content,Author,Time)" +
                    " VALUES('"+news.getId()+"','"+news.getTitle()+"','"+news.getContent()+"', " +
                    "'"+news.getAuthor()+"','"+news.getTime()+"');";
            return SqlHelper.executUpdate(sql);
        }

        public boolean DeleteNews(int ID){
            String sql = "delete from News where ID="+ID;
            boolean result = SqlHelper.executUpdate(sql);
            return result;
        }

        public boolean UpdateNews(News news){
            String sql = "update News set Content='"+news.getContent()+"' where ID="+news.getId();
            boolean result = SqlHelper.executUpdate(sql);
            return result;
        }

        public List<News> QueryNews() throws SQLException, SQLException {
            String sql = "SELECT * FROM NEWS";
            ResultSet rs;
            rs = SqlHelper.executeQuery(sql);
            List<News> lstNews = new ArrayList<News>();
            while (rs.next())
            {
                News news = new News();
                news.setId(rs.getInt("ID"));
                news.setTitle(rs.getString("Title"));
                news.setContent(rs.getString("Content"));
                news.setAuthor(rs.getString("Author"));
                news.setTime(rs.getDate("Time"));
                lstNews.add(news);
            }
            return lstNews;
        }

        public News GetNews(int ID) throws SQLException {
            String sql = "select * from News where ID="+ID;
            ResultSet rs;
            rs = SqlHelper.executeQuery(sql);
            News news = new News();;
            if (rs.next())
            {
                news.setId(rs.getInt("ID"));
                news.setTitle(rs.getString("Title"));
                news.setContent(rs.getString("Content"));
                news.setAuthor(rs.getString("Author"));
                news.setTime(rs.getDate("Time"));
            }
            return news;
        }

}
