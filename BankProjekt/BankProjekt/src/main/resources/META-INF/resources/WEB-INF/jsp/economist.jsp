<%@  include file="common/header.jsp" %>
<%@ include file="common/navigation.jsp" %>
  <div class="container">
  
  <hr>
  <h1>Enter Economist Details:</h1>
  
  <form:form method="post" modelAttribute="economist">
		<fieldset class="mb-3">
			<form:label path="name">Name:</form:label>
			<form:input type="text" path="name" required="required" />
			<form:errors path="name" cssClass="text-warning" />
		</fieldset>
		<fieldset class="mb-3">
			<form:label path="surname">Surname:</form:label>
			<form:input type="text" path="surname" required="required" />
			<form:errors path="surname" cssClass="text-warning" />
		</fieldset>
		<fieldset class="mb-3">
			<form:label path="salary">Salary:</form:label>
			<form:input type="text" path="salary" required="required" />
			<form:errors path="salary" cssClass="text-warning" />
		</fieldset>
		<fieldset class="mb-3">
			<form:label path="yearsOfEmployee">Years Of Emoloyee:</form:label>
			<form:input type="text" path="yearsOfEmployee" required="required" />
			<form:errors path="yearsOfEmployee" cssClass="text-warning" />
		</fieldset>

		<form:input type="hidden" path="id" />
		<input type="submit" class="btn btn-success ">
     
  </form:form>
  </div>      
<%@ include file="common/footer.jsp" %>