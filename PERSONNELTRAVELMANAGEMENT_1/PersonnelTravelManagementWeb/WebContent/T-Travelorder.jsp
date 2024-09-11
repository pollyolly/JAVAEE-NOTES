<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<title>Transaction-Travel Order</title>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="Avant">
	<meta name="author" content="The Red Team">
	<link rel="stylesheet" href="assets/css/styles.min.css?=113">
	<link href='assets/demo/variations/default.css' rel='stylesheet' type='text/css' media='all' id='styleswitcher'> 
	<link href='assets/demo/variations/default.css' rel='stylesheet' type='text/css' media='all' id='headerswitcher'> 
	<link rel='stylesheet' type='text/css' href='assets/plugins/codeprettifier/prettify.css' /> 
	<link rel='stylesheet' type='text/css' href='assets/plugins/form-toggle/toggles.css' />
	
	<link rel="stylesheet" type="text/css" href="assets/plugins/datatables/dataTables.css">
	<link rel="stylesheet" type="text/css" href="assets/plugins/form-multiselect/css/multi-select.css">
	<link rel='stylesheet' type='text/css' href='assets/plugins/form-select2/select2.css' /> 
	<link rel='stylesheet' type='text/css' href='assets/fonts/glyphicons/css/glyphicons.min.css' /> 
	<link rel='stylesheet' type='text/css' href='assets/css/custom.css' />
	<link rel='shortcut icon' href='assets/img/BPS_LOGO.png' type='image/jpeg' style="width: 16px; height: 16px;" />
	
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
				<li><b>Travel Order</b></li>
			</ol>
			<div class="options">
                  <a href="#myModal" data-toggle="modal"  class="btn btn-default">Import</a>
            </div>
		</div>
		<div class="container">
<!--BEGIN ADD FORM-->
        <div class="row">
            <div class="col-md-12">
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h4>Travel Order</h4>
                        <div class="options">
                            <a href="javascript:;" class="panel-collapse"><i class="fa fa-chevron-down"></i></a>
                        </div>
                    </div>
                    <div class="panel-body collapse in">
                 <form class="form-horizontal" action="TravelOrder" method="POST">
                 	<input type="hidden" id="forms" name="forms" value="addTO">
					<div class="form-group ">
					<label for="focusedinput" class="col-sm-2 control-label">Personnel:</label>
						<div class="col-sm-6">
						<select id="employee" name="employee" class="multiple" multiple="multiple" required>
							<c:forEach items="${employeelist}" var="list">
								<option value="${list.employeeid}">${list.employee}</option>
							</c:forEach>
						</select>
						</div>
                     </div>
					<div class="form-group ">
                            <label for="focusedinput" class="col-sm-2 control-label">Purpose:</label>
                            <div class="col-sm-3">
                             <textarea name="purpose" id="purpose" cols="20" rows="3" class="form-control" required></textarea>
                            </div>
                     </div>
                        <div class="form-group">
                            <label for="focusedinput" class="col-sm-2 control-label">Destination:</label>
                            <div class="col-sm-3">
                            <select id="destination" name="destination" style="width:100%" class="select2" required>
                                <option></option>
							<c:forEach items="${destinationlist}" var="list">
								<option value="${list.destinationid}">${list.destination}</option>
							</c:forEach>
                            </select>
                            </div>
                          </div>
                          <div class="form-group ">
                            <label for="mediuminput" class="col-sm-2 control-label">Priority:</label>
                            <div class="col-sm-3">
                              <select name="priority" id="priority" class="form-control" required>
							<option value="">Choose...</option>
							<c:forEach items="${prioritylist}" var="list">
								<option value="${list.priorityid}">${list.priority}</option>
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
                                    <input type="submit" class="btn-primary btn" value="Submit">
                                    <input type="reset" class="btn-default btn" value="Clear">
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
		<!--div class="row">
			<div class="col-md-12">
				<a href="#" class="btn btn-success margBelow"><i class="glyphicon glyphicon-send"></i> Approval</a>
			</div>
		</div-->
		<div class="row">
              <div class="col-md-12">

                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <h4>Travel Order List</h4>
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
	                                    <th>TO.#</th>
	                                    <th>TO.Date</th>
	                                    <th>Personnel</th>
										<th>Department</th>
										<th>Purpose</th>
										<th>Destination</th>
										<th>Priority</th>
			                            <th>Status</th>
										<th>ApprovedBy</th>
										<th>Comment</th>
                                    </tr>
                                </thead>
                                
                            <tbody>
                            <c:forEach items="${travelorderlist}" var="list">
                                <tr>
								 		<td>${list.tono}</td>
                                        <td>${list.todate}</td>
                                        <td>${list.name}</td>
                                        <td>${list.department}</td>
                                        <td>${list.purpose}</td>
                                        <td>${list.destination}</td>
                                        <td>
                                        <c:choose>
										<c:when test="${list.priorityid == 5}">
											<span class="label label-success">Medium</span>
										</c:when>
										<c:when test="${list.priorityid== 6}">
											<span class="label label-warning">Low</span>
										</c:when>
										<c:otherwise>
											<span class="label label-danger">High</span>
										</c:otherwise>
										</c:choose>
                                        </td>
                                        <td>
										<c:choose>
										<c:when test="${list.status == 'Approved'}">
											<span class="label label-success">Approved</span>
										</c:when>
										<c:when test="${list.status == 'Pending'}">
											<span class="label label-warning">Pending</span>
										</c:when>
										<c:otherwise>
											<span class="label label-danger">Not Approved</span>
										</c:otherwise>
										</c:choose>
										</td>
                                        <td>
                                        	<c:choose>
												<c:when test="${not empty list.officername}">
													${list.officername}
												</c:when>
												<c:otherwise>
														<span class="label label-default">None</span>
													</c:otherwise>
											</c:choose>
                                        </td>
										<td>
			                            	<c:choose>
											<c:when test="${not empty list.comment}">
												<a href="#myModal3" data-toggle="modal" data-commentid="${list.id}" class="editComment"><li class="fa fa-comment-o"></li></a>
											</c:when>
											<c:otherwise>
													<span class="label label-default">None</span>
												</c:otherwise>
											</c:choose>
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
    <%@include file="modal/_ImportTravelOrder.jsp"%>
    <%@include file="modal/_Comment.jsp"%>

</div> <!-- page-container -->


<script type='text/javascript' src='assets/js/jquery-1.10.2.min.js'></script> 
<script type='text/javascript' src='assets/js/jqueryui-1.10.3.min.js'></script> 
<script type='text/javascript' src='assets/js/bootstrap.min.js'></script> 
<script type='text/javascript' src='assets/js/enquire.js'></script> 
<script type='text/javascript' src='assets/js/jquery.cookie.js'></script> 
<script type='text/javascript' src='assets/js/jquery.nicescroll.min.js'></script> 
<script type='text/javascript' src='assets/plugins/codeprettifier/prettify.js'></script> 
<script type='text/javascript' src='assets/plugins/form-toggle/toggle.min.js'></script> 
<script type='text/javascript' src='assets/plugins/datatables/jquery.dataTables.min.js'></script> 
<script type='text/javascript' src='assets/plugins/datatables/dataTables.bootstrap.js'></script>
<script type='text/javascript' src='assets/js/placeholdr.js'></script> 
<script type='text/javascript' src='assets/js/application.js'></script>

<script type='text/javascript' src='assets/js/demo.js'></script>
<script type='text/javascript' src='assets/js/data-table.js'></script> 
<script type='text/javascript' src='assets/js/tools.js'></script>
<script type='text/javascript' src='assets/js/multi-select.js'></script>  
<script type="text/javascript" src="assets/plugins/quicksearch/jquery.quicksearch.min.js"></script>
<script type='text/javascript' src='assets/plugins/form-select2/select2.min.js'></script>
<script type='text/javascript' src='assets/plugins/form-multiselect/js/jquery.multi-select.min.js'></script>
<script type='text/javascript' src='assets/plugins/form-datepicker/js/bootstrap-datepicker.js'></script>
<script type='text/javascript' src="assets/plugins/form-jasnyupload/fileinput.js"></script>
<script type='text/javascript' src='assets/js/TO_Comment.js'></script>
<script type="text/javascript" src='assets/js/alert.js'></script>
</body>
</html>