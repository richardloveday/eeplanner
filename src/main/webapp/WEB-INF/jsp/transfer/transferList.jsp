<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%--@elvariable id="transfers" type="java.util.List<com.eeplanner.datastructures.Transfer>"--%>


<jsp:include page="../wireframe/header.jsp"/>
<jsp:include page="../wireframe/nav/mainnav.jsp"/>
<jsp:include page="../wireframe/nav/travel.jsp"/>

<h1 class="listHeader">All Transfers</h1>


<div class="clear"></div>

<div>
 <select name="showYear" id="showYearCombo">
 <option value="2012" ${showYear==2012?'selected="selected"':''}>2012</option>
  <option value="2011" ${showYear==2011?'selected="selected"':''}>2011</option>
  <option value="2010" ${showYear==2010?'selected="selected"':''}>2010</option>
 </select>
</div>
<p>&nbsp;</p>

<div>
	<form action="<c:url value="/transfer-list.htm"/> ">
		show deleted?<input type="checkbox" name="showDeleted" onchange="submit();" ${not empty param.showDeleted?'checked="checked"':''}/>
	</form>
</div>

<div class="clear"></div>

<div>
    <table class="listTable">
    	<tr>
	    	<th>id</th>
	    	<th>outbound departure</th>
	        <th>outbound arrival</th>
	    	<th>return departure</th>
	        <th>return arrival</th>
    	</tr>
        <c:forEach items="${transfers}" var="transfer">
            <tr>
                <td><a href="<c:url value='/transfer.htm'/>?id=${transfer.ID}">${transfer.ID}</a></td>
                <td><fmt:formatDate pattern='dd/MM/yyyy HH:mm' value='${transfer.outboundDeparture}' /> - ${transfer.outboundDeparturePoint}</td>
                <td><fmt:formatDate pattern='dd/MM/yyyy HH:mm' value='${transfer.outboundArrival}' /> - ${transfer.outboundArrivalPoint}</td>
                <td><fmt:formatDate pattern='dd/MM/yyyy HH:mm' value='${transfer.returnDeparture}' /> - ${transfer.returnDeparturePoint}</td>
                <td><fmt:formatDate pattern='dd/MM/yyyy HH:mm' value='${transfer.returnArrival}' /> - ${transfer.returnArrivalPoint}</td>
            </tr>
        </c:forEach>
    </table>

</div>
<jsp:include page="../wireframe/footer.jsp"/>