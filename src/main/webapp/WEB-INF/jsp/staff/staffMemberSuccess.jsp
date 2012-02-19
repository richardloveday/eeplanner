<%--
  Created by IntelliJ IDEA.
  User: IvieC
  Date: 10-Dec-2009
  Time: 16:11:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:redirect url="/staff-member.htm?id=${staffMember.ID}&staffYear=${staffMember.staffAvailability.year}" />