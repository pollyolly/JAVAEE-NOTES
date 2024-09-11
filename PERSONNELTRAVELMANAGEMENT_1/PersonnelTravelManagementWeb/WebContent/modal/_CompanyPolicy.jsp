<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true"
	style="display: none;">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="panel panel-primary">
				<div class="panel-heading">
                        <h4>Company Policy</h4>
                        <div class="options">   
                                <!--a href="javascript:;"><i class="fa fa-cog"></i></a-->
                            <a href="javascript:;" class="panel-collapse"><i class="fa fa-chevron-down"></i></a>
                        </div>
                    </div>
                    <div class="panel-body collapse in">
                        <form class="form-horizontal" action="CompanyPolicy" method="POST">
                        <input type="hidden" class="form-control" name="forms" id="forms" value="editPolicy" />
                        <input type="hidden" class="form-control" name="policyid" id="policyid" />
					<div class="form-group ">
                            <label for="focusedinput" class="col-sm-4 control-label">Expense Age(days):</label>
                            <div class="col-sm-6">
                              <input type="number" class="form-control" id="expensedays2" name="expensedays2" placeholder="0">
                            </div>
                          </div>
					<div class="form-group">
						<label class="col-sm-4 control-label">Receipt Amount:</label>
						<div class="col-sm-6">
							<div class="input-group">
								<input class="form-control" type="number" id="receiptamount2" name="receiptamount2">
								<span class="input-group-addon">.00</span>
							</div>
						</div>
					</div>
                        <div class="form-group">
						<label class="col-sm-4 control-label">Max Expense:</label>
						<div class="col-sm-6">
							<div class="input-group">
								<input class="form-control" type="number" id="maxexpense2" name="maxexpense2">
								<span class="input-group-addon">.00</span>
							</div>
						</div>
					</div>
                          <div class="form-group">
						<label class="col-sm-4 control-label">Max Budget:</label>
						<div class="col-sm-6">
							<div class="input-group">
								<input class="form-control" type="number" id="maxbudget2" name="maxbudget2">
								<span class="input-group-addon">.00</span>
							</div>
						</div>
						</div>
                          <div class="form-group ">
                            <label for="mediuminput" class="col-sm-4 control-label">Status:</label>
                            <div class="col-sm-6">
                              <select name="status2" id="status2" class="form-control">
                                <option>Choose...</option>
                               <c:forEach items="${statuslist}" var="stat">
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
			</div>
		</div>
	</div>
	<!-- /.modal-content -->
</div>
<!-- /.modal-dialog -->
</div>