<%-- 
    Document   : question_admin
    Created on : Sep 9, 2023, 1:49:54 AM
    Author     : Thanh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:url value="/admin/questions" var="action" />
<section class="container">
    <h1 class="text-center text-success mt-1">DANH SÁCH CÂU HỎI</h1>

    <c:if test="${pages > 1}">
        <ul class="pagination mt-1">


            <c:url value="/admin/questions" var="pageUrl">
                <c:param name="page" value="0" /> 
            </c:url>
            <li class="page-item"><a class="page-link" href="${pageUrl}">Tất cả</a></li>

            <c:forEach begin="1" end="${pages}" var="i">
                <c:url value="/admin/questions" var="pageUrl">
                    <c:param name="page" value="${i}" /> 
                </c:url>
                <li class="page-item"><a class="page-link" href="${pageUrl}">${i}</a></li>
                </c:forEach>
        </ul>

    </c:if>


    <table class="table table-hover rounded-pill" style="width:100%">
        <thead class="table-dark">
            <tr>
                <!--<th class="text-center" style="width:15%">Id  </th>-->
                <th class="text-center" colspan="2" style="width:60%">Nội dung</th>
                <th class="text-center" style="width:30%">Người đặt câu hỏi</th>
                <th class="text-center" style="width:10%">Xóa</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${questions}" var="d">
                <tr>
                    <td colspan="2">${d.content}</td>
                    <td class="text-center">${d.userId.firstName}</td>
                    <td class="text-center">
                        <c:url value="/api/questions/${d.id}" var="apiDelete" />
                        <button class="btn btn-danger text-center" onclick="deleteQuestion('${apiDelete}')">Xóa</button>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</section>
<script src="<c:url value="/js/main.js"/>"></script>
