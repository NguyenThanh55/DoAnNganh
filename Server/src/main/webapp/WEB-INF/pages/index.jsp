<%-- 
    Document   : index
    Created on : Jul 19, 2023, 9:20:54 PM
    Author     : Thanh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<section class="container" style="margin-top: 150px">
    <h1 class="text-center text-info mt-1">THÔNG TIN TUYỂN SINH</h1>
    <div class="container-fluid mt-3">
        <div class="row">

            <h2 id="1">Hệ chính quy</h2>
            <div>
                <c:forEach items="${post_1}" var="p">
                    <c:url value="/post_index" var="postIndex" >
                        <c:param name="typeoftrainningId" value="${p.typeoftrainningId.id}" />          
                    </c:url>
                    <c:url value="/post_info" var="postAction">
                        <c:param name="postId" value="${p.id}" />          
                    </c:url>
                    <div class="col-sm-4 p-3 ">
                        <div class="card" style="width:100%; height: 350px">
                            <img class="card-img-top" style="width: 100%" src="<c:url value="https://tuyensinh.ou.edu.vn/tmp/rscache/540x305-21072023-01.png" />" alt="Thông báo Ngưỡng điểm nhận hồ sơ đăng ký xét tuyển Kết quả thi tốt nghiệp THPT năm 2023">
                            <div class="card-body" >
                                <a class="card-title" href="${postAction}">${p.title}</a>
                            </div>
                        </div>
                    </div>
                </c:forEach>
                <div class="col-sm-4 p-3 " >
                    <div class="card" style="width:100%; height: 350px">
                        <div class="card-body" style="height: 100%; vertical-align: middle">
                            <a class="card-title" href="${postIndex}"  onclick="${departAction}">Xem thêm</a>
                        </div>
                    </div>
                </div>
            </div>

        </div>
        <div class="row">
            <h2 id="2">Hệ liên thông</h2>
            <div>
                <c:forEach items="${post_2}" var="p" begin="0" end="4">
                    <c:url value="/post_index" var="postIndex" >
                        <c:param name="typeoftrainningId" value="${p.typeoftrainningId.id}" />          
                    </c:url>
                    <c:url value="/post_info" var="postAction">
                        <c:param name="postId" value="${p.id}" />          
                    </c:url>
                    <div class="col-sm-4 p-3 " >
                        <div class="card" style="width:100%; height: 350px">
                            <img class="card-img-top" style="width: 100%" src="<c:url value="https://tuyensinh.ou.edu.vn/tmp/rscache/540x305-21072023-01.png" />" alt="Thông báo Ngưỡng điểm nhận hồ sơ đăng ký xét tuyển Kết quả thi tốt nghiệp THPT năm 2023">
                            <div class="card-body" >
                                <a class="card-title" href="${postAction}">${p.title}</a>
                            </div>
                        </div>
                    </div>
                </c:forEach>
                <div class="col-sm-4 p-3 ">
                    <div class="card" style="width:100%; height: 350px">
                        <div class="card-body" style="height: 100%; vertical-align: middle">
                            <a class="card-title" href="${postIndex}">Xem thêm</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <h2 id="3">Cao học</h2>
            <div>
                <c:forEach items="${post_3}" var="p" begin="0" end="4">
                    <c:url value="/post_index" var="postIndex" >
                        <c:param name="typeoftrainningId" value="${p.typeoftrainningId.id}" />          
                    </c:url>
                    <c:url value="/post_info" var="postAction">
                        <c:param name="postId" value="${p.id}" />          
                    </c:url>
                    <div class="col-sm-4 p-3 " >
                        <div class="card" style="width:100%; height: 350px">
                            <img class="card-img-top" style="width: 100%" src="<c:url value="https://tuyensinh.ou.edu.vn/tmp/rscache/540x305-21072023-01.png" />" alt="Thông báo Ngưỡng điểm nhận hồ sơ đăng ký xét tuyển Kết quả thi tốt nghiệp THPT năm 2023">
                            <div class="card-body" >
                                <a class="card-title" href="${postAction}">${p.title}</a>
                            </div>
                        </div>
                    </div>
                </c:forEach>
                <div class="col-sm-4 p-3 " >
                    <div class="card" style="width:100%; height: 350px">
                        <div class="card-body" style="height: 100%; vertical-align: middle">
                            <a class="card-title" href="${postIndex}">Xem thêm</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <h2 id="4">Thạc sĩ</h2>
            <div>
                <c:forEach items="${post_4}" var="p" begin="0" end="4">
                    <c:url value="/post_index" var="postIndex" >
                        <c:param name="typeoftrainningId" value="${p.typeoftrainningId.id}" />          
                    </c:url>
                    <c:url value="/post_info" var="postAction">
                        <c:param name="postId" value="${p.id}" />          
                    </c:url>
                    <div class="col-sm-4 p-3 ">
                        <div class="card" style="width:100%; height: 350px">
                            <img class="card-img-top" style="width: 100%" src="<c:url value="https://tuyensinh.ou.edu.vn/tmp/rscache/540x305-21072023-01.png" />" alt="Thông báo Ngưỡng điểm nhận hồ sơ đăng ký xét tuyển Kết quả thi tốt nghiệp THPT năm 2023">
                            <div class="card-body" >
                                <a class="card-title" href="${postAction}">${p.title}</a>
                            </div>
                        </div>
                    </div>
                </c:forEach>
                <div class="col-sm-4 p-3 " >
                    <div class="card" style="width:100%; height: 350px">
                        <div class="card-body" style="height: 100%; vertical-align: middle">
                            <a class="card-title" href="${postIndex}">Xem thêm</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <h2 id="5">Đào tạo từ xa</h2>
            <div>
                <c:forEach items="${post_5}" var="p" begin="0" end="4">
                    <c:url value="/post_index" var="postIndex" >
                        <c:param name="typeoftrainningId" value="${p.typeoftrainningId.id}" />          
                    </c:url>
                    <c:url value="/post_info" var="postAction">
                        <c:param name="postId" value="${p.id}" />          
                    </c:url>
                    <div class="col-sm-4 p-3 " >
                        <div class="card" style="width:100%; height: 350px">
                            <img class="card-img-top" style="width: 100%" src="<c:url value="https://tuyensinh.ou.edu.vn/tmp/rscache/540x305-21072023-01.png" />" alt="Thông báo Ngưỡng điểm nhận hồ sơ đăng ký xét tuyển Kết quả thi tốt nghiệp THPT năm 2023">
                            <div class="card-body" >
                                <a class="card-title" href="${postAction}">${p.title}</a>
                            </div>
                        </div>
                    </div>
                </c:forEach>
                <div class="col-sm-4 p-3 " >
                    <div class="card" style="width:100%; height: 350px">
                        <div class="card-body" style="height: 100%; vertical-align: middle">
                            <a class="card-title" href="${postIndex}">Xem thêm</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

</section>

<button onclick="topFunction()" id="myBtn" title="Go to top">Top</button>
<script src="<c:url value="/js/animation.js"/>"></script>

