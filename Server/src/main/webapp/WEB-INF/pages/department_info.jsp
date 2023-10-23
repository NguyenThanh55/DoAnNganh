<%-- 
    Document   : department_info
    Created on : Jul 27, 2023, 3:17:50 PM
    Author     : Thanh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<section class="container" style="margin-top: 150px">
    <h2 style="text-align: center">${department.name}</h2>
    <div class="container-fluid mt-3">
        <div class="container">
            <p>${department.description}</p>
            <p>${department.educationProgram}</p>
            <p>${department.website}</p>
            <p>${department.averageScore}</p>
        </div>
    </div><!-- comment -->
</section>