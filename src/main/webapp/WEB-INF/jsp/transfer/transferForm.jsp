<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--@elvariable id="transfer" type="com.eeplanner.datastructures.Transfer"--%>

<jsp:include page="../wireframe/header.jsp"/>
<jsp:include page="../wireframe/nav/mainnav.jsp"/>
<jsp:include page="../wireframe/nav/travel.jsp"/>

<form:form commandName="transfer" cssClass="addValidation">

    <h2>Transfer ${transfer.ID>0?transfer.ID:""}</h2>
    <div class="left blueBorder">

        <table class="boxForm" style="margin: 5px;">

            <tr>
                <td colspan="2"><h2>Outbound</h2></td>
            </tr>
            <tr>
                <td>Type</td>
                <td>
                    <form:select path="outboundType">
                        <form:option value="company"/>
                        <form:option value="independent"/>
                    </form:select>
                </td>
            </tr>
            <tr>
                <td>Reference</td>
                <td><form:input path="outboundReference" cssClass="required"/></td>
            </tr>
            <tr>
                <td>departure point:</td>
                <td><form:input path="outboundDeparturePoint"/></td>
            </tr>
            <tr>
                <td>arrival point:</td>
                <td><form:input path="outboundArrivalPoint"/></td>
            </tr>
            <tr>
                <td colspan="2">
                    <div class="blueborder marginAll">
                        <h2 class="marginLeft marginAll">outbound</h2>
                        <table>
                            <tr>
                                <td>departure:</td>
                                <td><input name="outboundDepartureDateToSave" class="dateselect date"
                                           value="<fmt:formatDate pattern='dd/MM/yyyy' value='${transfer.outboundDeparture}' />">
                                </td>
                                <td><input size="1" class="number min max" name="outdephours" id="outdephours"
                                           value="<fmt:formatDate pattern='HH' value='${transfer.outboundDeparture}' />"></td>
                                <td>:<input size="1" class="number min max" name="outdepminutes" id="outdepminutes"
                                            value="<fmt:formatDate pattern='mm' value='${transfer.outboundDeparture}' />"></td>
                            </tr>
                            <tr>
                                <td>arrival:</td>
                                <td><input name="outboundArrivalDateToSave" class="dateselect date"
                                           value="<fmt:formatDate pattern='dd/MM/yyyy' value='${transfer.outboundArrival}' />">
                                </td>
                                <td><input size="1" class="number min max" name="outarrhours" id="outarrhours"
                                           value="<fmt:formatDate pattern='HH' value='${transfer.outboundArrival}' />"></td>
                                <td>:<input size="1" class="number min max" name="outarrminutes" id="outarrminutes"
                                            value="<fmt:formatDate pattern='mm' value='${transfer.outboundArrival}' />"></td>
                            </tr>
                        </table>
                    </div>
                </td>
            </tr>
            <tr>
                <td>notes:</td>
                <td colspan="2"><form:textarea path="outboundNotes"/></td>
            </tr>
        </table>
        <table class="boxForm" style="margin: 5px;">
            <tr>
                <td colspan="2"><h2>Return</h2></td>
            </tr>

            <tr>
                <td>Type:</td>
                <td>
                    <form:select path="returnType">
                        <form:option value="company"/>
                        <form:option value="independent"/>
                    </form:select>
                </td>
            </tr>
            <tr>
                <td>Reference:</td>
                <td><form:input path="returnReference" cssClass="required"/></td>
            </tr>
            <tr>
                <td>departure point:</td>
                <td><form:input path="returnDeparturePoint"/></td>
            </tr>
            <tr>
                <td>arrival point:</td>
                <td><form:input path="returnArrivalPoint"/></td>
            </tr>
            <tr>
                <td colspan="2">
                    <div class="blueborder marginAll">
                        <h2 class="marginLeft marginAll">return</h2>
                        <table>
                            <tr>
                                <td>departure:</td>
                                <td><input name="returnDepartureDateToSave" class="dateselect date"
                                           value="<fmt:formatDate pattern='dd/MM/yyyy' value='${transfer.returnDeparture}' />">
                                </td>
                                <td><input size="1" class="number min max" name="retdephours" id="retdephours"
                                           value="<fmt:formatDate pattern='HH' value='${transfer.returnDeparture}' />"></td>
                                <td>:<input size="1" class="number min max" name="retdepminutes" id="retdepminutes"
                                            value="<fmt:formatDate pattern='mm' value='${transfer.returnDeparture}' />"></td>
                            </tr>
                            <tr>
                                <td>arrival:</td>
                                <td><input name="returnArrivalDateToSave" class="dateselect date"
                                           value="<fmt:formatDate pattern='dd/MM/yyyy' value='${transfer.returnArrival}' />">
                                </td>
                                <td><input size="1" class="number min max" name="retarrhours" id="retarrhours"
                                           value="<fmt:formatDate pattern='HH' value='${transfer.returnArrival}' />"></td>
                                <td>:<input size="1" class="number min max" name="retarrminutes" id="retarrminutes"
                                            value="<fmt:formatDate pattern='mm' value='${transfer.returnArrival}' />"></td>
                            </tr>
                        </table>
                    </div>
                </td>
            </tr>
            <tr>
                <td>notes:</td>
                <td colspan="2"><form:textarea path="returnNotes"/></td>
            </tr>

        </table>

        <div><input type="submit" value="Save Changes"/></div>
    </div>

</form:form>
<div class="left">


	<div class="marginLeft left">
		<jsp:include page="/WEB-INF/jsp/fragments/delete.jsp">
			<jsp:param name="action" value="Transfer"/>
			<jsp:param name="deleted" value="${transfer.deleted}" />
		    <jsp:param name="id" value="${transfer.ID}"/>
		</jsp:include>
	</div>

</div>

<jsp:include page="../wireframe/footer.jsp"/>