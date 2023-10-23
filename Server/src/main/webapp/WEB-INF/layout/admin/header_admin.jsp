<%-- 
    Document   : header_admin
    Created on : 2 thg 8, 2023, 17:08:35
    Author     : vbmho
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <div class="container">
        <a class="navbar-brand" href="#">OUAdmissions</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="collapsibleNavbar">
            <ul class="navbar-nav me-auto">
                <li class="nav-item">
                    <c:url value="/admin/index/cate" var="cateId">
                        <c:param name="cateId" value="0" />
                    </c:url>
                    <a class="nav-link" href="${cateId}">Thống kê</a>
                </li>
                <c:forEach items="${cates}" var="c">
                    <c:url value="/admin/index/cate" var="cateId">
                        <c:param name="cateId" value="${c.id}" /> 
                    </c:url>
                    <li class="nav-item">
                        <a class="nav-link" href="${cateId}">${c.name}</a>
                    </li>
                </c:forEach>
                 <li class="nav-item">
                    <c:url value="/admin/index/cate" var="cateId">
                        <c:param name="cateId" value="9" />
                    </c:url>
                    <a class="nav-link" href="${cateId}#">Thời gian hỏi</a>
                </li>
                <c:if test="${pageContext.request.userPrincipal.name != null}">
                    <li><a class="nav-link" href="#">${pageContext.request.userPrincipal.name}</a></li>
                    <li><a class="nav-link" href="<c:url value="/logout" />">Đăng xuất</a></li>
                </c:if>
            </ul>
            
        </div>
    </div>
</nav>
