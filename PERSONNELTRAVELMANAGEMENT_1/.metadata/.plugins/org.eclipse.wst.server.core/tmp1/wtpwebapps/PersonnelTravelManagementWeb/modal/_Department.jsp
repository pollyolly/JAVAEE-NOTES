<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true"
	style="display: none;">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h4>Department</h4>
					<div class="options">
						<!--a href="javascript:;"><i class="fa fa-cog"></i></a-->
						<a href="javascript:;" class="panel-collapse"><i
							class="fa fa-chevron-down"></i></a>
					</div>
				</div>
				<div class="panel-body collapse in">
					<form class="form-horizontal" action="Department" method="POST">
						<input type="hidden" class="form-control" name="forms" id="forms"
							value="editDepartment" />
						<input type="hidden" class="form-control" name="departmentid2" id="departmentid2" />
						<div class="form-group ">
							<label for="focusedinput" class="col-sm-4 control-label">Name:</label>
							<div class="col-sm-6">
								<input type="text" class="form-control" name="name2" id="name2"
									placeholder="Name">
							</div>
						</div>
						<div class="form-group ">
							<label for="focusedinput" class="col-sm-4 control-label">Description:</label>
							<div class="col-sm-6">
								<textarea name="description2" id="description2" cols="20" rows="3"
									class="form-control"></textarea>
							</div>
						</div>
						<div class="form-group ">
							<label for="mediuminput" class="col-sm-4 control-label">Status:</label>
							<div class="col-sm-6">
								<select name="status2" id="status2" class="form-control">
									<option value="0">Choose...</option>
									<c:forEach items="${statlist}" var="stat">
										<option value="${stat.statusid}">${stat.status}</option>
									</c:forEach>
								</select>
							</div>
						</div>
				</div>
				<!---->
				<div class="panel-footer">
					<div class="row">
						<div class="col-sm-4"></div>
						<div class="col-sm-8">
							<div class="btn-toolbar">
								<input type="submit" class="btn-primary btn" value="Submit" />
								<input type="reset" class="btn-default btn" value="Clear" />
							</div>
						</div>
					</div>
				</div>
				</form>
				<!---->
			</div>
		</div>
	</div>
	<!-- /.modal-content -->
</div>
<!-- /.modal-dialog -->
</div>