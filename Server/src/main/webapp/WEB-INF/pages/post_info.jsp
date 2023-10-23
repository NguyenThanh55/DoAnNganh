<%-- 
    Document   : post_info
    Created on : Jul 28, 2023, 12:57:32 PM
    Author     : Thanh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<section class="container" style="margin-top: 150px">
    <h2 style="text-align: center">${post.typeoftrainningId.name}</h2>
    <div class="container-fluid mt-3">
        <div class="container">
            <p>${post.title}</p>
            <p>${post.content}</p>
        </div>
    </div><!-- comment -->
</section>
