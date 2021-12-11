<%--
  Created by IntelliJ IDEA.
  User: cjjc2
  Date: 2021-11-15
  Time: 8:35 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>


    <title>My page</title>
    <style>
        h1 {
            text-align:center;
            background-color: cyan;

        }

        .btn {

            width: 100%;
        }

    </style>
</head>
<script>
    function myFunction(){document.getElementById("mes").innerHTML=""};
</script>


<h1>Savings</h1>

<div class="container">

    <form method="GET">
        <div class="form-group">
            <label for="cnum">Customer Number:</label>
            <input type="text" name="custno" class="form-control" id="cnum" value="${id}">
        </div>
        <div class="form-group">
            <label for="cname">Customer Name:</label>
            <input type="text" name="custname" class="form-control" id="cname" value="${name}">
        </div>
        <div class="form-group">
            <label for="cdepo">Customer Deposit:</label>
            <input type="number" name="cdep" class="form-control" id="cdepo" value="${deposit}">
        </div>
        <div class="form-group">
            <label for="noyears">Number of years:</label>
            <input type="number" name="nyears" class="form-control" id="noyears" value="${years}">
        </div>
        <div class="form-group">
            <label for="stype">Saving Type:</label>
            <input type="text" name="savtype" class="form-control" id="stype" value="${type}">
        </div>

        <a class="btn btn-success" href="add-todo">Add</a>


    </form>

    <h1 id="mes">${errorMessage}</h1>

    <div class="container2">
        <h2>Customers</h2>

        <table class="table table-striped">
            <thead>
            <tr>
                <th>Customer Number</th>
                <th>Customer Name</th>
                <th>Customer Deposit</th>
                <th>Number of years</th>
                <th>Saving Type</th>
            </tr>
            </thead>
            <tbody>

            <c:forEach items="${todos}" var="todo">
                <tr>
                    <td>${todo.custno}</td>
                    <td>${todo.custname}</td>
                    <td>${todo.cdep}</td>
                    <td>${todo.nyears}</td>
                    <td>${todo.savtype}</td>

                    <td>    <a type="button" class="btn btn-primary" onmouseover="function2()"
                               href="update-todo?id=${todo.custno}" >Edit</a> </td>

                    <td>    <a type="button" class="btn btn-primary" onClick="return confirm('Are you sure you want to delete the record ?')"   id="p"
                               href="delete-todo?id=${todo.custno}"  >Delete</a>

                    <td>

                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<
</html>



