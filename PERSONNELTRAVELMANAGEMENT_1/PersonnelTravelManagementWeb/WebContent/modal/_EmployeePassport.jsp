<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true"
	style="display: none;">
	<div class="modal-dialog">
		<div class="modal-content ">
			<div class="panel panel-primary">
                    <div class="panel-heading">
                        <h4>Employee Passport</h4>
                        <div class="options">   
                                <!--a href="javascript:;"><i class="fa fa-cog"></i></a-->
                            <a href="javascript:;" class="panel-collapse"><i class="fa fa-chevron-down"></i></a>
                        </div>
                    </div>
                    <div class="panel-body collapse in">
                 <form class="form-horizontal" action="EmployeePassport" method="POST">
										<input type="hidden"  name="forms" id="forms" value="updatePassport" />
										<input type="hidden"  name="id" id="id" value="" />
										<div class="form-group">
											<label for="focusedinput" class="col-sm-4 control-label">Employee:</label>
											<div class="col-sm-6">
												<select name="employee2" id="employee2" style="width: 100%;"
													class="select2">
													<option></option>
													<c:forEach items="${empList}" var="emp">
														<option value="${emp.employeeid}">${emp.employee}</option>
													</c:forEach>
												</select>
											</div>
										</div>
										<div class="form-group ">
											<label for="focusedinput" class="col-sm-4 control-label">Passport#:</label>
											<div class="col-sm-6">
												<input type="text" class="form-control" id="passport2"
													name="passport2" placeholder="Maximum 16 Characters">
											</div>
										</div>
										<div class="form-group ">
											 <label for="focusedinput" class="col-sm-4 control-label datepicker">Expiration Date:</label>
			                  				  <div class="col-sm-6">
			                                    <div class="input-group date datepicker">
			                                        <input type="text" class="form-control" id="expirationdate2" name="expirationdate2" placeholder="yyyy-mm-dd" required/>
			                                        <span class="input-group-addon"><i class="fa fa-calendar"></i></span>
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
                        <div class="col-sm-4">
                        </div>
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