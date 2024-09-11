<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<title>Configuration-Advance Policy</title>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="Avant">
	<meta name="author" content="The Red Team">
    <link rel="stylesheet" href="assets/css/styles.min.css?=113">
    <link href='http://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600' rel='stylesheet' type='text/css'>
    <link href='assets/demo/variations/default.css' rel='stylesheet' type='text/css' media='all' id='styleswitcher'> 
    <link href='assets/demo/variations/default.css' rel='stylesheet' type='text/css' media='all' id='headerswitcher'> 
	<link rel='stylesheet' type='text/css' href='assets/plugins/codeprettifier/prettify.css' /> 
	<link rel='stylesheet' type='text/css' href='assets/plugins/form-toggle/toggles.css' />
	<!--BEGIN TABLE-->
	<link rel="stylesheet" type="text/css" href="assets/plugins/datatables/dataTables.css">
	<!--END TABLE-->
        <!--DROPDOWN-->
	<!--BEGIN CUSTOM.CSS-->
    <link rel='stylesheet' type='text/css' href='assets/fonts/glyphicons/css/glyphicons.min.css' /> 
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
				<li>Configuration Management</li>
				<li><b>Advance Policy</b></li>
			</ol>
		</div>
		<div class="container">

 <!--BEGIN ADD FORM-->
        <div class="row">
            <div class="col-md-12">
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h4>Advance Policy</h4>
                        <div class="options">   
                                <!--a href="javascript:;"><i class="fa fa-cog"></i></a-->
                            <a href="javascript:;" class="panel-collapse"><i class="fa fa-chevron-down"></i></a>
                        </div>
                    </div>
                    <div class="panel-body collapse in">
                        <form class="form-horizontal">
                        <div class="form-group ">
                            <label for="focusedinput" class="col-sm-2 control-label">Amount:</label>
                            <div class="col-sm-3">
                              <input type="text" class="form-control" id="focusedinput" placeholder="Default Input">
                            </div>
                          </div>
                          <div class="form-group ">
                          <label for="focusedinput" class="col-sm-2 control-label">Department:</label>
                            <div class="col-sm-3">
                              <select name="selector1" id="selector1" class="form-control">
                                <option>Choose...</option>
                                <option>Correction</option>
                                <option>Rejected</option>
                                <option>Approved</option>
                            </select>
                            </div>
                          </div>
                          <div class="form-group ">
                            <label for="mediuminput" class="col-sm-2 control-label">Status:</label>
                            <div class="col-sm-3">
                              <select name="selector1" id="selector1" class="form-control">
                                <option>Choose...</option>
                                <option>Correction</option>
                                <option>Rejected</option>
                                <option>Approved</option>
                            </select>
                            </div>
                          </div>
                        </form>
                    </div>
                    <!---->
                    <div class="panel-footer">
                        <div class="row">
                        <div class="col-sm-2">
                        </div>
                            <div class="col-sm-4">
                                <div class="btn-toolbar">
                                    <button class="btn-primary btn">Submit</button>
                                    <button class="btn-default btn">Clear</button>
                                </div>
                            </div>
                        </div>
                      </div>
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
                            <h4>Advance Policy List</h4>
                            <div class="options">   
                                <!--a href=""><i class="fa fa-cog"></i></a-->
                                <a href="" class="panel-collapse"><i class="fa fa-chevron-down"></i></a>
                            </div>
                        </div>
                        <div class="panel-body collapse in">
                           <div class="table-responsive">
                            <table class="table table-striped table-bordered table-hover datatables dataTable" id="DataTables_Table_0">
                                <thead>
                                    <tr>
                                    <th>Amount</th>
                                    <th>Department</th>
                                    <th>Status</th>
                                    <th>Action</th>
                                    </tr>
                                </thead>
                                
                            <tbody>
                                    <tr>
                                        <td>10000</td>
                                        <td>Shoe Dept.</td>
                                        <td><span class="label label-danger">Inactive</span></td>
                                        <td>
                                            <a href="" class="btn btn-info btn-xs"><li class="fa fa-edit"></li></a>                 
                                        </td>
                                    </tr>
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

</div> <!-- page-container -->


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
<script type='text/javascript' src='assets/js/placeholdr.js'></script> 
<script type='text/javascript' src='assets/js/application.js'></script> 
<script type='text/javascript' src='assets/js/demo.js'></script>
<script type='text/javascript' src='assets/js/data-table.js'></script>
<script type="text/javascript" src='assets/js/alert.js'></script>
</body>
</html>