<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<title>Data-Builder-Employee Information</title>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="Avant">
	<meta name="author" content="The Red Team">
    <link rel="stylesheet" href="assets/css/styles.min.css">
    <link href='assets/demo/variations/default.css' rel='stylesheet' type='text/css' media='all' id='styleswitcher'> 
    <link href='assets/demo/variations/default.css' rel='stylesheet' type='text/css' media='all' id='headerswitcher'> 
	<link rel='stylesheet' type='text/css' href='assets/plugins/codeprettifier/prettify.css' /> 
	<link rel='stylesheet' type='text/css' href='assets/plugins/form-toggle/toggles.css' />
	<!--BEGIN TABLE-->
	<link rel="stylesheet" type="text/css" href="assets/plugins/datatables/dataTables.css">
	<!--END TABLE-->
        <!--DROPDOWN-->
    <link rel='stylesheet' type='text/css' href='assets/plugins/form-select2/select2.css' /> 
    <link rel='stylesheet' type='text/css' href='assets/plugins/form-stepy/jquery.step.css' /> 
	<!--BEGIN CUSTOM.CSS-->
    <link rel='stylesheet' type='text/css' href='assets/fonts/glyphicons/css/glyphicons.min.css' /> 
	<link rel='stylesheet' type='text/css' href='assets/css/custom.css' />
	<link rel='stylesheet' type='text/css' href='assets/css/fixdatepickeronmodal.css' />
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
				<li><b>Employee</b></li>
			</ol>
		</div>
		<div class="container">
		<%@include file="_Message.jsp"%>
<!--BEGIN ADD FORM-->
        <div class="row">
            <div class="col-md-12">
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h4>Employee Information</h4>
                        <div class="options">   
                                <!--a href="javascript:;"><i class="fa fa-cog"></i></a-->
                            <a href="javascript:;" class="panel-collapse"><i class="fa fa-chevron-down"></i></a>
                        </div>
                    </div>
                      <div class="panel-body collapse in">
                      <form class="form-horizontal wizard" action="EmployeeInformation" method="POST">
                      			<fieldset title="1st Step">
									<div class="form-group ">
									  <input type="hidden" id="forms" name="forms" value="addEmployee">
											<label for="focusedinput" class="col-sm-2 control-label">FirstName:</label>
											<div class="col-sm-3">
												<input type="text" class="form-control" id="firstname" name="firstname" placeholder="FirstName" required/>
											</div>
											<label class="col-sm-2 control-label">Gender:</label>
											<div class="col-sm-3">
												<select name="gender" id="gender" class="form-control" required >
					                                <option value="">Choose...</option>                           
					                                <option value="F">Female</option>
					                                <option value="M">Male</option>
					                            </select>
											</div>
					                 </div>
									<div class="form-group ">
					                            <label for="focusedinput" class="col-sm-2 control-label">MiddleName:</label>
					                            <div class="col-sm-3">
					                              <input type="text" class="form-control" id="middlename" name="middlename" placeholder="MiddleName" required/>
					                            </div>
					                            <label for="focusedinput" class="col-sm-2 control-label">Contact:</label>
					                            <div class="col-sm-3">
					                              <input type="text" class="form-control" id="contact" name="contact" placeholder="000-0000/+63000000000" required/>
					                            </div>
					                   </div>
										<div class="form-group ">
					                            <label for="focusedinput" class="col-sm-2 control-label">LastName:</label>
					                            <div class="col-sm-3">
					                              <input type="text" class="form-control" id="lastname" name="lastname" placeholder="LastName" required/>
					                            </div>
					                            <label for="focusedinput" class="col-sm-2 control-label">Email:</label>
													<div class="col-sm-3">
														<input type="email" class="form-control" id="email" name="email" placeholder="****@yahoo.com" required/>
													</div>
					                    </div>
										<div class="form-group">
					                            <label class="col-sm-2 control-label">Birthdate:</label>
					                                <div class="col-sm-3">
					                                    <div class="input-group date datepicker">
					                                        <input type="text" class="form-control" id="birthdate" name="birthdate" placeholder="yyyy-mm-dd" required/>
					                                        <span class="input-group-addon"><i class="fa fa-calendar"></i></span>
					                                    </div>
					                                </div>
					                               <label for="focusedinput" class="col-sm-2 control-label">Address:</label>
					                            <div class="col-sm-3">
					                             <textarea  id="address" name="address" cols="20" rows="3" class="form-control" placeholder="Barangay, States, City, Country" required/></textarea>
					                            </div>
					                                
					                        </div>
					                        </fieldset>
					            <fieldset title="2nd Step">
								<div class="form-group">
			                            <label for="focusedinput" class="col-sm-2 control-label">Department:</label>
			                            <div class="col-sm-3">
			                            <select name="department" id="department" style="width:100%;" class="select2" required>
			                                <option></option>
			                              <c:forEach items="${jspdeptlist}" var="list">  
			                                <option value="${list.departmentid}">${list.department}</option>
			                            </c:forEach>
			                            </select>
			                            </div>
			                    </div>
			                    <div class="form-group ">
			                            <label for="mediuminput" class="col-sm-2 control-label">Position:</label>
			                            <div class="col-sm-3">
			                              <select id="position" name="position" style="width:100%;" class="select2" required>
			                                <option></option>
				  								<c:forEach items="${jsppostlist}" var="list">  
				                             		<option value="${list.positionid}">${list.position}</option>
				                            	</c:forEach>
			                            </select>
			                            </div>
			                    </div>
			                    <div class="form-group ">
			                            <label for="mediuminput" class="col-sm-2 control-label">Status:</label>
			                            <div class="col-sm-3">
			                              <select name="status" id="status" class="form-control" required>
			                                <option value="">Choose...</option>
			                                <c:forEach items="${jspstatlist}" var="list">  
			                                <option value="${list.statusid}">${list.status}</option>
			                            </c:forEach>
			                            </select>
			                            </div>
			                    </div>
			                    </fieldset>
							<input type="submit" class="btn-primary btn" value="Submit" />
						</form>
						</div>
                </div>
            </div>
        </div>
        <!--BEGIN ADD FORM-->

		<!--BEGIN TABLE-->
		<div class="row">
              <div class="col-md-12">

                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <h4>Employee List</h4>
                            <div class="options">   
                                <!--a href=""><i class="fa fa-cog"></i></a-->
                                <a href="" class="panel-collapse"><i class="fa fa-chevron-down"></i></a>
                            </div>
                        </div>
                        <div class="panel-body collapse in">
                           <div class="table-responsive">
                            <table class="table table-striped table-bordered  table-hover datatables dataTable" id="DataTables_Table_0">
                                <thead>
                                    <tr>
                                    <th>Name</th>
                                    <th>Department</th>
                                    <th>Position</th>
                                    <th>Age</th>
									<th>Gender</th>
                                    <th>Contact</th>
									<th>Address</th>
                                    <th>Status</th>
                                    <th>Action</th>
                                    </tr>
                                </thead>
                                
                            <tbody>
                              <c:forEach items="${jspemplist}" var="list">
                              <tr>
								<td>${list.employee}</td>
								<td>${list.department}</td>
								<td>${list.position}</td>
								<td>${list.birthdate}</td>
								<td>${list.gender}</td>
								<td>Contact#:${list.contact} <br>
									Email:${list.email}</td>
								<td>${list.address}</td>
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
								<td>
									<a href="#myModal" data-toggle="modal" 
									data-editemp="${list.employeeid}" 
									class="btn btn-info btn-xs editemployee"><li class="fa fa-edit"></li></a>                 
								</td>
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

        
		</div> <!-- container -->
	</div> <!--wrap -->
</div> <!-- page-content -->

    <%@include file="_Footer.jsp"%>
	<%@include file="modal/_EmployeeInformation.jsp"%>
</div> <!-- page-container -->


<script type='text/javascript' src='assets/js/jquery-1.10.2.min.js'></script> 
<script type='text/javascript' src='assets/js/jqueryui-1.10.3.min.js'></script>
<script type='text/javascript'>
$(document).ready(function() {
 $('.wizard').stepy({titleClick: true, description: false});
 });
</script> 
<script type='text/javascript' src='assets/js/bootstrap.min.js'></script> 
<script type='text/javascript' src='assets/js/enquire.js'></script> 
<script type='text/javascript' src='assets/js/jquery.cookie.js'></script> 
<script type='text/javascript' src='assets/js/jquery.nicescroll.min.js'></script> 
<script type='text/javascript' src='assets/plugins/codeprettifier/prettify.js'></script>
<script type='text/javascript' src='assets/plugins/form-toggle/toggle.min.js'></script> 
<script type='text/javascript' src='assets/plugins/datatables/jquery.dataTables.min.js'></script> 
<script type='text/javascript' src='assets/plugins/datatables/dataTables.bootstrap.js'></script> 
<script type='text/javascript' src='assets/js/data-table.js'></script> 
<script type='text/javascript' src='assets/js/placeholdr.js'></script>
<script type='text/javascript' src='assets/js/application.js'></script> 
<script type='text/javascript' src='assets/demo/demo.js'></script>
<script type='text/javascript' src='assets/plugins/form-parsley/parsley.min.js'></script>
<script type="text/javascript" src="assets/plugins/form-stepy/jquery.stepy.js"></script>
<script type='text/javascript' src='assets/plugins/form-select2/select2.min.js'></script>
<script type='text/javascript' src='assets/plugins/form-datepicker/js/bootstrap-datepicker.js'></script>

<script type='text/javascript' src='assets/js/edit_ajax.js'></script>
<script type='text/javascript' src='assets/js/fixselect2inmodal.js'></script>
<script type="text/javascript" src='assets/js/tools.js'></script>
<script type="text/javascript" src='assets/js/alert.js'></script>
</body>
</html>