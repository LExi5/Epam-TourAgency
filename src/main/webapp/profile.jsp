<%@ page import="static DAO.sql.entity.user.Type.USER" %>
<%@ page import="static DAO.sql.entity.user.Type.MANAGER" %>
<%@ page import="static DAO.sql.entity.user.Type.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    .circle-image{
        display: inline-block;
        border-radius: 50%;
        overflow: hidden;
        width: 50px;
        height: 50px;
    }
    .circle-image img{
        width:100%;
        height:100%;
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
                <p><b>Email:</b> <c:out value="${sessionScope.user.email}"/></p>
            </div>
        </div>
    </div>
</div>
<br/>
<h2 style =" text-align:center">Your Orders</h2>
<br/>
<div class="container">
    <c:forEach var="order" items="${sessionScope.orders}">
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
                <h1 class="card-text" > ${order.tour.name}</h1>
                <p class="card-text">${order.tour.description}</p>
                <p class="card-text">Price: ${order.tour.price} €</p>
                <p class="card-text">Start Date: ${order.tour.startDate}</p>
                <p class="card-text">End Date: ${order.tour.endDate}</p>
            </div>
            <div class="col">
                <p class="card-text">Registration Date ${order.registrationDate}</p>
            </div>
            <div class="col">
                <%if(session.getAttribute("access")==USER){%>
                <br/>
                    <p>${order.status}</p>
                <%} else {%>
                <select>
                    <option value = "reg">Registered</option>
                    <option value = "canceled">Canceled</option>
                    <option value = "payed">Payed</option>
                </select>
                <%}%>
            </div>
            <div class="col"></div>
        </div>
    </c:forEach>
</div>
</body>
</html>
