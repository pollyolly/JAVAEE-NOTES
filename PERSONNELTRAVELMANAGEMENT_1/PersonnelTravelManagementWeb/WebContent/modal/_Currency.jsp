<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true"
	style="display: none;">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h4>Approving Officer</h4>
					<div class="options">
						<!--a href="javascript:;"><i class="fa fa-cog"></i></a-->
						<a href="javascript:;" class="panel-collapse"><i
							class="fa fa-chevron-down"></i></a>
					</div>
				</div>
				<div class="panel-body collapse in">
									<form class="form-horizontal" action="Currency" method="POST">
										<input type="hidden"  name="forms" id="forms" value="updateCurrency" />
										<input type="hidden"  name="currencyid" id="currencyid" value=""/>
										<div class="form-group ">
											<label for="focusedinput" class="col-sm-4 control-label">Name:</label>
											<div class="col-sm-6">
												<input type="text" class="form-control" id="name2" name="name2" required>
											</div>
										</div>
										<div class="form-group ">
											<label for="focusedinput" class="col-sm-4 control-label">Country:</label>
											<div class="col-sm-6">
												<input type="text" class="form-control" id="country2" name="country2" required>
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-4 control-label">Rate:</label>
											<div class="col-sm-6">
												<div class="input-group">
													<input id="rate2" name="rate2" class="form-control" type="text" required>
													<span class="input-group-addon">.00</span>
												</div>
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