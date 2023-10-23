<%-- 
    Document   : admin.jsp
    Created on : 2 thg 8, 2023, 17:07:30
    Author     : vbmho
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:url value="/admin/post" var="action" />
<section class="container">
    <h1 class="text-center text-success mt-1">DANH SÁCH BÀI ĐĂNG</h1>
    <a href="<c:url value="/admin/post/add"/>" class="btn btn-success mt-1">Thêm bài đăng</a>

    <c:if test="${pages > 1}">
        <ul class="pagination mt-1">
            <c:url value="/admin/post" var="pageUrl">
                <c:param name="page" value="0" /> 
            </c:url>
            <li class="page-item"><a class="page-link" href="${pageUrl}">Tất cả</a></li>


            <c:forEach begin="1" end="${pages}" var="i">
                <c:url value="/admin/post" var="pageAction">
                    <c:param name="page" value="${i}" /> 
                </c:url>
                <li class="page-item"><a class="page-link" href="${pageAction}">${i}</a></li>
                </c:forEach>
        </ul>

    </c:if>

    <div id="buttons" class="mb-3">
        <c:if test="${typeOfTrainningId == null}">
            <a class="btn btn-outline-primary button-value active"  href="${action}">Tất cả</a>
        </c:if>
        <c:if test="${typeOfTrainningId != null}">
            <a class="btn btn-outline-primary button-value" href="${action}">Tất cả</a>
        </c:if>

       
        <c:forEach items="${types}" var="t">
            <c:url value="/admin/post" var="typeAction">
                <c:param name="typeOfTrainningId" value="${t.id}" /> 
            </c:url>

            <c:choose>
                <c:when test="${typeOfTrainningId == t.id}">
                    <a class="btn btn-outline-primary button-value active" href="${typeAction}">${t.name}</a>
                </c:when>
                <c:otherwise>
                    <a class="btn btn-outline-primary button-value" href="${typeAction}">${t.name}</a>
                </c:otherwise>
            </c:choose>
        </c:forEach>
    </div>

    <form class="d-flex mb-3" action="${action}">

        <input class="form-control me-2" name="kw" type="text" placeholder="Nhập từ khóa...">
        <button class="btn btn-primary" type="submit">Tìm</button>
    </form>

    <table class="table table-hover rounded-pill" style="width:100%">
        <thead class="table-dark">
            <tr>
                <th class="text-center" style="width:10%">ID</th>
                <th class="text-center" colspan="2" style="width:60%">Tiêu đề</th>
                <th class="text-center" style="width:10%">Hệ đào tạo</th>
                <th class="text-center" style="width:10%">Cập nhật</th>
                <th class="text-center" style="width:10%">Xóa</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${posts}" var="p">
                <tr>
                    <td class="text-center">${p.id}</td>
                    <td colspan="2">${p.title}</td>
                    <td>${p.typeoftrainningId.name}</td>
                    <c:url value="/admin/post/add/${p.id}" var="api" />
                    <td class="text-center">
                        <a href="${api}" class=" btn btn-success">Cập nhật</a>
                    </td>
                    <td class="text-center">
                        <c:url value="/api/admin/post/${p.id}" var="apiDelete" />
                        <button class="btn btn-danger text-center" onclick="deletePost('${apiDelete}')">Xóa</button>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</section>
<script src="<c:url value="/js/main.js"/>"></script>
