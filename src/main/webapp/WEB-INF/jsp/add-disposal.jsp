<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
	<div class="row">
		<div class="col-md-6 col-md-offset-3 ">
			<div class="panel panel-primary">
				<div class="panel-heading">New Disposal</div>
				<div class="panel-body">
					<form:form method="post" modelAttribute="disposal">

						<fieldset class="form-group">
							<form:label path="description">description</form:label>
							<form:input path="description" type="text" class="form-control"
								required="required" />
							<form:errors path="description" cssClass="text-warning" />
						</fieldset>
						
						<fieldset class="form-group">
							<form:label path="vendorName">vendorName</form:label>
							<form:input path="vendorName" type="text" class="form-control"
								required="required" />
							<form:errors path="vendorName" cssClass="text-warning" />
						</fieldset>
						
						<fieldset class="form-group">
							<form:label path="type">sold/destroyed</form:label>
							<form:input path="type" type="text" class="form-control"
								required="required" />
							<form:errors path="type" cssClass="text-warning" />
						</fieldset>
						
						<fieldset class="form-group">
							<form:label path="disposalDate">disposalDate</form:label>
							<form:input path="disposalDate" type="date" class="form-control"
								required="required" />
							<form:errors path="disposalDate" cssClass="text-warning" />
						</fieldset>
						
						<table class="table table-striped">
							<thead>
								<tr>
									<th width="25%">Item Name</th>
									<th width="25%">Description</th>
									<th width="25%">Count</th>
								</tr>
							</thead>
							<tbody id="itemsTable">
							
									<tr>
										<td><input name="items[0].itemName" type="text" class="form-control" required="required" value=""></td>
										<td><input name="items[0].details" type="text" class="form-control" required="required" value=""></td>
										<td><input name="items[0].count" type="text" class="form-control" required="required" value=""></td>
									</tr>
								
							</tbody>
						</table>
						<button id="addItem" type="button" class="btn">Add Item</button>

						<button type="submit" class="btn btn-success">Save</button>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
  $(document).ready(function() {
      	var itemNum = 0;
		var itemRow = '<tr><td><input name="items[idx].itemName" type="text" class="form-control" required="required" value=""></td><td><input name="items[idx].details" type="text" class="form-control" required="required" value=""></td><td><input name="items[idx].count" type="text" class="form-control" required="required" value=""></td></tr>';
      	$("#addItem").click(function() {
          	itemNum++;
		$(itemsTable).append( itemRow.replace(/idx/g,itemNum));
      	});
  });
</script>
<%@ include file="common/footer.jspf"%>