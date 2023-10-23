<%-- 
    Document   : livestream_admin
    Created on : Sep 8, 2023, 6:33:26 PM
    Author     : Thanh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:url value="/admin/livestreams" var="action" />
<section class="container">
    <h1 class="text-center text-success mt-1">DANH SÁCH THÔNG BÁO LIVESTREAM</h1>
        <a href="<c:url value="/admin/livestreams/add"/>" class="btn btn-success mt-1">THÊM THÔNG BÁO LIVESTREAM</a>

    <c:if test="${pages > 1}">
        <ul class="pagination mt-1">


            <c:url value="/admin/livestreams" var="pageUrl">
                <c:param name="page" value="0" /> 
            </c:url>
            <li class="page-item"><a class="page-link" href="${pageUrl}">Tất cả</a></li>

            <c:forEach begin="1" end="${pages}" var="i">
                <c:url value="/admin/livestreams" var="pageUrl">
                    <c:param name="page" value="${i}" /> 
                </c:url>
                <li class="page-item"><a class="page-link" href="${pageUrl}">${i}</a></li>
                </c:forEach>
        </ul>

    </c:if>


    <table class="table table-hover rounded-pill" style="width:100%">
        <thead class="table-dark">
            <tr>
                <th class="text-center" style="width:20%">Tiêu đề Livestream</th>
                <th class="text-center" colspan="2" style="width:50%">Nội dung</th>
                <th class="text-center" style="width:10%">Ngày phát</th>
                <th class="text-center" style="width:10%">Cập nhật</th>
                <th class="text-center" style="width:10%">Xóa</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${livestreams}" var="d">
                <tr>
                    <td class="text-center">${d.title}</td>
                    <td class="text-center" colspan="2">${d.content}</td>
                    <td class="text-center">${d.date}</td>
                    <c:url value="/admin/livestreams/add/${d.id}" var="api" />
                    <td class="text-center">
                        <a href="${api}" class=" btn btn-success">Cập nhật</a>
                    </td>
                    <td class="text-center">
                        <c:url value="/api/admin/livestreams/${d.id}" var="apiDelete" />
                        <button class="btn btn-danger text-center" onclick="deleteLivestream('${apiDelete}')">Xóa</button>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</section>
<script src="<c:url value="/js/main.js"/>"></script>
