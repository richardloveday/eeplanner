<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="../wireframe/header.jsp"/>
<jsp:include page="../wireframe/nav/mainnav.jsp"/>

<form method="POST" action="<c:url value="/mail.htm" />">
	   <input type="hidden" name="action" value="addStaff"/>
	   <input type="hidden" name="contacts" id="contacts" value="${contacts}"> 
	   <input type="submit" value="Add"/>
	     
		<br/><br/>
		<input type="checkbox" id="selectAll" /> Select All
		<br/><br/>

		<div>
			<table class="listTable">
        		<tr>
        			<th>Name</th>
				</tr>
        		<c:forEach items="${staffMembers}" var="staffMember">
           	 		<tr>
                		<td><input type="checkbox" name="${staffMember.ID}" /> ${staffMember.contact.secondName}, ${staffMember.contact.firstNames}</td>
            		</tr>
        		</c:forEach>
    		</table>
		</div>
</form>

<jsp:include page="../wireframe/footer.jsp"/>