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
    input[type="text"], input[type="number"], input[type="date"],input[type="submit"] {
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
    <form action="createstudent.php?page=createstudent" method="post" style="color: white;width: 50%; margin-left: 30%; height: fit-content; display: flex; flex-direction: column; gap: 1rem; ">
<%--        <label for="id">Student Id: </label>--%>
<%--        <input type="number" size="25" maxlength="50"--%>
<%--               name="id" id="id" />--%>

        <label for="firstName">Firstname: </label>
        <input type="text" size="25" maxlength="50"
               name="firstName" id="firstName" />

        <label for="lastName">Lastname: </label>
        <input type="text" size="50"
               maxlength="50" name="lastName" id="lastName"  />

        <label for="dateOfBirth">Date of Birth: </label>
        <input type="date" name="dateOfBirth" id="dateOfBirth" />

        <label for="email">Email</label>
        <input type="text" size="50" maxlength="50"
               name="email" id="email" />

        <label for="phoneNumber">Phone Number</label>
        <input type="number" size="50" maxlength="50"
               name="phoneNumber" id="phoneNumber" />

        <label>
            <input type="radio" name="gender" value="male">
            Male
        </label>

        <label>
            <input type="radio" name="gender" value="female">
            Female
        </label>
<%--        <br>--%>
<%--        <label>--%>
<%--            <input type="radio" name="isInternational" id="isInternational" value="1">--%>
<%--            International--%>
<%--        </label>--%>

<%--        <label>--%>
<%--            <input type="radio" name="isInternational" id="isInternational" value="0">--%>
<%--            Local--%>
<%--        </label>--%>
        <br>
        <label for="address">Address: </label>
        <input type="number" name="address" id="address" class="form-control" />

        <input type="submit" name="saveStd"
               value="Register Student" style="padding: 10px 10px; background-color: #4CAF50; color: white; border: none; cursor: pointer; border-radius: 4px; font-size: 16px;" />
    <a href="liststudents.php?page=students&&action=list">All courses </a>
    </form>
</div>
<%@ include file="footer.jsp"%>