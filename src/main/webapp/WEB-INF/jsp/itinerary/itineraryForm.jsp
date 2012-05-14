<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--@elvariable id="itinerary" type="com.eeplanner.datastructures.Itinerary"--%>
<%--@elvariable id="staffMember" type="com.eeplanner.datastructures.StaffMember"--%>

<jsp:include page="../wireframe/header.jsp"/>
<jsp:include page="../wireframe/nav/mainnav.jsp"/>


<div class="left blueBorder">

    <div class="marginAll">

        <p>staff member ID: ${itinerary.staffMember.ID}</p>
        <p>staff member name: ${itinerary.staffMember.contact.secondName} ${itinerary.staffMember.contact.firstNames}</p>


        <form:form commandName="itinerary" cssClass="addValidation">

            <input type="hidden" name="itinerary.staffID" value="${itinerary.staffID}"/>
            <input type="hidden" name="itinerary.campID" value="${itinerary.campID}"/>
            <input type="hidden" name="itinerary.year" value="${itinerary.year}"/>

            <h2>Flight</h2>

            <form:select path="flightID" cssClass="required">
            	<option></option>
            	<c:forEach items="${flights}" var="flight">
            		<c:if test="${fn:length(flight.staffMembers) lt flight.numberOfSeats or itinerary.flightID eq flight.ID}">
                		<form:option value="${flight.ID}" label="${flight.itemLabel}" />
                	</c:if>
                </c:forEach>
            </form:select>

            <h2>Notes</h2>

            <form:textarea  path="notes" rows="4" cols="30"/>
            
            <br/>

            <input type="submit" value="Save Itinerary Changes"/>

        </form:form>
    </div>
    
</div>

<jsp:include page="../wireframe/footer.jsp"/>
