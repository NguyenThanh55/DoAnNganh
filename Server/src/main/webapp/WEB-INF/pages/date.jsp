<%-- 
    Document   : date
    Created on : 8 thg 9, 2023, 18:49:03
    Author     : vbmho
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:url value="/admin/setdate" var="action" />
<section class="container">
    <h1 class="text-center text-success mt-1">THỜI GIAN ĐẶT CÂU HỎI</h1>
    <h3 class="mt-1">${date}</h3>
    <form action="${action}" method="post">
            <div class="mt-3">
                <label for="title"><b>Đặt câu hỏi trước ngày</b></label>
                <div class="mt-1">
                    <input class="form-control me-2" name="date" path="date" type="text" placeholder="yyyy-MM-dd">
                </div>
            </div>
            <div class="form-floating mb-3 mt-3">
                <button class="btn btn-info mt-1" type="submit">Cập nhật</button>
            </div>
        </form>
</section>
<script src="<c:url value="/js/main.js"/>"></script>