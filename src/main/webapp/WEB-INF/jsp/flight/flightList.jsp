<%--
  Created by IntelliJ IDEA.
  User: IvieC
  Date: 15-Jan-2010
  Time: 15:51:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<jsp:include page="../wireframe/header.jsp"/>
<jsp:include page="../wireframe/nav/mainnav.jsp"/>
<jsp:include page="../wireframe/nav/travel.jsp"/>

<h1 class="listHeader">All Flights</h1>
<div>
 <select name="showYear" id="showYearCombo">
 <option value="2012" ${theYear==2012?'selected="selected"':''}>2012</option>
  <option value="2011" ${theYear==2011?'selected="selected"':''}>2011</option>
  <option value="2010" ${theYear==2010?'selected="selected"':''}>2010</option>
 </select>
</div>
<p>&nbsp;</p>

<div class="clear"></div>

<div>
	<form action="<c:url value="/flight-list.htm"/> ">
		show deleted?<input type="checkbox" name="showDeleted" id="showDeleted" ${showDeleted=="true"?'checked="checked"':''}/>
	</form>
</div>

<div class="clear"></div>

<div>
    <table class="listTable">
    	<tr>	
	    	<th>Destination</th>
	        <th>Flight number</th>
	        <th>Outbound Departure</th>
	        <th>Return Departure</th>
	        <th>Seats</th>
	        <th>Remaining</th>
    	</tr>
        <c:forEach items="${flights}" var="flight">
            <tr>
                <td><a href="<c:url value='/flight.htm'/>?id=${flight.ID}">${flight.destination}</a></td>
            	<td><a href="<c:url value='/flight.htm'/>?id=${flight.ID}">${flight.flightNumber} / ${flight.returnFlightNumber}</a></td>
                <td><fmt:formatDate pattern='dd/MM/yyyy HH:mm' value='${flight.outboundDeparture}' /></td>
                <td><fmt:formatDate pattern='dd/MM/yyyy HH:mm' value='${flight.returnDeparture}' /></td>
                <td>${flight.numberOfSeats}</td>
                <td>${flight.numberOfSeats - fn:length(flight.staffMembers)}</td>
            </tr>
        </c:forEach>
    </table>

</div>
<jsp:include page="../wireframe/footer.jsp"/>