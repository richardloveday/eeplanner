<%--
  Created by IntelliJ IDEA.
  User: IvieC
  Date: 23-Dec-2009
  Time: 16:06:44
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="../wireframe/header.jsp"/>
<jsp:include page="../wireframe/nav/mainnav.jsp"/>
<jsp:include page="../wireframe/nav/staff.jsp"/>

<h1 class="listHeader">Staff</h1>

<div class="clear"></div>


<div>Available in
    <select name="showYear" id="showYear">
        <option value="2012" ${showYear==2016?'selected="selected"':''}>2016</option>
        <option value="2012" ${showYear==2015?'selected="selected"':''}>2015</option>
        <option value="2012" ${showYear==2014?'selected="selected"':''}>2014</option>
        <option value="2012" ${showYear==2013?'selected="selected"':''}>2013</option>
        <option value="2012" ${showYear==2012?'selected="selected"':''}>2012</option>
        <option value="2011" ${showYear==2011?'selected="selected"':''}>2011</option>
        <option value="2010" ${showYear==2010?'selected="selected"':''}>2010</option>
        <option value="0" ${showYear==0?'selected="selected"':''}>Show All</option>
    </select>
</div>

<div>
    <form action="<c:url value="/staff-member-list.htm"/> ">
        show deleted?<input type="checkbox" name="showDeleted"
                            onchange="submit();" ${not empty param.showDeleted?'checked="checked"':''}/>
    </form>
</div>

<div class="clear"></div>
<div>
    <table class="listTable">
    	<tr>
	        <th>Name</th>
	        <th title="Updated by Staff">Updated</th>
	        <th title="Existing or New Staff">Existing</th>
	        <th title="Travelling within a 50 mile radius of London Gatwick">G50</th>
	        <th title="Activity Leader">AL</th>
			<th title="Teacher">T</th>
			<th title="Coordinator">Co</th>
			<th title="Drama Coordinator">DC</th>
			<th title="Split/Mixed Role">Split</th>
		</tr>
		<c:set var="itemIndex" value="1"/>
        <c:forEach items="${staffMembers}" var="staffMember" varStatus="status">
            <c:choose>
                <c:when test="${showYear==0}">

                    <tr>
                        <td>
                            <a href="<c:url value='/staff-member.htm'/>?id=${staffMember.ID}">${staffMember.contact.secondName}, ${staffMember.contact.firstNames}</a>
                        </td>
                        <td>${staffMember.parentID==-1 ? 'Y' : 'N'}</td>
                        <td>${staffMember.existing ? 'Y' : 'N'}</td>
                        <td>${staffMember.travelWithinLondon ? 'Y' : 'N'}</td>
                        <td>${staffMember.activityleader ? 'Y' : 'N'}</td>
                        <td>${staffMember.teacher ? 'Y' : 'N'}</td>
                        <td>${staffMember.coordinator ? 'Y' : 'N'}</td>
                        <td>${staffMember.drama ? 'Y' : 'N'}</td>
                        <td>${staffMember.mixedRole ? 'Y' : 'N'}</td>
                    </tr>
					<c:set var="itemIndex" value="${itemIndex+1}"/>
                </c:when>

                <c:otherwise>

                    <c:if test="${staffMember.staffAvailability.available1
                                    || staffMember.staffAvailability.available2
                                    || staffMember.staffAvailability.available3
                                    || staffMember.staffAvailability.available4
                                    || staffMember.staffAvailability.available5
                                    || staffMember.staffAvailability.available6
                                    || staffMember.staffAvailability.available7}">

                        <tr>
                            <td>
                                <a href="<c:url value='/staff-member.htm'/>?id=${staffMember.ID}">${staffMember.contact.secondName}, ${staffMember.contact.firstNames}</a>
                            </td>
                            <td>${staffMember.parentID==-1 ? 'Y' : 'N'}</td>
                            <td>${staffMember.existing ? 'Y' : 'N'}</td>
                            <td>${staffMember.travelWithinLondon ? 'Y' : 'N'}</td>
	                        <td>${staffMember.activityleader ? 'Y' : 'N'}</td>
	                        <td>${staffMember.teacher ? 'Y' : 'N'}</td>
	                        <td>${staffMember.coordinator ? 'Y' : 'N'}</td>
	                        <td>${staffMember.drama ? 'Y' : 'N'}</td>
	                        <td>${staffMember.mixedRole ? 'Y' : 'N'}</td>
                        </tr>
						<c:set var="itemIndex" value="${itemIndex+1}"/>
                    </c:if>

                </c:otherwise>

            </c:choose>
            
            <c:if test="${itemIndex%20==0}">
	            <tr>
			        <th>Name</th>
			        <th title="Updated by Staff">Updated</th>
			        <th title="Existing or New Staff">Existing</th>
			        <th title="Travelling within a 50 mile radius of London Gatwick">G50</th>
			        <th title="Activity Leader">AL</th>
					<th title="Teacher">T</th>
					<th title="Coordinator">Co</th>
					<th title="Drama Coordinator">DC</th>
					<th title="Split/Mixed Role">Split</th>
				</tr>
            </c:if>

        </c:forEach>
    </table>

</div>
<jsp:include page="../wireframe/footer.jsp"/>