<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">
	<div>
		<a type="button" class="btn btn-primary btn-md" href="/add-transaction">New Transaction</a>
	</div>
	<br>
	<div class="panel panel-primary">
		<div class="panel-heading">
			<h3>Transactions</h3>
		</div>
		<div class="panel-body">
			<table class="table table-striped">
				<thead>
					<tr>
						<th width="10%">TransactionID</th>
						<th width="10%">Type</th>
						<th width="10%">Assignment</th>
						<th width="15%">Zone</th>
						<th width="15%">Person</th>
						<th width="10%">Date</th>
						<th width="30%">Items</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${transactions}" var="transaction">
						<tr>
							
							<td>${transaction.transactionId}</td>
							<td>${transaction.transactionType}</td>
							<td>${transaction.assignedType}</td>
							<td>${transaction.zoneName}</td>
							<td>${transaction.personName}</td>
							<td>${transaction.transactionDate}</td>
							<td>
								<table class="table table-striped">
									<thead>
										<tr>
											<th width="30%">Name</th>
											<th width="30%">Count</th>
											<th width="40%">Detail</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${transaction.items}" var="item">
											<tr>
												<td>${item.itemName}</td>
												<td>${item.count}</td>
												<td>${item.details}</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

</div>
<%@ include file="common/footer.jspf"%>