<%-- 
    Document   : add_comment
    Created on : 6 thg 9, 2023, 20:09:07
    Author     : vbmho
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:url value="/admin/comments/add" var="action" />
<section class="container">

    <div class="mt-3">

        <c:if test="${errMsg != null}">
            <div class="alert alert-danger">
                ${errMsg}
            </div>
        </c:if>
        <form:form action="${action}" method="post" modelAttribute="comment">
            <form:errors path="*" element="div" cssClass="alert alert-danger" />

            <form:hidden path="id" />
            <c:choose>
                <c:when test="${comment.id != null}">
                    <h1 class="text-center text-success mt-1">CẬP NHẬT BÌNH LUẬN</h1>
                </c:when>
                <c:otherwise>
                    <h1 class="text-center text-success mt-1">THÊM BÌNH LUẬN</h1>
                </c:otherwise>
            </c:choose>
            <div class="mt-3">
                <label for="title"><b>Nội dung</b></label>
                <div class="mb-3">
                    <form:input type="text" class="form-control" path="content" id="content" required="required" />
                </div>
            </div>

            <div class="mt-3">
                <label for="title"><b>Người bình luận</b></label>
                <div class="mb-3">
                    <form:input type="text" class="form-control" path="userId" id="userId" required="required" />
                </div>
            </div>

            <div class="mt-3">
                <label for="title"><b>Bài viết</b></label>
                <div class="mb-3">
                    <form:input type="text" class="form-control" path="postId" value="${comment.postId.id}" id="postId"  required="required"/>
                </div>
            </div>

            <div class="mt-3">
                <label for="title"><b>Trả lời bình luận</b></label>
                <div class="mb-3">
                    <form:input type="text" class="form-control" path="reply" id="reply"  />
                </div>
            </div>



            <div class="form-floating mb-3 mt-3">
                <button class="btn btn-info mt-1" type="submit">
                    <c:choose>
                        <c:when test="${comment.id != null}">
                            Cập nhật
                        </c:when>
                        <c:otherwise>
                            Thêm bình luận
                        </c:otherwise>
                    </c:choose>
                </button>
            </div>


        </form:form>
</section>
<script src="<c:url value="/js/main.js"/>"></script>