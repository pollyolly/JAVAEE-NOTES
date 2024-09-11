<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Login</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Avant">
    <meta name="author" content="The Red Team">
	<link rel='shortcut icon' href='assets/img/BPS_LOGO.png' type='image/jpeg' style="width: 16px; height: 16px;" />
    <link rel="stylesheet" href="assets/css/styles.min.css">
    
</head><body class="focusedform">
<div class="verticalcenter">
<%@include file="_Message.jsp"%>
	<div class="panel panel-primary">
		<div class="panel-body">
			<div></div>
			<h4 class="text-center"><image class="" src="assets/img/BPS_LOGO.png" style="width:60px; height:60px;"> | BPS-Personnel Travel Management System</h4>
				<form action="Authentication" method="POST" class="form-horizontal" style="margin-bottom: 0px !important;">
						<input type="hidden" class="form-control" name="forms" id="forms" value="login"/>
						<div class="form-group">
							<div class="col-sm-12">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user"></i></span>
									<input type="text" class="form-control" name="username" id="username" placeholder="Username">
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-12">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-lock"></i></span>
									<input type="password" class="form-control" name="password" id="password" placeholder="Password">
								</div>
							</div>
						</div>
						<div class="clearfix">
							<!--div class="pull-right"><label><input type="checkbox" style="margin-bottom: 20px" checked=""> Remember Me</label></div-->
						</div>
		</div>
		<div class="panel-footer">
			<!--a href="extras-forgotpassword.htm" class="pull-left btn btn-link" style="padding-left:0">Forgot password?</a-->
			
			<div class="pull-right">
				<input type="reset" class="btn btn-default" value="Clear"/>
				<input type="submit" class="btn btn-primary" value="Log-In"/>
			</div>
		</div>
		</form>
	</div>
 </div>
<script type='text/javascript' src='assets/js/bootstrap.min.js'></script>
<script type='text/javascript' src='assets/js/jquery-1.10.2.min.js'></script> 
<script type='text/javascript' src='assets/js/jqueryui-1.10.3.min.js'></script>
<script type="text/javascript" src='assets/js/alert.js'></script>
</body>
</html>