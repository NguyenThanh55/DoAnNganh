<%-- 
    Document   : add_livestream
    Created on : Sep 9, 2023, 12:40:23 AM
    Author     : Thanh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:url value="/admin/livestreams/add" var="action" />
<section class="container">
 
    <div class="mt-3">

        <c:if test="${errMsg != null}">
            <div class="alert alert-danger">
                ${errMsg}
            </div>
        </c:if>
        <form:form action="${action}" method="post" modelAttribute="livestream">
            <form:errors path="*" element="div" cssClass="alert alert-danger" />

            <form:hidden path="id" />
            <c:choose>
                <c:when test="${livestream.id != null}">
                    <h1 class="text-center text-success mt-1">CẬP NHẬT THÔNG BÁO LIVESTREAM</h1>
                </c:when>
                <c:otherwise>
                       <h1 class="text-center text-success mt-1">THÊM THÔNG BÁO LIVESTREAM</h1>
                </c:otherwise>
            </c:choose>
            <div class="mt-3">
                <label for="title"><b>Tên thông báo livestream</b></label>
                <div class="form-floating mb-3">
                    <form:input type="text" class="form-control" path="title" required="required" id="title"  />
                </div>
            </div>

            <div class="mt-3">
                <label for="content"><b>Nội dung</b></label>
                <div class="mb-3">
                    <form:textarea rows="5" class="form-control" path="content" required="required" id="content"/>
                </div>
            </div>
            <div class="mt-3">
                <label for="dod">Hạn cho phép đặt câu hỏi:</label>
                <div class="mb-3">
                    <form:input type="date" id="date" required="required" path="date"/>
                </div>
            </div>
            <div class="form-floating mb-3 mt-3">
                <button class="btn btn-info mt-1" type="submit">
                    <c:choose>
                        <c:when test="${livestream.id != null}">
                            Cập nhật
                        </c:when>
                        <c:otherwise>
                            Thêm live
                        </c:otherwise>
                    </c:choose>
                </button>
            </div>


        </form:form>
</section>
<script src="<c:url value="/js/main.js"/>"></script>