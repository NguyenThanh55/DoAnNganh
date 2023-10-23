<%-- 
    Document   : post_index
    Created on : Jul 27, 2023, 6:49:33 PM
    Author     : Thanh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<section class="container" style="margin-top: 150px">
        <h2 style="text-align: center">${posts[0].typeoftrainningId.name}</h2>
    <div class="row">
        <c:forEach items="${posts}" var="p">
            <c:url value="/post_info" var="postAction">
                <c:param name="postId" value="${p.id}" />          
            </c:url>
            <div class="col-sm-4 p-3 " >
                <div class="card" style="width:100%">
                    <img class="card-img-top" style="width: 100%" 
                         src="<c:url value="https://tuyensinh.ou.edu.vn/tmp/rscache/540x305-21072023-01.png" />" alt="Thông báo Ngưỡng điểm nhận hồ sơ đăng ký xét tuyển Kết quả thi tốt nghiệp THPT năm 2023">
                    <div class="card-body" >
                        <strong>
                            <a href="${postAction}">  
                                <span style="font-size:18px;">
                                    <span style="color:#000000;">
                                        ${p.title}
                                    </span>
                                </span>
                            </a>
                        </strong>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</section>
