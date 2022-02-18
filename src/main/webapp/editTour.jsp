<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Your Lovely Tour</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"></script>
</head>
<body>

<jsp:include page="menu.jsp"></jsp:include>

<div class="col" style="text-align:center">
    <label class="form-label">Editor ${tour.name}</label>
</div>
<br/>

<form action="editor" method="post">
    <div class="container">
        <div class="row">
            <div class="mb-3">
                <label class="form-label">Name</label>
                <input type="text" class="form-control" name="name">
            </div>
            <div class="mb-3">
                <label class="form-label">Lasting</label>
                <input type="text" class="form-control" name="lasting">
            </div>
            <div class="mb-3">
                <label class="form-label">Hotel</label>
                <select name="hotel">
                    <c:forEach var="hotel" items="${listOfHotels}">
                        <option value="${hotel.id}">${hotel.name} ${hotel.addres} - ${hotel.country} ${hotel.city}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="mb-3">
                <label class="form-label">Start Date (year-month-day)</label>
                <input type="date" class="form-control" name="startDate">
            </div>
            <div class="mb-3">
                <label class="form-label">End Date (year-month-day</label>
                <input type="date" class="form-control" name="endDate">
            </div>
            <div class="comb-3l">
                <label class="form-label">Status</label>
                <input type="text" class="form-control" name="status">
            </div>
            <div class="mb-3">
                <label class="form-label">Description</label>
                <textarea  type="text" class="form-control" name="description" style = "width: 1300px;height: 250px"></textarea>
            </div>
            <div class="mb-3">
                <label class="form-label">Price</label>
                <input type="text" class="form-control" name="price">
            </div>
            <div class="mb-3">
                <label class="form-label">Type</label>
                <input type="text" class="form-control" name="type">
            </div>
            <div class="mb-3">
                <label class="form-label">Discount</label>
                <input type="text" class="form-control" name="discount">
            </div>
            <div class="mb-3">
                <label class="form-label">Step</label>
                <input type="text" class="form-control" name="step">
            </div>
            <br/>
            <button type="submit" class="btn btn-primary">Submit</button>
        </div>
    </div>
</form>
</body>
</html>
