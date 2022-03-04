<%@ page import="java.util.Date" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"
         language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="resources"/>
<html>
<head>
    <title>Your Lovely Tour</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"></script>
</head>
<body>
<div class="mb-3" style="color:red;text-align:center">
    <h1 class="form-label">ERROR</h1>
</div>
<div class="mb-3" style="color:red;text-align:center">
    <h2 class="form-label">MASSAGE:</h2>
    <c:if test="${massage != null}">
        <% out.println(request.getAttribute("massage"));%>
    </c:if>
    <c:if test="${massage == 'This user is blocked'}">
        <div>
            <a href="logout" style = "color:red"><fmt:message key="main.menu.logout"/></a>
        </div>

    </c:if>
    <br/>
</div>

</body>
</html>
