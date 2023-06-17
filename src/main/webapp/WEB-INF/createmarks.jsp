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
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<div class="container">
    <jsp:include page="headeradmin.jsp"><jsp:param
            name="title" value="Create Marks" />
    </jsp:include>
</div>
<style>
    body {
        display: flex;
        flex-direction: column;
        align-items: center;
    }
    input {
        height: 2.2rem;
        border-radius: 0.4rem;
        width: 60%;
        outline: none;
    }

</style>
<div id="middle" style="width: 100%">
    <h2 style="text-align: left; color: black;">
        <b>Enter User Details</b>
    </h2>
    <c:if test="${message != null}">
        <fieldset>
            <h3>
                <span style="color: red"> ${message}</span>
            </h3>
        </fieldset>
    </c:if>
    <form action="createmarks.php?page=createmarks" method="post"  style="color:white; width: 50%; margin-left: 35%; height: fit-content; display: flex; flex-direction: column; gap: 1rem; ">
        <label for="studentname">Student Name: </label>
      <input type="text" size="25" maxlength="50"
                                        name="studentname" id="studentname" />
        <label for="subject">Subject: </label>
                    <input type="text" size="25"
                                        maxlength="50" name="subject" id="subject" />
        <label for="marksobtained">Marks Obtained: </label>
                    <input type="number" size="50" maxlength="50"
                                        name="marksobtained" id="marksobtained" />

                    <input type="submit" name="saveDataMarks"
                                        value="Submit Marks" style="padding: 10px 10px; background-color: #4CAF50; color: white; border: none; cursor: pointer; border-radius: 4px; font-size: 16px;" />
        <a href="listmarks.php?page=marks&&action=list">All Marks </a>
    </form>
</div>

<%@ include file="footer.jsp"%>

