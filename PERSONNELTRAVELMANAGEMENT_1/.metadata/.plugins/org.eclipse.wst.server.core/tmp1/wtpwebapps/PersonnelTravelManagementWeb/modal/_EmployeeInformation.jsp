<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true"
	style="display: none;">
	<div class="modal-dialog">
		<div class="modal-content ">
			<div class="panel panel-primary">
                    <div class="panel-heading">
                        <h4>Employee Information</h4>
                        <div class="options">   
                                <!--a href="javascript:;"><i class="fa fa-cog"></i></a-->
                            <a href="javascript:;" class="panel-collapse"><i class="fa fa-chevron-down"></i></a>
                        </div>
                    </div>
                    <div class="panel-body collapse in">
                 <form class="form-horizontal" action="EmployeeInformation" method="POST">
                 <input type="hidden" id="forms" name="forms" value="updateEmployee">
                 <input type="hidden" id="employeeid" name="employeeid">
					<div class="form-group ">
						<label for="focusedinput" class="col-sm-4 control-label">FirstName:</label>
					<div class="col-sm-6">
						<input type="text" class="form-control" id="firstname2" name="firstname2" placeholder="FirstName">
					</div>
					
                          </div>
					<div class="form-group ">
                            <label for="focusedinput" class="col-sm-4 control-label">MiddleName:</label>
                            <div class="col-sm-6">
                              <input type="text" class="form-control" id="middlename2" name="middlename2" placeholder="MiddleName">
                            </div>
						
                          </div>
					<div class="form-group ">
                            <label for="focusedinput" class="col-sm-4 control-label">LastName:</label>
                            <div class="col-sm-6">
                              <input type="text" class="form-control" id="lastname2" name="lastname2" placeholder="LastName">
                            </div>
						
                          </div>
					<div class="form-group">
                            <label for="focusedinput" class="col-sm-4 control-label">Department:</label>
                            <div class="col-sm-6">
                            <select name="department2" id="department2" style="width:100%;" class="select2">
                                <option value="0">Choose...</option>
                              <c:forEach items="${jspdeptlist}" var="list">  
                                <option value="${list.departmentid}">${list.department}</option>
                            </c:forEach>
                            </select>
                            </div>
						
                          </div>
                    <div class="form-group ">
                            <label for="mediuminput" class="col-sm-4 control-label">Position:</label>
                            <div class="col-sm-6">
                              <select id="position2" name="position2" style="width:100%;" class="select2">
                                <option>Choose...</option>
	  								<c:forEach items="${jsppostlist}" var="list">  
	                             		<option value="${list.positionid}">${list.position}</option>
	                            	</c:forEach>
                            </select>
                            </div>
                           
                          </div>
					<div class="form-group">
                            <label class="col-sm-4 control-label">Birthdate:</label>
                                <div class="col-sm-6">
                                    <div class="input-group date datepicker">
                                        <input type="text" class="form-control" id="birthdate2" name="birthdate2" placeholder="YYYY-MM-DD">
                                        <span class="input-group-addon"><i class="fa fa-calendar"></i></span>
                                    </div>
                                </div>
                        </div>
					<div class="form-group">
						<label class="col-sm-4 control-label">Gender:</label>
						<div class="col-sm-6">
							<select name="gender2" id="gender2" class="form-control" required>
                                <option value="">Choose...</option>                           
                                <option value="Female">Female</option>
                                <option value="Male">Male</option>
                            </select>
						</div>
					</div>
                          <div class="form-group ">
                            <label for="focusedinput" class="col-sm-4 control-label">Contact:</label>
                            <div class="col-sm-6">
                              <input type="text" class="form-control" id="contact2" name="contact2" placeholder="000-0000/+63000000000">
                            </div>
                          </div>
                     <div class="form-group ">
                            <label for="focusedinput" class="col-sm-4 control-label">Email:</label>
                            <div class="col-sm-6">
                              <input type="email" class="form-control" id="email2" name="email2" placeholder="****@yahoo.com">
                            </div>
                          </div>
						<div class="form-group ">
                            <label for="focusedinput" class="col-sm-4 control-label">Address:</label>
                            <div class="col-sm-6">
                             <textarea id="address2" name="address2" cols="20" rows="3" class="form-control" placeholder="Barangay, States, City, Country"></textarea>
                            </div>
                          </div>
                        	 <div class="form-group ">
                            <label for="mediuminput" class="col-sm-4 control-label">Status:</label>
                            <div class="col-sm-6">
                              <select name="status2" id="status2" class="form-control">
                                <option>Choose...</option>
                                <c:forEach items="${jspstatlist}" var="list">  
                                <option value="${list.statusid}">${list.status}</option>
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