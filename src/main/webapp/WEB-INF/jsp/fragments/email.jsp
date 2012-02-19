<%--
  Created by IntelliJ IDEA.
  User: IvieC
  Date: 26-Jan-2010
  Time: 14:51:32
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="email">

    <table>
        <tr>
            <td>
                <form action="/process-phone-email-note.htm">
                    <input type="hidden" name="action" value="storeEmail">
                    <input type="hidden" name="emailID" value="${param.emailID}"/>
                    <input type="hidden" name="contactID" value="${param.contactID}"/>
                    <input type="hidden" name="redirectID" value="${param.redirectID}"/>
                    <input type="hidden" name="redirectPath" value="${param.redirectPath}"/>
                    <table>
                        <tr>
                            <td>
                                <input type="text" value="${param.emailName}">
                            </td>
                            <td>
                                <input type="text" value="${param.emailAddress}">
                            </td>
                            <td>
                                <input value="save">
                            </td>
                        </tr>
                    </table>

                </form>
            </td>
            <td>
                <form action="/process-phone-email-note.htm">
                    <input type="hidden" name="action" value="removeEmail">
                    <input type="hidden" name="redirectID" value="${param.redirectID}"/>
                    <input type="hidden" name="redirectPath" value="${param.redirectPath}"/>
                    <input type="hidden" name="emailID" value="${param.emailID}"/>
                    <input value="remove this email">
                </form>
            </td>
        </tr>
    </table>

</div>