<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">
	<div>
		<a type="button" class="btn btn-primary btn-md" href="/add-purchase">New Purchase</a>
	</div>
	<br>
	<div class="panel panel-primary">
		<div class="panel-heading">
			<h3>Purchases</h3>
		</div>
		<div class="panel-body">
			<table class="table table-striped">
				<thead>
					<tr>
						<th width="10%">PurchaseID</th>
						<th width="15%">Description</th>
						<th width="15%">Vendor</th>
						<th width="15%">Purchase Date</th>
						<th width="15%">Invoice No.</th>
						<th width="30%">Items</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${purchases}" var="purchase">
						<tr>
							
							<td>${purchase.purchaseId}</td>
							<td>${purchase.description}</td>
							<td>${purchase.vendorName}</td>
							<td>${purchase.purchaseDate}</td>
							<td>${purchase.invoiceNumber}</td>
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
										<c:forEach items="${purchase.items}" var="item">
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