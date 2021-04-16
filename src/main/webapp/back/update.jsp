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
            // 初始化省
            $.get('/cate2/findName', function (data) {
                console.log(data);
                for (var i = 0; i < data.length; i++) {
                    $('#province')
                        .append($('<option value="' + data[i].id + '">' + data[i].name + '</option>'));
                }
                // 手动触发change事件
                $('#province').change();
            }, 'json');

            // 初始化市
            $('#province').change(function () {
                // 清空历史记录
                $('#city').empty();
                $.get('/cate2/findCity', 'parentId=' + $(this).val(), function (data) {
                    for (var i = 0; i < data.length; i++) {
                        $('#city')
                            .append($('<option value="' + data[i].id + '">' + data[i].name + '</option>'));
                    }
                    // 手动触发city的change事件
                    $('#city').change();
                }, 'json');
            });
            /*
                        $('#city').change(function () {
                            // 清空历史记录
                            //$('#country').empty();
                            $.get('/studd/count', 'parentId=' + $(this).val(), function (data) {
                                console.log(data);
                                console.log(data.count);
                                $('#country').empty().val(data.count);
                            }, 'json');
                        });*/
        });
    </script>
</head>

<body>

<form action="${path}/list/update" method="post" enctype="multipart/form-data">
    <%--<td>${p.id}</td>--%>
        <input type="text" name="id" value="${lis.id}" hidden="hidden">
    请输入名称；
    <td><input type="text" name="name" value="${lis.name}"></td><br>
    请输入价格；
    <td><input type="text" name="price" value="${lis.price}"></td><br>
    <%--<td>${p.count}</td>--%>
    请选择封面；
    <td>
        <input type="file" name="bb" va>
    </td><br>
    请选择类别；<%--<td>${p.category}</td>--%>

    一级类别；<select id="province"></select>
    <%--到后台在根据id查询--%>
    二级类别；<select id="city" name="pid">
    <%--
&lt;%&ndash;已经学习<select id="country">次<br/>&ndash;%&gt;
已经学习<input type="text" id="country">次--%>
</select><br>
    <input type="submit" value="提交修改">
    <a href="${path}/list/queryAll"><input type="button" value="返回上一层"></a>
</form>

</body>
</html>
