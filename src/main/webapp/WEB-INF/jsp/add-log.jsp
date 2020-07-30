<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
	<div class="row">
		<div class="col-md-6 col-md-offset-3 ">
			<div class="panel panel-primary">
				<div class="panel-heading">Add Log</div>
				<div class="panel-body">
					<form:form method="post" modelAttribute="log">
						<%-- <form:hidden path="id" /> --%>
						
						<%-- <fieldset class="form-group">
							<form:label path="description">Description</form:label>
							<form:input path="description" type="text" class="form-control"
								required="required" />
							<form:errors path="description" cssClass="text-warning" />
						</fieldset> --%>

						<fieldset class="form-group">
							<form:label path="type">Type</form:label>
							<form:input path="type" type="text" class="form-control"
								required="required" />
							<form:errors path="type" cssClass="text-warning" />
						</fieldset>
						
						<fieldset class="form-group">
							<form:label path="toLoc">To Location</form:label>
							<form:input path="toLoc" type="text" class="form-control"
								required="required" />
							<form:errors path="toLoc" cssClass="text-warning" />
						</fieldset>
						
						<fieldset class="form-group">
							<form:label path="fromLoc">From Location</form:label>
							<form:input path="fromLoc" type="text" class="form-control"
								required="required" />
							<form:errors path="fromLoc" cssClass="text-warning" />
						</fieldset>
						
						<fieldset class="form-group">
							<form:label path="quantity">Quantity</form:label>
							<form:input path="quantity" type="text" class="form-control"
								required="required" />
							<form:errors path="quantity" cssClass="text-warning" />
						</fieldset>

						<button type="submit" class="btn btn-success">Save</button>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>
<%@ include file="common/footer.jspf"%>