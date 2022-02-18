<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 18.02.2022
  Time: 18:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
  <!-- reCAPTCHA with English language -->
  <script src='https://www.google.com/recaptcha/api.js?hl=en'></script>


  <!-- reCAPTCHA with Auto language -->
  <script src='https://www.google.com/recaptcha/api.js'></script>
</head>
<body>
<form action="?" method="POST">
  <div class="g-recaptcha" data-sitekey="your_site_key"></div>
  <br/>
</form>
</body>
