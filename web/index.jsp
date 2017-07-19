<!DOCTYPE html>
<html >
<head>
  <meta charset="UTF-8">
  <title>login form</title>

  <%--<link rel="stylesheet" href="WEB-INF/resources/css/reset.css">--%>
  <link rel="stylesheet" href="resources/css/index.css">

</head>

<body>
<div class="welcome">
  <span class="text">WELCOME</span>
</div>

<div class="text1">
  <span>to STUDENT HELPER</span>
</div>


<div class="login">
  <header class="login-header"><span class="text">LOGIN</span><span class="loader"></span></header>
  <form action="AuthController" method="post" class="login-form">
    <input class="login-input" type="text" name="login" placeholder="Username">
    <input class="login-input" type="password" name="password"  placeholder="Password">
    <button class="login-btn" type="submit" name="OK" value="OK"></button>
  </form>
</div>
<script src="resources/js/index.js"></script>

</body>
</html>
