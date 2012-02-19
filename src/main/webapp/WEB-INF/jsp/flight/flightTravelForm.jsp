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


<div class="left blueBorder">

    <%-- todo copy functionality to add / edit / delete camps as well as staff members to meet new requirements.--%>


    <form:form commandName="flight" cssClass="addValidation" action="flightToSave.htm">
        <table>
            <c:if test="${not empty flight.ID}">
                <tr>
                    <td>CampID:</td>
                    <td>${flight.campID}</td>
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
 
            </tr>
        </table>
        
    <input type="hidden" name="itineraryID" value="${flight.itineraryID}"/>
	<input type="hidden" name="campID" value="${flight.campID}"/>	
	<input class="marginAll" type="submit" value="Save changes"/>
    </form:form>

</div>

<jsp:include page="../wireframe/footer.jsp"/>