<%@ page import="static DAO.sql.entity.user.Type.ADMIN" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"
         language="java"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="resources"/>

<html>
<head>
    <title>Your Lovely Tour</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
            integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
            integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
            crossorigin="anonymous"></script>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="index.jsp"><fmt:message key="main.logo.title"/></a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarScroll"
                aria-controls="navbarScroll" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarScroll">
            <ul class="navbar-nav me-auto my-2 my-lg-0 navbar-nav-scroll" style="--bs-scroll-height: 100px;">
                <li class="nav-item">
                    <a type="submit" class="navbar-brand" href="tours"><fmt:message key="main.menu.tour"/></a>
                </li>
                <%if (session.getAttribute("access") == ADMIN) {%>
                <li class="nav-item">
                    <a type="submit" class="navbar-brand" style="margin-left: 15px" href="users"><fmt:message key="main.menu.users"/></a>
                </li>
                <li class="nav-item">
                    <a type="submit" class="navbar-brand" style="margin-left: 15px" href="profile"><fmt:message key="main.menu.profile"/></a>
                </li>
                <%} else {%>
                <li class="nav-item">
                    <a type="submit" class="navbar-brand" style="margin-left: 15px" href="profile"><fmt:message key="main.menu.profile"/></a>
                </li>
                <%}%>
            </ul>
            <div class="dropdown">
                <a class="btn btn-secondary dropdown-toggle" href="#" role="button" id="dropdownMenuLink"
                   data-bs-toggle="dropdown" aria-expanded="false" style="margin-right: 15px;margin-bottom: 15px">
                    <c:if test = "${sessionScope.lang != null}">
                        ${sessionScope.lang}
                    </c:if>
                    <c:if test = "${sessionScope.lang == null}">
                        en
                    </c:if>
                </a>
                <div class="dropdown-menu" aria-labelledby="dropdownMenuButton1" style="color:green">
                    <a class="dropdown-item" href="?lang=en">en</a>
                    <a class="dropdown-item" href="?lang=ua">ua</a>
                </div>
            </div>

            <%if (session.getAttribute("user") != null) {%>
            <form class="d-flex" action="logout" method="get">
                <button class="btn btn-outline-success" type="submit"><fmt:message key="main.menu.logout"/></button>
            </form>
            <%} else {%>
            <form class="d-flex" action="log" method="get">
                <button class="btn btn-outline-success" type="submit"><fmt:message key="main.menu.login"/></button>
            </form>
            <%}%>
        </div>
    </div>
</nav>
</body>
</html>
