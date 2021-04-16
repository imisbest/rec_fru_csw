<%@ page pageEncoding="UTF-8" contentType="text/html; charset=utf-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    request.setAttribute("path", request.getContextPath());
%>
<!DOCTYPE HTML>
<html>


<head>
    <script type="text/javascript" src="${path}/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $('.move').mouseover(function () {
                $.get('${path}/list/addCount', 'find=' + $(this).prop('alt'));
            });
            $('.move2').mouseover(function () {
                $.get('${path}/list/addCount', 'find=' + $(this).prop('title'));
            });
            window.setInterval(function () {
                $.get('${path}/list/rec', function (data) {
                $('#tj').empty();
                    console.log(data);
                    for (var i = 0; i < data.length; i++) {
                        $('#tj')
                            .append($('<span><img src="${path}/upDown/'+data[i].path+'/'+data[i].nname+'" width="50px" height="50px"><br>'+data[i].name+''+data[i].price+'</span><br>'));
                    }
                }, 'json');
            }, 5000);

        });

    </script>
</head>

<body>

<form action="${path}/list/query" method="post">
    <input type="text" name="findall">
    <input type="submit" value="搜索">
</form>
<c:forEach items="${lis}" var="p">
    <div style="float: left">
        <img src="${path}/upDown/${p.path}/${p.nname}" width="50px" height="50px" class="move" alt="${p.name}"><br>
        <a href="#" class="move2" title="${p.name}">${p.name}&nbsp;&nbsp;${p.price}</a>
    </div>
</c:forEach>
<div style="clear: left"></div>
    <h1>推荐列表</h1>
    <div id="tj"></div>

<a href="${path}/front/login.jsp"><input type="button" value="去前台登陆"></a>
<a href="${path}/back/login.jsp"><input type="button" value="去后台登陆"></a>
</body>
</html>
