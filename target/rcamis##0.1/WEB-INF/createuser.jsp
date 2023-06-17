<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>

<div class="container">
	<jsp:include page="headeradmin.jsp"><jsp:param
			name="title" value="Create Parent" />
	</jsp:include>
</div>
<style>
	body {
		display: flex;
		flex-direction: column;
		align-items: center;
	}
	input,select {
		height: 2.2rem;
		border-radius: 0.4rem;
		width: 60%;
		outline: none;
	}

</style>
<div id="middle" style="width: 100%">
	<h3 style="text-align: center; padding-top: 32px;color: black ">
		<b>Enter Student Details</b>
	</h3>
	<c:if test="${message != null}">
		<fieldset>
			<h3>
				<span style="color: red"> ${message}</span>
			</h3>
		</fieldset>
	</c:if>
		<form action="login.php" method="post" style="color:white; width: 50%; margin-left: 35%; height: fit-content; display: flex; flex-direction: column; gap: 1rem; ">
			<label for="username" >Username:</label>
			<input type="text" size="25" maxlength="50"  name="username" id="username" style="width: 80%; border-radius: 5px" />


			<label for="password" >Password:</label>
			<input type="password" size="25" maxlength="50"  name="password" id="password" style="width: 80%; border-radius: 5px" />


			<label for="userfullname" style="color: white">Full Name:</label>
			<input type="text" size="50" maxlength="50"  name="userfullname" id="userfullname" style="width: 80%; border-radius: 5px" />


			<label for="email" >Email:</label>
			<input type="text" size="50" maxlength="50"  name="email" id="email" style="width: 80%; border-radius: 5px" />


			<label for="userRole" >Role:</label>
			<select name="userRole" id="userRole" style="width: 80%; border-radius: 5px;">
				<option value="">Select Role</option>
				<!-- Assuming you are using JSTL -->
				<c:forEach items="${userRoles}" var="userrole" varStatus="userrolestatus">
					<option value="${userrole}" style="color: black">
						<c:out value="${userrole.getRoleDescription()}" />
					</option>
				</c:forEach>
			</select
			<div style="text-align: center;">
				<input type="submit" name="saveDataUser" value="Create User" style="width: 50%;padding: 10px 10px; background-color: #4CAF50; color: white; border: none; cursor: pointer; border-radius: 4px; font-size: 16px;" />
			</div>
		</form>
		<div id="footerlogin" style="display: flex; flex-direction: column; justify-content: flex-start; ">
			<p>RCA SMIS, a product of Rwanda Coding Academy</p>
			&copy;2023 RCA
		</div>
	</div>
</div>

<%@ include file="footer.jsp"%>