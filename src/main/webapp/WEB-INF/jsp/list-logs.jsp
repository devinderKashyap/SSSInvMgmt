<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">
	<div>
		<a type="button" class="btn btn-primary btn-md" href="/add-log">Add Log</a>
	</div>
	<br>
	<div class="panel panel-primary">
		<div class="panel-heading">
			<h3>Inventory Logs</h3>
		</div>
		<div class="panel-body">
			<table class="table table-striped">
				<thead>
					<tr>
						<th width="15%">LogID</th>
						<th width="15%">Date</th>
						<th width="15%">Type</th>
						<th width="15%">To</th>
						<th width="15%">From</th>
						<th width="15%">Quantity</th>
						<th width="10%"></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${logs}" var="log">
						<tr>
							<td>${log.logID}</td>
							<td>${log.date}</td>
							<td>${log.type}</td>
							<td>${log.toLoc}</td>
							<td>${log.fromLoc}</td>
							<td>${log.quantity}</td>
							<%-- <td><fmt:formatDate value="${todo.targetDate}"
									pattern="dd/MM/yyyy" /></td>
							<td><a type="button" class="btn btn-success"
								href="/update-todo?id=${todo.id}">Update</a>
							<a type="button" class="btn btn-warning"
								href="/delete-todo?id=${todo.id}">Delete</a></td> --%>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

</div>
<%@ include file="common/footer.jspf"%>