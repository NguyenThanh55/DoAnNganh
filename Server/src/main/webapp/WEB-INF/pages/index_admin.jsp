<%-- 
    Document   : index_admin
    Created on : 13 thg 8, 2023, 21:11:40
    Author     : vbmho
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);
        
      function drawChart() {
        let data1 = [];
        <c:forEach items="${postbytype}" var="c">
            data1.push(${c});
        </c:forEach>
        var data = google.visualization.arrayToDataTable([
          ['Task', 'Hours per Day'],
          ['Hệ chính quy',     data1[0]],
          ['Hệ liên thông',      data1[1]],
          ['Cao học',  data1[2]],
          ['Thạc sĩ', data1[3]],
          ['Đào tạo từ xa',    data1[4]]
        ]);

        var options = {
          title: 'BÀI ĐĂNG THEO HỆ ĐÀO TẠO',
          is3D: true
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart'));

        chart.draw(data, options);
      }
    </script>
<section class="container">
    <h1 class="text-center text-success mt-3">THỐNG KÊ BÁO CÁO</h1>
<div id="piechart" style="width: 1000px; height: 800px;"></div>
</section>
<script src="<c:url value="/js/main.js"/>"></script>

