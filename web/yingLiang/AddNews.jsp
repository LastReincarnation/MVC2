<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>AddNews</title>
</head>
<body>
<span class="cp_title">新闻管理</span>
<form action="SaveNewsServlet" method="post">
    新闻ID<input type="text" name="id" value="${news.id}">
    新闻标题<input type="text" name="title" value="${news.title}">
    新闻内容<input type="text" name="content" value="${news.content}">
    作者<input type="text" name="author" value="${news.author}">
    时间<input type="text" name="time" value="${news.time}">
    <input type="submit" value="保存">
</form>
</body>
</html>
