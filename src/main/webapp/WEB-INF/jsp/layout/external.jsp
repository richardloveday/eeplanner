<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%><%@
taglib uri="http://www.springframework.org/tags/form" prefix="form"%><%@
taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%@ 
taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"
%><!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title><tiles:insertAttribute name="title" ignore="true" /></title>

	<script type="text/javascript" src="<c:url value='/js/jquery-1.3.2.min.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/js/jquery-ui-1.7.2.custom.min.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/js/jquery.validate.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/js/jquery.table.addrow.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/js/eeplanner.js'/>"></script>
    <link type="text/css" href="<c:url value="/css/ui-lightness/jquery-ui-1.8rc1.custom.css" />" rel="stylesheet" />
    
	<link rel="stylesheet" href="http://twitter.github.com/bootstrap/1.4.0/bootstrap.min.css">
	<link href="<c:url value="/css/bootstrap.css" />" rel="stylesheet" type="text/css" />
  </head>

  <body> 
  
  	<tiles:insertAttribute name="header" />
  	
  	<div class="container">

      <div class="content">
        <div class="page-header">
          <h1>${staffMember.contact.secondName}, ${staffMember.contact.firstNames}
          	<small>Please update and submit your information</small>
          </h1>
        </div>
       	<tiles:insertAttribute name="body" />
      </div>
		&nbsp;
    </div> <!-- /container -->
  	
  </body>
</html>