<%@ page import="static DAO.sql.entity.user.Type.USER" %>
<%@ page import="static DAO.sql.entity.user.Type.MANAGER" %>
<%@ page import="static DAO.sql.entity.user.Type.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="resources"/>

<html>
<head>
    <title>Order</title>
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
        <lable><fmt:message key="tour.page.sort.by"/></lable>
        <button class="btn btn-primary" type="submit" style="margin-left: 15px"><fmt:message
                key="tour.page.price"/></button>
        <button class="btn btn-primary" type="submit" style="margin-left: 15px"><fmt:message
                key="tour.page.hotel"/></button>
        <button class="btn btn-primary" type="submit" style="margin-left: 15px"><fmt:message
                key="tour.page.tour"/></button>
        <button class="btn btn-primary" type="submit" style="margin-left: 15px"><fmt:message
                key="tour.page.people"/></button>
    </form>
    <%if (session.getAttribute("access") == ADMIN) {%>
    <a href="editTour.jsp" class="btn btn-primary" style="margin-left: 15px;margin-bottom: 15px"><fmt:message
            key="tour.page.add"/></a>
    <%}%>
</div>


<div class="container">
    <table class="table table-hover">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col"><fmt:message key="edit.field.name"/></th>
            <th scope="col"><fmt:message key="edit.field.description"/></th>
            <th scope="col"><fmt:message key="tour.price"/></th>
            <th scope="col">Dates</th>
            <th scope="col"><fmt:message key="tour.orders"/></th>
            <th scope="col"><fmt:message key="edit.field.status"/></th>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="tour" items="${sessionScope.listOfTours}">
        <tr>
            <td><img class="rounded" src="https://pbs.twimg.com/media/E9YJOcmWQAczMrY.jpg" alt="Card image cap"
                     style="width:250px;height:175px"></td>
            <td>${tour.name}</td>
            <td>${tour.description} </td>
            <td>${tour.price} €</td>
            <td><fmt:message key="tour.start.date"/> ${tour.startDate} <br/>
                <fmt:message key="tour.end.date"/> ${tour.endDate}
            </td>
            <td>${tour.countPeople}</td>
            <td><c:if test="${tour.status == 'fire'}">
                <p class="card-text"><fmt:message key="tour.status"/> ${tour.status}</p>
            </c:if></td>
            <td>
                <div class="col">
                    <%if (session.getAttribute("access") == USER) {%>
                    <a href="addOrder?tourId=${tour.id}" class="btn btn-primary"><fmt:message
                            key="tour.button.order"/></a>
                    <%} else if (session.getAttribute("access") == MANAGER) {%>
                    <a href="editor?tourId=${tour.id}" class="btn btn-primary"><fmt:message key="tour.button.edit"/></a>
                    <div class="dropdown" style="margin-top: 15px">
                        <a class="btn btn-secondary dropdown-toggle" href="#" role="button" id="dropdownMenuLink"
                           data-bs-toggle="dropdown" aria-expanded="false"
                           style="margin-right: 15px;margin-bottom: 15px">
                            <p>${tour.status}</p>
                        </a>
                        <div class="dropdown-menu" aria-labelledby="dropdownMenuButton1" style="color:green">
                            <a class="dropdown-item" href="updateTour?tourId=${tour.id}&status=none">None</a>
                            <a class="dropdown-item" href="updateTour?tourId=${tour.id}&status=fire">Fire</a>
                        </div>
                    </div>
                    <%} else if (session.getAttribute("access") == ADMIN) {%>
                    <a href="editor?tourId=${tour.id}" class="btn btn-primary"><fmt:message key="tour.button.edit"/></a>
                    <a href="deleteTour?tourId=${tour.id}" class="btn btn-primary"><fmt:message
                            key="tour.button.delete"/></a>
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
                        <td><a href="tours?page=${i}"><p>${i}</p></a></td>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </tr>
    </table>
    <c:if test="${currentPage != 1}">
        <td><a href="tours?page=${currentPage - 1}">
            <button class="btn btn-primary" type="submit" style="margin-left: 15px"><fmt:message
                    key="pagination.prev"/></button>
        </a></td>
    </c:if>
    <c:if test="${currentPage lt noOfPages}">
        <td><a href="tours?page=${currentPage + 1}">
            <button class="btn btn-primary" type="submit" style="margin-left: 15px"><fmt:message
                    key="pagination.next"/></button>
        </a></td>
    </c:if>
</div>
</body>
</html>
