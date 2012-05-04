<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<form:form commandName="staffMember" cssClass="addValidation">
	<form:hidden path="ID"/>
	<form:hidden path="parentID"/>
	<div class="row">
		<div class="span14">
			<div class="alert-message block-message warning">
				<p>
					<strong>WARNING:</strong> YOU WILL ONLY BE ABLE TO ACCESS THIS FORM
					ONCE. PLEASE COMPLETE AND CHECK YOUR DETAILS CAREFULLY BEFORE
					PRESSING SUBMIT.
				</p>
			</div>
		</div>
		<div class="span8">
			<fieldset class="well">
				<div class="alert-message block-message info">
					<p>
						<strong>Please note:</strong> your name must be EXACTLY as shown on
						your passport, as it may be used for our flight lists. Please do not
						use abbreviations. If your name is not correct, you may be liable for
						a fee of up to &pound;100 for a name change with the airline.
					</p>
				</div>
				<div class="clearfix">
		            <label for="xlInput">First Name</label>
		            <div class="input">
		            	<form:input path="contact.firstNames" cssClass="medium required" size="30" />
		            </div>
				</div>
				<div class="clearfix">
		            <label for="xlInput">Surname</label>
		            <div class="input">
		            	<form:input path="contact.secondName" cssClass="medium required"/>
		            </div>
				</div>
				<div class="clearfix">
		            <label for="xlInput">Address</label>
		            <div class="input">
		            	<form:textarea  path="contact.add1" rows="2" cssClass="large"/>
		            </div>
				</div>
				<div class="clearfix">
		            <label for="xlInput">City</label>
		            <div class="input">
		              <form:input path="contact.add2" cssClass="small"/>
		            </div>
				</div>
				<div class="clearfix">
		            <label for="xlInput">County</label>
		            <div class="input">
		           	  <form:input path="contact.add3" cssClass="small"/>
		            </div>
				</div>
				<div class="clearfix">
		            <label for="xlInput">Postcode</label>
		            <div class="input">
		              <form:input path="contact.postCode" cssClass="small"/>
		            </div>
				</div>
				<div class="clearfix">
		            <label for="xlInput">Country</label>
		            <div class="input">
		              <form:input path="contact.add4" cssClass="small"/>
		            </div>
				</div>
			</fieldset>
			<fieldset class="well form-stacked">
				<p class="label notice">PHONE NUMBERS<a href="#phoneNumbers">&nbsp;</a></p>
				<div class="clearfix">
					<div>
						<a id="addPhoneNumber" href="#phoneNumbers" class="btn">Add Another Phone</a>
					</div>
					<table id="phoneNumbersTable" class="form-table" cellpadding="0" cellspacing="0">
						<thead>
							<tr>
								<th>Description</th>
								<th>Phone</th>
							</tr>
						</thead>
						<tbody>
							<c:choose>
                                <c:when test="${not empty staffMember.contact.phoneNumbers}">
                                    <c:forEach items="${staffMember.contact.phoneNumbers}" var="phoneNumber"
                                               varStatus="status">
                                        <tr id="${status.index}">
                                            <input type="hidden" name="phoneID${status.index}"
                                                   value="${phoneNumber.ID}"/>
                                            <td><input name="phoneName${status.index}"
                                                       value="${phoneNumber.name}" class="medium"></td>
                                            <td><input name="phoneNumber${status.index}"
                                                       value="${phoneNumber.number}" class="medium"></td>
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
						</tbody>
					</table>
					<div>
						<a id="removePhoneNumber" href="#phoneNumbers" class="btn danger" >Remove Number</a>
					</div>
				</div>
			</fieldset>
			<fieldset class="well form-stacked">
				<p class="label notice">EMAIL ADDRESSES<a href="#emailAddresses">&nbsp;</a></p>
				<div class="clearfix">
					<div>
						<a id="addEmail" href="#emailAddresses" class="btn">Add Another Email Address</a>
					</div>
					<table id="emailsTable" class="form-table" cellpadding="0" cellspacing="0">
						<thead>
							<tr>
								<th>Description</th>
								<th>Email Address</th>
							</tr>
						</thead>
						<tbody>
							<c:choose>
							  <c:when test="${not empty staffMember.contact.emails}">
                                  <c:forEach items="${staffMember.contact.emails}" var="email"
                                             varStatus="status">
                                      <tr id="${status.index}">
                                          <input type="hidden" name="emailID${status.index}"
                                                 value="${email.ID}" />
                                          <td><input name="emailName${status.index}" value="${email.name}" class="medium">
                                          </td>
                                          <td><input class="email" name="emailAddress${status.index}"
                                                     value="${email.address}" class="long"></td>
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
						</tbody>
					</table>
					<div>
						<a id="removeEmail" href="#emailAddresses" class="btn danger" >Remove Email Address</a>
					</div>
				</div>
			</fieldset>
			<fieldset class="well form-stacked">
				<p class="label notice">TRAVEL</p>
				<div class="clearfix">
					<label>Will you be travelling from:</label>
					<div class="input">
		              <ul class="inputs-list">
		                <li>
		                  <label>
		                    <form:checkbox path="travelWithinLondon" />
		                    <span>Within a 50 mile radius of London Gatwick</span>
		                  </label>
		                </li>
		                <li>
		                  <label>
		                    <form:checkbox path="travelOutside" />
		                    <span>Outside the UK</span>
		                  </label>
		                </li>
		              </ul>
		            </div>
		    	</div>
			</fieldset>
			<fieldset class="well form-stacked">
				<p class="label notice">PROFILE</p>
				<p>Please write a short statement about yourself, including
					experience teaching or working with children. This information will
					be given to your host family, colleagues on your camp and local
					coordinator.</p>
				<div class="clearfix">
		            <div class="input">
		            	<form:textarea  path="profile" rows="5" cssClass="xlarge" />
		            </div>
				</div>
			</fieldset>
			<fieldset class="well">
				<p class="label notice">
					PERSONAL INFORMATION
				</p>
				<div class="clearfix">
					<label for="xlInput">Date of Birth</label>
		            <div class="input">
		            	<input name="dobToSave" class="dateselect date small"
                           value="<fmt:formatDate pattern='dd/MM/yyyy' value='${staffMember.contact.dob}' />">
		            </div>
				</div>
				<div class="clearfix">
					<label for="xlInput">Gender</label>
					<div class="input">
						<form:select path="contact.sex" cssClass="small">
	                        <form:option value="male">male</form:option>
	                        <form:option value="female">female</form:option>
	                    </form:select>
		            </div>
				</div>
				<div class="clearfix">
					<label for="xlInput">Medical Information</label>
					<div class="input">
						<form:textarea  path="medical" rows="3" cssClass="large"/>
					</div>
				</div>
				<div class="clearfix">
					<label for="xlInput">Special Dietary Requirements</label>
					<div class="input">
						<form:textarea  path="dietary" rows="3" cssClass="large"/>
					</div>
				</div>
				<p class="label">
					EMERGENCY CONTACT
				</p>
				<div class="clearfix">
					<label for="xlInput">Name</label>
					<div class="input">
						<form:input path="kinName" cssClass="medium" />
					</div>
				</div>
				<div class="clearfix">
					<label for="xlInput">Phone Number</label>
					<div class="input">
						<form:input path="kinNumber" cssClass="medium" />
					</div>
				</div>
			</fieldset>
			<fieldset class="well">
				<p class="label notice">
					PAY and TAX INFORMATION
				</p>
				<div class="clearfix">
					<label for="xlInput">Account Holder Name</label>
		            <div class="input">
		            	<form:input path="contact.accountHolderName" cssClass="large"/>
		            </div>
				</div>
				<div class="clearfix">
					<label for="xlInput">Account Number</label>
		            <div class="input">
		            	<form:input path="contact.accountNumber" cssClass="medium"/>
		            </div>
				</div>
				<div class="clearfix">
					<label for="xlInput">Sort Code</label>
		            <div class="input">
		            	<form:input path="contact.accountSortCode" cssClass="small"/>
		            </div>
				</div>
				<div class="clearfix">
					<label for="xlInput">National Insurance Number:</label>
		            <div class="input">
		            	<form:input path="contact.nationalInsuranceNumber" cssClass="small"/>
		            </div>
				</div>
				<div class="clearfix">
					<label for="xlInput">Are you a student?</label>
		            <div class="input">
            		  <ul class="inputs-list">
		                <li>
		                  <label>
		                  	<form:radiobutton path="contact.student" value="true" />
		                    <span>Yes</span>
		                  </label>
		                </li>
		                <li>
		                  <label>
		                    <form:radiobutton path="contact.student" value="false" />
		                    <span>No</span>
		                  </label>
		                </li>
		              </ul>
		            </div>
				</div>
			</fieldset>
		</div>
		<div class="span6">
			<fieldset class="well form-stacked">
				<p class="label notice">ROLE</p>
				<div class="clearfix">
					<label>Please select the roles you are interested in:</label>
					<div class="input">
		              <ul class="inputs-list">
		                <li>
		                  <label>
		                  	<form:checkbox path="teacher" />
		                    <span>Teacher</span>
		                  </label>
		                </li>
		                <li>
		                  <label>
		                    <form:checkbox path="activityleader" />
		                    <span>Activity leader</span>
		                  </label>
		                </li>
		                <li>
		                  <label>
		                    <form:checkbox path="drama" />
		                    <span>Drama coordinator</span>
		                  </label>
		                </li>
		                <li>
		                  <label>
		                    <form:checkbox path="coordinator" />
		                    <span>Coordinator</span>
		                  </label>
		                </li>
		              </ul>
		            </div>
		    	</div>
		    	<div class="clearfix">
					<label>Occasionally our camps require staff to have a mixed
						role (usually 2 sessions teaching and one activity per day).
						Please indicate if you would be willing to accept a mixed role:</label>
					<div class="input">
		              <ul class="inputs-list">
		                <li>
		                  <label>
		                  	<form:radiobutton path="mixedRole" value="true" />
		                    <span>Yes</span>
                  		  </label>
		                </li>
		                <li>
		                  <label>
		                  	<form:radiobutton path="mixedRole" value="false" />
		                    <span>No</span>
	                  	  </label>
	                  	</li>
	                  </ul>					
					</div>
				</div>
			</fieldset>
			<fieldset class="well form-stacked">
				<p class="label notice">Availability</p>
				<div class="clearfix">
					<label>Most of our camps will run from 9th-23rd June,
						16th-30th June and 25th August- 8th September.
						You must select at least one month. If you are only available for specific 
						persiods within the month, please add this information in the notes box</label>
					<div class="input">
		              <ul class="inputs-list">
		                <li>
		                  <label>
		                  	<form:checkbox path="staffAvailability.available1" cssClass="staffAvailability "/>
		                    <span>June</span>
		                  </label>
		                </li>
		                <li>
		                  <label>
		                    <form:checkbox path="staffAvailability.available2" cssClass="staffAvailability "/>
		                    <span>July</span>
		                  </label>
		                </li>
		                <li>
		                  <label>
		                    <form:checkbox path="staffAvailability.available3" cssClass="staffAvailability" />
		                    <span>August</span>
		                  </label>
		                </li>
		                <li>
		                  <label>
		                    <form:checkbox path="staffAvailability.available4" cssClass="staffAvailability" />
		                    <span>September</span>
		                  </label>
		                </li>
		                <li>
		                	<form:textarea path="staffAvailability.note" rows="2" cssClass="xlarge validateAvailablity"/>
		                </li>
		              </ul>
		            </div>
		    	</div>
		    </fieldset>
		    <fieldset class="well form-stacked">
		    	<div class="alert-message block-message info">
					<p>Depending on your role, you will be expected to
					work with a range of ages and activities. However, while we cannot
					guarantee we will be able to accommodate your preference, please
					fill in the information below to help us place you appropriately.</p>
				</div>
				<div class="clearfix">
					<label>Preferred age range:</label>
					<div class="input">
						<form:checkbox path="prefAgeGroup1" />
	                    <span>6-10</span>&nbsp;
	                    <form:checkbox path="prefAgeGroup2" />
	                    <span>10-14</span>&nbsp;
	                    <form:checkbox path="prefAgeAny" />
	                    <span>any</span>
					</div>
				</div>
				<div class="clearfix">
					<label>Preferred activity:</label>
					<div class="input">
						<div class="input-prepend">
	                		<label class="add-on">Art&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
		                    <form:select path="prefActivityArt" cssClass="valid mini">
		                		<form:option value="1" />
		                		<form:option value="2" />
		                		<form:option value="3" />
		                		<form:option value="4" />
		                	</form:select>
		                </div>
		             </div>
	             </div>
        		 <div class="clearfix">
		             <div class="input">
		                <div class="input-prepend">
	                		<label class="add-on">Sport&nbsp;&nbsp;</label>
	                		<form:select path="prefActivitySport" cssClass="valid mini">
		                		<form:option value="1" />
		                		<form:option value="2" />
		                		<form:option value="3" />
		                		<form:option value="4" />
		                	</form:select>
		                </div>
	                </div>
	             </div>
        		 <div class="clearfix">
		             <div class="input">
		                <div class="input-prepend">
	                		<label class="add-on">Drama</label>
		                    <form:select path="prefActivityDrama" cssClass="valid mini">
		                		<form:option value="1" />
		                		<form:option value="2" />
		                		<form:option value="3" />
		                		<form:option value="4" />
		                	</form:select>
		                </div>
		             </div>
	             </div>
        		 <div class="clearfix">
		             <div class="input">
		                <div class="input-prepend">
	                		<label class="add-on">Any&nbsp;&nbsp;&nbsp;&nbsp;</label>
	                		<form:select path="prefActivityAny" cssClass="valid mini">
		                		<form:option value="1" />
		                		<form:option value="2" />
		                		<form:option value="3" />
		                		<form:option value="4" />
		                	</form:select>
		                </div>
					</div>
				</div>
			</fieldset>		
			<fieldset class="well form-stacked">   
				<p class="label">
					NOTES
				</p>
				<div class="clearfix">
					<label>Please type any additional note:</label>
					<form:textarea  path="staffNotes" rows="3" cssClass="xlarge"/>
				</div>
			</fieldset>
		</div>
	</div>
	<div class="row">
		<div class="span14">
			<div class="actions">
				<input type="submit" name="submitOperation" value="Save changes" class="btn primary large" >&nbsp;
				<button type="submit" name="submitOperation" value="Submit" class="btn large success">Submit changes</button>
			</div>
		</div>
	</div>
</form:form>
