<%-- 
    Document   : add_product
    Created on : 8 thg 8, 2023, 21:47:35
    Author     : vbmho
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:url value="/admin/post/add" var="action" />
<section class="container">
    
    <!--    <div class="mt-3">-->

    <c:if test="${errMsg != null}">
        <div class="alert alert-danger">
            ${errMsg}
        </div>
    </c:if>
    <form:form action="${action}" method="post" modelAttribute="post" enctype="multipart/form-data">
        <c:choose>
            <c:when test="${post.id != null}">
                <h1 class="text-center text-success mt-1">CẬP NHẬT BÀI ĐĂNG</h1>
            </c:when>
            <c:otherwise>
                <h1 class="text-center text-success mt-1">THÊM BÀI ĐĂNG</h1>
            </c:otherwise>
        </c:choose>
        <form:errors path="*" element="div" cssClass="alert alert-danger" />

        <form:hidden path="id" />
        <div class="mt-3">
            <label for="title"><b>Tiêu đề</b></label>
            <div class="form-floating mb-3">
                <form:input type="text" class="form-control" required="required" path="title" id="title"  />

            </div>
        </div>

        <div class="mt-3">
            <label for="typeoftrainningId"><b>Hệ đào tạo</b></label>
            <div class="form-floating mt-1">
                <form:select class="form-select" id="type" name="type" required="required" path="typeoftrainningId.id">
                    <c:forEach items="${types}" var="t">
                        <c:choose>
                            <c:when test="${t.id == post.typeoftrainningId.id}">
                                <option value="${t.id}" selected>${t.name}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${t.id}">${t.name}</option>
                            </c:otherwise>
                        </c:choose>

                    </c:forEach>
                </form:select>
            </div>
        </div>

        <div class="mt-3">
            <label for="content"><b>Nội dung bài đăng</b></label>
            <div class="mt-1 mb-3">
                <form:textarea rows = "15"  class="form-control" path="content" id="content"/>
            </div>
        </div>

        <div class="mt-3">
            <label for="file">Ảnh</label>
            <div class="mt-1 mb-3">
                <form:input type="file" id="file" path="file"/>
            </div>
        </div>
        <div class="form-floating mb-3 mt-3">
            <button class="btn btn-info mt-1" type="submit">
                <c:choose>
                    <c:when test="${post.id != null}">
                        Cập nhật bài đăng
                    </c:when>
                    <c:otherwise>
                        Thêm bài đăng
                    </c:otherwise>
                </c:choose>
            </button>
        </div>


    </form:form>
    <script>
        ClassicEditor
                .create(document.querySelector('#content'))
                .catch(error => {
                    console.error(error);
                });
    </script>
</section>

