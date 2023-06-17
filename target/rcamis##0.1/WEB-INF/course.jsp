<%--
  Created by IntelliJ IDEA.
  User: Yvette
  Date: 4/22/2023
  Time: 7:00 PM
  To change this template use File | Settings | File Templates.
--%>
<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"/>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link rel="stylesheet" href="cssfile.css" type="text/css" />
    <link rel="stylesheet" href="css/displaytag.css" type="text/css" />
    <link rel="stylesheet" href="css/screen.css" type="text/css" />
    <link rel="stylesheet" href="css/site.css" type="text/css" />
    <title>Course Registrations</title>

</head>
<style>
    table {
        border-collapse: collapse;
        width: 50%;
        border-spacing: 1rem;
        margin-left: 20%;
    }
</style>

<body style="margin: 0px; height: 100vh; width: 100%">
<div id="layout" style="width: 100%; height: 100%; background: black">
    <div id="banner">
        <div class="bannerlogo"></div>
        <div class="text_header">RCA Management Information System</div>
        <div class="right" style="text-align: right;">
            <c:if test="${authenticatedUser !=null}">
                <b> <a
                        href="listuser.php?page=profile&&id=${authenticatedUser.id}"><button>Profile
                </button></a> | <img src="icons/user.png" /> <font color="#ffffff">${authenticatedUser.userRole}:
                        ${authenticatedUser.username}</font> | <a href="login.ap?page=logout"><font
                        color="#ffffff">Logout</font></a>
                </b>
            </c:if>
            <c:if test="${authenticatedUser ==null}">
                <div class="menu" align="left">
                    | <a href="login.php?">Login</a> |
                </div>
            </c:if>
        </div>
    </div>
    <div>
        <%@ include file="menu.jsp"%>
    </div>
    <div id="middle" style="color: white">
        <c:if test="${authenticatedUser !=null}">
            <div class="options">

                <a href="createcourse.php?page=createcourse"><button>
                    <img src="icons/user_add.png" /> Create New Course
                </button></a>
            </div>
            <div class="search">
                <form action="listuser.php" method="get" style="float:right;margin-top: -20px" >
<%--                    <table>--%>
<%--                        <tr>--%>
<%--                            <td style="color: #000000;">Enter User ID</td>--%>
<%--                            <td><input type="text" name="id" id="id" /></td>--%>
<%--                            <td><input type=le'submit' name="userregistrationsearch"--%>
<%--                                       value='search' /></td>--%>
<%--                        </tr>--%>
<%--                    </table>--%>
    <label for="userID">Enter User ID</label>
    <input type="text" name="id" id="userID"/>
    <button type="submit" name="userregistrationsearch" style="margin-right: 10px" >Search</button>
                </form>
            </div>
            <hr />


                    <table style="border: 0;">

                            <td align="left"><input type="text" size="15"
                                                    maxlength="50" readonly="readonly" name="savedBy" id="savedBy"
                                                    hidden="hidden" value="${authenticatedUser.id}" /></td>

<%--                            <td><select name="userRole" id="userRole">--%>
<%--                                <option selected="selected" value="NONE">Select Role</option>--%>
<%--                                <c:forEach items="${userRoles}" var="usrRole"--%>
<%--                                           varStatus="usrRolestatus">--%>
<%--                                    <option value="${usrRole}">--%>
<%--                                        <c:out value="${usrRole.getRoleDescription()}" />--%>
<%--                                    </option>--%>
<%--                                </c:forEach>--%>
<%--                            </select></td>--%>
<%--                            <td align="right"><input type="submit"--%>
<%--                                                     name="saveCourseStatus" value="Save Status" /></td>--%>



                    <table>
                        <thead>
                        <tr>
                            <td  style="border: 1px solid white">ID</td>
                            <td  style="border: 1px solid white">Name</td>
                            <td  style="border: 1px solid white">code</td>
                            <td  style="border: 1px solid white">minimum student</td>
                            <td  style="border: 1px solid white">maximum student</td>

                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${courses}" var="csr" varStatus="csrstatus">
                            <tr>
                                <td  style="border: 1px solid white">${csr.getId()}</td>
                                <td  style="border: 1px solid white">${csr.getName()}</td>
                                <td  style="border: 1px solid white">${csr.getCode()}</td>
                                <td  style="border: 1px solid white">${csr.getMinStudent()}</td>
                                <td  style="border: 1px solid white">${csr.getMaxStudent()}</td>

                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    </table>

        </c:if>
    </div>
<%@ include file="footer.jsp"%>
</div>
</body>