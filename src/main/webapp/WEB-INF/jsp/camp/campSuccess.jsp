<%--
  Created by IntelliJ IDEA.
  User: IvieC
  Date: 11-Jan-2010
  Time: 16:55:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    

<jsp:include page="../wireframe/header.jsp"/>
<jsp:include page="../wireframe/nav/mainnav.jsp"/>
<jsp:include page="../wireframe/nav/camps.jsp"/>

<!--<div class="blueBorder left marginBottom marginTop">
    <c:forEach items="${deletedStaffMembers}" var="staffMember">
        deleted - ${staffMember.contact.secondName} <br/>
    </c:forEach>
</div>


-->
<c:redirect url="/camp.htm?id=${camp.ID}" />
