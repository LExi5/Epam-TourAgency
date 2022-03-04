<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"
         language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="resources"/>
<html>
<head>
    <title>Users</title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
<body>
<jsp:include page="menu.jsp"></jsp:include>
<div class="navbar navbar-expand-lg navbar-light bg-light">
    <form class="d-flex" action="logout" method="get" style="margin-left: 15px">
        <lable><fmt:message key="users.page.group"/></lable>
        <button class="btn btn-primary" type="submit" style="margin-left: 15px"><fmt:message
                key="users.page.group.by"/></button>
    </form>
</div>

<div class="container">
    <table class="table table-hover">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col"><fmt:message key="users.table.firstname"/></th>
            <th scope="col"><fmt:message key="users.table.lastname"/></th>
            <th scope="col"><fmt:message key="users.table.email"/></th>
            <th scope="col"><fmt:message key="users.table.type"/></th>
            <th scope="col"></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${userList}">
            <tr>
                <th scope="row">${user.id}</th>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
                <td>${user.email}</td>
                <td>${user.type}</td>
                <td>
                    <c:choose>
                        <c:when test="${user.isBlocked}">
                            <a href="userBlock?userId=${user.id}">
                                <button class="btn btn-primary" type="submit" style="margin-left: 15px"><fmt:message
                                        key="users.table.unblocked"/></button>
                            </a>
                        </c:when>
                        <c:otherwise>
                            <a href="userBlock?userId=${user.id}">
                                <button class="btn btn-primary" type="submit" style="margin-left: 15px"><fmt:message
                                        key="users.table.blocked"/></button>
                            </a>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>


    <table class="table table-hover">
        <tr>
            <c:forEach begin="1" end="${noOfPages}" var="i">
                <c:choose>
                    <c:when test="${currentPage eq i}">
                        <td>${i}</td>
                    </c:when>
                    <c:otherwise>
                        <td><a href="users?page=${i}"><p>${i}</p></a></td>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </tr>
    </table>
    <c:if test="${currentPage != 1}">
        <td><a href="users?page=${currentPage - 1}">
            <button class="btn btn-primary" type="submit" style="margin-left: 15px"><fmt:message
                    key="pagination.prev"/></button>
        </a></td>
    </c:if>
    <c:if test="${currentPage lt noOfPages}">
        <td><a href="users?page=${currentPage + 1}">
            <button class="btn btn-primary" type="submit" style="margin-left: 15px"><fmt:message
                    key="pagination.next"/></button>
        </a></td>
    </c:if>
</div>

</body>
</html>
