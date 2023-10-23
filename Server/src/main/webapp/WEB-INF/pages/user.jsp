<%-- 
    Document   : user
    Created on : 17 thg 8, 2023, 20:24:14
    Author     : vbmho
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<section class="container">
    <h1 class="text-center text-success mt-1">DANH SÁCH NGƯỜI DÙNG</h1>
        <a href="<c:url value="/admin/user/register"/>" class="btn btn-success mt-1 mb-1">THÊM NGƯỜI DÙNG</a>


    <table class="table table-hover rounded-pill" >
        <thead class="table-dark">
            <tr>
                <th class="text-center" style="width:10%">ID</th>
                <th class="text-center" style="width:10%">First_name</th>
                <th class="text-center" style="width:10%">Last_name</th>
                <th class="text-center" style="width:10%">Email</th>
                <th class="text-center" style="width:10%">Phone</th>
                <th class="text-center" style="width:10%">Username</th>
                <th class="text-center" style="width:10%">User_role</th>
                <th class="text-center" style="width:10%">Cập nhật</th>
                <th class="text-center" style="width:10%">Xóa</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${users}" var="u">
                <tr>
                    <td class="text-center">${u.id}</td>
                    <td class="text-center">${u.firstName}</td>
                    <td class="text-center">${u.lastName}</td>
                    <td class="text-center">${u.email}</td>
                    <td class="text-center">${u.phone}</td>
                    <td class="text-center">${u.username}</td>
                    <td class="text-center">${u.userRole}</td>
                    
                    
                    
                    
                    <c:url value="/admin/user/add/${u.id}" var="api" />
                    <td class="text-center">
                        <a href="${api}" class=" btn btn-success">Cập nhật</a>
                    </td>
                    <td class="text-center">
                        <c:url value="/api/admin/user/${u.id}" var="apiDelete" />
                        <button class="btn btn-danger text-center" onclick="deleteUser('${apiDelete}')">Xóa</button>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</section>
<script src="<c:url value="/js/main.js"/>"></script>
