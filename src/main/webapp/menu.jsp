<%@ page import="java.util.Date" %>
<%@ page import="static DAO.sql.entity.user.Type.ADMIN" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Your Lovely Tour</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="index.jsp">Tour Agency</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarScroll"
                aria-controls="navbarScroll" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarScroll">
            <ul class="navbar-nav me-auto my-2 my-lg-0 navbar-nav-scroll" style="--bs-scroll-height: 100px;">
                <li class="nav-item">
                    <a type="submit"  class="navbar-brand" href="tours">Tours</a>
                </li>
                <%if (session.getAttribute("access") == ADMIN) {%>
                <li class="nav-item">
                    <a type="submit"  class="navbar-brand" style="margin-left: 15px" href="users">Users</a>
                </li>
                <li class="nav-item">
                    <a type="submit"  class="navbar-brand" style="margin-left: 15px" href="profile">Profile</a>
                </li>
                <%} else {%>
                <li class="nav-item">
                    <a type="submit"  class="navbar-brand" style="margin-left: 15px" href="profile">Profile</a>
                </li>
                <%}%>
            </ul>
            <select  class="btn btn-outline-success" style = "margin-right: 15px; margin-bottom: 15px">
                <option>ua</option>
                <option>en</option>
            </select>
            <%if (session.getAttribute("user") != null) {%>
            <form class="d-flex" action="logout" method="get">
                <button class="btn btn-outline-success" type="submit">Logout</button>
            </form>
            <%} else {%>
            <form class="d-flex" action="log" method="get">
                <button class="btn btn-outline-success" type="submit">Login</button>
            </form>
            <%}%>
        </div>
    </div>
</nav>
</body>
</html>
