<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:parseDate value="${param.dateTime}" type="DATE" pattern="yyyy-MM-dd HH:mm:ss.S" var="formatted"/>
<fmt:formatDate value="${formatted}" pattern="HH" var="hour"/>    
<fmt:formatDate value="${formatted}" pattern="mm" var="min"/>    

<div class="timeselector">
	<select name="${param.prefix}hours">
		<c:forEach begin="0" end="23" varStatus="status">
			<fmt:formatNumber minIntegerDigits="2" value="${status.index}" var="num"/>
			<c:set var="sel" value="${hour==num?'selected=\"selected\"':''}"/>
			<option value="${num}" ${sel} >${num}</option>
		</c:forEach>
	</select>
	<select name="${param.prefix}minutes">
		<c:forEach begin="0" end="59" varStatus="status">
			<fmt:formatNumber minIntegerDigits="2" value="${status.index}" var="num"/>
			<c:set var="sel" value="${min==num?'selected=\"selected\"':''}"/>
			<option value="${num}" ${sel} >${num}</option>
		</c:forEach>
	</select>
</div>