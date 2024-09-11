<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true"
	style="display: none;">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="panel panel-primary">
                    <div class="panel-heading">
                        <h4>Card Information</h4>
                        <div class="options">   
                                <!--a href="javascript:;"><i class="fa fa-cog"></i></a-->
                            <a href="javascript:;" class="panel-collapse"><i class="fa fa-chevron-down"></i></a>
                        </div>
                    </div>
                    <div class="panel-body collapse in">
                        <form class="form-horizontal" action="CardInformation" method="POST">
                        <input type="hidden" id="forms"  name="forms"  value="updateCardinformation">
                         <input type="hidden" id="cardinfoid"  name="cardinfoid">
					<div class="form-group ">
					<label for="focusedinput" class="col-sm-4 control-label">CardNo:</label>
                            <div class="col-sm-6">
                              <input type="text" class="form-control" id="cardnumber2"  name="cardnumber2" maxlength="8" placeholder="00000000">
                            </div>
                          </div>
					<div class="form-group ">
						<label for="focusedinput" class="col-sm-4 control-label">ExpirationDate:</label>
                            <div class="col-sm-6">
                                    <div class="input-group date datepicker">
                                        <input type="text" id="expirydate2" name="expirydate2" class="form-control" placeholder="YYYY-MM-DD">
                                        <span class="input-group-addon"><i class="fa fa-calendar"></i></span>
                                    </div>
                                </div>
                          </div>
					<div class="form-group ">
                            <label for="mediuminput" class="col-sm-4 control-label">CardType:</label>
                            <div class="col-sm-6">
                              <select id="cardtype2" name="cardtype2" class="form-control">
                                <option>Choose...</option>
                               <c:forEach items="${Cardtyplist}" var="list">
                                <option value="${list.cardtypeid}">${list.cardtype}</option>
                               </c:forEach>
                            </select>
                            </div>
                          </div>
					<div class="form-group ">
                            <label for="mediuminput" class="col-sm-4 control-label">Ownership:</label>
                            <div class="col-sm-6">
                              <select name="ownership2" id="ownership2" class="form-control">
                                <option>Choose...</option>
                               <c:forEach items="${Ownlist}" var="list">
                                <option value="${list.ownershipid}">${list.ownership}</option>
                               </c:forEach>
                            </select>
                            </div>
                          </div>
					<div class="form-group">
                            <label for="focusedinput" class="col-sm-4 control-label">Employee:</label>
                            <div class="col-sm-6">
                            <select name="employee2" id="employee2" style="width:100%;" class="select2">
                                <option></option>
                                <c:forEach items="${Emplist}" var="list">
                                <option value="${list.employeeid}">${list.employee}</option>
                               </c:forEach>
                            </select>
                            </div>
                          </div>
                          <div class="form-group ">
                            <label for="mediuminput" class="col-sm-4 control-label">Status:</label>
                            <div class="col-sm-6">
                              <select name="status2" id="status2" class="form-control">
                                <option>Choose...</option>
                               <c:forEach items="${Statlist}" var="list">
                                <option value="${list.statusid}">${list.status}</option>
                               </c:forEach>
                            </select>
                            </div>
                          </div>
                        
                    </div>
                    <!---->
                    <div class="panel-footer">
                        <div class="row">
                        <div class="col-sm-2">
                        </div>
                            <div class="col-sm-4">
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