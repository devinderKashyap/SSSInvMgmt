<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">
	<!-- <div>
		<a type="button" class="btn btn-primary btn-md" href="/add-log">Add Log</a>
	</div> -->
	<br>
	<div class="panel panel-primary">
		<div class="panel-heading">
			<h3>Zonal Inventory</h3>
		</div>
		<div class="panel-body">
			<table class="table table-striped">
				<thead>
					<tr>
						<th width="15%">Zone Name</th>
						<th width="15%">Item Name</th>
						<th width="15%">Quantity</th>
						<th width="15%">Last Updated</th>
						<th width="20%">Last Updated By</th>
						<th width="20%">Description</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${zoneinv}" var="item">
						<tr>
							<td>${item.zoneName}</td>
							<td>${item.itemName}</td>
							<td>${item.count}</td>
							<td>${item.updated}</td>
							<td>${item.updatedBy}</td>
							<td>${item.description}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

</div>
<%@ include file="common/footer.jspf"%>