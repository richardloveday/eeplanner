<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--@elvariable id="camp" type="com.eeplanner.datastructures.Camp"--%>
<%--@elvariable id="camps" type="java.util.List<com.eeplanner.datastructures.Camp>"--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="../wireframe/header.jsp"/>
<jsp:include page="../wireframe/nav/mainnav.jsp"/>
<jsp:include page="../wireframe/nav/template.jsp"/>

<h1 class="listHeader left">Templates</h1>
<br/><br/><br/>

<div class="clear"></div>
<div>
	List of Templates
    <table class="listTable">
    	<tr>
	        <th>Template Type</th>
	        <th>Update Date</th>
        </tr>
        <c:forEach items="${templateList}" var="template">
	        <tr>
	            <td>
	                <a href="<c:url value='/template.htm'/>?id=${template.ID}">${template.type}</a>
	            </td>
	            <td>${template.editedDate}</td>
	        </tr>
        </c:forEach>
    </table>

</div>
<jsp:include page="../wireframe/footer.jsp"/>