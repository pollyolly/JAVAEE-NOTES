<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
        <%@include file="_SidebarOfficer.jsp" %>
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
                                <div class="tiles-heading">Travel Order</div>
                                <div class="tiles-body-alt">
                                    <i class="fa fa-book"></i>
                                    <div class="text-center">${topend[0].count}</div>
                                    <small>Pending</small>
                                </div>
                            </a>
                        </div>
                        <div class="col-md-4 col-xs-12 col-sm-6">
                            <a class="info-tiles tiles-toyo" href="#">
                                <div class="tiles-heading">Travel Plan</div>
                                <div class="tiles-body-alt">
                                    <i class="fa fa-plane"></i>
                                    <div class="text-center">${planpend[0].count}</div>
                                    <small>Pending</small>
                                </div>
                            </a>
                        </div>
                        <div class="col-md-4 col-xs-12 col-sm-6">
                            <a class="info-tiles tiles-alizarin" href="#">
                                <div class="tiles-heading">Travel Expense</div>
                                <div class="tiles-body-alt">
                                    <i class="fa fa-usd"></i>
							<div class="text-center">${exppend[0].count}</div>
                                    <small>Pending</small>
                                </div>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
<!-- END DASH ITEMS -->
			<div class="row">
                    <div class="col-md-6 col-lg-6">
                        <div class="panel panel-primary">
                            <div class="panel-heading">
                                <h4>Expense Analytical Report - <%= new java.text.SimpleDateFormat("yyyy").format(new java.util.Date()) %></h4>
                                <div class="options">   
                                    <!--a href="javascript:;"><i class="fa fa-cog"></i></a-->
                                    <a href="javascript:;" class="panel-collapse"><i class="fa fa-chevron-down"></i></a>
                                </div>
                            </div>
                            <div class="panel-body">
                                <div id="graph"></div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6 col-lg-6">
                        <div class="panel panel-primary">
                            <div class="panel-heading">
                                <h4>Travel Analytical Report - <%= new java.text.SimpleDateFormat("yyyy").format(new java.util.Date()) %></h4>
                                <div class="options">   
                                    <!--a href="javascript:;"><i class="fa fa-cog"></i></a-->
                                    <a href="javascript:;" class="panel-collapse"><i class="fa fa-chevron-down"></i></a>
                                </div>
                            </div>
                            <div class="panel-body">
                                <div id="graph1"></div>
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
<script type='text/javascript' src='assets/plugins/form-toggle/toggle.min.js'></script> 
<script type='text/javascript' src='assets/js/placeholdr.js'></script> 
<script type='text/javascript' src='assets/js/application.js'></script>
<script type='text/javascript' src='assets/demo/demo.js'></script>

<script type='text/javascript' src='assets/plugins/charts-morrisjs/morris.min.js'></script> 
<script type='text/javascript' src='assets/plugins/charts-morrisjs/raphael.min.js'></script>
<script type="text/javascript">

$(document).ready(function(){
//BAR
Morris.Bar({
        element: 'graph1',
        data: $.parseJSON('${Atravel}'),
        xkey: 'x',
        ykeys: ['y'],
        labels: ['Total']
    });
//BAR
//LINE
var months = ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"];
Morris.Line({
  element: 'graph',
  data: $.parseJSON('${Aexpense}'),
  xkey: 'x',
  ykeys: ['y'],
  labels: ['Total'],
  xLabelFormat: function(x) {
	    var month = months[x.getMonth()];
	    return month;
	  },
	  dateFormat: function(x) {
	    var month = months[new Date(x).getMonth()];
	    return month;
	  }
});
//LINE
});
</script>
</body>
</html>