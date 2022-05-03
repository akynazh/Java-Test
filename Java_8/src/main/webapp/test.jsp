<%@ page import="com.example.Java_8.Person" %>
<%@ page import="java.util.*" %><%--
  Created by IntelliJ IDEA.
  User: akyna
  Date: 2021/8/6
  Time: 16:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Test</title>
</head>
<style type="text/css">
    table {
        border: bisque solid 2px;
    }
    tr {
        border: black solid 2px;
    }
    td {
        border: black solid 1px;
    }
</style>
<body>
    EL的基本使用：<br/>
    <br/>
    四个域对象：<br/>
    <%
        pageContext.setAttribute("key", "99");
        request.setAttribute("key", "100");
        session.setAttribute("key", "101");
        application.setAttribute("key", "102");
    %>
    <br/>
    四个域对象作用范围：<br/>
    ${key}<br/>
    ${pageScope.key}<br/>
    ${requestScope.key}<br/>
    ${sessionScope.key}<br/>
    ${applicationScope.key}<br/>
    <br/>
    通过pageContext获取页面信息：<br/>
    ${pageContext.request.serverName}<br/>
    ${pageContext.request.serverPort}<br/>
    ${pageContext.request.contextPath}<br/>
    ${pageContext.request.method}<br/>
    ${pageContext.request.remoteHost}<br/>
    ${pageContext.session.id}<br/>
    <br/>
    获取参数：
    ${param.username}<br/>
    ${paramValues.hobby[0]}<br/>
    ${header['User-Agent']}<br>
    ${header.Connection}<br>
    ${cookie.JSESSIONID.name}<br/>
    ${cookie.JSESSIONID.value}<br/>
    ${initParam.username}<br/>
    <br/>
    JSTL core的基本使用:<br/>
    <c:set scope="session" var="name" value="jzh" />
    ${sessionScope.name}
    <%
        request.setAttribute("height", 195);
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            persons.add(new Person(i + 10, "person" + i));
        }
        pageContext.setAttribute("persons", persons);
    %>
    <table>
        <tr>
            <th>编号</th>
            <th>姓名</th>
            <th>年龄</th>
        </tr>
        <c:forEach varStatus="status" items="${persons}" var="p">
            <tr>
                <td>${status.index}</td>
                <td>${p.name}</td>
                <td>${p.age}</td>
            </tr>
        </c:forEach>
    </table>
    <c:choose>
        <c:when test="${requestScope.height > 190}">
            <h2>大于190</h2>
        </c:when>
        <c:when test="${requestScope.height > 180}">
            <h2>大于180</h2>
        </c:when>
        <c:when test="${requestScope.height > 170}">
            <h2>大于170</h2>
        </c:when>
        <c:otherwise>
            <h2>其他</h2>
        </c:otherwise>
    </c:choose>

</body>
</html>
