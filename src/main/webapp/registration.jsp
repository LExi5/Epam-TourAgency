<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="resources"/>

<html>
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>Your Lovely Tour</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"></script>
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>

<form action="registration" method="post" style="margin-top: 15px;margin-right: 400px;margin-left:400px"
      accept-charset="UTF-8">
    <div class="mb-3">
        <label class="form-label"><fmt:message key="reg.title"/></label>
    </div>
    <div class="mb-3">
        <label for="exampleInputEmail1" class="form-label" style="color:red">
            <%
                if (request.getAttribute("massage") != null) {
                    out.println(request.getAttribute("massage"));
                }
            %>
        </label>
    </div>
    <div class="mb-3">
        <label class="form-label"><fmt:message key="reg.field.first.name"/></label>
        <input type="text" class="form-control" name="firstname">
    </div>
    <div class="mb-3">
        <label for="exampleInputEmail1" class="form-label"><fmt:message key="reg.field.last.name"/></label>
        <input type="text" class="form-control" name="lastname">
    </div>
    <div class="mb-3">
        <label for="exampleInputEmail1" class="form-label"><fmt:message key="reg.field.email"/></label>
        <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="email">
        <div id="emailHelp" class="form-text"><fmt:message key="req.massage"/></div>
    </div>
    <div class="mb-3">
        <label for="exampleInputPassword1" class="form-label"><fmt:message key="reg.field.password"/></label>
        <input type="password" class="form-control" id="exampleInputPassword1" name="password">
    </div>
    <button type="submit" class="btn btn-primary"><fmt:message key="req.submit"/></button>
</form>
</body>
</html>
