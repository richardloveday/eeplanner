<%@ page isErrorPage="true" %>
<%@ page import="java.io.PrintWriter" %>
<div class="row">
	<div class="span14">
		<div class="alert-message block-message error">
			<a class="close" href="#">×</a>
			<p>
				<strong>The following exception occured while executing your request</strong>
			</p>
			<div class="alert-actions">
				<strong>DETAILS:</strong> ${exception.message}
		    	<a class="btn small" href="#" id="exceptionTrace">See Details</a>
		    	<div id="exceptionTraceContent" style="display: none;">
		    		<% exception.printStackTrace(new PrintWriter(out)); %>
		    	</div>
		  	</div>
		</div>
	</div>
</div>