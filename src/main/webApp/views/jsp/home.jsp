<%--suppress ALL --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE HTML>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Event Management</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f9fa;
            margin: 0;
            padding: 0;
        }
        .container {
            max-width: 800px;
            margin: 20px auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h1 {
            text-align: center;
            margin-bottom: 30px;
            color: #333;
        }
        .tab {
            overflow: hidden;
            border-radius: 5px;
            background-color: #007bff;
            margin-bottom: 20px;
        }
        .tab button {
            background-color: inherit;
            float: left;
            border: none;
            outline: none;
            cursor: pointer;
            padding: 10px 20px;
            transition: 0.3s;
            font-size: 18px;
            color: #fff;
        }
        .tab button:hover {
            background-color: #0056b3;
        }
        .tabcontent {
            display: none;
            padding: 20px;
            border-radius: 5px;
            border: 1px solid #ccc;
            margin-top: 20px;
        }
        input[type="text"], select {
            width: 100%;
            padding: 10px;
            margin: 5px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
        }
        input[type="submit"] {
            width: 100%;
            background-color: #28a745;
            color: #fff;
            padding: 10px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
            font-weight: bold;
        }
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            padding: 10px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #007bff;
            color: #fff;
        }
        a {
            text-decoration: none;
            color: #007bff;
        }
        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>

<div class="container">
    <h1>Event Management</h1>
    <jsp:useBean id="isEventDeleted" scope="request" type="java.lang.String"/>
    <div class="tab">
        <button class="tablinks" onclick="openTab(event, 'Add')">Create Event</button>
        <button class="tablinks" onclick="openTab(event, 'List')">Event List</button>
    </div>

    <div id="Add" class="tabcontent" style="display: block;">
        <h2>Create Event</h2>
        <jsp:useBean id="isEventCreated" scope="request" type="java.lang.String"/>
        <c:if test="${isEventCreated.equals('true')}">
            <p style="color: green">Event is successfully Created!</p>
        </c:if>
        <c:if test="${isEventCreated.equals('false')}">
            <p style="color: red">Failed to create new Event!</p>
        </c:if>
        <form action="./createEvent" method="GET">
            <label for="name">Event Name:</label>
            <input type="text" id="name" name="name" required>
            <label for="eventType">Event Type:</label>
            <select id="eventType" name="eventType" required>
                <jsp:useBean id="eventTypeList" scope="request" type="java.util.List"/>
                <c:forEach items="${eventTypeList}" var="eventType">
                    <option value="${eventType}">${eventType.label}</option>
                </c:forEach>
            </select>
            <input type="submit" value="Create">
        </form>
    </div>
</div>


<div class="container">
    <div id="List" class="tabcontent" style="display: ${isEventDeleted.equals('true') ? 'block' : 'none'}">
        <h2>Event List</h2>
        <c:if test="${isEventDeleted.equals('true')}">
            <p style="color: green">Event is successfully Deleted!</p>
        </c:if>
        <c:if test="${isEventDeleted.equals('false')}">
            <p style="color: red">Failed to delete new Event!</p>
        </c:if>
        <table>
            <thead>
            <tr>
                <th>Name</th>
                <th>Type</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
            <jsp:useBean id="eventList" scope="request" type="java.util.List"/>
            <c:forEach items="${eventList}" var="event">
                <c:set var="statusNull" value="${(event.status == null)}"/>
                <c:set var="statusOn" value="${(event.status == true)}"/>
                <c:set var="destinationFileNull" value="${(event.destinationFile == null)}"/>
                <tr>
                    <td>${event.name}</td>
                    <td>${event.eventType}</td>
                    <td><a href="./deleteEvent?name=${event.name}">Delete</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<script>
    function openTab(evt, tabName) {
        var i, tabcontent, tablinks;
        tabcontent = document.getElementsByClassName("tabcontent");
        for (i = 0; i < tabcontent.length; i++) {
            tabcontent[i].style.display = "none";
        }
        tablinks = document.getElementsByClassName("tablinks");
        for (i = 0; i < tablinks.length; i++) {
            tablinks[i].className = tablinks[i].className.replace(" active", "");
        }
        document.getElementById(tabName).style.display = "block";
        evt.currentTarget.className += " active";
    }
</script>

</body>
</html>
