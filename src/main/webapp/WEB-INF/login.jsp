<%--
  Created by IntelliJ IDEA.
  User: Yvette
  Date: 5/1/2023
  Time: 9:45 AM
  To change this template use File | Settings | File Templates.
--%>
<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<style>
	body {
		margin: 0;
		padding: 0;
		box-sizing: border-box;
	}
</style>
<div style="width: 100%; height: 100vh; display: grid; place-items: center; justify-items: center; background: black">
	<div style="width: 40%;height: 50%;align-self: center;justify-self: center;display: grid;justify-items: center; background: white; padding: 2rem; border-radius: 2rem">
		<span style="color: black; font-size: 2rem; text-align: center; width: 100%; height: 100% ">RCA SMIS LOGIN</span>
		<form action="login.php" method="post" style="width: 100%; height: fit-content; display: flex; flex-direction: column; gap: 1rem; ">
			<label for="username">Username: </label>
			<input type="text" size="25" maxlength="50" name="username" id="username" style="width: 80%; border-radius:5px; padding: 5px" />
			<label for="password">Password: </label>
			<input type="password" size="25" maxlength="50" name="password" id="password" style="width: 80%; border-radius:5px; padding: 5px" />
			<input type="submit" value="Login" style="width: 50%; margin-bottom: 1rem; background: #4CAF50; margin-left: 100px; border-radius: 5px; padding: 6px" ; />
			<c:if test="${authenticatedUser ==null}">
				<a href="createuser.php?page=createuser" style="width: 100%; padding: 10px; color: black; border: 10px; text-underline: white;">New User Registration</a>
			</c:if>
		</form>
		<div id="footerlogin" style="display: flex; flex-direction: column; justify-content: flex-start; ">
			<p>RCA SMIS, a product of Rwanda Coding Academy</p>
			&copy;2023 RCA
		</div>
	</div>
</div>
