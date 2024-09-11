<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true"
	style="display: none;">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h4>Destination</h4>
					<div class="options">
						<!--a href="javascript:;"><i class="fa fa-cog"></i></a-->
						<a href="javascript:;" class="panel-collapse"><i
							class="fa fa-chevron-down"></i></a>
					</div>
				</div>
				<div class="panel-body collapse in">
						<form class="form-horizontal" action="Destination" method="POST">
								<input type="hidden" class="form-control" name="forms" id="forms" value="updateDestination" />
								<input type="hidden"name="destinationid" id="destinationid" value="" />
										<div class="form-group ">
											<label for="focusedinput" class="col-sm-4 control-label">Code:</label>
											<div class="col-sm-6">
												<input type="text" class="form-control" name="code2" id="code2" placeholder="Name" required>
											</div>
										</div>
										<div class="form-group ">
											<label for="focusedinput" class="col-sm-4 control-label">City:</label>
											<div class="col-sm-6">
												<input type="text" class="form-control" name="city2"
													id="city2" placeholder="City" required>
											</div>
										</div>
										<div class="form-group ">
											<label for="focusedinput" class="col-sm-4 control-label">State:</label>
											<div class="col-sm-6">
												<input type="text" class="form-control" name="state2"
													id="state2" placeholder="State" required>
											</div>
										</div>
										<div class="form-group ">
											<label for="focusedinput" class="col-sm-4 control-label">Country:</label>
											<div class="col-sm-6">
												<input type="text" class="form-control" name="country2"
													id="country2" placeholder="Country" required>
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