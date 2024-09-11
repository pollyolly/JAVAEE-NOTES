<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<title>Messages</title>
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
    <link rel='stylesheet' type='text/css' href='assets/plugins/form-select2/select2.css' /> 
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
				<li><b>Messages</b></li>
			</ol>
		</div>
		<div class="container">

        <!--div class="row">
            <div class="col-md-12">
                <a href="" class="btn btn-success btn-lg margBelow" id="bootbox-demo-5"><li class="fa fa-plus"></li> CREATE</a>
            </div>
        </div-->

<div class="row">
                <div class="col-md-3">
                    <div class="panel">
                        <a href="#" class="btn btn-primary col-xs-12">Create New</a>
                    </div>
                    <hr>
                    <div class="panel">
                        <div class="list-group"> 
                            <a href="#" class="list-group-item"><span class="badge badge-primary">27</span>Inbox</a> 
                            <a href="#" class="list-group-item"><span class="badge badge-danger">9</span>Junk</a> 
                            <a href="#" class="list-group-item">Draft</a> 
                            <a href="#" class="list-group-item">Sent</a> 
                            <a href="#" class="list-group-item"><span class="badge badge-inverse">14</span>Deleted</a> 
                            <a href="#" class="list-group-item"><span class="badge badge-success">5</span>Important</a> 
                        </div>
                    </div>
                </div>
                <div class="col-md-9">

                    <div class="panel panel-gray">
                        <div class="panel-heading">
                            <h4>Inbox</h4>
                            <div class="options">

                            </div>
                        </div>
                        <div class="panel-body">
                            <form class="form-inline" action="#">
                                <div class="input-group">
                                    <input type="text" placeholder="Search messages..." class="form-control">
                                    <div class="input-group-btn">
                                        <button type="button" class="btn btn-primary"><i class="fa fa-search"></i></button>
                                    </div>
                                </div>
                            </form>
                            <hr>
                            <table class="table table-striped table-advance table-hover mailbox">
                                <thead>
                                    <tr>
                                        <th width="5%"><span><input type="checkbox"></span></th>
                                        <th colspan="1">
                                            <div class="btn-group">
                                                <a class="btn btn-sm btn-default dropdown-toggle" href="#" data-toggle="dropdown"> Action <i class="fa fa-caret-down"></i>
                                                </a>
                                                <ul class="dropdown-menu">
                                                    <li><a href="#">Mark Read</a></li>
                                                    <li><a href="#">Mark Unread</a></li>
                                                    <li><a href="#">Junk</a></li>
                                                    <li><a href="#">Move</a></li>
                                                    <li class="divider"></li>
                                                    <li><a href="#">Delete</a></li>
                                                </ul>
                                            </div>
                                        </th>
                                        <th colspan="4">
                                            <div class="pull-right">
                                                <span class="pagination-info" style="margin-right:5px">1-30 of 789</span>
                                                <a class="btn btn-sm btn-default"><i class="fa fa-angle-left"></i></a>
                                                <a class="btn btn-sm btn-default"><i class="fa fa-angle-right"></i></a>
                                            </div>
                                        </th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr class="unread">
                                        <td><span><input type="checkbox"></span></td>
                                        <td class="hidden-xs">Posiedon Web</td>
                                        <td>Server undergoing maintainence</td>
                                        <td><i class="fa fa-paperclip"></i></td>
                                        <td class="text-right">16:30 PM</td>
                                    </tr>
                                    <tr class="unread">
                                        <td><span><input type="checkbox"></span></td>
                                        <td class="hidden-xs">Douglas Adams</td>
                                        <td>Waiting for documentation</td>
                                        <td></td>
                                        <td class="text-right">May 5</td>
                                    </tr>
                                    <tr>
                                        <td><span><input type="checkbox"></span></td>
                                        <td class="hidden-xs">The Doctor</td>
                                        <td>Lorem ipsum dolor sit amet</td>
                                        <td></td>
                                        <td class="text-right">May 5</td>
                                    </tr>
                                    <tr>
                                        <td><span><input type="checkbox"></span></td>
                                        <td class="hidden-xs">Nero</td>
                                        <td>Rilate niro lakem, consectetuer adipiscing</td>
                                        <td></td>
                                        <td class="text-right">May 4</td>
                                    </tr>
                                    <tr>
                                        <td><span><input type="checkbox"></span></td>
                                        <td class="hidden-xs">Envato</td>
                                        <td>Lorem ipsum dolor sit amet</td>
                                        <td></td>
                                        <td class="text-right">May 5</td>
                                    </tr>
                                    <tr>
                                        <td><span><input type="checkbox"></span></td>
                                        <td class="hidden-xs">mPower</td>
                                        <td>Rilate niro lakem, consectetuer adipiscing</td>
                                        <td><i class="fa fa-paperclip"></i></td>
                                        <td class="text-right">May 4</td>
                                    </tr>
                                    <tr>
                                        <td><span><input type="checkbox"></span></td>
                                        <td class="hidden-xs">Facebook</td>
                                        <td>Lorem ipsum dolor sit amet</td>
                                        <td><i class="fa fa-paperclip"></i></td>
                                        <td class="text-right">May 5</td>
                                    </tr>
                                    <tr>
                                        <td><span><input type="checkbox"></span></td>
                                        <td class="hidden-xs">Twitter</td>
                                        <td>Rilate niro lakem, consectetuer adipiscing</td>
                                        <td></td>
                                        <td class="text-right">May 4</td>
                                    </tr>
                                    <tr>
                                        <td><span><input type="checkbox"></span></td>
                                        <td class="hidden-xs">Emma Watson</td>
                                        <td>Lorem ipsum dolor sit amet</td>
                                        <td></td>
                                        <td class="text-right">May 5</td>
                                    </tr>
                                    <tr>
                                        <td><span><input type="checkbox"></span></td>
                                        <td class="hidden-xs">Life</td>
                                        <td>Lemons for sale</td>
                                        <td></td>
                                        <td class="text-right">May 4</td>
                                    </tr>
                                    <tr>
                                        <td><span><input type="checkbox"></span></td>
                                        <td class="hidden-xs">John Doe</td>
                                        <td>Lorem ipsum dolor sit amet</td>
                                        <td></td>
                                        <td class="text-right">May 5</td>
                                    </tr>
                                    <tr>
                                        <td><span><input type="checkbox"></span></td>
                                        <td class="hidden-xs">Jack Smith</td>
                                        <td>Rilate niro lakem, consectetuer adipiscing</td>
                                        <td><i class="fa fa-paperclip"></i></td>
                                        <td class="text-right">May 4</td>
                                    </tr>
                                    <tr>
                                        <td><span><input type="checkbox"></span></td>
                                        <td class="hidden-xs">Indiana Jones</td>
                                        <td>Lorem ipsum dolor sit amet</td>
                                        <td><i class="fa fa-paperclip"></i></td>
                                        <td class="text-right">May 5</td>
                                    </tr>
                                    <tr>
                                        <td><span><input type="checkbox"></span></td>
                                        <td class="hidden-xs">Sherlock</td>
                                        <td>Rilate niro lakem, consectetuer adipiscing</td>
                                        <td></td>
                                        <td class="text-right">May 4</td>
                                    </tr>
                                    <tr>
                                        <td><span><input type="checkbox"></span></td>
                                        <td class="hidden-xs">Facebook</td>
                                        <td>Rilate niro lakem, consectetuer adipiscing</td>
                                        <td><i class="fa fa-paperclip"></i></td>
                                        <td class="text-right">May 4</td>
                                    </tr>
                                    <tr>
                                        <td><span><input type="checkbox"></span></td>
                                        <td class="hidden-xs">Jane Smith</td>
                                        <td>Lorem ipsum dolor sit amet</td>
                                        <td><i class="fa fa-paperclip"></i></td>
                                        <td class="text-right">May 5</td>
                                    </tr>
                                </tbody>
                                <tfoot>
                                    <tr>
                                        <th colspan="5">
                                            <div class="pull-right">
                                                <span class="pagination-info" style="margin-right:5px">1-30 of 789</span>
                                                <a class="btn btn-sm btn-default"><i class="fa fa-angle-left"></i></a>
                                                <a class="btn btn-sm btn-default"><i class="fa fa-angle-right"></i></a>
                                            </div>
                                        </th>
                                    </tr>
                                </tfoot>
                            </table>
                        </div>
                    </div>
                </div>
                
            </div>

        
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
<script type='text/javascript' src='assets/demo/demo-datatables.js'></script> 
<script type='text/javascript' src='assets/js/placeholdr.js'></script> 
<script type='text/javascript' src='assets/js/application.js'></script> 
<script type='text/javascript' src='assets/demo/demo.js'></script>

<script type='text/javascript' src='assets/plugins/form-select2/select2.min.js'></script>
<script type="text/javascript">
$(document).ready(function() {
  $("#e1").select2(),
  $("#e2").select2();
});
</script>
</body>
</html>