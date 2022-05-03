<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Form</title>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <style>
        input[type=text] {
            width: 100%;
            border-radius: 4px;
            padding: 5px 5px;
            margin: 10px 0;
            box-sizing: border-box;
        }
        input[type=radio] {
            margin: 10px 0;
        }
        #form {
            border-radius: 10px;
            background-color: lightblue;
            padding: 20px;
            width: 300px;
            box-shadow: 10px 10px 5px lightgray
        }
        button[type=submit] {
            width: 25%;
            border-radius: 5px;
            padding: 5px;
            margin: 10px 0;
            box-sizing: border-box;
            background-color: lightblue;
        }
        button[type=submit]:hover {
            background-color: lightgreen;
            cursor: pointer;
        }
    </style>
</head>
<body>
<div id='form'>
    <form action="cookieServlet" method="get">
        <h3>Record Information</h3>
        <label for="uname">Your Name:</label><br/>
        <input id="uname" type="text" name="username" placeholder="your name..." autocomplete="off"
        value="${cookie.username.value}"><br/>
        <label for="pwd">Your Password:</label><br/>
        <input id="pwd" type="password" name="password" placeholder="your password..." autocomplete="off"
        value="${cookie.password.value}"><br/>
        <button type="submit">Login</button>
    </form>
</div>
</body>
</html>