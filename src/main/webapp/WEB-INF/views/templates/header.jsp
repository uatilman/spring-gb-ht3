<%@ page session="false" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<header class="padding-site">
    <div class="header">
        <nav>
            <ul class="menu">
                <li><a href="${pageContext.request.contextPath}/chambers">Chambers list</a></li>
                <li><a href="${pageContext.request.contextPath}/chambers?form">Add chamber</a></li>
                <li><a href="#">Page 3</a></li>
                <li><a href="#">Page 4</a></li>
                </li>
            </ul>
        </nav>
    </div>
</header>