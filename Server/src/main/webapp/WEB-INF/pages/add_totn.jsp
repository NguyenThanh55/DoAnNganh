<%-- 
    Document   : add_totn
    Created on : 14 thg 8, 2023, 21:22:28
    Author     : vbmho
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:url value="/admin/typeoftrainnings/add" var="action" />
<section class="container">

    <div class="mt-3">

        <c:if test="${errMsg != null}">
            <div class="alert alert-danger">
                ${errMsg}
            </div>
        </c:if>
        <form:form action="${action}" method="post" modelAttribute="totn">
            <form:errors path="*" element="div" cssClass="alert alert-danger" />

            <form:hidden path="id" />
            <c:choose>
                <c:when test="${totn.id != null}">
                    <h1 class="text-center text-success mt-1">CẬP NHẬT HỆ ĐÀO TẠO</h1>
                </c:when>
                <c:otherwise>
                    <h1 class="text-center text-success mt-1">THÊM HỆ ĐÀO TẠO</h1>
                </c:otherwise>
            </c:choose>
            <div class="mt-3">
                <label for="title"><b>Tên hệ đào tạo</b></label>
                <div class="form-floating mb-3">
                    <form:input type="text" class="form-control" required="required" path="name" id="name"  />

                </div>
            </div>


            <div class="form-floating mb-3 mt-3">
                <button class="btn btn-info mt-1" type="submit">
                    <c:choose>
                        <c:when test="${totn.id != null}">
                            Cập nhật
                        </c:when>
                        <c:otherwise>
                            Thêm hệ đào tạo
                        </c:otherwise>
                    </c:choose>
                </button>
            </div>


        </form:form>
</section>
<script src="<c:url value="/js/main.js"/>"></script>
