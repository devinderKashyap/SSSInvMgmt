<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">
	<div>
		<a type="button" class="btn btn-primary btn-md" href="/add-zone">Add Zone</a>
	</div>
	<br>
	<div class="panel panel-primary">
		<div class="panel-heading">
			<h3>Zones</h3>
		</div>
		<div class="panel-body">
			<table class="table table-striped">
				<thead>
					<tr>
						<th width="15%">Id</th>
						<th width="25%">Zone Name</th>
						<th width="25%">Zone Description</th>
						<th width="15%">Last Upadated</th>
						<th width="15%">Last Updated By</th>
						<th width="10%"></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${zones}" var="zone">
						<tr>
							<td>${zone.zId}</td>
							<td>${zone.zoneName}</td>
							<td>${zone.description}</td>
							<td>${zone.updated}</td>
							<td>${zone.updatedBy}</td>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

</div>
<%@ include file="common/footer.jspf"%>