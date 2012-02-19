<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="../wireframe/header.jsp"/>
<jsp:include page="../wireframe/nav/mainnav.jsp"/>


<table>
	<tr>
		<td>
			<fieldset>
			<legend>Contacts</legend>
			<textarea name="contacts" rows="20" cols="50" readonly="readonly">${contacts}</textarea>
			</fieldset>
		</td>
		<td>
			<table>
				<tr>
					<td>
						<form method="POST" action="<c:url value="/camp-contacts.htm" />">
	   						<input type="hidden" name="action" value="camps">
	   						<input type="hidden" name="contacts" value="${contacts}">
	   						<input type="submit" value="add by camps"/>
	   					</form>
					</td>	
				</tr>	
				<tr>			
					<td>
						<form method="POST" action="<c:url value="/staff-contacts.htm" />">
	   						<input type="hidden" name="action" value="staff">
	   						<input type="hidden" name="contacts" value="${contacts}">
	   						<input type="submit" value="add by staff members"/>
	   					</form>
					</td>
				</tr>		
			</table>
		</td>
	</tr>
</table>

<div class="clear"></div>
<jsp:include page="../wireframe/footer.jsp"/>