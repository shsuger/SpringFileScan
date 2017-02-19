<%--
  Created by IntelliJ IDEA.
  User: shsuger
  Date: 2017/2/18
  Time: 16:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>交易名查询输入</title>
</head>
<body>
<h1 align="center">交易名查询输入</h1>
<div>
    <form name="form1" method="post" action="searchtransName.do">
        <table align="center">
            <tr>
                <td>关键字:</td>
                <td><input type="text" name="keyWord" id="keyWord" size="100"></td>
            </tr>
            <tr>
                <td>目标根路径:</td>
                <td><input type="text" name="targetRootPath" id="targetRootPath" size="100"></td>
            </tr>
            <tr>
                <td>sop文件路径:</td>
                <td><input type="text" name="sopFilePath" id="sopFilePath" size="100"></td>
            </tr>
            <tr colspan="2">
                <td>
                    <input type="submit" value="查询" style="background-color:pink" size="30">
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
