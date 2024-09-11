<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Transaction-Support Document</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="Avant">
<meta name="author" content="The Red Team">
<link rel="stylesheet" href="assets/css/styles.min.css?=113">
<link href='assets/demo/variations/default.css' rel='stylesheet'
	type='text/css' media='all' id='styleswitcher'>
<link href='assets/demo/variations/default.css' rel='stylesheet'
	type='text/css' media='all' id='headerswitcher'>
<link rel='stylesheet' type='text/css'
	href='assets/plugins/codeprettifier/prettify.css' />
<link rel='stylesheet' type='text/css'
	href='assets/plugins/form-toggle/toggles.css' />
<!--BEGIN TABLE-->
<link rel="stylesheet" type="text/css"
	href="assets/plugins/datatables/dataTables.css">
<!--END TABLE-->
<!--DROPDOWN-->
<link rel='stylesheet' type='text/css'
	href='assets/plugins/form-select2/select2.css' />
<!--BEGIN CUSTOM.CSS-->
<link rel='stylesheet' type='text/css'
	href='assets/fonts/glyphicons/css/glyphicons.min.css' />
<link rel='stylesheet' type='text/css' href='assets/css/custom.css' />
<link rel='shortcut icon' href='assets/img/BPS_LOGO.png' type='image/jpeg' style="width: 16px; height: 16px;" />
<!--END CUSTOM.CSS-->
</head>

<body class=" ">

	<!--BEGIN HEADERBAR poping header-->
	<!--END HEADERBAR poping header-->
	<!--BEGIN TOPBAR-->
	<%@include file="_Topbar.jsp"%>
	<!--END TOPBAR-->
	<div id="page-container">
		<!-- BEGIN SIDEBAR -->
		<%@include file="_Sidebar.jsp"%>
		<!-- END SIDEBAR -->
		<!-- BEGIN RIGHTBAR -->
		<!-- END RIGHTBAR -->
		<div id="page-content">
			<div id='wrap'>
				<div id="page-heading">
					<ol class="breadcrumb">
						<li><a href="Dashboard.jsp">Dashboard</a></li>
						<li>Transaction</li>
						<li><b>Support Document</b></li>
					</ol>
				</div>
				<div class="container">
				<%@include file="_Message.jsp"%>
				<!--BEGIN ADD FORM-->
					<div class="row">
						<div class="col-md-12">
							<div class="panel panel-primary">
								<div class="panel-heading">
									<h4>Document</h4>
									<div class="options">
										<!--a href="javascript:;"><i class="fa fa-cog"></i></a-->
										<a href="javascript:;" class="panel-collapse"><i
											class="fa fa-chevron-down"></i></a>
									</div>
								</div>
								<div class="panel-body collapse in">
									<form class="form-horizontal" action="SupportDocument" method="post" enctype="multipart/form-data">
											<div class="form-group">
						                            <label for="focusedinput" class="col-sm-2 control-label">TravelOrder#:</label>
						                            <div class="col-sm-3">
						                            <select name="tono" id="tono" style="width:100%;" class="select2" required>
						                                <option></option>
						                                 <c:forEach items="${tolist}" var="list">
															<option value="${list.tono}">${list.tono}</option>
														</c:forEach>
						                            </select>
						                            </div>
						                    </div>
										<div class="form-group ">
											<label for="focusedinput" class="col-sm-2 control-label">Description:</label>
											<div class="col-sm-3">
												<textarea name="description" id="description" cols="20"
													rows="3" class="form-control"></textarea>
											</div>
										</div>
										<div class="form-group ">
											<label for="focusedinput" class="col-sm-2 control-label">File:</label>
											<div class="col-sm-8">
												<div class="fileinput fileinput-new" data-provides="fileinput"><input name="forms" value="TravelOrder" type="hidden">
								                  	<span class="btn btn-default btn-file">
								                  	<span class="fileinput-new" title="Import file .csv format">Select File</span>
								                  	<span class="fileinput-exists">Change</span>
								                  		<input id="file" name="file" type="file"  size="50">
								                  	</span>
								                  	<span class="fileinput-filename"></span>
								                  		<a href="#" class="close fileinput-exists" data-dismiss="fileinput"> x </a>
								                  </div>
											</div>
										</div>
										<input type="hidden" name="status" id="status" value="1"/>
										<!--div class="form-group ">
											<label class="col-sm-2 control-label">Status:</label>
											<div class="col-sm-3">
												<select name="status" id="status" class="form-control">
													<option value="0">Choose...</option>
													<c:forEach items="${statlist}" var="list">
														<option value="${list.statusid}">${list.status}</option>
													</c:forEach>
												</select>
											</div>
										</div-->
								</div>
								<!---->
								<div class="panel-footer">
									<div class="row">
										<div class="col-sm-2"></div>
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
					<!--BEGIN ADD FORM-->

					<!--BEGIN TABLE-->
					<div class="row">
						<div class="col-md-12">

							<div class="panel panel-primary">
								<div class="panel-heading">
									<h4>Document List</h4>
									<div class="options">
										<!--a href=""><i class="fa fa-cog"></i></a-->
										<a href="" class="panel-collapse"><i
											class="fa fa-chevron-down"></i></a>
									</div>
								</div>
								<div class="panel-body collapse in">
									<div class="table-responsive">
										<table
											class="table table-striped table-bordered  table-hover datatables dataTable"
											id="DataTables_Table_0">
											<thead>
												<tr>
													<th>TO.No</th>
													<th>Description</th>
													<th>File</th>
													<th>Status</th>
													<th>Action</th>
												</tr>
											</thead>

											<tbody>
											<c:forEach items="${doclist}" var="list">
												<tr>
													<td>${list.tono}</td>
													<td>${list.description}</td>
													<td><a href="SupportDocumentDownload?file=${list.file}">${list.file}</a></td>
													<td>
						                            	<c:choose>
															<c:when test="${list.status == 'Active'}">
																<span class="label label-success">Active</span>
															</c:when>
															<c:when test="${list.status == 'Pending'}">
																<span class="label label-warning">Pending</span>
															</c:when>
															<c:otherwise>
																<span class="label label-danger">Inactive</span>
															</c:otherwise>
														</c:choose>
													</td>
													<td><a href="SupportDocumentUpdate?supportid=${list.id}" class="btn btn-danger btn-xs">
															delete</a>   </td>
												</tr>
												</c:forEach>
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>
					</div>
					<!--END TABLE-->


				</div>
				<!-- container -->
			</div>
			<!--wrap -->
		</div>
		<!-- page-content -->

		<%@include file="_Footer.jsp"%>
		
	</div>
	<!-- page-container -->

	<script type='text/javascript' src='assets/js/jquery-1.10.2.min.js'></script>
	<script type='text/javascript' src='assets/js/jqueryui-1.10.3.min.js'></script>
	<script type='text/javascript' src='assets/js/bootstrap.min.js'></script>
	<script type='text/javascript' src='assets/js/enquire.js'></script>
	<script type='text/javascript' src='assets/js/jquery.cookie.js'></script>
	<script type='text/javascript' src='assets/js/jquery.nicescroll.min.js'></script>
	<script type='text/javascript'src='assets/plugins/codeprettifier/prettify.js'></script>
	<script type='text/javascript'src='assets/plugins/easypiechart/jquery.easypiechart.min.js'></script>
	<script type='text/javascript' src='assets/plugins/sparklines/jquery.sparklines.min.js'></script>
	<script type='text/javascript' src='assets/plugins/form-toggle/toggle.min.js'></script>
	<script type='text/javascript' src='assets/plugins/datatables/jquery.dataTables.min.js'></script>
	<script type='text/javascript' src='assets/plugins/datatables/dataTables.bootstrap.js'></script>
	
	<script type='text/javascript' src='assets/js/data-table.js'></script> 
	<script type='text/javascript' src='assets/js/placeholdr.js'></script>
	<script type='text/javascript' src='assets/js/application.js'></script>
	<script type='text/javascript' src='assets/demo/demo.js'></script>
	
	<script type='text/javascript' src='assets/plugins/form-select2/select2.min.js'></script>
	<script type='text/javascript' src='assets/js/edit_ajax.js'></script>
	<script type='text/javascript' src='assets/js/fixselect2inmodal.js'></script>
	<script type="text/javascript" src='assets/js/tools.js'></script>
	<script type='text/javascript' src="assets/plugins/form-jasnyupload/fileinput.js"></script>
	<script type="text/javascript" src='assets/js/alert.js'></script>
</body>
</html>