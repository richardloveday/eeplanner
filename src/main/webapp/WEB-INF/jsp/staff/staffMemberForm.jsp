<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: IvieC
  Date: 08-Dec-2009
  Time: 16:25:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="../wireframe/header.jsp"/>
<jsp:include page="../wireframe/nav/mainnav.jsp"/>
<jsp:include page="../wireframe/nav/staff.jsp"/>

<form:form id="staffMemberForm" commandName="staffMember" cssClass="addValidation">
<form:hidden path="parentID"/>
<form:hidden path="hash"/>
<div class="blueBorder left">
<table>

<tr>
	<td>
		<table class="boxForm">
            <tr>
               <td>ID:</td>
                <td>${staffMember.ID}</td>
               </tr>  
            <tr>
                <td>First Name</td>
                <td><form:input path="contact.firstNames" cssClass="required"/></td>
            </tr>               
            <tr>
                <td>Surname</td>
                <td><form:input path="contact.secondName" cssClass="required"/></td>
            </tr>

            <tr>
                <td>Address</td>
                <td><form:textarea  path="contact.add1" rows="2"/></td>
            </tr>

            <tr>
                <td>City</td>
                <td><form:input path="contact.add2"/></td>
            </tr>
            <tr>
                <td>County</td>
                <td><form:input path="contact.add3"/></td>
            </tr>
            <tr>
                <td>Postcode</td>
                <td><form:input path="contact.postCode"/></td>
            </tr>
            <tr>
                <td>Country</td>
                <td><form:input path="contact.add4"/></td>
            </tr>
            
            </table>
	</td>
</tr>


            <tr>
                <td class="phoneEmailNoteTd" colspan="2">
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
                                        <c:when test="${not empty staffMember.contact.phoneNumbers}">
                                            <c:forEach items="${staffMember.contact.phoneNumbers}" var="phoneNumber"
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

                <td class="phoneEmailNoteTd" colspan="2">
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
                                        <c:when test="${not empty staffMember.contact.emails}">
                                            <c:forEach items="${staffMember.contact.emails}" var="email"
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

            </tr>

<tr>
	<td>
		<table class="boxForm">
			<tr>
                <td>
                	Will you be travelling from:
        		</td>
            </tr>
            <tr>
            	<td>
                    <form:checkbox path="travelWithinLondon" label="Within a 50 mile radius of London Gatwick"/>
	                <br/>
                    <form:checkbox path="travelOutside" label="Outside the UK"/>
            	</td>
            </tr>
    	</table>
	</td>
</tr>
<tr>
	<td>
		<table class="boxForm">
            <tr>
                <td>Role</td>
                <td>
                    <form:checkbox path="teacher" label="teacher"/><br/>
                    <form:checkbox path="activityleader" label="activity leader"/><br/>
                    <form:checkbox path="coordinator" label="coordinator"/><br/>
                    <form:checkbox path="drama" label="drama coordinator"/><br/>
                </td>
            </tr>
            
            </table>
	</td>
</tr>
         <%--    <tr>
                <td>Archive password</td>
                <td><form:input path="archivePassword"/></td>
            </tr>
           --%> 
<tr>
	<td>
		<table class="boxForm">
            <tr>
                <td>
                Existing: <form:radiobutton path="existing" value="true" id="existingStaff"/>
        		New: <form:radiobutton path="existing" value="false" id="newStaff"/> 
        		</td>
            </tr>
            <tr id="newStatus">
            	<td>
            	<form:checkbox path="applied" label="Applied"/><br/>
            	<form:checkbox path="interviewed" label="Interviewed"/><br/>
            	<form:checkbox path="approved" label="Approved"/><br/>
            	</td>
            </tr>
            
            </table>
	</td>
</tr>
<tr>
	<td>
		<table class="boxForm">            
            <tr>
                <td>Status</td>
                <td>
                    <form:select path="status">
                        <form:option value="DEV">DEV</form:option>
                        <form:option value="DE">DE</form:option>
                        <form:option value="PE">PE</form:option>
                        <form:option value="DNE">DNE</form:option>
                    </form:select>
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
                                        <c:when test="${not empty staffMember.contact.notes}">
                                            <c:forEach items="${staffMember.contact.notes}" var="note"
                                                       varStatus="status">
                                                <tr id="${status.index}">
                                                    <input type="hidden" name="noteID${status.index}"
                                                           value="${note.ID}"/>
                                                    <td><input name="noteName${status.index}" value="${note.name}"></td>
                                                    <td><textarea name="noteText${status.index}" rows="3" cols="20" >${note.text}</textarea></td>
                                                </tr>
                                            </c:forEach>
                                        </c:when>
                                        <c:otherwise>
                                            <tr id="0">
                                                <td><input name="noteName0" value=""></td>
                                                <td><textarea name="noteText0" rows="3" cols="20" ></textarea></td>
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
            
       
            </table>
	</td>
</tr>

<tr>
	<td>
		<table class="boxForm">
            <tr>
                <td>Profile</td>
                <td><form:textarea  path="profile" rows="5"  cols="35"/></td>

            </tr>
            </table>
	</td>
</tr>

<tr>
	<td>
		<table class="boxForm">

            <tr>
                <td>Date of birth</td>
                <td>
                    <input name="dobToSave" class="dateselect date"
                           value="<fmt:formatDate pattern='dd/MM/yyyy' value='${staffMember.contact.dob}' />">
                </td>
            </tr>
            <tr>
                <td>Sex</td>
                <td>
                    <form:select path="contact.sex">
                        <form:option value="male">male</form:option>
                        <form:option value="female">female</form:option>
                    </form:select>
                </td>
            </tr>
            
            <tr>
                <td>Medical Information</td>
                <td><form:textarea  path="medical" rows="3"/></td>
            </tr>
            
           <tr>
                <td>Special Dietary Requirements</td>
                <td><form:textarea  path="dietary" rows="3"/></td>
            </tr>
            <tr>
                <td>Emergency Contact Name</td>
                <td><form:input path="kinName"/></td>
            </tr>
            <tr>
                <td>Contact Number</td>
                <td><form:input path="kinNumber"/></td>
            </tr>
            
            
            </table>
	</td>
</tr>

<tr>
	<td>
		<table class="boxForm">

            <tr>
                <td>Account Holder Name</td>
                <td><form:input path="contact.accountHolderName"/></td>
            </tr>
            <tr>
                <td>Account Number</td>
                <td><form:input path="contact.accountNumber"/></td>
            </tr>
            <tr>
                <td>Sort Code</td>
                <td><form:input path="contact.accountSortCode"/></td>
            </tr>
            <tr>
                <td>National Insurance Number:</td>
                <td><form:input path="contact.nationalInsuranceNumber"/></td>
            </tr>
            <tr>
                <td>Are you a student?</td>
                <td>
					<form:radiobutton path="contact.student" value="true" /> Yes<br/>
					<form:radiobutton path="contact.student" value="false" /> No
				</td>
            </tr>
            </table>
	</td>
</tr>
<tr>
	<td>
		<table class="boxForm">
            <tr>
                <td>Office Notes</td>
                <td><form:textarea  path="officeNotes" rows="5"  cols="35"/></td>
            </tr>
            <tr>
                <td>Accept a mixed role?</td>
                <td>
                	<form:radiobutton path="mixedRole" value="true" /> Yes<br/>
					<form:radiobutton path="mixedRole" value="false" /> No
                </td>
            </tr>
            </table>
	</td>
</tr>
<tr>
	<td>
		<table class="boxForm">
            <tr>
                <td>Preferred age range:</td>
                <td>
                	<form:checkbox path="prefAgeGroup1" label="6-10"/>
                	<form:checkbox path="prefAgeGroup2" label="10-14"/>
                	<form:checkbox path="prefAgeAny" label="Any"/>
                </td>
            </tr>
            <tr>
                <td>Preferred activity</td>
                <td>
                </td>
            </tr>
            <tr>
                <td>Art</td>
                <td>
					<form:select path="prefActivityArt">
                		<form:option value="1" />
                		<form:option value="2" />
                		<form:option value="3" />
                		<form:option value="4" />
                	</form:select>
                </td>
            </tr>
            <tr>
                <td>Sport</td>
                <td>
					<form:select path="prefActivitySport">
                		<form:option value="1" />
                		<form:option value="2" />
                		<form:option value="3" />
                		<form:option value="4" />
                	</form:select>
                </td>
            </tr>
            <tr>
                <td>Drama</td>
                <td>
					<form:select path="prefActivityDrama">
                		<form:option value="1" />
                		<form:option value="2" />
                		<form:option value="3" />
                		<form:option value="4" />
                	</form:select>
                </td>
            </tr>
            <tr>
                <td>Any</td>
                <td>
					<form:select path="prefActivityAny">
                		<form:option value="1" />
                		<form:option value="2" />
                		<form:option value="3" />
                		<form:option value="4" />
                	</form:select>
                </td>
            </tr>
            <tr>
                <td>Staff Notes</td>
                <td><form:textarea  path="staffNotes" rows="5"  cols="35"/></td>
            </tr>
           </table>
	</td>
</tr>

            <tr>
                <td colspan="3">
                    <input type="submit" value="Save Changes"/>
                </td>
            </tr>
        </table>
</div>
<div class="left marginLeft">
	<div class="blueBorder marginBottom">
		<h2 class="marginAll">availability</h2>
		
		<br/>
		<div>	
 			<select name="staffYear" id="staffYear">
 				<option value="2010" ${staffMember.staffAvailability.year==2010?'selected="selected"':''}>2010</option>	
 				<option value="2011" ${staffMember.staffAvailability.year==2011?'selected="selected"':''}>2011</option>
 				<option value="2012" ${staffMember.staffAvailability.year==2012?'selected="selected"':''}>2012</option>
 				<option value="2013" ${staffMember.staffAvailability.year==2013?'selected="selected"':''}>2013</option> 				
 		 		<option value="2014" ${staffMember.staffAvailability.year==2014?'selected="selected"':''}>2014</option>
 				<option value="2015" ${staffMember.staffAvailability.year==2015?'selected="selected"':''}>2015</option>
 				<option value="2016" ${staffMember.staffAvailability.year==2016?'selected="selected"':''}>2016</option>
 				<option value="2017" ${staffMember.staffAvailability.year==2017?'selected="selected"':''}>2017</option>
 				<option value="2018" ${staffMember.staffAvailability.year==2018?'selected="selected"':''}>2018</option>
 				<option value="2019" ${staffMember.staffAvailability.year==2019?'selected="selected"':''}>2019</option>
 				 
 			</select>
 		</div>			
		<br/>	
				
		<table>
			<tr>
				<td>June</td>
				<td><form:checkbox path="staffAvailability.available1"/></td>
			</tr>
			<tr>
				<td>July</td>
				<td><form:checkbox path="staffAvailability.available2"/></td>
			</tr>
			<tr>
				<td>August</td>
				<td><form:checkbox path="staffAvailability.available3"/></td>
			</tr>
			<tr>
				<td>September</td>
				<td><form:checkbox  path="staffAvailability.available4"/></td>
			</tr>
			<tr>
				<td colspan="2"><form:textarea  path="staffAvailability.note" rows="2"/></td>
			</tr>
		</table>
		<input class="marginAll" type="submit" value="Save changes"/>
	</div>
</form:form>

<!-- switched off for now
	<div>
		<jsp:include page="/itinerary/itineraryList.htm">
			<jsp:param name="action" value="itineraryList"/> 
			<jsp:param name="id" value="${staffMember.ID}"/>
			<jsp:param name="year" value="${staffMember.staffAvailability.year}"/>
		</jsp:include>			
	</div>
-->
	
	<div>
		<jsp:include page="/WEB-INF/jsp/fragments/delete.jsp">
			<jsp:param name="action" value="StaffMember"/>
			<jsp:param name="deleted" value="${staffMember.deleted}" />
		    <jsp:param name="id" value="${staffMember.ID}"/>
		</jsp:include>
	</div>
	<div class="marginTop">
		<div class="blueBorder marginBottom">
			<h2 class="marginAll">External Update</h2>
			<p>
				<c:if test="${staffMember.parentID==0}">
					<select id="externalUpdateStatus">
						<option value="0" selected="selected">Enabled</option>
						<option value="-1">Disabled</option>
					</select>
					<br/>
					<a target="blank" href="<c:url value="/staff-member-external.htm?hash=${staffMember.hash}"/>">External Form Link</a>
				</c:if>
				<c:if test="${staffMember.parentID==-1}">
					<select id="externalUpdateStatus">
						<option value="0">Enabled</option>
						<option value="-1" selected="selected">Disabled</option>
					</select>
				</c:if>
			</p>
		</div>
	</div>
	
	<div class="marginTop marginLeft left">
		<div class="blueborder">
			<h2 class="marginAll">Staff Data Form</h2>            
			<form action="<c:url value="/generate-rtf.htm" />">
				<input type="hidden" name="action" value="generateStaffDataForm">
	            <input type="hidden" name="id" value="${staffMember.ID}"/>
	            <input type="submit" value="generate"/>
	    	</form>
		</div>
	</div>
	
</div>

<jsp:include page="../wireframe/footer.jsp"/>