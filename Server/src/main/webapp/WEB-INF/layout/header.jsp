<%-- 
    Document   : header
    Created on : Jul 25, 2023, 3:36:11 PM
    Author     : Thanh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<nav class="navbar navbar-expand-sm bg-dark navbar-light fixed-top" style="margin-bottom: 0px; border-radius: 0;
     padding-top: 0px; margin-top: 0px">
    <div class="collapse navbar-collapse ml-auto m-mainmenu-nav" >
        <ul class="navbar-nav text-center m-mainmenu" style="width: 70%">
            <li class="nav-item" style="width: 15%">
                <a class="nav-link active" href="#">
                    <img src="<c:url value="/img/logo.png" />" alt="Avatar Logo" style="width:80px;" class="rounded-pill"> 
                </a>
            </li>
            <li class="nav-item" style="width: 55%; text-align: left; margin-top: 30px">
                <span class="m-brandtext">CỔNG THÔNG TIN TUYỂN SINH<br />
                    TRƯỜNG ĐẠI HỌC MỞ THÀNH PHỐ HỒ CHÍ MINH</span>
            </li>
        </ul>
        <ul class="nav navbar-nav navbar-right" style="margin-top: 30px; margin-right: 10px">
            <c:url value="/" var="action" />
            <form class="d-flex" action="${action}">
                <input class="form-control me-2" type="text" name="kw" placeholder="Nhập từ khóa...">
                <button class="btn btn-primary ml-2" type="submit">Tìm</button>
            </form>
        </ul>
    </div>
</nav>

<nav>
    <nav class="navbar navbar-expand-sm bg-dark navbar-dark fixed-top" style="border-radius: 0;
         padding-bottom: 0px; margin-bottom: 0px">
        <div class="container-fluid">
            <div class="collapse navbar-collapse ml-auto m-mainmenu-nav">
                <ul class="navbar-nav text-center m-mainmenu">
                    <li class="nav-item" >
                        <a class="nav-link" href="<c:url value="/"/>">Trang chủ</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown">Thông tin tuyển sinh</a>
                        <ul class="dropdown-menu">
                            <c:forEach items="${types}" var="t">
                                <li><a class="dropdown-item" style="color: activeborder" href="#${t.id}">${t.name}</a></li>
                                </c:forEach>
                        </ul>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/departments"/>">Thông tin khoa-ngành</a>
                    </li>
                </ul>
                <ul class="nav navbar-nav navbar-right" style="color: #ffffff;">
                    <c:if test="${pageContext.request.userPrincipal.name == null}">
                        <li><a href="<c:url value="/user/login" />"><i class="fa-solid fa-user-large"></i> Đăng nhập</a></li>
                        </c:if>
                        <c:if test="${pageContext.request.userPrincipal.name != null}">
                        <li><a href="<c:url value="/" />"><i class="fa-solid fa-user-large"></i> ${pageContext.request.userPrincipal.name}</a></li>
                        <li><a href="<c:url value="/logout" />"><i class="fa-solid fa-user-large"></i> Đăng xuất</a></li>
                        </c:if>
                </ul>
            </div>
        </div>
    </nav>
</nav>


<!--Slide banner-->
<div id="myCarousel" class="carousel slide" data-ride="carousel" style="height: 500px">
    <!-- Indicators -->
    <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
        <li data-target="#myCarousel" data-slide-to="3"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
        <div class="item active">
            <img src="<c:url value="https://tuyensinh.ou.edu.vn/tmp/rscache/1110x475-21072023-01.png" />" alt="Chania" width="100%">
            <div class="carousel-caption">
                <h3>Chania</h3>
                <p>The atmosphere in Chania has a touch of Florence and Venice.</p>
            </div>
        </div>

        <div class="item">
            <img src="<c:url value="https://tuyensinh.ou.edu.vn/tmp/rscache/1110x475-Ket qua so tuyen-1-01.png" />" alt="Chania"  width="100%">
            <div class="carousel-caption">
                <h3>Chania</h3>
                <p>The atmosphere in Chania has a touch of Florence and Venice.</p>
            </div>
        </div>

        <div class="item">
            <img src="<c:url value="https://tuyensinh.ou.edu.vn/tmp/rscache/1110x475-dkxt2-01.png" />" alt="Flower"  width="100%">
            <div class="carousel-caption">
                <h3>Flowers</h3>
                <p>Beautiful flowers in Kolymbari, Crete.</p>
            </div>
        </div>

        <div class="item">
            <img src="<c:url value="https://tuyensinh.ou.edu.vn/tmp/rscache/1110x475-web ts 2023-v1-01.png" />" alt="Flower"  width="100%">
            <div class="carousel-caption">
                <h3>Flowers</h3>
                <p>Beautiful flowers in Kolymbari, Crete.</p>
            </div>
        </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>
</div>


