<%--
  Created by IntelliJ IDEA.
  User: IvieC
  Date: 26-Jan-2010
  Time: 14:51:38
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="note">

    <table>
        <tr>
            <td>
                <form action="/process-phone-email-note.htm">
                    <input type="hidden" name="action" value="storeNote">
                    <input type="hidden" name="noteID" value="${param.noteID}"/>
                    <input type="hidden" name="contactID" value="${param.contactID}"/>
                    <input type="hidden" name="redirectID" value="${param.redirectID}"/>
                    <input type="hidden" name="redirectPath" value="${param.redirectPath}"/>
                    <table>
                        <tr>
                            <td>
                                <input type="text" value="${param.noteName}">
                            </td>
                            <td>
                                <input type="text" value="${param.noteText}">
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
                    <input type="hidden" name="action" value="removeNote">
                    <input type="hidden" name="noteID" value="${param.noteID}"/>
                    <input type="hidden" name="redirectID" value="${param.redirectID}"/>
                    <input type="hidden" name="redirectPath" value="${param.redirectPath}"/>
                    <input value="remove this note">
                </form>
            </td>
        </tr>
    </table>

</div>