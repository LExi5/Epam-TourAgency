<%@ page import="static DAO.sql.entity.user.Type.USER" %>
<%@ page import="static DAO.sql.entity.user.Type.MANAGER" %>
<%@ page import="static DAO.sql.entity.user.Type.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.lang}" />
<fmt:setBundle basename="resources" />

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
        <button class="btn btn-primary" type="submit" style="margin-left: 15px"><fmt:message key="tour.page.price"/></button>
        <button class="btn btn-primary" type="submit" style="margin-left: 15px"><fmt:message key="tour.page.hotel"/></button>
        <button class="btn btn-primary" type="submit" style="margin-left: 15px"><fmt:message key="tour.page.tour"/></button>
        <button class="btn btn-primary" type="submit" style="margin-left: 15px"><fmt:message key="tour.page.people"/></button>
    </form>
    <%if (session.getAttribute("access") == ADMIN) {%>
    <a href="editTour.jsp" class="btn btn-primary" style="margin-left: 15px;margin-bottom: 15px"><fmt:message key="tour.page.add"/></a>
    <%}%>
</div>


<div class="container">
    <c:forEach var="tour" items="${listOfTours}">
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
                <img class="rounded" src="https://pbs.twimg.com/media/E9YJOcmWQAczMrY.jpg" alt="Card image cap"
                     style="width:250px;height:175px">
            </div>
            <div class="col">
                <h5 class="card-title">${tour.name}</h5>
                <p class="card-text">${tour.description}</p>
                <p class="card-text"><fmt:message key="tour.price"/>: ${tour.price} €</p>
                <p class="card-text"><fmt:message key="tour.start.date"/> ${tour.startDate}</p>
                <p class="card-text"><fmt:message key="tour.end.date"/> ${tour.endDate}</p>
                <p class="card-text"><fmt:message key="tour.orders"/> ${tour.countPeople}</p>
            </div>
            <br/>
            <div class="col">
                <%if (session.getAttribute("access") == USER) {%>
                <a href="addOrder?tourId=${tour.id}" class="btn btn-primary"><fmt:message key="tour.button.order"/></a>
                <%} else if (session.getAttribute("access") == MANAGER) {%>
                <a href="editor?tourId=${tour.id}" class="btn btn-primary"><fmt:message key="tour.button.edit"/></a>
                <select>
                    <option value = "canceled">None</option>
                    <option value = "payed">Fire</option>
                </select>
                <%} else if (session.getAttribute("access") == ADMIN) {%>
                <a href="editor?tourId=${tour.id}" class="btn btn-primary"><fmt:message key="tour.button.edit"/></a>
                <a href="deleteTour?tourId=${tour.id}" class="btn btn-primary"><fmt:message key="tour.button.delete"/></a>
                <%}%>
            </div>
            <div class="col"></div>
        </div>
    </c:forEach>
</div>
</body>
</html>
