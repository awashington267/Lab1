<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Characters</title>
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2>Character List</h2>
    </div>
</div>

<div id="container">

    <div id="content">
        <table>
            <c:forEach var="tempCharacters" items="${characters}">
                <tr>
                    <td>
                        <img src="${pageContext.request.contextPath}/resources/img/${tempCharacters.picture}"
                             alt="${tempCharacters.name}">
                    </td>
                    <td>${tempCharacters.characterID}</td>
                    <td>${tempCharacters.name}</td>
                </tr>
            </c:forEach>
            <c:forEach var="tempRoles" items="${roles}">
                <tr>
                    <td>${tempRoles.classID}</td>
                    <td>${tempRoles.role}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
