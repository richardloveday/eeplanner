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

            <form:select path="flightID">
                <form:options items="${flights}" itemValue="ID" itemLabel="itemLabel"/>
            </form:select>

            <h2>Notes</h2>

            <form:textarea  path="notes" rows="4" cols="30"/>
            
            <br/>

            <input type="submit" value="Save Itinerary Changes"/>

        </form:form>
    </div>
    
</div>
<div class="marginTop marginLeft left">
	<div class="blueborder">
		<h2 class="marginAll">Personal Travel Info document</h2>            
		<form action="<c:url value="/generate-rtf.htm" />">
			<input type="hidden" name="action" value="generatePersonalInfoDocument">
	           <input type="hidden" name="staffMemberID" value="${itinerary.staffID}"/>
	           <input type="hidden" name="campID" value="${itinerary.campID}"/>
	           <input type="submit" value="generate"/>
	   	</form>
	</div>
</div>


<jsp:include page="../wireframe/footer.jsp"/>
