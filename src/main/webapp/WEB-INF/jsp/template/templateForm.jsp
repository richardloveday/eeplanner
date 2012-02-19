<%@page import="java.lang.reflect.AccessibleObject"%>
<%@page import="java.lang.reflect.Field"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="../wireframe/header.jsp"/>
<jsp:include page="../wireframe/nav/mainnav.jsp"/>

<form:form commandName="template" cssClass="addValidation" method="POST" enctype="multipart/form-data">
<div class="blueBorder left">
<table>

<tr>
	<td>
		<table class="boxForm">
			<c:if test="${template.ID>0}">
				<tr>
					<td>Edited Date</td>
					<td>${template.editedDate}</td>
				</tr>
			</c:if>
            <tr>
                <td>Template Type</td>
                <td><form:select path="type" cssClass="required">
					     <form:option value="" label="--Please Select"/>
					     <form:options items="${typeList}" />
					</form:select>
					<span><form:errors path="type" cssClass="error" /></span>
				</td>
            </tr>
            <tr>
                <td>RTF Document</td>
                <td><input type="file" name="text" id="text" cssClass="required"/>
                	<span><form:errors path="text" cssClass="error" /></span>
                	<c:if test="${template.ID>0}">
                		<a href="<c:url value="/generate-rtf.htm" />?action=viewTemplateDocument&id=${template.ID}">View Document</a>
                	</c:if>
                </td>
            </tr>
            <tr>
             	<td></td>
                <td>
                    <input type="submit" value="Save Changes"/>
                </td>
            </tr>
         </table>
	</td>
</tr>

</table>

	<h4>Available Fields for templates</h4>
	<div id="accordion">
	    <h3><a href="#">&nbsp;&nbsp;&nbsp;Contract of a Staff Member</a></h3>
	    <div>
	    	<ul>
	    		<li>staff
					<ul style="height:100px;overflow: auto;">
						<%
			    			Field[] fields = com.eeplanner.datastructures.StaffMember.class.getDeclaredFields();
			    			AccessibleObject.setAccessible(fields, true);
			                for (int i = 0; i < fields.length; i++) {
			                    Field field = fields[i];
			                    String fieldName = field.getName();
			                    out.println("<li>" + field.getName() + "</li>");
			                }
		    			%>
	    			</ul>
	    		</li>
	    		<li>camp
	    			<ul style="height:100px;overflow: auto;">
    				<%
		    			fields = com.eeplanner.datastructures.Camp.class.getDeclaredFields();
		    			AccessibleObject.setAccessible(fields, true);
		                for (int i = 0; i < fields.length; i++) {
		                    Field field = fields[i];
		                    String fieldName = field.getName();
		                    out.println("<li>" + field.getName() + "</li>");
		                }
	    			%>
	    			</ul>
	    		</li>
	    		<li>campStaff
	    			<ul>
    				<%
		    			fields = com.eeplanner.datastructures.CampStaff.class.getDeclaredFields();
		    			AccessibleObject.setAccessible(fields, true);
		                for (int i = 0; i < fields.length; i++) {
		                    Field field = fields[i];
		                    String fieldName = field.getName();
		                    out.println("<li>" + field.getName() + "</li>");
		                }
	    			%>
	    			</ul>
	    		</li>
	    		<li>currentDate</li>
	    	</ul>
	    </div>
	    <h3><a href="#">&nbsp;&nbsp;&nbsp;Offer_Letter</a></h3>
	    <div>
	    	Second content
	    </div>
	    <h3><a href="#">&nbsp;&nbsp;&nbsp;Travel_info_for_a_camp</a></h3>
	    <div>
	    	Third content
	    </div>
	    <h3><a href="#">&nbsp;&nbsp;&nbsp;Staff_profiles_for_a_camp</a></h3>
	    <div>
	    	Fourth content
	    </div>
	    <h3><a href="#">&nbsp;&nbsp;&nbsp;Host_family_profiles_for_a_camp</a></h3>
	    <div>
	    	Fifth content
	    </div>
	    <h3><a href="#">&nbsp;&nbsp;&nbsp;List_staff_on_a_camp</a></h3>
	    <div>
	    	Sixth content
	    </div>
	    <h3><a href="#">&nbsp;&nbsp;&nbsp;Flight_data</a></h3>
	    <div>
	    	Seventh content
	    </div>
	</div>
</div>
</form:form>

<jsp:include page="../wireframe/footer.jsp"/>