<%--
  Created by IntelliJ IDEA.
  User: Yvette
  Date: 4/22/2023
  Time: 7:01 PM
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
            name="title" value="Create Course" />
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
<div id="middle" style="width:100%; ">
    <h2 style="text-align: center; color: black; visibility: hidden ">
        <b>Enter Course Details</b>
    </h2>
    <c:if test="${message != null}">
        <fieldset>
            <h3>
                <span style="color: red"> ${message}</span>
            </h3>
        </fieldset>
    </c:if>

    <form action="createcourse.php?page=createcourse" method="post" style="color:white; width: 50%; margin-left: 35%; height: fit-content; display: flex; flex-direction: column; gap: 1rem; ">
        <label for="coursename">Coursename: </label>
      <input type="text" size="25" maxlength="50"
                                        name="coursename" id="coursename" />
        <label for="coursecode">Coursecode: </label>
          <input type="text" size="25"
                                        maxlength="50" name="coursecode" id="coursecode" />
        <label for="minStudent">minimumStudent: </label>
        <input type="number" size="50" maxlength="50"
                                        name="minStudent" id="minStudent" />
        <label for="maxStudent">maximumStudent: </label>
        <input type="number" size="50" maxlength="50"
               name="maxStudent" id="maxStudent" />
        <label for="start">startDate: </label>
        <input type="date" size="50" maxlength="50"
                                        name="start" id="start" />
        <label for="end">endDate: </label>
        <input type="date" size="50" maxlength="50"
                                        name="end" id="end" />
        <input type="submit" name="saveDataCourse" value="Create Course" style="padding: 10px 10px; background-color: #4CAF50; color: white; border: none; cursor: pointer; border-radius: 4px; font-size: 16px;" />
        <a href="listcourse.php?page=courses&&action=list" style="background: white; align-items: center; width: 20%; color: black; padding: 10px 10px; border-radius: 5px; text-underline: none">All courses </a>
    </form>

</div>

<%@ include file="footer.jsp"%>
