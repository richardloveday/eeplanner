<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: IvieC
  Date: 05-Jan-2010
  Time: 14:59:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="mainnav">
    <div class="level2">

        <li><a href="<c:url value='/flight.htm'/>">Add flight</a></li>
        <li><a href="<c:url value='/transfer.htm'/>">Add transfer</a></li>
        <li><a href="<c:url value='/flight-list.htm'/>">Browse / edit flights</a></li>
        <li><a href="<c:url value='/transfer-list.htm'/>">Browse / edit transfers</a></li>

    </div>
    <div class="clear"></div>
</div>