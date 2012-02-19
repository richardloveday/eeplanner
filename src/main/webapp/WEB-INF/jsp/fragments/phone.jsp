<%--
  Created by IntelliJ IDEA.
  User: IvieC
  Date: 26-Jan-2010
  Time: 14:50:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="phoneNumber">

    <table>
        <tr>
            <td>
                <form action="/process-phone-email-note.htm">
                    <input type="hidden" name="action" value="storePhone">
                    <input type="hidden" name="phoneID" value="${param.phoneID}"/>
                    <input type="hidden" name="contactID" value="${param.contactID}"/>
                    <input type="hidden" name="redirectID" value="${param.redirectID}"/>
                    <input type="hidden" name="redirectPath" value="${param.redirectPath}"/>
                    <table>
                        <tr>
                            <td>
                                <input type="text" value="${param.phoneName}">
                            </td>
                            <td>
                                <input type="text" value="${param.phoneNumber}">
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
                    <input type="hidden" name="action" value="removePhone">
                    <input type="hidden" name="phoneID" value="${param.phoneID}"/>
                    <input type="hidden" name="redirectID" value="${param.redirectID}"/>
                    <input type="hidden" name="redirectPath" value="${param.redirectPath}"/>
                    <input value="remove this phone number">
                </form>
            </td>
        </tr>
    </table>

</div>