<%-- 
    Document   : totn
    Created on : 14 thg 8, 2023, 21:17:45
    Author     : vbmho
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<section class="container">
    <h1 class="text-center text-success mt-1">DANH SÁCH HỆ ĐÀO TẠO</h1>
        <a href="<c:url value="/admin/typeoftrainnings/add"/>" class="btn btn-success mt-1 mb-1">THÊM HỆ ĐÀO TẠO</a>


    <table class="table table-hover rounded-pill" style="width:100%">
        <thead class="table-dark">
            <tr>
                <th class="text-center" style="width:20%">ID</th>
                <th class="text-center" colspan="2" style="width:60%">Hệ đào tạo</th>
                <th class="text-center" style="width:10%">Cập nhật</th>
                <th class="text-center" style="width:10%">Xóa</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${types}" var="t">
                <tr>
                    <td class="text-center">${t.id}</td>
                    <td colspan="2">${t.name}</td>
                    <c:url value="/admin/typeoftrainnings/add/${t.id}" var="api" />
                    <td class="text-center">
                        <a href="${api}" class=" btn btn-success">Cập nhật</a>
                    </td>
                    <td class="text-center">
                        <c:url value="/api/admin/typeoftrainnings/${t.id}" var="apiDelete" />
                        <button class="btn btn-danger text-center" onclick="deleteTypeoftrainning('${apiDelete}')">Xóa</button>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</section>
<script src="<c:url value="/js/main.js"/>"></script>