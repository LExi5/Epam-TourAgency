<%@ page import="static DAO.sql.entity.user.Type.USER" %>
<%@ page import="static DAO.sql.entity.user.Type.MANAGER" %>
<%@ page import="static DAO.sql.entity.user.Type.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<div class="navbar navbar-expand-lg navbar-light bg-light" >
    <form class="d-flex" action="logout" method="get" style="margin-left: 15px">
        <lable>Group By</lable>
        <button class="btn btn-primary" type="submit" style="margin-left: 15px">Type</button>
    </form>
</div>


<div class="container">
    <c:forEach var="user" items="${userList}">
        <div style="display: block;
     position: relative;
    border-radius: 5px;
    box-shadow: 0 20px 70px -20px rgb(0 73 112 / 60%);
    padding: 20px 20px 20px 40px;
    width: 100%;
    margin: 2em 0;
    line-height: 1.4;
    box-sizing: border-box;
    background-color: #fff;" class="row">
            <div class="col">
                <p class="card-text">${user.firstName} ${user.lastName}</p>
                <p class="card-text">${user.email}</p>
                <p class="card-text">${user.type}</p>
            </div>
            <br/>
            <div class="col">
                <c:choose>
                    <c:when test="${user.isBlocked}">
                        <button class="btn btn-primary" type="submit" style="margin-left: 15px">Unblock</button>
                    </c:when>
                    <c:otherwise>
                        <button class="btn btn-primary" type="submit" style="margin-left: 15px">Block</button>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </c:forEach>
</div>
</body>
</html>
