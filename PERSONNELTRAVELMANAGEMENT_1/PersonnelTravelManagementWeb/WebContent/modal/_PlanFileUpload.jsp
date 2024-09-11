<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true"
	style="display: none;">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h4>Travel Plan Import</h4>
					<div class="options">
						<!--a href="javascript:;"><i class="fa fa-cog"></i></a-->
						<a href="javascript:;" class="panel-collapse"><i
							class="fa fa-chevron-down"></i></a>
					</div>
				</div>
				<div class="panel-body collapse in">
					<form class="form-horizontal" action="Import" method="POST" enctype="multipart/form-data">
					<input type="hidden" name="forms" id="forms" value="TravelPlan">
							<div class="col-sm-2"></div>
							<div class="col-sm-8">
								<div class="fileinput fileinput-new" data-provides="fileinput"><input name="forms" value="Plan" type="hidden">
				                  	<span class="btn btn-default btn-file">
				                  	<span class="fileinput-new" title="Import file .csv format">Select File</span>
				                  	<span class="fileinput-exists">Change</span>
				                  		<input name="import" type="file">
				                  	</span>
				                  	<span class="fileinput-filename"></span>
				                  		<a href="#" class="close fileinput-exists" data-dismiss="fileinput"> x </a>
				                  </div>
							</div>
						
				</div>
				<!---->
				<div class="panel-footer">
					<div class="row">
						<div class="col-sm-5"></div>
						<div class="col-sm-2">
							<div class="btn-toolbar">
								<input type="submit" class="btn-primary btn" value="OK" />
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