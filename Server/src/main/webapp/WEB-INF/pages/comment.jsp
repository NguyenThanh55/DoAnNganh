<%-- 
    Document   : comment
    Created on : 6 thg 9, 2023, 20:08:53
    Author     : vbmho
--%>

<%-- 
    Document   : banner
    Created on : 5 thg 9, 2023, 15:31:23
    Author     : vbmho
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:url value="/admin/comments" var="action" />
<section class="container">
    <h1 class="text-center text-success mt-1">DANH SÁCH BÌNH LUẬN</h1>
        <!--<a href="< value="/admin/comments/add"/>" class="btn btn-success mt-1 mb-1">THÊM BÌNH LUẬN</a>-->

    <c:if test="${pages > 1}">
        <ul class="pagination mt-1">


            <c:url value="/admin/comments" var="pageUrl">
                <c:param name="page" value="0" /> 
            </c:url>
            <li class="page-item"><a class="page-link" href="${pageUrl}">Tất cả</a></li>

            <c:forEach begin="1" end="${pages}" var="i">
                <c:url value="/admin/comments" var="pageUrl">
                    <c:param name="page" value="${i}" /> 
                </c:url>
                <li class="page-item"><a class="page-link" href="${pageUrl}">${i}</a></li>
                </c:forEach>
        </ul>

    </c:if>
        
    <form class="d-flex mb-3" action="${action}">

        <input class="form-control me-2" name="postId" type="text" placeholder="Nhập ID bài viết">
        <button class="btn btn-primary" type="submit">Tìm</button>
    </form>


    <table class="table table-hover rounded-pill" style="width:100%">
        <thead class="table-dark">
            <tr>
                <th class="text-center" style="width:10%">ID</th>
                <th class="text-center" colspan="2" style="width:50%">NỘI DUNG</th>
                <th class="text-center" style="width:10%">POST ID</th>
                <th class="text-center" style="width:10%">TÀI KHOẢN</th>
                <th class="text-center" style="width:10%">Cập nhật</th>
                <th class="text-center" style="width:10%">Xóa</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${comments}" var="c">
                <tr>
                    <td class="text-center">${c.id}</td>
                    <td colspan="2">${c.content}</td>
                    <td class="text-center">${c.postId.id}</td>
                    <td class="text-center">${c.userId.username}</td>
                    <c:url value="/admin/comments/add/${c.id}" var="api" />
                    <td class="text-center">
                        <a href="${api}" class=" btn btn-success">Cập nhật</a>
                    </td>
                    <td class="text-center">
                        <c:url value="/api/comments/${c.id}" var="apiDelete" />
                        <button class="btn btn-danger text-center" onclick="deleteComment('${apiDelete}')">Xóa</button>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</section>
<script src="<c:url value="/js/main.js"/>"></script>