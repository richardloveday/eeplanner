<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="../wireframe/header.jsp"/>
<jsp:include page="../wireframe/nav/mainnav.jsp"/>


<form method="POST" action="<c:url value="/mail.htm" />">
	   <input type="hidden" name="action" value="addCamp"/>
	   <input type="hidden" name="contacts" id="contacts" value="${contacts}"> 
	   <input type="submit" value="Add"/>
	     
		<br/><br/>
		<input type="checkbox" id="selectAll" /> Select All
		<br/><br/>

		<div>
 			<select name="showYear" id="showYear" >
  				<option value="2012" ${theYear==2012?'selected="selected"':''}>2012</option>
  				<option value="2011" ${theYear==2011?'selected="selected"':''}>2011</option>
  				<option value="2010" ${theYear==2010?'selected="selected"':''}>2010</option>					 
 			</select>
		</div>

		<br/><br/>

		<div>
    		<table class="listTable">
        		<tr>	
        			<th>name</th>
        			<th>start date</th>
        			<th>end date</th>
				</tr>
        		<c:forEach items="${camps}" var="camp">
            		<tr>
                		<td><input type="checkbox" name="${camp.ID}" /> ${camp.name}</td>
                		<td><fmt:formatDate pattern='dd/MM/yyyy' value='${camp.start}' /></td>
               		 	<td><fmt:formatDate pattern='dd/MM/yyyy' value='${camp.end}' /></td>

            		</tr>
       			</c:forEach>
    		</table>
		</div>  
</form>

<jsp:include page="../wireframe/footer.jsp"/>