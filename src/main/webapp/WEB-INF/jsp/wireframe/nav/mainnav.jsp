<%--
  Created by IntelliJ IDEA.
  User: IvieC
  Date: 09-Dec-2009
  Time: 11:51:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="mainnav">
    <div class="level1">

        <li><a href="<c:url value='/staff-member-list.htm'/>">Staff</a></li>
        <li><a href="<c:url value='/camp-list.htm'/>">Camps</a></li>
        <li><a href="<c:url value='/flight-list.htm'/>">Travel</a></li>
        <li><a href="<c:url value='/mail.htm?action=mail'/>">Email Recipient List</a></li>
        <li><a href="<c:url value='/search.htm'/>">Search</a></li>
        <li><a href="<c:url value='/template-list.htm'/>">Templates</a></li>

    </div>
    <div class="clear"></div>
</div>



