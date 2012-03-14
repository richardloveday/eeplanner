<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--@elvariable id="camp" type="com.eeplanner.datastructures.Camp"--%>
<%--
  Created by IntelliJ IDEA.
  User: IvieC
  Date: 11-Jan-2010
  Time: 16:34:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="../wireframe/header.jsp"/>
<jsp:include page="../wireframe/nav/mainnav.jsp"/>
<jsp:include page="../wireframe/nav/camps.jsp"/>

<div class="left marginAll blueBorder">
<form:form commandName="camp" cssClass="addValidation"  name="editForm">
<table>
<tr>
	<td>
		<table class="boxForm">
<tr>
    <td>Camp Name</td>
    <td><form:input path="name" cssClass="required"/></td>
     <td>Start date:</td>
    <td><input name="startDateToSave" class="required dateselect date ${not empty camp.start?'dateChangeCheck':''}"
               value="<fmt:formatDate pattern='dd/MM/yyyy' value='${camp.start}' />"></td>
</tr>
<tr>
    <td>School name</td>
    <td><form:input path="contact.orgName"/></td>
     <td>End date:</td>
     <td><input name="endDateToSave" class="required dateselect date ${not empty camp.end?'dateChangeCheck':''}"
               value="<fmt:formatDate pattern='dd/MM/yyyy' value='${camp.end}' />"></td>
  
   
    </tr>
<tr>
    <td>Add 1</td>
    <td><form:input path="contact.add1"/></td>
 
</tr>
<tr>
    <td>Add 2</td>
    <td><form:input path="contact.add2"/></td>
</tr>
<tr>
    <td>Add 3</td>
    <td><form:input path="contact.add3"/></td>
</tr>
</table>

<table class="boxForm">
<tr>
    <td>Contact first name</td>
    <td><form:input path="contact.firstNames"/></td>
    <td>Contact second name</td>
    <td><form:input path="contact.secondName"/></td>
</tr>
<tr>
    <td>sex</td>
    <td>
        <form:select path="contact.sex">
            <form:option value="male">male</form:option>
            <form:option value="female">female</form:option>
        </form:select>
    </td>
</tr>
		
	</td>
</tr>


<tr>
    <td class="phoneEmailNoteTd" colspan="4">
        <table>
            <tr>
                <td class="numTitle">Phone numbers</td>
                <td>
                    <table class="nvpTable" id="phoneNumbersTable">

                        <tr>
                            <td>Description</td>
                            <td>Number</td>
                        </tr>

                        <c:choose>
                            <c:when test="${not empty camp.contact.phoneNumbers}">
                                <c:forEach items="${camp.contact.phoneNumbers}" var="phoneNumber"
                                           varStatus="status">
                                    <tr id="${status.index}">
                                        <input type="hidden" name="phoneID${status.index}"
                                               value="${phoneNumber.ID}"/>
                                        <td><input name="phoneName${status.index}"
                                                   value="${phoneNumber.name}"></td>
                                        <td><input name="phoneNumber${status.index}"
                                                   value="${phoneNumber.number}"></td>
                                    </tr>
                                </c:forEach>
                            </c:when>
                            <c:otherwise>
                                <tr id="0">
                                    <td><input name="phoneName0" value=""></td>
                                    <td><input name="phoneNumber0" value=""></td>
                                </tr>
                            </c:otherwise>
                        </c:choose>
                        <div><a id="addPhoneNumber" href="#">add another number</a></div>
                    </table>
                    <div><a id="removePhoneNumber" href="#">remove number</a></div>
                </td>
            </tr>
        </table>
        
    </td>
</tr>
<tr class="emailsRow">

    <td class="phoneEmailNoteTd" colspan="4">
        <table>
            <tr>
                <td class="numTitle">Email addresses</td>
                <td>
                    <table class="nvpTable" id="emailsTable">
                        <tr>
                            <td>Description</td>
                            <td>Email address</td>
                        </tr>
                        <c:choose>
                            <c:when test="${not empty camp.contact.emails}">
                                <c:forEach items="${camp.contact.emails}" var="email"
                                           varStatus="status">
                                    <tr id="${status.index}">
                                        <input type="hidden" name="emailID${status.index}"
                                               value="${email.ID}"/>
                                        <td><input name="emailName${status.index}" value="${email.name}">
                                        </td>
                                        <td><input class="email" name="emailAddress${status.index}"
                                                   value="${email.address}"></td>
                                    </tr>
                                </c:forEach>
                            </c:when>
                            <c:otherwise>
                                <tr id="0">
                                    <td><input name="emailName0" value=""></td>
                                    <td><input class="email" name="emailAddress0" value=""></td>
                                </tr>
                            </c:otherwise>
                        </c:choose>
                        <div><a id="addEmail" href="#">add another email address</a></div>
                    </table>
                    <div><a id="removeEmail" href="#">remove email address</a></div>
                </td>
            </tr>
        </table>
    </td>
</table>
</tr>
<tr>
	<td>
		<table class="boxForm">
<tr>
    <td>Daily Hours</td>
    <td><form:input path="dailyHours"/></td>
    <td>Presentation time</td>
    <td><form:input path="presentationTime"/></td>
</tr>
		</table>
	</td>
</tr>

<tr>
    <td class="phoneEmailNoteTd" colspan="2">
        <table>
            <tr>
                <td class="numTitle">School phone & fax numbers</td>
                <td>
                    <table class="nvpTable" id="schoolPhoneNumbersTable">

                        <tr>
                            <td>Description</td>
                            <td>Number</td>
                        </tr>

                        <c:choose>
                            <c:when test="${not empty camp.schoolContact.phoneNumbers}">
                                <c:forEach items="${camp.schoolContact.phoneNumbers}" var="schoolPhoneNumber"
                                           varStatus="status">
                                    <tr id="${status.index}">
                                        <input type="hidden" name="schoolPhoneID${status.index}"
                                               value="${schoolPhoneNumber.ID}"/>
                                        <td><input name="schoolPhoneName${status.index}"
                                                   value="${schoolPhoneNumber.name}"></td>
                                        <td><input name="schoolPhoneNumber${status.index}"
                                                   value="${schoolPhoneNumber.number}"></td>
                                    </tr>
                                </c:forEach>
                            </c:when>
                            <c:otherwise>
                                <tr id="0">
                                    <td><input name="schoolPhoneName0" value=""></td>
                                    <td><input name="schoolPhoneNumber0" value=""></td>
                                </tr>
                            </c:otherwise>
                        </c:choose>
                        <div><a id="addSchoolPhoneNumber" href="#">add another number</a></div>
                    </table>
                    <div><a id="removeSchoolPhoneNumber" href="#">remove number</a></div>
                </td>
            </tr>
        </table>
    </td>
</tr>
<tr class="emailsRow">

    <td class="phoneEmailNoteTd" colspan="2">
        <table>
            <tr>
                <td class="numTitle">School email addresses</td>
                <td>
                    <table class="nvpTable" id="schoolEmailsTable">
                        <tr>
                            <td>Description</td>
                            <td>Email address</td>
                        </tr>
                        <c:choose>
                            <c:when test="${not empty camp.schoolContact.emails}">
                                <c:forEach items="${camp.schoolContact.emails}" var="schoolEmail"
                                           varStatus="status">
                                    <tr id="${status.index}">
                                        <input type="hidden" name="schoolEmailID${status.index}"
                                               value="${schoolEmail.ID}"/>
                                        <td><input name="schoolEmailName${status.index}" value="${schoolEmail.name}">
                                        </td>
                                        <td><input class="email" name="schoolEmailAddress${status.index}"
                                                   value="${schoolEmail.address}"></td>
                                    </tr>
                                </c:forEach>
                            </c:when>
                            <c:otherwise>
                                <tr id="0">
                                    <td><input name="schoolEmailName0" value=""></td>
                                    <td><input class="email" name="schoolEmailAddress0" value=""></td>
                                </tr>
                            </c:otherwise>
                        </c:choose>
                        <div><a id="addSchoolEmail" href="#">add another email address</a></div>
                    </table>
                    <div><a id="removeSchoolEmail" href="#">remove email address</a></div>
                </td>
            </tr>
        </table>
    </td>

</tr>

<tr>
	<td>
		<table class="boxForm">

<tr>
	<td>Predicted student numbers</td>
	<td><form:input path="predictedStudents" cssClass="number"/></td>
</tr>

<tr>
	<td>Student registrations</td>
	<td><form:input path="studentRegistrations" cssClass="number"/></td>

	<td>Date stamp</td>
	<td><input name="dateStampToSave" class="dateselect date ${not empty camp.dateStamp?'dateChangeCheck':''}"
               value="<fmt:formatDate pattern='dd/MM/yyyy' value='${camp.dateStamp}' />"></td>
	
</tr>
<tr>
    <td>
        <div class="blueborder marginAll">
            <h2 class="marginLeft marginAll">Student count by age</h2>
            <table>
                <tr>
                    <td>6 - 7</td>
                    <td><form:input path="ageRange6_7" cssClass="number"/></td>
                </tr>
                <tr>
                    <td>8 - 10</td>
                    <td><form:input path="ageRange8_10" cssClass="number"/></td>
                </tr>
                <tr>
                    <td>11 - 12</td>
                    <td><form:input path="ageRange11_12" cssClass="number"/></td>
                </tr>
                <tr>
                    <td>13 - 14</td>
                    <td><form:input path="ageRange13_14" cssClass="number"/></td>
                </tr>
            </table>
        </div>
    </td>
</tr>
		


<tr>
	<td>Students for 2 weeks</td>
	<td><form:input path="students2Week" cssClass="number"/></td>
</tr>

<tr>
	<td>Students for 1 week</td>
	<td><form:input path="students1week" cssClass="number"/></td>
</tr>
<tr>
    <td>Number of siblings</td>
    <td><form:input path="siblingNumber" cssClass="number"/></td>
</tr>

		</table>
	</td>
</tr>

<tr>
	<td>
		<table class="boxForm">
<tr>
    <td>Coordinators Needed Total</td>
    <td><form:input path="coordinatorsNeeded" cssClass="required number"/></td>
</tr>
<tr>
    <td>Teachers Needed Total</td>
    <td><form:input path="teachersNeeded" cssClass="required number"/></td>
</tr>
<tr>
    <td>Drama Teachers Needed Total</td>
    <td><form:input path="dramaTeachersNeeded" cssClass="required number"/></td>
</tr>
<tr>
    <td>Activity Leaders Needed Total</td>
    <td><form:input path="activityLeadersNeeded" cssClass="required number"/></td>
</tr>

<tr>
    <td>Course Specialists Needed Total</td>
    <td><form:input path="courseSpecialistsNeeded" cssClass="required number"/></td>
</tr>

		</table>
	</td>
</tr>

<tr>
	<td>
		<table class="boxForm">
<tr>
    <td>Materials sent</td>
    <td><form:input path="materialsSent" /></td>
</tr>

<tr>
    <td>Items sent</td>
    <td><form:textarea path="itemsSent" rows="3" cols="20" /></td>
</tr>
                                                     
<tr>
    <td>Materials - Date sent:</td>
    <td><input name="forwardingDateToSave" class="dateselect date"
               value="<fmt:formatDate pattern='dd/MM/yyyy' value='${camp.forwardingDate}' />"></td>
</tr>
<tr>
    <td>Materials - Date received:</td>
    <td><input name="deliveryDateToSave" class="dateselect date"
               value="<fmt:formatDate pattern='dd/MM/yyyy' value='${camp.deliveryDate}' />"></td>
</tr>

<tr>
    <td>Materials - Time received:</td>
    <td><form:input path="timeReceived"/></td>
</tr>

<tr>
    <td>Signature</td>
    <td><form:input path="signature"/></td>
</tr>
		</table>
	</td>
</tr>
<tr class="notesRow">
    <td class="phoneEmailNoteTd" colspan="2">
        <table>
            <tr>
                <td class="numTitle">Notes</td>
                <td>
                    <table class="nvpTable" id="notesTable">
                        <tr>
                            <td>Description</td>
                            <td>Note</td>
                        </tr>

                        <c:choose>
                            <c:when test="${not empty camp.contact.notes}">
                                <c:forEach items="${camp.contact.notes}" var="note"
                                           varStatus="status">
                                    <tr id="${status.index}">
                                        <input type="hidden" name="noteID${status.index}" value="${note.ID}"/>
                                        <td><input name="noteName${status.index}" value="${note.name}"></td>
                                        <td><textarea name="noteText${status.index}" rows="3"
                                                      cols="20">${note.text}</textarea></td>
                                    </tr>
                                </c:forEach>
                            </c:when>
                            <c:otherwise>
                                <tr id="0">
                                    <td><input name="noteName0" value=""></td>
                                    <td><textarea name="noteText0" rows="3" cols="20"></textarea></td>
                                </tr>
                            </c:otherwise>
                        </c:choose>
                        <div><a id="addNote" href="#">add another note</a></div>
                    </table>
                    <div><a id="removeNote" href="#">remove note</a></div>
                </td>
            </tr>
        </table>
    </td>

</tr>

<tr>
    <td colspan="3">
        <input type="submit" id="saveCamp" value="Save Changes"/>
    </td>
</tr>
</table>
</form:form>
</div>

<div class="left marginLeft marginTop">
	<div class="blueBorder">
	    <div class="marginAll">
	        <h2>Current staff members:</h2>
	        <table>
	            <c:forEach items="${camp.staffMembers}" var="staffMember">
	                <tr>
	                    <form action="<c:url value="/process-camp-staff.htm" />">
	
	                        <input type="hidden" name="action" value="editStaffMember">
	                        <input type="hidden" name="campID" value="${camp.ID}">
	                        <input type="hidden" name="staffMemberID" value="${staffMember.ID}">
	                        <td width="100px">
	                            <a href="<c:url value="/staff-member.htm"/>?id=${staffMember.ID}">${staffMember.contact.secondName}, ${staffMember.contact.firstNames}</a>
	                        </td>
	                        <td>
	                            <select name="job">
	                                <option value="0">Select a role...</option>
	                                <c:if test="${staffMember.teacher}">
	                                    <option value="teacher"  ${staffMember.job=='teacher'?'SELECTED':''}>teacher
	                                    </option>
	                                </c:if>
	                                <c:if test="${staffMember.coordinator}">
	                                    <option value="coordinator" ${staffMember.job=='coordinator'?'SELECTED':''}>
	                                        coordinator
	                                    </option>
	                                </c:if>
	                                <c:if test="${staffMember.drama}">
	                                    <option value="drama" ${staffMember.job=='drama'?'SELECTED':''}>drama teacher
	                                    </option>
	                                </c:if>
	                                <c:if test="${staffMember.activityleader}">
	                                    <option value="activityleader" ${staffMember.job=='activityleader'?'SELECTED':''}>
	                                        activity leader
	                                    </option>
	                                </c:if>
	                                <c:if test="${staffMember.activityCoordinator}">
	                                    <option value="activityCoordinator" ${staffMember.job=='activityCoordinator'?'SELECTED':''}>
	                                        activity coordinator
	                                    </option>
	                                </c:if>
	                                <c:if test="${staffMember.dptCoordinator}">
	                                    <option value="dptCoordinator" ${staffMember.job=='dptCoordinator'?'SELECTED':''}>
	                                        DPT coordinator
	                                    </option>
	                                </c:if>
	                                <c:if test="${staffMember.courseSpecialist}">
	                                    <option value="courseSpecialist" ${staffMember.job=='courseSpecialist'?'SELECTED':''}>
	                                        course specialist
	                                    </option>
	                                </c:if>
	                            </select>
	                        </td>
	                        <td>
	                            offered? <input type="checkbox" name="offered"
	                                            value="offered" ${staffMember.offered?'CHECKED':''}/>
	                        </td>
	                        <td>
	                            accepted? <input type="checkbox" name="accepted"
	                                             value="offered" ${staffMember.accepted?'CHECKED':''}/>
	                        </td>
	                        <td>
	                            contracts returned? <input type="checkbox" name="returned"
	                                             value="returned" ${staffMember.returned?'CHECKED':''}/>
	                        </td>
	                        <td>
	                            <input type="submit" value="save">
	                        </td>
	                    </form>
	                    <form action="<c:url value="/generate-rtf.htm" />">
					        <input type="hidden" name="action" value="generateStaffContract">
                       		<input type="hidden" name="staffMemberID" value="${staffMember.ID}">
					        <input type="hidden" name="campID" value="${camp.ID}">
                            <td>
	                            <input type="submit" value="contract"/>
	                        </td>
					    </form>
					    <form action="<c:url value="/generate-rtf.htm" />">
					        <input type="hidden" name="action" value="generateStaffOffer">
                       		<input type="hidden" name="staffMemberID" value="${staffMember.ID}">
					        <input type="hidden" name="campID" value="${camp.ID}">
                            <td>
	                            <input type="submit" value="offer"/>
	                        </td>
					    </form>
	                    <form action="<c:url value="/process-camp-staff.htm" />">
	                        <input type="hidden" name="action" value="removeStaffMember">
	                        <input type="hidden" name="campID" value="${camp.ID}">
	                        <input type="hidden" name="staffMemberID" value="${staffMember.ID}">
	                        <td>
	                            <input type="submit" value="remove"/>
	                        </td>
	                    </form>
	                    <form class="marginAll" action="<c:url value="/itinerary.htm"/>" >
					        <input type="hidden" name="staffMemberID" value="${staffMember.ID}">
					        <input type="hidden" name="name" value="${camp.name}">
					        <input type="hidden" name="campID" value="${camp.ID}">
					        <td>
					        	<input type="submit" value="travel"/>
					        </td>
					    </form>
	                </tr>
	            </c:forEach>
	        </table>
	    </div>
	
	
	    <div class="marginAll">
	        <h2>Still needed...</h2>
	        <li>${coordinatorsStillNeeded} coordinators</li>
	        <li>${teachersStillNeeded} teachers</li>
	        <li>${dramaTeachersStillNeeded} drama teachers</li>
	        <li>${activityLeadersStillNeeded} activity leaders</li>
	   <%-- <li>${activityCoordinatorsStillNeeded} activity coordinators</li>
	  		<li>${dptCoordinatorsStillNeeded} dpt coordinators</li> --%>
	        <li>${courseSpecialistsStillNeeded} course specialists</li>
	    </div>
	
	    <c:if test="${fn:length(availableStaff)>0}">
	        <form class="marginAll" action="<c:url value="/process-camp-staff.htm" />">
	            <input type="hidden" name="action" value="addStaffMember">
	            <input type="hidden" name="campID" value="${camp.ID}">
	            <select name="staffMemberID">
	                <c:forEach items="${availableStaff}" var="staffMember">
	                    <option value="${staffMember.ID}">${staffMember.contact.secondName}
	                        - ${staffMember.contact.firstNames}</option>
	                </c:forEach>
	            </select>
	            <input type="submit" value="Add to camp"/>
	        </form>
	    </c:if>
		
	</div>
	
	<div>
		
		<div class="marginTop left">
			<jsp:include page="/WEB-INF/jsp/fragments/delete.jsp">
				<jsp:param name="action" value="Camp"/>
				<jsp:param name="deleted" value="${camp.deleted}" />
			    <jsp:param name="id" value="${camp.ID}"/>
			</jsp:include>
		</div>
		
		<div class="marginTop marginLeft left">
			<div class="blueborder">
				<h2 class="marginAll">Staff profiles document</h2>            
				<form action="<c:url value="/generate-rtf.htm" />">
					<input type="hidden" name="action" value="generateStaffProfilesForACamp">
		            <input type="hidden" name="id" value="${camp.ID}"/>
		            <input type="submit" value="generate"/>
		    	</form>
			</div>
		</div>
		<div class="marginTop marginLeft left">
			<div class="blueborder">
				<h2 class="marginAll">Host Family profiles document</h2>            
				<form action="<c:url value="/generate-rtf.htm" />">
					<input type="hidden" name="action" value="generateHostFamilyProfilesForACamp">
		            <input type="hidden" name="id" value="${camp.ID}"/>
		            <input type="submit" value="generate"/>
		    	</form>
			</div>
		</div>
		
	</div>
</div>
<div class="clear"></div>
<jsp:include page="../wireframe/footer.jsp"/>