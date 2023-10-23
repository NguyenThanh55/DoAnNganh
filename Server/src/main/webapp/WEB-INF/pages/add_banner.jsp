<%-- 
    Document   : add_banner
    Created on : 5 thg 9, 2023, 15:35:48
    Author     : vbmho
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:url value="/admin/banners/add" var="action" />
<section class="container">
    


        <c:if test="${errMsg != null}">
            <div class="alert alert-danger">
                ${errMsg}
            </div>
        </c:if>
        <form:form action="${action}" method="post" modelAttribute="banner" enctype="multipart/form-data">
            <form:errors path="*" element="div" cssClass="alert alert-danger" />

            <form:hidden path="id" />
            <c:choose>
                <c:when test="${banner.id != null}">
                    <h1 class="text-center text-success mt-1">CẬP NHẬT BANNER</h1>
                </c:when>
                <c:otherwise>
                    <h1 class="text-center text-success mt-1">THÊM BANNER</h1>
                </c:otherwise>
            </c:choose>
            <div class="mt-3">
                <label for="title"><b>Tiêu đề</b></label>
                <div class="mb-3">
                    <form:input type="text" class="form-control" path="title" required="required" id="title"  />

                </div>
            </div>


            <c:choose>
                <c:when test="${banner.url == null}">
                    <label for="file">Chọn banner:</label>
                    <form:input type="file" id="file" path="file" accept=".jpg, .jpeg, .png"/>
                </c:when>
                <c:otherwise>
                    <label for="url"><b>Đường dẫn</b></label>
                    <form:input type="text" class="form-control" path="url" required="required" id="url"/>
                </c:otherwise>
            </c:choose>


            <div class="form-floating mb-3 mt-3">
                <button class="btn btn-info mt-1" type="submit">
                    <c:choose>
                        <c:when test="${banner.id != null}">
                            Cập nhật
                        </c:when>
                        <c:otherwise>
                            Thêm banner
                        </c:otherwise>
                    </c:choose>
                </button>
            </div>


        </form:form>
</section>
<script src="<c:url value="/js/main.js"/>"></script>
