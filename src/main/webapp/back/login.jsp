<%@ page pageEncoding="UTF-8" contentType="text/html; charset=utf-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    request.setAttribute("path", request.getContextPath());
%>
<!DOCTYPE HTML>
<html>
<title>后台登陆界面</title>
<head>
</head>

<body>
<h1>后台登陆界面</h1>
<form action="${path}/admin/login" method="post">
    name:
    <input type="text" value="" name="name">
    password;
    <input type="text" value="" name="password">
    <input type="submit" value="提交">
</form>
</body>
</html>
