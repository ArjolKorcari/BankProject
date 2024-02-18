<%@ include file="common/header.jsp"%>
<%@ include file="common/navigation.jsp"%>
<div class= "container">
  <hr>
  <h1>Your Programmers are:</h1>
  <table class="table">
       <thead>
           <tr>
           
           <th>Name</th>
           <th>Surname</th>
           <th>Description</th>
           <th>salary</th>
           <th>Tasks</th>
           <th>Years of Employee</th>
        
          
           </tr>
       
       </thead>
       <tbody>
       <c:forEach items="${programmers}" var="programmer">
          <tr>
            <td>${programmer.name }</td>
            <td>${programmer.surname }</td>
            <td>${programmer.description }</td>
            <td>${programmer.salary }</td>
            <td>${programmer.tasks }</td>
             <td>
                ${programmer.yearsOfEmployee} 
                <c:choose>
                    <c:when test="${programmer.yearsOfEmployee == 1}">
                        year
                    </c:when>
                    <c:otherwise>
                        years
                    </c:otherwise>
                </c:choose>
            </td>
            <td><a href="delete-programmer?id=${programmer.id}"
						class="btn btn-warning">Delete </a></td>
					<td><a href="update-programmer?id=${programmer.id}"
						class="btn btn-success">Update </a></td>
						<td><a href="calculate-bonus?id=${programmer.id}"
						class="btn btn-success">Calculate Bonus </a></td>
						
          
          
          
          
          </tr>
          
       
       
       </c:forEach>
       
       </tbody>
  
  </table>
  <a href="add-programmer" class="btn btn-success">Add Programmer</a>
</div>
<%@ include file="common/footer.jsp"%>