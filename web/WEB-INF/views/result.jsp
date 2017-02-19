<%--
  Created by IntelliJ IDEA.
  User: shsuger
  Date: 2017/2/18
  Time: 23:49
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>result</title>
</head>
<body>
    <h1 style="font-family:verdana">result</h1>
    <form name="form1">
        <table>

            <tr>
                <td>transName</td>
                <td>transCode</td>
            </tr>
            <c:forEach items="${result}" var="row" varStatus="status">
                <tr>
                    <td><c:out value='${row}'/></td>
                    <td><c:out value='${row}'/></td>
                </tr>
            </c:forEach>
</table>
    </form>


</body>
</html>
