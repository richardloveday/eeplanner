<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<div class="blueborder marginBottom">

<h2 class="marginAll">Flight</h2>

<c:choose>
	<c:when test="${not empty flights}">
		<table class="listTable">
			<tr>	
	    	<th>Destination</th>
	        <th>Flight number</th>
	        <th>outbound arrival</th>
	        <th>type</th>
    		</tr>
			<c:forEach items="${flights}" var="flights">
            <tr>
                <td><a href="<c:url value='/flight.htm'/>?id=${flights.ID}">${flights.destination}</a></td>
            	<td><a href="<c:url value='/flight.htm'/>?id=${flights.ID}">${flights.flightNumber}</a></td>
                <td><fmt:formatDate pattern='dd/MM/yyyy HH:mm' value='${flights.outboundArrival}' /></td>
                <td>${flights.type}</td>
            </tr>
			</c:forEach>
		</table>
	</c:when>
	<c:otherwise>
		<form class="marginAll" action="<c:url value="../flight.htm"/>" >
	        <input type="hidden" name="id" value="0">
	        <input type="hidden" name="staffId" value="${itinerary.ID}">
	    </form>    
	</c:otherwise>
	   
</c:choose>
	    <form class="marginAll" action="<c:url value="../flight.htm"/>">
	       <input type="hidden" name="itineraryID" value="${itinerary.ID}">
	       <input type="submit" value="add flight"/>
	    </form>
</div>