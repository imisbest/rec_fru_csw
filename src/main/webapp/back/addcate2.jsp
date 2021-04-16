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

<form action="${path}/cate2/add" method="post">

    请选择所属的一级类别：<select name="cid">
    <c:forEach items="${cate1s}" var="p">
        <option value="${p.id}">${p.name}</option>
    </c:forEach>
</select>
    <input type="text" value="" name="name">
    <input type="submit" value="提交">
</form>

</body>
</html>
