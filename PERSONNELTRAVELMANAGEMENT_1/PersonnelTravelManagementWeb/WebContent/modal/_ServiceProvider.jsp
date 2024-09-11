<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true"
	style="display: none;">
	<div class="modal-dialog">
		<div class="modal-content">
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h4>Service Provider</h4>
                        <div class="options">   
                                <!--a href="javascript:;"><i class="fa fa-cog"></i></a-->
                            <a href="javascript:;" class="panel-collapse"><i class="fa fa-chevron-down"></i></a>
                        </div>
                    </div>
                    <div class="panel-body collapse in">
                        <form class="form-horizontal"  action="ServiceProvider" method="POST">
                          <div class="form-group ">
                          <input type="hidden" id="forms" name="forms" value="updateSP">
                          <input type="hidden" id="id" name="id" value="">
                            <label for="focusedinput" class="col-sm-4 control-label">Company:</label>
                            <div class="col-sm-6">
                              <input type="text" class="form-control" id="company2" name="company2" placeholder="Name">
                            </div>
                          </div>
					<div class="form-group ">
                            <label for="focusedinput" class="col-sm-4 control-label">Contact:</label>
                            <div class="col-sm-6">
                              <input type="text" class="form-control" id="contact2" name="contact2" placeholder="000-0000/+63000000000">
                            </div>
                          </div>
					<div class="form-group ">
                            <label for="focusedinput" class="col-sm-4 control-label">Website:</label>
                            <div class="col-sm-6">
                              <input type="text" class="form-control" id="website2" name="website2" placeholder="http://">
                            </div>
                          </div>
					<div class="form-group ">
                            <label for="focusedinput" class="col-sm-4 control-label">Email:</label>
                            <div class="col-sm-6">
                              <input type="text" class="form-control" id="email2" name="email2" placeholder="@yahoo.com">
                            </div>
                          </div>
					<div class="form-group ">
                            <label for="focusedinput" class="col-sm-4 control-label">Address:</label>
                            <div class="col-sm-6">
                             <textarea id="address2" name="address2" cols="20" rows="3" class="form-control"></textarea>
                            </div>
                          </div>
                          <div class="form-group ">
                            <label for="mediuminput" class="col-sm-4 control-label">Status:</label>
                            <div class="col-sm-6">
                              <select id="status2" name="status2" class="form-control">
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
                    <!---->
                </div>
		</div>
	</div>
	<!-- /.modal-content -->
</div>
<!-- /.modal-dialog -->
</div>