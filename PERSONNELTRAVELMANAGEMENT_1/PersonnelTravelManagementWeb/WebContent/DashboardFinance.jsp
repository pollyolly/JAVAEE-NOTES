<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
		<meta charset="utf-8">
		<title>Dashboard</title>
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta name="description" content="Avant">
		<meta name="author" content="The Red Team">
		<link rel="stylesheet" href="assets/css/styles.min.css?=113">
		<link href='assets/demo/variations/default.css' rel='stylesheet' type='text/css' media='all' id='styleswitcher'> 
		<link href='assets/demo/variations/default.css' rel='stylesheet' type='text/css' media='all' id='headerswitcher'> 
		<link rel='stylesheet' type='text/css' href='assets/plugins/codeprettifier/prettify.css' /> 
		<link rel='stylesheet' type='text/css' href='assets/plugins/form-toggle/toggles.css' />
		<!--BEGIN CUSTOM.CSS--> 
		<link rel='stylesheet' type='text/css' href='assets/plugins/charts-morrisjs/morris.css'/> 
		<link rel='stylesheet' type='text/css' href='assets/css/custom.css' />
		<link rel='stylesheet' type='text/css' href='assets/fonts/glyphicons/css/glyphicons.min.css' /> 
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
        <%@include file="_Sidebarfinance.jsp" %>
        <!-- END SIDEBAR -->
        <!-- BEGIN RIGHTBAR -->
        <!-- END RIGHTBAR -->
<div id="page-content">
	<div id='wrap'>
		<div id="page-heading">
			<ol class="breadcrumb">
				<li><a href="">Dashboard</a></li>
			</ol>
		</div>
		<div class="container">
<!-- BEGIN DASH ITEMS -->
<div class="row">
                <div class="col-md-12">
                    <div class="row">
                        <div class="col-md-4 col-xs-12 col-sm-6">
                            <a class="info-tiles tiles-orange" href="#">
                                <div class="tiles-heading">Travel Cash Advance</div>
                                <div class="tiles-body-alt">
                                    <i class="fa fa-usd"></i>
                                    <div class="text-center">109</div>
                                    <small>pending Cash Advance</small>
                                </div>
                                <div class="tiles-footer">go to users</div>
                            </a>
                        </div>
                        <div class="col-md-4 col-xs-12 col-sm-6">
                            <a class="info-tiles tiles-toyo" href="#">
                                <div class="tiles-heading">Travel Budget</div>
                                <div class="tiles-body-alt">
                                    <i class="fa fa-usd"></i>
                                    <div class="text-center">854</div>
                                    <small>Pending Budget Approval</small>
                                </div>
                                <div class="tiles-footer">go to travel plan</div>
                            </a>
                        </div>
                        <div class="col-md-4 col-xs-12 col-sm-6">
                            <a class="info-tiles tiles-alizarin" href="#">
                                <div class="tiles-heading">Travel Expense</div>
                                <div class="tiles-body-alt">
                                    <i class="fa fa-usd"></i>
							<div class="text-center">22</div>
                                    <small>Pending Expense Approval</small>
                                </div>
                                <div class="tiles-footer">go to travel expense</div>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
<!-- END DASH ITEMS -->
			<div class="row">
                    <div class="col-md-12 col-lg-12">
                        <div class="panel panel-primary">
                            <div class="panel-heading">
                                <h4>Expense Analytical  Summary Report</h4>
                                <div class="options">   
                                    <!--a href="javascript:;"><i class="fa fa-cog"></i></a-->
                                    <a href="javascript:;" class="panel-collapse"><i class="fa fa-chevron-down"></i></a>
                                </div>
                            </div>
                            <div class="panel-body">
                                <div id="line-example"></div>
                            </div>
                        </div>
                    </div>
                </div>
			<div class="row">
                    <div class="col-md-12 col-lg-12">
                        <div class="panel panel-primary">
                            <div class="panel-heading">
                                <h4>Travel Analytical Summary Report</h4>
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

<script type='text/javascript' src='assets/plugins/charts-morrisjs/morris.min.js'></script> 
<script type='text/javascript' src='assets/plugins/charts-morrisjs/raphael.min.js'></script>
<script type="text/javascript">
$(document).ready(function(){
Morris.Line({
        element: 'line-example',
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
    }),
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