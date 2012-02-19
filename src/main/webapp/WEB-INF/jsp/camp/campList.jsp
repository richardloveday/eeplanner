<%--
  Created by IntelliJ IDEA.
  User: IvieC
  Date: 11-Jan-2010
  Time: 16:55:10
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--@elvariable id="camp" type="com.eeplanner.datastructures.Camp"--%>
<%--@elvariable id="camps" type="java.util.List<com.eeplanner.datastructures.Camp>"--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="../wireframe/header.jsp"/>
<jsp:include page="../wireframe/nav/mainnav.jsp"/>
<jsp:include page="../wireframe/nav/camps.jsp"/>

<h1 class="listHeader left">Camps</h1>
<br/><br/><br/>

<div>
 <select name="showYear" id="showYearCombo">
 <option value="2012" ${theYear==2012?'selected="selected"':''}>2012</option>
  <option value="2011" ${theYear==2011?'selected="selected"':''}>2011</option>
  <option value="2010" ${theYear==2010?'selected="selected"':''}>2010</option>
 </select>
</div>
<p>&nbsp;</p>
<div>
  Order by
  <select name="orderBy" id="orderBy">
      <option value="name" ${orderBy=='name'?'selected="selected"':''}>name</option>
      <option value="date" ${orderBy=='date'?'selected="selected"':''}>date</option>
  </select>
</div>
<div>
	<form action="<c:url value="/mail-camp-contacts.htm"/>">
		show deleted?<input type="checkbox" name="showDeleted" id="showDeleted" ${showDeleted=="true"?'checked="checked"':''}/>
	</form>
<div>																		
</div>
	<input type="button" id="copyAll" value ="Copy camps from last year"/>
</div>
<br/>
<br/>



<div class="clear"></div>
<div>
    <table class="listTable">
        <th>name</th>
        <th>start date</th>
        <th>end date</th>
        <th>still needed count</th>
        <th>activity leaders needed</th>
        <th>coordinators needed</th>
        <th>drama teachers needed</th>
        <th>teachers needed</th>
        <c:forEach items="${camps}" var="camp">
            <tr>
                <c:if test="${camp.name == 'Total'}">
                	<td>${camp.name}</td>
                 </c:if>
                 <c:if test="${camp.name != 'Total'}">
                  	<td><a href="<c:url value='/camp.htm'/>?id=${camp.ID}">${camp.name}</a></td>
                 </c:if>
                <td><fmt:formatDate pattern='dd/MM/yyyy' value='${camp.start}' /></td>
                <td><fmt:formatDate pattern='dd/MM/yyyy' value='${camp.end}' /></td>
                
                
                <td>${camp.activityLeadersStillNeeded + camp.coordinatorsStillNeeded + camp.dramaTeachersStillNeeded + camp.teachersStillNeeded}</td>
                <td>${camp.activityLeadersStillNeeded}</td>
                <td>${camp.coordinatorsStillNeeded}</td> 
                <td>${camp.dramaTeachersStillNeeded}</td> 
                <td>${camp.teachersStillNeeded}</td>
            </tr>
        </c:forEach>
    </table>
</div>
<jsp:include page="../wireframe/footer.jsp"/>