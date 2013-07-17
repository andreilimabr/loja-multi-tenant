<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<link rel="stylesheet" href="<c:url value='/resource/css/bootstrap.min.css'/>">
</head>
<body>
<script type="text/javascript" src="<c:url value='/resource/js/jquery-1.8.2.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resource/js/bootstrap.min.js'/>"></script>
<div class="container"  style="margin-left: 20px;margin-top: 5px">
<form id="loginform" name="loginform" method="post" action="">
  <label for="username">Username</label><input name="username" id="username" type="text" /><br/>
  <label for="password">Password</label><input name="password" id="password" type="password" /><br/>
  <button class="btn" type="submit" name="Login">   Login  </button>
</form>
</div>
</body>
</html>