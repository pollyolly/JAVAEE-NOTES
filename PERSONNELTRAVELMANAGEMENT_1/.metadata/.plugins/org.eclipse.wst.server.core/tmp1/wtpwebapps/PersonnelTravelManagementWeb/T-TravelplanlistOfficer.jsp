<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
		<meta charset="utf-8">
		<title>Transaction-Travel Plan</title>
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta name="description" content="Avant">
		<meta name="author" content="The Red Team">
		<link rel="stylesheet" href="assets/css/styles.min.css">
		<link href='assets/demo/variations/default.css' rel='stylesheet' type='text/css' media='all' id='styleswitcher'> 
		<link href='assets/demo/variations/default.css' rel='stylesheet' type='text/css' media='all' id='headerswitcher'> 
		<link rel='stylesheet' type='text/css' href='assets/plugins/codeprettifier/prettify.css' /> 
		<link rel='stylesheet' type='text/css' href='assets/plugins/form-toggle/toggles.css' />
		
	<link rel="stylesheet" type="text/css" href="assets/plugins/datatables/dataTables.css">
	<link rel="stylesheet" type="text/css" href="assets/plugins/form-multiselect/css/multi-select.css">
	<!--link rel='stylesheet' type='text/css' href='assets/plugins/form-select2/select2.css' /-->
	<link rel='stylesheet' type='text/css' href='assets/plugins/select2-4.0/css/select2.css' />
	<link rel='stylesheet' type='text/css' href='assets/fonts/glyphicons/css/glyphicons.min.css' />
	<link rel='stylesheet' type='text/css' href='assets/css/custom.css' />
	
	<!--link rel='stylesheet' type='text/css' href='assets/plugins/datetimepicker/css/bootstrap-datetimepicker.min.css' /-->
	
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
        <%@include file="_SidebarOfficer.jsp"%>
        <!-- END SIDEBAR -->
        <!-- BEGIN RIGHTBAR -->
        <!-- END RIGHTBAR -->
<div id="page-content">
	<div id='wrap'>
		<div id="page-heading">
			<ol class="breadcrumb">
				<li><a href="DashboardOfficer">Dashboard</a></li>
				<li>Transaction</li>
				<li><b>Travel Plan List</b></li>
			</ol>
		</div>
		<div class="container">

        <div class="row">
            <div class="col-md-6">
                <div class="panel panel-primary">
                    <div class="panel-body">
                        <table class="table-1">
                        	 <c:forEach items="${plan}" var="list" begin="0" end="0">
								<tr>
									<td>TO.#:</td><td><c:out value="${list.tono}"/></td>
								</tr>
								<tr>
									<td>Personnel(s):</td><td><textarea id="demp" class="form-control txtplan" rows="2" cols="60" readonly><c:out value="${names}"/></textarea></td>
								</tr>
								<!--tr>
									<td>Departmet:</td><td>Shoe Dept.</td><td>Purpose:</td><td>Business Trip</td>
								</tr -->
								<tr>
									<td>FromDate:</td><td><c:out value="${list.fromdate}"/></td>
								</tr>
								<tr>
									<td>ToDate:</td><td><c:out value="${list.todate}"/></td>
								</tr>
								<tr>
									<td>Destination:</td><td><c:out value="${list.destination}"/></td>
								</tr>
								<tr>
									<td>ApprovedBy:</td><td><c:out value="${list.officername}"/></td>
								</tr>
								<tr>
									<td>Status:</td>
									<td>
										<c:choose>
										<c:when test="${list.status== 'Approved'}">
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
								</tr>
								</c:forEach>
                         </table>
                    </div>
                </div>
            </div>
            <div class="col-md-6">
                <div class="panel panel-primary">
                    <div class="panel-body">
                        <table class="table-1">
                        <c:forEach items="${plan}" var="list"  begin="0" end="0">
					<tr>
						<td><b>Accommodation:</b></td><td><fmt:formatNumber value="${list.accommodation}" type="currency" currencySymbol="P" minFractionDigits="2"/></td>
					</tr>
					<tr>
						<td><b>Transportation:</b></td><td><fmt:formatNumber value="${list.transportation}" type="currency" currencySymbol="P" minFractionDigits="2"/></td>
					</tr>
					<tr>
						<td><b>Food:</b></td><td><fmt:formatNumber value="${list.food}" type="currency" currencySymbol="P" minFractionDigits="2"/></td>
					</tr>
					<tr>
						<td><b>PerDiem:</b></td><td><fmt:formatNumber value="${list.perdiem}" type="currency" currencySymbol="P" minFractionDigits="2"/></td>
					</tr>
					<tr>
						<td><b>Allowance:</b></td><td><fmt:formatNumber value="${list.allowance}" type="currency" currencySymbol="P" minFractionDigits="2"/></td>
					</tr>
					<tr>
						<td><b>On-travel:</b></td>
						<td><span><fmt:formatNumber value="${list.svtotal}" type="currency" currencySymbol="P" minFractionDigits="2"/></span></td>
					</tr>
					<tr>
						<td><b>Total:</b></td>
						<td>
							<c:choose>
							<c:when test="${(list.svtotal + list.accommodation + list.transportation + list.food+ list.perdiem + list.allowance) > policylist[0].maxbudget}">
								<label id="dtotal" class="label label-danger" >
								<fmt:formatNumber value="${list.svtotal+ list.accommodation+ list.transportation + list.food+ list.perdiem + list.allowance}" type="currency" currencySymbol="P" minFractionDigits="2"/>
								</label>
							</c:when>
							<c:otherwise>
								<fmt:formatNumber value="${list.svtotal+ list.accommodation+ list.transportation + list.food+ list.perdiem + list.allowance}" type="currency" currencySymbol="P" minFractionDigits="2"/>
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
        <!--div class="row">
			<div class="col-md-12">
				<a href="#" class="btn btn-success margBelow"><i class="glyphicon glyphicon-send"></i> Approval</a>
			</div>
		</div-->
		<!--BEGIN TABLE-->
		<div class="row">
              <div class="col-md-12">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <h4>Travel Plan List</h4>
                            <div class="options">   
                                <a href="javascript:;" class="panel-collapse"><i class="fa fa-chevron-down"></i></a>
                            </div>
                        </div>
                        <div class="panel-body collapse in">
                         <div class="table-responsive">
                            <table class="table table-striped table-bordered table-hover datatables dataTable" id="DataTables_Table_0">
                                <thead>
                                    <tr>
                                    <th>Type</th>
                                    <th>Details</th>
                                    <th>Services</th>
                                    <th>Amount</th>
                                    <!--th>Attachment</th-->
                                    </tr>
                                </thead>
                                
                            <tbody>
                            <c:forEach items="${planlist}" var="list">
                            	 <c:choose>
                            		<c:when test="${list.type == 'Flight'}">
                            			<tr>
                                        <td>${list.type}</td>
                                        <td>
                                        <b>ServiceProvider:</b> ${list.serviceprovider}<br>
										<b>PaymentConfirmation#:</b> ${list.pcn}<br>
                                        <b>Departure:</b> ${list.departure}
                                        <b>Return:</b> ${list.returns}<br>
										<b>Stop-Over:</b>
										<c:choose>
										<c:when test="${list.stopover > 0}">
											YES
										</c:when>
										<c:otherwise>
											No
										</c:otherwise>
										</c:choose>
										<b>From:</b> ${list.ffrom} <b>To:</b> ${list.fto}
                                        </td>
                                        <td>${list.service}</td>
                                        <td><fmt:formatNumber value="${list.amount}" type="currency" currencySymbol="P" minFractionDigits="2"/></td>
                                        <!--td>
                                             <a href="" class="btn btn-info btn-xs">Add</a>
                                            
                                        </td-->
                                    </tr>
									</c:when>
									<c:when test="${list.type == 'Car Rental'}">
										 <tr>
                                        <td>${list.type}</td>
                                        <td>
                                        <b>ServiceProvider:</b> ${list.serviceprovider}<br>
										<b>PaymentConfirmation#:</b> ${list.pcn}<br>
                                        <b>From:</b> ${list.cfrom}
                                        <b>To:</b> ${list.cto}<br>
                                        <b>Pick-Up:</b> ${list.pickup}
                                        <b>Drop-Off:</b> ${list.dropoff}
                                        </td>
                                        <td>${list.service}</td>
                                        <td><fmt:formatNumber value="${list.amount}" type="currency" currencySymbol="P" minFractionDigits="2"/></td>
                                        <!--td>
                                              <a href="" class="btn btn-info btn-xs">Add</a>
                                           
                                        </td-->
                                    </tr>
									</c:when>
									<c:when test="${list.type == 'Hotel'}">
										 <tr>
                                        <td>${list.type}</td>
                                        <td>
                                        <b>ServiceProvider:</b> ${list.serviceprovider}<br>
										<b>PaymentConfirmation#:</b> ${list.pcn}<br>
										<b>Check-In:</b> ${list.checkin} 
                                        <b>Check-Out:</b> ${list.checkout}
                                        </td>
                                        <td>${list.service}</td>
                                        <td><fmt:formatNumber value="${list.amount}" type="currency" currencySymbol="P" minFractionDigits="2"/></td>
                                        <!--td>
                                             <a href="" class="btn btn-info btn-xs">Add</a>
                                        </td-->
                                    </tr>
									</c:when>
									<c:when test="${list.type == 'Miscellaneous'}">
										<tr>
                                        <td>${list.type}</td>
                                        <td>
                                        <b>Vendor:</b> ${list.vendor}<br>
										<b>PaymentConfirmation#:</b> ${list.pcn}
                                        </td>
                                        <td><b>Description:</b> ${list.description}</td>
                                        <td><fmt:formatNumber value="${list.miscamount}" type="currency" currencySymbol="P" minFractionDigits="2"/></td>
                                        <!--td>
                                             <a href="" class="btn btn-info btn-xs">Add</a>
                                        </td-->
                                    </tr>
									</c:when>
									<c:otherwise>
										<tr>
                                        <td><label class="label label-default">None</label></td>
                                        <td><label class="label label-default">None</label></td>
                                        <td><label class="label label-default">None</label></td>
                                        <td><label class="label label-default">None</label></td>
                                    </tr>
									</c:otherwise>
                            	 </c:choose>
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

</div> <!-- page-container -->


<script type='text/javascript' src='assets/js/jquery-1.10.2.min.js'></script> 
<script type='text/javascript' src='assets/js/jqueryui-1.10.3.min.js'></script> 
<script type='text/javascript' src='assets/js/bootstrap.min.js'></script> 
<script type='text/javascript' src='assets/js/enquire.js'></script> 
<script type='text/javascript' src='assets/js/jquery.cookie.js'></script> 
<script type='text/javascript' src='assets/js/jquery.nicescroll.min.js'></script> 
<script type='text/javascript' src='assets/plugins/codeprettifier/prettify.js'></script>  
<script type='text/javascript' src='assets/plugins/sparklines/jquery.sparklines.min.js'></script> 
<script type='text/javascript' src='assets/plugins/form-toggle/toggle.min.js'></script> 
<script type='text/javascript' src='assets/plugins/datatables/jquery.dataTables.min.js'></script> 
<script type='text/javascript' src='assets/plugins/datatables/dataTables.bootstrap.js'></script>
<script type='text/javascript' src='assets/js/placeholdr.js'></script> 
<script type='text/javascript' src='assets/js/application.js'></script>
<script type='text/javascript' src='assets/js/demo.js'></script>
<script type='text/javascript' src='assets/js/data-table.js'></script> 
<script type='text/javascript' src='assets/js/populate-services.js'></script> 
<script type='text/javascript' src='assets/js/tools.js'></script>
<script type='text/javascript' src='assets/js/multi-select.js'></script>  

<script type="text/javascript" src="assets/plugins/quicksearch/jquery.quicksearch.min.js"></script>
<!--script type='text/javascript' src='assets/plugins/form-select2/select2.min.js'></script-->
<script type='text/javascript' src='assets/plugins/select2-4.0/js/select2.full.min.js'></script>
<script type='text/javascript' src='assets/plugins/form-multiselect/js/jquery.multi-select.min.js'></script>
<script type='text/javascript' src='assets/plugins/form-datepicker/js/bootstrap-datepicker.js'></script>
<script type='text/javascript' src="assets/plugins/form-jasnyupload/fileinput.js"></script>
<script type="text/javascript" src='assets/js/alert.js'></script>
</body>
</html>