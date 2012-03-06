<%--
  Created by IntelliJ IDEA.
  User: IvieC
  Date: 15-Jan-2010
  Time: 15:50:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--@elvariable id="staffMember" type="com.eeplanner.datastructures.StaffMember"--%>
<%--@elvariable id="camp" type="com.eeplanner.datastructures.Camp"--%>
<%--@elvariable id="flight" type="com.eeplanner.datastructures.Flight"--%>

<jsp:include page="../wireframe/header.jsp"/>
<jsp:include page="../wireframe/nav/mainnav.jsp"/>
<jsp:include page="../wireframe/nav/flights.jsp"/>

<div class="left blueBorder">

    <%-- todo copy functionality to add / edit / delete camps as well as staff members to meet new requirements.--%>


    <form:form commandName="flight" cssClass="addValidation">
        <table>
            <c:if test="${not empty flight.ID}">
                <tr>
                    <td>ID:</td>
                    <td>${flight.ID}</td>
                </tr>
            </c:if>
            <tr>
                <td>departing from:</td>
                <td><form:input path="airport" cssClass="required"/></td>
            </tr>
            <tr>
                <td>destination:</td>
                <td><form:input path="destination" cssClass="required"/></td>
            </tr>
            <tr>
                <td>carrier:</td>
                <td><form:input path="carrier"/></td>
            </tr>
            <tr>
                <td>type:</td>
                <td>
                    <form:select path="type">
                        <form:option value="independent"/>
                        <form:option value="company"/>
                    </form:select>
                </td>
            </tr>
            <tr>
                <td>flight number:</td>
                <td><form:input path="flightNumber"/></td>
            </tr>
            <tr>
                <td>cost:</td>
                <td><form:input path="cost"/></td>
            </tr>
            <tr>
                <td>number of seats:</td>
                <td><form:input path="numberOfSeats"/></td>
            </tr>
            <tr>
                <td colspan="2">
                    <div class="blueborder marginAll">
                        <h2 class="marginLeft marginAll">outbound</h2>
                        <table>
                            <tr>
                                <td>departure:</td>
                                <td><input name="outboundDepartureDateToSave" class="dateselect date"
                                           value="<fmt:formatDate pattern='dd/MM/yyyy' value='${flight.outboundDeparture}' />">
                                </td>
                                <td><input size="1" class="number min max" name="outdephours" id="outdephours"
                                           value="<fmt:formatDate pattern='HH' value='${flight.outboundDeparture}' />"></td>
                                <td>:<input size="1" class="number min max" name="outdepminutes" id="outdepminutes"
                                            value="<fmt:formatDate pattern='mm' value='${flight.outboundDeparture}' />"></td>
                            </tr>
                            <tr>
                                <td>arrival:</td>
                                <td><input name="outboundArrivalDateToSave" class="dateselect date"
                                           value="<fmt:formatDate pattern='dd/MM/yyyy' value='${flight.outboundArrival}' />">
                                </td>
                                <td><input size="1" class="number min max" name="outarrhours" id="outarrhours"
                                           value="<fmt:formatDate pattern='HH' value='${flight.outboundArrival}' />"></td>
                                <td>:<input size="1" class="number min max" name="outarrminutes" id="outarrminutes"
                                            value="<fmt:formatDate pattern='mm' value='${flight.outboundArrival}' />"></td>
                            </tr>
                        </table>
                    </div>
                </td>
            <tr>
                <td colspan="2">
                    <div class="blueborder marginAll">
                        <h2 class="marginLeft marginAll">return</h2>
                        <table>
                            <tr>
                                <td>departure:</td>
                                <td><input name="returnDepartureDateToSave" class="dateselect date"
                                           value="<fmt:formatDate pattern='dd/MM/yyyy' value='${flight.returnDeparture}' />">
                                </td>
                                <td><input size="1" class="number min max" name="retdephours" id="retdephours"
                                           value="<fmt:formatDate pattern='HH' value='${flight.returnDeparture}' />"></td>
                                <td>:<input size="1" class="number min max" name="retdepminutes" id="retdepminutes"
                                            value="<fmt:formatDate pattern='mm' value='${flight.returnDeparture}' />"></td>
                            </tr>
                            <tr>
                                <td>arrival:</td>
                                <td><input name="returnArrivalDateToSave" class="dateselect date"
                                           value="<fmt:formatDate pattern='dd/MM/yyyy' value='${flight.returnArrival}' />">
                                </td>
                                <td><input size="1" class="number min max" name="retarrhours" id="retarrhours"
                                           value="<fmt:formatDate pattern='HH' value='${flight.returnArrival}' />"></td>
                                <td>:<input size="1" class="number min max" name="retarrminutes" id="retarrminutes"
                                            value="<fmt:formatDate pattern='mm' value='${flight.returnArrival}' />"></td>
                            </tr>
                        </table>
                    </div>
                </td>
            </tr>
            <tr>
                <td colspan="3">
                    <input type="submit" value="Save Changes"/>
                </td>
            </tr>
        </table>
    </form:form>

</div>
<div class="left marginLeft">
    <c:if test="${fn:length(flight.staffMembers) ge flight.numberOfSeats}">
        <div class="blueBorder marginBottom">
            <p class="error marginAll bold">This flight is now full...</p>
        </div>
    </c:if>
    <div class="blueBorder">

        <div class="marginAll">
            <h2>Current staff members:</h2>
            <table>
                <c:forEach items="${flight.staffMembers}" var="staffMember">
                    <tr>
                        <form action="<c:url value="/process-flight-staff.htm" />">

                            <input type="hidden" name="action" value="editStaffMember">
                            <input type="hidden" name="flightID" value="${flight.ID}">
                            <input type="hidden" name="staffMemberID" value="${staffMember.ID}">
                            <td width="100px">
                                <a href="<c:url value="/staff-member.htm"/>?id=${staffMember.ID}">${staffMember.contact.secondName}, ${staffMember.contact.firstNames}</a>
                            </td>
                            <td>
                                info sent? <input type="checkbox" name="infoSent"
                                                  value="infoSent" ${staffMember.infoSent?'CHECKED':''}/>
                            </td>
                            <td>
                                transfer needed? <input type="checkbox" name="transferNeeded"
                                                  value="transferNeeded" ${staffMember.transferNeeded?'CHECKED':''}/>
                            </td>
                            <td>
                                <input type="submit" value="save">
                            </td>
                        </form>
                        <form action="<c:url value="/process-flight-staff.htm" />">
                            <input type="hidden" name="action" value="removeStaffMember">
                            <input type="hidden" name="flightID" value="${flight.ID}">
                            <input type="hidden" name="staffMemberID" value="${staffMember.ID}">
                            <td>
                                <input type="submit" value="remove">
                            </td>
                        </form>
                    </tr>
                </c:forEach>
            </table>
        </div>

        <c:if test="${fn:length(flight.staffMembers) lt flight.numberOfSeats && fn:length(availableStaff)>0}">
            <form class="marginAll" action="<c:url value="/process-flight-staff.htm" />">
                <input type="hidden" name="action" value="addStaffMember">
                <input type="hidden" name="flightID" value="${flight.ID}">
                <select name="staffMemberID">
                    <c:forEach items="${availableStaff}" var="staffMember">
                        <option value="${staffMember.ID}">${staffMember.contact.secondName}
                            - ${staffMember.contact.firstNames}</option>
                    </c:forEach>
                </select>
                <input type="submit" value="Add staff member">
            </form>
        </c:if>
        <div class="marginAll">
            <h2>Current camps:</h2>
            <table>
                <c:forEach items="${flight.camps}" var="camp">
                    <tr>
                        <td width="100px">
                            <a href="<c:url value="/camp.htm"/>?id=${camp.ID}">${camp.name}</a>
                        </td>
                        <form action="<c:url value="/process-flight-camp.htm" />">
                            <input type="hidden" name="action" value="removeCamp">
                            <input type="hidden" name="flightID" value="${flight.ID}">
                            <input type="hidden" name="campID" value="${camp.ID}">
                            <td>
                                <input type="submit" value="remove">
                            </td>
                        </form>
                    </tr>
                </c:forEach>
            </table>
        </div>

        <c:if test="${fn:length(availableCamps)>0}">
            <form class="marginAll" action="<c:url value="/process-flight-camp.htm" />">
                <input type="hidden" name="action" value="addCamp">
                <input type="hidden" name="flightID" value="${flight.ID}">
                <select name="campID">
                    <c:forEach items="${availableCamps}" var="camp">
                        <option value="${camp.ID}">${camp.name}</option>
                    </c:forEach>
                </select>
                <input type="submit" value="Add camp">
            </form>
        </c:if>

    </div>

	<div class="marginTop left">
		<jsp:include page="/WEB-INF/jsp/fragments/delete.jsp">
			<jsp:param name="action" value="Flight"/>
			<jsp:param name="deleted" value="${flight.deleted}" />
		    <jsp:param name="id" value="${flight.ID}"/>
		</jsp:include>
	</div>
	<div class="marginTop marginLeft left">
		<div class="blueborder">
			<h2 class="marginAll">Flight document</h2>            
			<form action="<c:url value="/generate-rtf.htm" />">
				<input type="hidden" name="action" value="generateFlightInfo">
	            <input type="hidden" name="id" value="${flight.ID}"/>
	            <input type="submit" value="generate"/>
	    	</form>
		</div>
	</div>
	
</div>

<div class="clear"></div>

<jsp:include page="../wireframe/footer.jsp"/>