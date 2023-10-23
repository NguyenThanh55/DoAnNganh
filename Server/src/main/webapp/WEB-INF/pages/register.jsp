<%-- 
    Document   : register
    Created on : 31 thg 7, 2023, 12:22:27
    Author     : vbmho
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="bootstrap.min.css" />
    <link href="https://tuyensinh.ou.edu.vn/core/mdb/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="<c:url value="https://www.w3schools.com/w3css/4/w3.css"/>" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <title>
        <tiles:insertAttribute name="title" />
    </title>

</head>
<style>
    * {
        box-sizing: border-box
    }

    /* Add padding to containers */

    /* Full-width input fields */
    input[type=text], input[type=password] {
        width: 100%;
        padding: 15px;
        margin: 5px 0 22px 0;
        display: inline-block;
        border: none;
        background: #f1f1f1;
    }

    input[type=text]:focus, input[type=password]:focus {
        background-color: #ddd;
        outline: none;
    }

    /* Overwrite default styles of hr */
    hr {
        border: 1px solid #f1f1f1;
        margin-bottom: 25px;
    }

    /* Set a style for the submit/register button */
    .registerbtn {
        background-color: #04AA6D;
        color: white;
        padding: 16px 20px;
        margin: 8px 0;
        border: none;
        cursor: pointer;
        width: 100%;
        opacity: 0.9;
        font-size: 20px;
    }

    .registerbtn:hover {
        opacity:1;
    }

    /* Add a blue text color to links */
    a {
        color: dodgerblue;
    }

    /* Set a grey background color and center the text of the "sign in" section */
    .signin {
        background-color: #f1f1f1;
        text-align: center;
    }
</style>


<c:url value="/user/register" var="register" />
<sec:authorize access="hasAuthority('ADMIN')">
    <c:url value="/admin/user/register" var="register" />
</sec:authorize>

<div class="container mt-3">

    
    <c:choose>
            <c:when test="${user.id == null}">
                <h1>Đăng ký </h1>
            </c:when>
            <c:otherwise>
               <h1>Cập nhật tài khoản</h1>
            </c:otherwise>
        </c:choose>
    


    <c:if test="${errMsg != null}">
        <div class="alert alert-danger">
            ${errMsg}
        </div>
    </c:if>
    <c:if test="${sucMsg != null}">
        <div class="alert alert-primary">
            ${sucMsg}
        </div>
    </c:if>
    <hr>
    <form:form action="${register}" method="post" modelAttribute="user">
        <form:hidden path="id" />

        <label for="first_name"><b>Tên</b></label>
        <form:input type="text" placeholder="Nhập tên"  path="firstName" required="required" autocomplete="off" id="first_name"  />

        <label for="last_name"><b>Họ</b></label>
        <form:input type="text" placeholder="Nhập họ" path="lastName" required="required" autocomplete="off" id="last_name"/>

        <label for="email"><b>Địa chỉ Email</b></label>
        <form:errors path="email" element="div" cssClass="text-danger" />
        <form:input type="text" placeholder="Nhập email" path="email" autocomplete="off" id="email"/>

        <label for="phone"><b>Số điện thoại</b></label>
        <form:errors path="phone" element="div" cssClass="text-danger" />
        <form:input type="text" placeholder="Nhập số điện thoại" path="phone" autocomplete="off" id="phone"/>

        <label for="username"><b>Tên đăng nhập</b></label>
        <form:input type="text" placeholder="Nhập tên tài khoản" path="username" required="required" autocomplete="off" id="username"/>

        <c:choose>
            <c:when test="${user.id == null}">
                <label for="password"><b>Mật khẩu</b></label>
                <form:errors path="password" element="div" cssClass="text-danger" />
                <form:input type="password" placeholder="Nhập mật khẩu" path="password" required="required" autocomplete="off" id="password"/>
            </c:when>
            <c:otherwise>
                <label for="password"><b>Mật khẩu</b></label>
                <form:errors path="password" element="div" cssClass="text-danger" />
                <form:input type="password" placeholder="Nhập mật khẩu" path="password" readonly="true" autocomplete="off" id="password" />
            </c:otherwise>
        </c:choose>



        <c:if test="${user.id == null}">
            <label for="confirm-password"><b>Nhập lại mật khẩu</b></label>
            <form:errors path="confirmPassword" element="div" cssClass="text-danger" />
            <form:input type="password" placeholder="Nhập lại mật khẩu" path="confirmPassword" required="required" autocomplete="off" id="confirm-password"/>
        </c:if>



        <sec:authorize access="hasAuthority('ADMIN')">
            <label for="user-role">Quyền</label>
            <form:select class="form-select mb-3" id="userRole" name="userRole" path="userRole">
                <c:forEach items="${roles}" var="r">
                    <c:choose>
                        <c:when test="${r == user.userRole}">
                            <option value="${r}" selected>${r}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${r}">${r}</option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </form:select>
        </sec:authorize>


        <p>Thông tin & chính sách sử dụng <a href="#">OUAdmissions</a>.</p>
        <c:choose>
            <c:when test="${user.id != null}">
                <button type="submit" class="registerbtn">Cập nhật</button>
            </c:when>
            <c:otherwise>
                <button type="submit" class="registerbtn">Đăng ký</button>
            </c:otherwise>
        </c:choose>



        <c:if test="${pageContext.request.userPrincipal.name == null}">
            <div class="signin">
                <p>Bạn đã có tài khoản? <a href="#">Đăng nhập</a>.</p>
            </div>
        </c:if>

    </form:form>
</div>

