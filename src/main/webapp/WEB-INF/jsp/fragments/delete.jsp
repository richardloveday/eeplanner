<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<c:choose>
	<c:when test="${param.deleted}">
		<div class="blueborder">
			<h2 class="marginAll">restore this ${param.action}...</h2>            
			<form class="marginAll" action="<c:url value="/delete-entity.htm"/>" >
		        <input type="hidden" name="action" value="restore${param.action}">
		        <input type="hidden" name="id" value="${param.id}">
		        <input type="submit" value="restore"/>
		    </form>
		</div>
	</c:when>
	<c:otherwise>
		<div class="blueborder">
			<h2 class="marginAll">delete this ${param.action}...</h2>            
			<form class="marginAll" action="<c:url value="/delete-entity.htm"/>">
		        <input type="hidden" name="action" value="delete${param.action}">
		        <input type="hidden" name="id" value="${param.id}">
		        <input type="submit" value="delete"/>
		    </form>
		</div>	
	</c:otherwise>
</c:choose>
