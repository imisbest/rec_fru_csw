<%@ page pageEncoding="UTF-8" contentType="text/html; charset=utf-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    request.setAttribute("path", request.getContextPath());
%>
<!DOCTYPE HTML>
<html>
<h1>类别管理</h1>
<ul>
    <c:forEach items="${cate2s}" var="p" varStatus="s">


            <c:if test="${s.count%2==1}">
                <li>${p.cate1.name}: </li>
            </c:if>


            <li>${p.name}</li>


    </c:forEach>
</ul>
<a href="${path}/back/addcate1.jsp"><input type="button" value="添加一级类别"></a>
<a href="${path}/cate2/addcate2first"><input type="button" value="添加二级类别"></a>

<hr>
<table border="1px" cellspacing="0px" cellpadding="5px">
    <tr>
        <td>id</td>
        <td>name</td>
        <td>price</td>
        <td>count</td>
        <td>pic</td>
        <td>category</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${listLis}" var="p">
        <tr>
            <td>${p.id}</td>
            <td>${p.name}</td>
            <td>${p.price}</td>
            <td>${p.count}</td>
            <td> <img src="${path}/upDown/${p.path}/${p.nname}" width="20px" height="20px">
                   </td>
            <td>${p.category}</td>
            <td>
<%--
                <a href="${path}/list/delete?id=${p.id}"><input type="button" value="删除"></a>
--%>
                <a href="${path}/list/updatefirst?id=${p.id}"><input type="button" value="修改"></a>
            </td>
        </tr>
    </c:forEach>
</table>
<a href="${path}/back/add.jsp"><input type="button" value="添加"> </a>
<a href="${path}/front/login.jsp"><input type="button" value="去前台登陆"></a>
<a href="${path}/back/login.jsp"><input type="button" value="去后台登陆"></a>
<head>
</head>

<body>


</body>
</html>
