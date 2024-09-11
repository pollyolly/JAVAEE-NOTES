<%@ page contentType="text/html charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>DataBuilder-Employee Emergency Contact</title>
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
						<li>Data-Builder</li>
						<li><b>Emergency Contact</b></li>
					</ol>
				</div>
				<div class="container">
				<%@include file="_Message.jsp"%>
					<!--BEGIN ADD FORM-->
					<div class="row">
						<div class="col-md-12">
							<div class="panel panel-primary">
								<div class="panel-heading">
									<h4>Employee Emergency Contact</h4>
									<div class="options">
										<!--a href="javascript:;"><i class="fa fa-cog"></i></a-->
										<a href="javascript:;" class="panel-collapse"><i
											class="fa fa-chevron-down"></i></a>
									</div>
								</div>
								<div class="panel-body collapse in">
									<form class="form-horizontal" action="EmployeeEmergencyContact" method="POST">
										<input type="hidden"  name="forms" id="forms" value="addContact" />
										<div class="form-group">
											<label for="focusedinput" class="col-sm-2 control-label">Employee:</label>
											<div class="col-sm-3">
												<select name="employee" id="employee" style="width: 100%;"
													class="select2">
													<option></option>
													<c:forEach items="${empList}" var="emp">
														<option value="${emp.employeeid}">${emp.employee}</option>
													</c:forEach>
												</select>
											</div>
										</div>
										<div class="form-group ">
											<label for="focusedinput" class="col-sm-2 control-label">PersonName:</label>
				                            <div class="col-sm-3">
				                              <input type="text" class="form-control" id="personname" name="personname" placeholder="Lastname, Firstname Initial" required/>
				                            </div>
										</div>
										<div class="form-group ">
											<label for="focusedinput" class="col-sm-2 control-label">Relationship:</label>
				                            <div class="col-sm-3">
				                              <input type="text" class="form-control" id="relationship" name="relationship" placeholder="Mother, Father etc." required/>
				                            </div>
										</div>
										<div class="form-group ">
											<label for="focusedinput" class="col-sm-2 control-label">EmergencyContact#:</label>
				                            <div class="col-sm-3">
				                              <input type="text" class="form-control" id="emergencycontact" name="emergencycontact" placeholder="000-0000/+63000000000" required/>
				                            </div>
										</div>
										<div class="form-group ">
											<label for="mediuminput" class="col-sm-2 control-label">Status:</label>
											<div class="col-sm-3">
												<select name="status" id="status" class="form-control">
													<option value="0">Choose...</option>
													<c:forEach items="${statList}" var="stat">
														<option value="${stat.statusid}">${stat.status}</option>
													</c:forEach>
												</select>
											</div>
										</div>
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
									<h4>Emergency Contact List</h4>
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
													<th>Employee</th>
													<th>Department</th>
													<th>PersonName</th>
													<th>Relationship</th>
													<th>EmergencyContact#</th>
													<th>Status</th>
													<th>Action</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${emerlist}" var="list">
													<tr>
														<td>${list.employee}</td>
														<td>${list.department}</td>
														<td>${list.personname}</td>
														<td>${list.relationship}</td>
														<td>${list.contact}</td>
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
														<td><a data-toggle="modal"
															data-contid="${list.contactid}" href="#myModal"
															class="btn btn-info btn-xs editContact">
																<li class="fa fa-edit"></li>
														</a></td>
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
		<%@include file="modal/_EmployeeEmergencyContact.jsp"%>
	</div>
	<!-- page-container -->

	<script type='text/javascript' src='assets/js/jquery-1.10.2.min.js'></script>
	<script type='text/javascript' src='assets/js/jqueryui-1.10.3.min.js'></script>
	<script type='text/javascript' src='assets/js/bootstrap.min.js'></script>
	<script type='text/javascript' src='assets/js/enquire.js'></script>
	<script type='text/javascript' src='assets/js/jquery.cookie.js'></script>
	<script type='text/javascript' src='assets/js/jquery.nicescroll.min.js'></script>
	<script type='text/javascript' src='assets/plugins/codeprettifier/prettify.js'></script>
	<script type='text/javascript' src='assets/plugins/easypiechart/jquery.easypiechart.min.js'></script>
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
	<script type="text/javascript" src='assets/js/alert.js'></script>
</body>
</html>