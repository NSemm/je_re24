<%@ page import="com.k7.dto.Note" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: nick
  Date: 20.03.2021
  Time: 7:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<% List<Note> notes = (List<Note>) request.getAttribute("notes");
%>
%>
<body>
<ul>
    <c:forEach var="note" items="${notes}">
        <li>
            <a href="<c:url value="/notes/${note.id}" />">
                <b>${note.name}</b>${note.description}
            </a>
        </li>
    </c:forEach>
</ul>
</body>
</html>
