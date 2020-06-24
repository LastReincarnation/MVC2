<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/6/24
  Time: 18:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        input{
            width: 80%;
            text-align: left;
            margin-left: 30px;
        }
    </style>
</head>
<body>
    <form>
        <p>新闻ID</p><input type="text" name="id" value="${news.id}"><br>
        <p>新闻标题</p><input type="text" name="title" value="${news.title}"><br>
        <p>新闻内容</p><input type="text" name="content" value="${news.content}"><br>
        <p>作者</p><input type="text" name="author" value="${news.author}"><br>
        <p>时间</p><input type="text" name="time" value="${news.time}"><br>
    </form>
</body>
</html>
