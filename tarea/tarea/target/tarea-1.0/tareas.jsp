<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="com.umariana.tarea.Registro" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="templates/header.jsp" %>

<head>
    <meta charset="UTF-8">
    <title>Tareas</title>
</head>
<body>
    <% String nombre = request.getParameter("nombre");%>
    <p>Bienvenido a tu página de tareas, <%= nombre %>!<p>
    <p>Aquí puedes ver y gestionar tus tareas.</p>

    <!-- Agrega enlaces o botones para que el usuario pueda realizar otras acciones relacionadas con las tareas -->
    <!-- Por ejemplo, editar o eliminar tareas -->
</body>
<%@include file="templates/footer.jsp" %>