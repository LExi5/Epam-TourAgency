<%@ page import="static DAO.sql.entity.user.Type.USER" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="resources"/>
<html>
<head>
    <title>Your Lovely Tour</title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
<style>
    .circle-image {
        display: inline-block;
        border-radius: 50%;
        overflow: hidden;
        width: 50px;
        height: 50px;
    }

    .circle-image img {
        width: 100%;
        height: 100%;
        object-fit: cover;
    }
</style>
<body>
<jsp:include page="menu.jsp"></jsp:include>

<div>
    <div class="container">
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
                <span class="circle-image">
                    <img class="rounded" src="https://cdn-icons-png.flaticon.com/512/21/21104.png">
                </span>
            </div>
            <div class="col">
                <h1><c:out value="${sessionScope.user.firstName} ${sessionScope.user.lastName}"/></h1>
                <p><b><fmt:message key="users.table.email"/></b> <c:out value="${sessionScope.user.email}"/></p>
            </div>
        </div>
    </div>
</div>
<br/>
<br/>
<div class="container">
    <table class="table table-hover">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Name</th>
            <th scope="col">Description</th>
            <th scope="col">Price</th>
            <th scope="col">Dates</th>
            <th scope="col">Status</th>
            <th scope="col"><fmt:message key="profile.registration"/></th>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="order" items="${sessionScope.orders}">
        <tr>
            <td><img class="rounded" src="https://pbs.twimg.com/media/E9YJOcmWQAczMrY.jpg" alt="Card image cap"
                     style="width:250px;height:175px"></td>
            <td>${order.tour.name}</td>
            <td>${order.tour.description}</td>
            <td><fmt:message key="tour.price"/>: ${order.tour.price} €</td>
            <td><fmt:message key="tour.start.date"/> ${order.tour.startDate}
                <fmt:message key="tour.end.date"/> ${order.tour.endDate}
            </td>
            <td>${order.status}</td>
            <td>${order.registrationDate}</td>
            <td>
                <div class="col">
                    <%if (session.getAttribute("access") == USER) {%>
                    <br/>
                    <a class="dropdown-item"
                       href="update?tourId=${order.tourId}&userId=${order.userId}&status=CANCELLED">
                        <button class="btn btn-outline-success" type="submit" style="margin-left: -15px"><fmt:message
                                key="profile.select.cancel"/></button>
                    </a>
                    <%} else {%>
                    <div class="dropdown" style="margin-top: 15px">
                        <a class="btn btn-secondary dropdown-toggle" href="#" role="button" id="dropdownMenuLink"
                           data-bs-toggle="dropdown" aria-expanded="false"
                           style="margin-right: 15px;margin-bottom: 15px">
                        </a>
                        <div class="dropdown-menu" aria-labelledby="dropdownMenuButton1" style="color:green">
                            <a class="dropdown-item"
                               href="update?tourId=${order.tourId}&userId=${order.userId}&status=REGISTERED"><fmt:message
                                    key="profile.select.registration"/></a>
                            <a class="dropdown-item"
                               href="update?tourId=${order.tourId}&userId=${order.userId}&status=CANCELLED"><fmt:message
                                    key="profile.select.canceled"/></a>
                            <a class="dropdown-item"
                               href="update?tourId=${order.tourId}&userId=${order.userId}&status=PAYED"><fmt:message
                                    key="profile.select.payed"/></a>
                        </div>
                    </div>
                    <%}%>
                </div>
            </td>
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
                        <td><a href="profile?page=${i}"><p>${i}</p></a></td>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </tr>
    </table>
    <c:if test="${currentPage != 1}">
        <td><a href="profile?page=${currentPage - 1}">
            <button class="btn btn-primary" type="submit" style="margin-left: 15px"><fmt:message
                    key="pagination.prev"/></button>
        </a></td>
    </c:if>
    <c:if test="${currentPage lt noOfPages}">
        <td><a href="profile?page=${currentPage + 1}">
            <button class="btn btn-primary" type="submit" style="margin-left: 15px"><fmt:message
                    key="pagination.next"/></button>
        </a></td>
    </c:if>
</div>
</body>
</html>
