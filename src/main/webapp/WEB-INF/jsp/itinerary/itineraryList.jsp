<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<div class="blueborder marginBottom">

<h2 class="marginAll">itineraries</h2>
		
		<c:if test="${fn:length(itineraries)>0}">
		<table class="listTable">
			<th>Name</th>
			<c:forEach items="${itineraries}" var="itineraries">
				<tr>
					<td><a
						href="<c:url value='/itinerary/itineraryUpdate.htm'/>?id=${itineraries.ID}&staffID=${itineraries.staffID}">${itineraries.name}</a>
					</td>
				</tr>
			</c:forEach>
		</table>
		</c:if>
		<form class="marginAll" action="<c:url value="/itinerary/itineraryUpdate.htm"/>" >
	        <input type="hidden" name="id" value="0">
	        <input type="hidden" name="staffId" value="${staffMember.ID}">
	        <input type="submit" value="add itinerary"/>
	    </form>
</div>
