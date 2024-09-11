<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true"
	style="display: none;">
	<div class="modal-dialog">
		<div class="modal-content">
<div class="panel panel-primary">
                    <div class="panel-heading">
                        <h4>Services</h4>
                        <div class="options">   
                                <!--a href="javascript:;"><i class="fa fa-cog"></i></a-->
                            <a href="javascript:;" class="panel-collapse"><i class="fa fa-chevron-down"></i></a>
                        </div>
                    </div>
                    <div class="panel-body collapse in">
                        <form class="form-horizontal" action="Services" method="POST">
                        <input type="hidden" id="forms" name="forms"  value="editServices"/>
                        <input type="hidden" id="id" name="id"  value=""/>
					<div class="form-group">
                            <label for="focusedinput" class="col-xs-4 control-label">Company:</label>
                            <div class="col-xs-6">
                            <select name="company2" id="company2" style="width:100%;" class="select2" required>
                                <option></option>
                                <c:forEach items="${splist}" var="list">
                                 	<option value="${list.id}">${list.company}</option>
                                 </c:forEach>
                            </select>
                            </div>
                    </div>
                    <div class="form-group ">
                            <label for="focusedinput" class="col-xs-4 control-label">Service:</label>
                            <div class="col-xs-6">
                              <input id="service2" name="service2" class="form-control" type="text"/>
                            </div>
                    </div>
                    <div class="form-group ">
                            <label for="focusedinput" class="col-xs-4 control-label">Description:</label>
                            <div class="col-xs-6">
                              <textarea id="description2" name="description2" class="form-control" rows="2" cols="60"></textarea>
                            </div>
                    </div>        		
					<div class="form-group ">
                            <label for="mediuminput" class="col-xs-4 control-label">Type:</label>
                            <div class="col-xs-6">
                              <select name="type2" id="type2" class="form-control" required>
                                <option>Choose...</option>
								<c:forEach items="${svtype}" var="list">
                                 	<option value="${list.typeid}">${list.type}</option>
                                 </c:forEach>
                            </select>
                            </div>
                    </div>
                    <div class="form-group ">
                            <label for="mediuminput" class="col-xs-4 control-label">Class:</label>
                            <div class="col-xs-6">
                              <select name="class2" id="class2" class="form-control" required>
                                <option>Choose...</option>
								<c:forEach items="${svclass}" var="list">
                                 	<option value="${list.classid}">${list.serviceclass}</option>
                                 </c:forEach>
                            </select>
                            </div>
                    </div>
					<div class="form-group">
						<label class="col-sm-4 control-label">Cost:</label>
						<div class="col-sm-6">
							<div class="input-group">
								<input class="form-control" type="text" id="cost2" name="cost2" required>
								<span class="input-group-addon">.00</span>
							</div>
						</div>
					</div>
                          <div class="form-group ">
                            <label for="mediuminput" class="col-xs-4 control-label">Status:</label>
                            <div class="col-xs-6">
                              <select name="status2" id="status2" class="form-control">
                                <option>Choose...</option>
                                <c:forEach items="${statuslist}" var="list">
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
                                    <button class="btn-primary btn">Submit</button>
                                    <button class="btn-default btn">Clear</button>
                                </div>
                            </div>
                        </div>
                      </div>
                      </form>
                    <!---->
                </div>
		</div>
	</div>
</div>