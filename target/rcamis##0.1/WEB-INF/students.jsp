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
    <title>Student Registrations</title>
</head>
<style>

    table {
        border-collapse: collapse;
        width: 50%;
        border-spacing: 1rem;
        margin-left: 20%;
    }
</style>
<body style="margin: 0px; height: 100vh; width: 100%; overflow: hidden">
<div id="layout" style="height: 100vh; background: black; padding: 10px">
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

                <a href="createstudent.php?page=createstudent"><button>
                    <img src="icons/user_add.png" /> Add new Student
                </button></a>
            </div>
            <div class="search">
                <form action="listuser.php" method="get" style="float: right;margin-top: -20px">
<%--                    <table style="float: right;">--%>
<%--                        <tr>--%>
<%--                            <td style="color: #fff;">Enter User ID</td>--%>
<%--                            <td><input type="text" name="id" id="id" />--%>
<%--                            <button type=le'submit' name="userregistrationsearch"--%>
<%--                                        value='search'></button></td>--%>
<%--                        </tr>--%>
<%--                    </table>--%>

    <label for="userID">Enter User ID</label>
    <input type="text" name="id" id="userID"/>
                    <button type="submit" name="userregistrationsearch" style="margin-right: 10px" >Search</button>


                </form>
            </div>
            <hr />
                <table class="table table-bordered" style="align-items: center; margin-top: 60px">
                    <thead>
                    <tr>
<%--                        <td>ID</td>--%>
                        <td style="border: 1px solid white">Firstname</td>
                        <td style="border: 1px solid white">Lastname</td>
                        <td style="border: 1px solid white">Gender </td>
                        <td style="border: 1px solid white">Email</td>
<%--                        <td>isInternational</td>--%>
                        <td style="border: 1px solid white">Address Id</td>
                        <td style="border: 1px solid white">Phone number</td>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${students}" var="std" varStatus="stdstatus">
                        <tr>
<%--                            <td>${std.getId()}</td>--%>
                            <td style="border: 1px solid white">${std.getFirstName()}</td>
                            <td style="border: 1px solid white">${std.getLastName()}</td>
                            <td style="border: 1px solid white">${std.getGender()}</td>
                            <td style="border: 1px solid white">${std.getEmail()}</td>
                            <td style="border: 1px solid white">${std.getAddress().getId()}</td>
                            <td style="border: 1px solid white">${std.getPhoneNumber()}</td>
<%--                            <td><a href="editstudent.php?page=editstudent">Edit</a></td>--%>
<%--                            <td><a href="deleteuser.php?page=deleteuser">Delete</a></td>--%>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </form>
        </c:if>
    </div>
<%@ include file="footer.jsp"%>