<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
	<div class="row">
		<div class="col-md-6 col-md-offset-3 ">
			<div class="panel panel-primary">
				<div class="panel-heading">New Zone</div>
				<div class="panel-body">
					<form:form method="post" modelAttribute="zone">

						<fieldset class="form-group">
							<form:label path="zoneName">Name</form:label>
							<form:input path="zoneName" type="text" class="form-control"
								required="required" />
							<form:errors path="zoneName" cssClass="text-warning" />
						</fieldset>
						
						<fieldset class="form-group">
							<form:label path="description">Description</form:label>
							<form:input path="description" type="text" class="form-control"
								required="required" />
							<form:errors path="description" cssClass="text-warning" />
						</fieldset>
						

						<button type="submit" class="btn btn-success">Save</button>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>
<%@ include file="common/footer.jspf"%>