<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<title>Report-Travel Analytical</title>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="Avant">
	<meta name="author" content="The Red Team">
	<link rel="stylesheet" href="assets/css/styles.css?=121">
	<link href='assets/demo/variations/default.css' rel='stylesheet' type='text/css' media='all' id='styleswitcher'> 
	<link href='assets/demo/variations/default.css' rel='stylesheet' type='text/css' media='all' id='headerswitcher'> 
	<link rel='stylesheet' type='text/css' href='assets/plugins/codeprettifier/prettify.css' /> 
	<link rel='stylesheet' type='text/css' href='assets/plugins/form-toggle/toggles.css' /> 
	
	<link rel='stylesheet' type='text/css' href='assets/plugins/charts-morrisjs/morris.css'/> 
	<link rel='stylesheet' type='text/css' href='assets/plugins/form-select2/select2.css' /> 
	<link rel='stylesheet' type='text/css' href='assets/css/custom.css'/>
	<link rel='stylesheet' type='text/css' href='assets/fonts/glyphicons/css/glyphicons.min.css' />
	<link rel='shortcut icon' href='assets/img/BPS_LOGO.png' type='image/jpeg' style="width: 16px; height: 16px;" />
</head>

<body class="">

<%@include file="_Topbar.jsp"%>

    <div id="page-container">
        <!-- BEGIN SIDEBAR -->
         <%@include file="_Sidebar.jsp" %>

    <div id="page-content">
        <div id='wrap'>
            <div id="page-heading">
                <ol class="breadcrumb">
                    <li><a href="index.htm">Dashboard</a></li>
                    <li>Report</li>
                    <li><b>Travel Analytical</b></li>
                </ol>
            </div>
            <div class="container">
			<div class="row">
			<div class="col-md-12">
				<div class="panel panel-primary">
					<div class="panel-body">
						<form class="form-horizontal">
                          <div class="form-group">
                            <label for="focusedinput" class="col-xs-2 control-label">Department:</label>
                            <div class="col-xs-3">
                            <select name="department" id="department" style="width:100%;">
                                <option>Search...</option>
                                <option>Department One</option>
                                <option>Department Two</option>
                                <option>Deartment Three</option>
                            </select>
                            </div>
                          </div>
					<div class="form-group">
                            <label for="focusedinput" class="col-xs-2 control-label">Personnel:</label>
                            <div class="col-xs-3">
                            <select name="personnel" id="personnel" style="width:100%;">
                                <option>Search...</option>
                                <option>Department One</option>
                                <option>Department Two</option>
                                <option>Deartment Three</option>
                            </select>
                            </div>
                          </div>
					<div class="form-group">
                            <label for="focusedinput" class="col-xs-2 control-label">Destination:</label>
                            <div class="col-xs-3">
                            <select name="destination" id="destination" style="width:100%;">
                                <option>Search...</option>
                                <option>Department One</option>
                                <option>Department Two</option>
                                <option>Deartment Three</option>
                            </select>
                            </div>
                          </div>
					<div class="form-group">
                            <label class="col-xs-2 control-label">FromDate:</label>
                                <div class="col-xs-3">
                                    <div class="input-group date" id="fromdate">
                                        <input type="text" class="form-control">
                                        <span class="input-group-addon"><i class="fa fa-calendar"></i></span>
                                    </div>
                                </div>
                        </div>
                        <div class="form-group">
                            <label class="col-xs-2 control-label">ToDate:</label>
                                <div class="col-xs-3">
                                    <div class="input-group date" id="todate">
                                        <input type="text" class="form-control">
                                        <span class="input-group-addon"><i class="fa fa-calendar"></i></span>
                                    </div>
                                </div>
                        </div>
                        </form>
					</div>
				</div>
			</div>
			</div>
                <div class="row">
                    <div class="col-md-12 col-lg-12">
                        <div class="panel panel-primary">
                            <div class="panel-heading">
                                <h4>Travel Analytical Report</h4>
                                <div class="options">   
                                    <!--a href="javascript:;"><i class="fa fa-cog"></i></a-->
                                    <a href="javascript:;" class="panel-collapse"><i class="fa fa-chevron-down"></i></a>
                                </div>
                            </div>
                            <div class="panel-body">
                              <div id="bar-example"></div>
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
<script type='text/javascript' src='assets/js/placeholdr.js'></script> 
<script type='text/javascript' src='assets/js/application.js'></script> 
<script type='text/javascript' src='assets/demo/demo.js'></script>

<script type='text/javascript' src='assets/plugins/form-select2/select2.min.js'></script>
<script type='text/javascript' src='assets/plugins/form-datepicker/js/bootstrap-datepicker.js'></script>
<script type='text/javascript' src='assets/plugins/charts-morrisjs/morris.min.js'></script> 
<script type='text/javascript' src='assets/plugins/charts-morrisjs/raphael.min.js'></script>
<script type="text/javascript">
$(document).ready(function(){
$('#fromdate').datepicker({}),
$('#todate').datepicker({}),
$('#department').select2(),
$('#destination').select2(),
$('#personnel').select2(),
Morris.Bar({
        element: 'bar-example',
        data: [
            { y: '2006', a: 100, b: 90 },
            { y: '2007', a: 75,  b: 65 },
            { y: '2008', a: 50,  b: 40 },
            { y: '2009', a: 75,  b: 65 },
            { y: '2010', a: 50,  b: 40 },
            { y: '2011', a: 75,  b: 65 },
            { y: '2012', a: 100, b: 90 }
        ],
        xkey: 'y',
        ykeys: ['a', 'b'],
        labels: ['Series A', 'Series B']
    });
});
</script>

</body>
</html>