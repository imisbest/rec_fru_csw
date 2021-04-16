<%@ page pageEncoding="UTF-8" contentType="text/html; charset=utf-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    request.setAttribute("path", request.getContextPath());
%>
<!DOCTYPE HTML>
<html>


<head>

</head>

<body>

<form action="${path}/cate1/add" method="post">
    请输入一级类别：<input type="text" value="" name="name">
    <input type="submit" value="提交">
</form>

</body>
</html>
