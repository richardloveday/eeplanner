<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--@elvariable id="staff" type="java.util.List<com.eeplanner.datastructures.StaffMember>"--%>
<%--@elvariable id="camps" type="java.util.List<com.eeplanner.datastructures.Camp>"--%>
<%--@elvariable id="staffData" type="java.util.List<com.eeplanner.datastructures.StaffMemberSearchData>"--%>
<%--
  Created by IntelliJ IDEA.
  User: IvieC
  Date: 01-Feb-2010
  Time: 16:40:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="../wireframe/header.jsp"/>
<jsp:include page="../wireframe/nav/mainnav.jsp"/>
<jsp:include page="../wireframe/nav/search.jsp"/>

<div class="search">
    <form action="<c:url value="/search.htm"/> ">
        <select name="type">
            <option value="staff" ${type eq 'staff'?'SELECTED':''}>Staff</option>
            <option value="camp" ${type eq 'camp'?'SELECTED':''}>Camps</option>
        </select>
        <input name="text" value="${text}"/>
        <input type="submit" value="search"/>
    </form>
</div>

<div class="left">
    <c:choose>
        <c:when test="${not empty staff}">
            <table class="searchResultTable">
                <c:forEach items="${staff}" var="staffMember">
                    <tr>
                        <td>
                            <a href="<c:url value="/search.htm"/>?staffMemberID=${staffMember.ID}&text=${text}&type=${type}">${staffMember.contact.secondName}, ${staffMember.contact.firstNames}</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </c:when>
        <c:when test="${not empty camps}">
            <table class="searchResultTable">
                <c:forEach items="${camps}" var="camp">
                    <tr>
                        <td>
                            <a href="<c:url value="/search.htm"/>?campID=${camp.ID}&text=${text}&type=${type}">${camp.name}, ${camp.start}</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </c:when>
        <c:when test="${not empty staffData}">
        
            <div class="data">
                <h3>
                    <a href="<c:url value="/staff-member.htm"/>?id=${staffData[0].staffMember.ID}">${staffData[0].staffMember.contact.secondName}, ${staffData[0].staffMember.contact.firstNames}</a>
                </h3>
            </div>
            <c:forEach items="${staffData}" var="data">
                <div class="staffData blueBorder marginBottom"">
                    <div class="data left">
                    	
                        <h3>Camp - <a href="<c:url value="/camp.htm"/>?id=${data.camp.ID}">${data.camp.name}</a></h3>
                        <h3>Role - ${data.staffMember.job}</h3>
                        <table>
                            <tr>
                                <td><p>start date:</p></td>
                                <td><p><fmt:formatDate pattern='dd/MM/yyyy' value='${data.camp.start}'/></p></td>
                            </tr>
                            <tr>
                                <td><p>end date:</p></td>
                                <td><p><fmt:formatDate pattern='dd/MM/yyyy' value='${data.camp.end}'/></p></td>
                            </tr>
                        </table>
                    </div>
                    <div class="data left">

                        <c:choose>
                            <c:when test="${not empty data.flight}">
                                <h3>Flight - <a href="<c:url value="/flight.htm"/>?id=${data.flight.ID}">${data.flight.flightNumber}</a></h3>
                                <table>
                                    <tr>
                                        <td><p>destination:</p></td>
                                        <td><p>${data.flight.destination}</p></td>
                                    </tr>
                                    <tr>
                                        <td><p>carrier:</p></td>
                                        <td><p>${data.flight.carrier}</p></td>
                                    </tr>
                                    <tr>
                                        <td><p>type:</p></td>
                                        <td><p>${data.flight.type}</p></td>
                                    </tr>
                                    <tr>
                                        <td><p>outbound departure:</td>
                                        <td><p><fmt:formatDate pattern='dd/MM/yyyy HH:mm'
                                                               value='${data.flight.outboundDeparture}'/></p></td>
                                    </tr>
                                    <tr>
                                        <td><p>return departure:</p></td>
                                        <td><p><fmt:formatDate pattern='dd/MM/yyyy HH:mm'
                                                               value='${data.flight.returnDeparture}'/></p></td>
                                    </tr>
                                </table>
                            </c:when>
                            <c:otherwise>
                                <p class="error">This staff member is not<br/>on a flight for this camp<br/></p>
                            </c:otherwise>
                        </c:choose>

                    </div>
                    <div class="clear"></div>
                </div>
            </c:forEach>
        </c:when>
        <c:when test="${not empty camp}">
            show a list of camps searches
        </c:when>
    </c:choose>

</div>