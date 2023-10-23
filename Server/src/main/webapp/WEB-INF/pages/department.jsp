<%-- 
    Document   : deparment
    Created on : Jul 26, 2023, 5:59:35 PM
    Author     : Thanh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="w3-container" style="margin-top: 150px">
    <h1 class="text-center text-info mt-1">THÔNG TIN KHOA - NGÀNH</h1>
    <div class="w3-row">
        <a href="javascript:void(0)" onclick="openCity(event, 'Daitra');">
            <div class="w3-third tablink w3-bottombar w3-hover-light-grey w3-padding w3-border-red">Các Khoa/ngành đại trà</div>
        </a>
        <a href="javascript:void(0)" onclick="openCity(event, 'DTDB');">
            <div class="w3-third tablink w3-bottombar w3-hover-light-grey w3-padding">Chương trình chất lượng cao</div>
        </a>
        <a href="javascript:void(0)" onclick="openCity(event, 'Lienket');">
            <div class="w3-third tablink w3-bottombar w3-hover-light-grey w3-padding">Chương trình liên kết</div>
        </a>
    </div>
    
    <div id="Daitra" class="w3-container city" style="display:block">
        <div>
            <c:forEach items="${departments}" begin="0" end="9" var="d">
                <c:url value="/department_info" var="departAction">
                    <c:param name="departId" value="${d.id}" />          
                </c:url>
                <div class="col-sm-4 p-3 " >
                    <div class="card" style="width:100%">
                        <img class="card-img-top" style="width: 100%" src="<c:url value="https://tuyensinh.ou.edu.vn/tmp/rscache/540x305-21072023-01.png" />" alt="Thông báo Ngưỡng điểm nhận hồ sơ đăng ký xét tuyển Kết quả thi tốt nghiệp THPT năm 2023">
                        <div class="card-body" >
                            <strong>
                                <a href="${departAction}" type="button" > 
                                    <span style="font-size:18px;">
                                        <span style="color:#000000;">
                                            ${d.name}
                                        </span>
                                    </span>
                                </a>
                            </strong>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>

    <div id="DTDB" class="w3-container city" style="display:none">
        <div>
            <c:forEach items="${departments}" begin="11" end="11" var="d">
                <c:url value="/department_info" var="departAction">
                    <c:param name="departId" value="${d.id}" />          
                </c:url>
                <div class="col-sm-4 p-3 " >
                    <div class="card" style="width:100%">
                        <img class="card-img-top" style="width: 100%" src="<c:url value="https://tuyensinh.ou.edu.vn/tmp/rscache/540x305-21072023-01.png" />" alt="Thông báo Ngưỡng điểm nhận hồ sơ đăng ký xét tuyển Kết quả thi tốt nghiệp THPT năm 2023">
                        <div class="card-body" >
                            <strong>
                                <a href="${departAction}"> 
                                    <span style="font-size:18px;">
                                        <span style="color:#000000;">
                                            ${d.name}
                                        </span>

                                    </span>
                                </a>
                            </strong>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>

    <div id="Lienket" class="w3-container city" style="display:none">
        <div>
            <c:forEach items="${departments}" begin="11" end="13" var="d">
                 <c:url value="/department_info" var="departAction">
                        <c:param name="postId" value="${p.id}" />          
                    </c:url>
                <div class="col-sm-4 p-3 " >
                    <div class="card" style="width:100%">
                        <img class="card-img-top" style="width: 100%" src="<c:url value="https://tuyensinh.ou.edu.vn/tmp/rscache/540x305-21072023-01.png" />" alt="Thông báo Ngưỡng điểm nhận hồ sơ đăng ký xét tuyển Kết quả thi tốt nghiệp THPT năm 2023">
                        <div class="card-body" >
                            <strong>
                                <a href="${departAction}">  
                                    <span style="font-size:18px;">
                                        <span style="color:#000000;">
                                            ${d.name}
                                        </span>

                                    </span>
                                </a>
                            </strong>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>

    </div>
</div>


