<%@ include file="common/header.jsp"%>
<%@ include file="common/navigation.jsp"%>
<div class="container">
	<hr>
	<h1>Your Economists are:</h1>
	<table class="table">
		<thead>
			<tr>

				<th>Name</th>
				<th>Surname</th>
				<th>salary</th>
				<th>Years of Employee</th>

			</tr>

		</thead>
		<tbody>
			<c:forEach items="${economists}" var="economist">
				<tr>
					<td>${economist.name }</td>
					<td>${economist.surname }</td>
					<td>${economist.salary }</td>
					<td>${economist.yearsOfEmployee}<c:choose>
							<c:when test="${economist.yearsOfEmployee == 1}">
                        year
                    </c:when>
							<c:otherwise>
                        years
                    </c:otherwise>
						</c:choose>
					</td>
					<td><a href="delete-economist?id=${economist.id}"
						class="btn btn-warning">Delete </a></td>
					<td><a href="update-economist?id=${programmer.id}"
						class="btn btn-success">Update </a></td>
					<td><a href="calculate-economist-bonus?id=${economist.id}"
						class="btn btn-success">Calculate Bonus </a></td>





				</tr>



			</c:forEach>

		</tbody>

	</table>
	<a href="add-economist" class="btn btn-success">Add Economist</a>
</div>
<%@ include file="common/footer.jsp"%>