<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
		<meta charset="utf-8">
		<title>Transaction-Travel Expense</title>
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta name="description" content="Avant">
		<meta name="author" content="The Red Team">
		<link rel="stylesheet" href="assets/css/styles.min.css?=113">
		<link href='assets/demo/variations/default.css' rel='stylesheet' type='text/css' media='all' id='styleswitcher'> 
		<link href='assets/demo/variations/default.css' rel='stylesheet' type='text/css' media='all' id='headerswitcher'> 
		<link rel='stylesheet' type='text/css' href='assets/plugins/codeprettifier/prettify.css' /> 
		<link rel='stylesheet' type='text/css' href='assets/plugins/form-toggle/toggles.css' />
		
		<link rel="stylesheet" type="text/css" href="assets/plugins/form-multiselect/css/multi-select.css">
		<link rel="stylesheet" type="text/css" href="assets/plugins/datatables/dataTables.css">
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
        <%@include file="_SidebarPersonnel.jsp"%>
        <!-- END SIDEBAR -->
        <!-- BEGIN RIGHTBAR -->
        <!-- END RIGHTBAR -->
<div id="page-content">
	<div id='wrap'>
		<div id="page-heading">
			<ol class="breadcrumb">
				<li><a href="Dashboard.jsp">Dashboard</a></li>
				<li>Transaction</li>
				<li><b>Travel Expense</b></li>
			</ol>
		</div>
		<div class="container">
           <div class="row">
              <div class="col-md-12">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <h4>Travel Expense List</h4>
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
									<th>Personnel</th>
                                    <th>TO.No</th>
                                    <th>FromDate</th>
									<th>ToDate</th>
                                    <th>Status</th>
                                    <th>Comment</th>
                                    </tr>
                                </thead>
                            <tbody>
                            <c:forEach items="${explist}" var="list">
	                            <tr>
	                            	<td><a href="TravelExpenseListPersonnel?odid=${list.id}" target="_blank">${list.name}</a></td>
	                            	<td>${list.tono}</td>
	                            	<td>${list.fromdate}</td>
	                            	<td>${list.todate}</td>
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
                            </table>
                           </div>
                        </div>
            </div>
        </div>
    </div> 
    
		</div> <!-- container -->
	</div> <!--wrap -->
</div> <!-- page-content -->

    <%@include file="_Footer.jsp"%>
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
<script type='text/javascript' src='assets/js/data-table.js'></script> 
<script type='text/javascript' src='assets/js/placeholdr.js'></script> 
<script type='text/javascript' src='assets/js/application.js'></script> 

<script type='text/javascript' src='assets/js/TE_Comment.js'></script>
<script type='text/javascript' src='assets/demo/demo.js'></script>
<script type='text/javascript' src='assets/js/multi-select.js'></script>
<script type='text/javascript' src='assets/js/populate-multiselect-expense.js'></script>
<script type="text/javascript" src="assets/plugins/quicksearch/jquery.quicksearch.min.js"></script>
<script type='text/javascript' src='assets/plugins/form-select2/select2.min.js'></script>
<script type='text/javascript' src='assets/plugins/form-multiselect/js/jquery.multi-select.min.js'></script>
<script type='text/javascript' src='assets/plugins/form-datepicker/js/bootstrap-datepicker.js'></script>
<script type='text/javascript' src='assets/js/tools.js'></script>
<script type="text/javascript" src='assets/js/alert.js'></script>
</body>
</html>