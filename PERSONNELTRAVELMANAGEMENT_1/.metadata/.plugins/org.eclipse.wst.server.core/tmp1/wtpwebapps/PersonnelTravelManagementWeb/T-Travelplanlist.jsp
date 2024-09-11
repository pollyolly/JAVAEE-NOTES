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
				<li><b>Travel Plan List</b></li>
			</ol>
			<div class="options">
                  <a href="#myModal" data-toggle="modal"  class="btn btn-default">Import</a>
            </div>
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
							<c:when test="${(list.svtotal+ list.accommodation+ list.transportation + list.food+ list.perdiem + list.allowance) > policylist[0].maxbudget}">
								<label class="label label-danger" >
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
                                             <a href="" class="btn btn-info btn-sm">Add</a>
                                            
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
                                              <a href="" class="btn btn-info btn-sm">Add</a>
                                           
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
                                             <a href="" class="btn btn-info btn-sm">Add</a>
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
                                             <a href="" class="btn btn-info btn-sm">Add</a>
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
        <div class="row">
            <div class="col-md-12">
                <!-- PANEL PRIMARY TAB -->
                <div class="panel panel-primary">
				  <div class="panel-heading">
				  	<div class="options">   
                            <a href="" class="panel-collapse"><i class="fa fa-chevron-down"></i></a>
                        </div>
				    <ul class="nav nav-tabs">
				      <li class="active">
				        <a href="#cartab" data-toggle="tab">Car Rental</a>
				      </li>
				      <li>
				        <a href="#hoteltab" data-toggle="tab">Hotel</a>
				      </li>
				      <li>
				        <a href="#flighttab" data-toggle="tab">Flight</a>
				      </li>
				      <li>
				        <a href="#miscellaneoustab" data-toggle="tab">Miscellaneous</a>
				      </li>
				    </ul>
				  
				  </div>
				  <div class="panel-body">
				    <div class="tab-content">
				      <div class="tab-pane active" id="cartab">
                        <form class="form-horizontal" action="TravelPlanList" method="POST">
                        <c:forEach items="${plan}" var="list" begin="0" end="0">
                        	<input type="hidden" name="tno" id="tno" value="${list.tono}">
                        	<input type="hidden" name="tpid" id="tpid" value="${list.planid}">
                        </c:forEach>
                        	<input type="hidden" name="type" id="type" value="9">
                        	<input type="hidden" name="forms" id="forms" value="car">
	                        <div class="form-group ">
	                            <label for="mediuminput" class="col-sm-3 control-label">PaymentConfirmation#:</label>
	                            <div class="col-sm-3">
	                              <input type="text" class="form-control" id="pcn" name="pcn" placeholder="0000000">
	                            </div>
	                        </div>
	                       	<div class="form-group" id="val9">
	                            <label for="focusedinput" class="col-sm-3 control-label">ServiceProvider:</label>
	                            <div class="col-sm-3">
	                            <select name="serviceprovider" id="serviceprovider" class="select2 carserviceprovider" style="width:100%;">
	                                <option></option>
	                                <c:forEach items="${splist}" var="list">
	                                	<option value="${list.id}">${list.company}</option>
	                                </c:forEach>
	                            </select>
	                            </div>
	                         </div>
	                         <div class="form-group" id="val9">
	                            <label for="focusedinput" class="col-sm-3 control-label">Services:</label>
	                            <div class="col-sm-3">
	                            <select name="service" id="service" class="select2 carservice" style="width:100%;">
	                               <option></option>
	                            </select>
	                            </div>
	                         </div>
	                        <div class="form-group " id="val5">
	                            <label for="mediuminput" class="col-sm-3 control-label car">From:</label>
	                            <div class="col-sm-3">
	                              <input type="text" class="form-control" id="from" name="from" placeholder="">
	                            </div>
	                        </div>
	                        <div class="form-group " id="val6">
	                            <label for="mediuminput" class="col-sm-3 control-label car">To:</label>
	                            <div class="col-sm-3">
	                              <input type="text" class="form-control" id="to" name="to" placeholder="">
	                            </div>
	                        </div>
	                        <div class="form-group " id="val7">
	                            <label for="mediuminput" class="col-sm-3 control-label car">PickUp:</label>
	                            <div class="col-sm-3">
	                                    <div class="input-group date">
	                                        <input type="text" class="form-control fromDATElist" id="pickup" name="pickup" placeholder="yyyy-mm-dd">
	                                        <span class="input-group-addon"><i class="fa fa-calendar"></i></span>
	                                    </div>
	                                </div>
	                        </div>
	                        <div class="form-group " id="val8">
	                            <label for="mediuminput" class="col-sm-3 control-label car">DropOff:</label>
	                            <div class="col-sm-3">
	                                    <div class="input-group date">
	                                        <input type="text" class="form-control toDATElist" id="dropoff" name="dropoff" placeholder="yyyy-mm-dd">
	                                        <span class="input-group-addon"><i class="fa fa-calendar"></i></span>
	                                    </div>
	                                </div>
	                        </div>
	                    <div class="panel-footer">
	                        <div class="row">
	                        <div class="col-sm-2">
	                        </div>
	                            <div class="col-sm-4">
	                                <div class="btn-toolbar">
	                                    <input type="submit" class="btn-primary btn" value="Submit"/>
	                                    <input type="reset" class="btn-default btn" value="Clear"/>
	                                </div>
	                            </div>
	                        </div>
	                      </div></form>
						</div> <!-- TAB 1 -->
				      <div class="tab-pane" id="hoteltab">
				      	<form class="form-horizontal" action="TravelPlanList" method="POST">
				      		<c:forEach items="${plan}" var="list" begin="0" end="0">
                        	<input type="hidden" name="tno" id="tno" value="${list.tono}">
                        	<input type="hidden" name="tpid" id="tpid" value="${list.planid}">
                       		 </c:forEach>
				      		<input type="hidden" name="type" id="type" value="7">
				      		<input type="hidden" name="forms" id="forms" value="hotel">
	                        <div class="form-group ">
	                            <label for="mediuminput" class="col-sm-3 control-label">PaymentConfirmation#:</label>
	                            <div class="col-sm-3">
	                              <input type="text" class="form-control" id="pcn" name="pcn" placeholder="0000000">
	                            </div>
	                        </div>
	                       	<div class="form-group" id="val9">
	                            <label for="focusedinput" class="col-sm-3 control-label">ServiceProvider:</label>
	                            <div class="col-sm-3">
	                            <select name="serviceprovider" id="serviceprovider" class="select2 hotelserviceprovider" style="width:100%;">
	                                <option></option>
	                                <c:forEach items="${splist}" var="list">
	                                	<option value="${list.id}">${list.company}</option>
	                                </c:forEach>
	                            </select>
	                            </div>
	                         </div>
	                         <div class="form-group" id="val9">
	                            <label for="focusedinput" class="col-sm-3 control-label">Services:</label>
	                            <div class="col-sm-3">
	                            <select name="service" id="service" class="form-control hotelservice select2" style="width:100%;">
	                               <option></option>
	                            </select>
	                            </div>
	                         </div>
				      		<div class="form-group " id="val3">
	                            <label for="mediuminput" class="col-sm-3 control-label">CheckIn:</label>
	                            <div class="col-sm-3">
	                                    <div class="input-group date">
	                                        <input type="text" class="form-control fromDATElist" name="checkin" id="checkin" placeholder="yyyy-mm-dd">
	                                        <span class="input-group-addon"><i class="fa fa-calendar"></i></span>
	                                    </div>
	                                </div>
	                        </div>
	                        <div class="form-group " id="val4">
	                            <label for="mediuminput" class="col-sm-3 control-label">CheckOut:</label>
	                            <div class="col-sm-3">
	                                    <div class="input-group date">
	                                        <input type="text" class="form-control toDATElist" name="checkout" id="checkout" placeholder="yyyy-mm-dd">
	                                        <span class="input-group-addon"><i class="fa fa-calendar"></i></span>
	                                    </div>
	                                </div>
	                        </div>
	                        <div class="panel-footer">
	                        <div class="row">
	                        <div class="col-sm-2">
	                        </div>
	                            <div class="col-sm-4">
	                                <div class="btn-toolbar">
	                                    <input type="submit" class="btn-primary btn" value="Submit"/>
	                                    <input type="reset" class="btn-default btn" value="Clear"/>
	                                </div>
	                            </div>
	                        </div>
	                      </div>
	                  	</form>
				      </div><!-- TAB 2 -->
				      <div class="tab-pane" id="flighttab">
				      	<form class="form-horizontal" action="TravelPlanList" method="POST">
				      		<c:forEach items="${plan}" var="list" begin="0" end="0">
                        	<input type="hidden" name="tno" id="tno" value="${list.tono}">
                        	<input type="hidden" name="tpid" id="tpid" value="${list.planid}">
                        	</c:forEach>
				      		<input type="hidden" name="type" id="type" value="8">
				      		<input type="hidden" name="forms" id="forms" value="flight">
	                        <div class="form-group ">
	                            <label for="mediuminput" class="col-sm-3 control-label">PaymentConfirmation#:</label>
	                            <div class="col-sm-3">
	                              <input type="text" class="form-control" id="pcn" name="pcn" placeholder="0000000">
	                            </div>
	                        </div>
	                       	<div class="form-group" id="val9">
	                            <label for="focusedinput" class="col-sm-3 control-label">ServiceProvider:</label>
	                            <div class="col-sm-3">
	                            <select name="serviceprovider" id="serviceprovider" class="select2 flightserviceprovider" style="width:100%;">
	                                <option></option>
	                                <c:forEach items="${splist}" var="list">
	                                	<option value="${list.id}">${list.company}</option>
	                                </c:forEach>
	                            </select>
	                            </div>
	                         </div>
	                         <div class="form-group" id="val9">
	                            <label for="focusedinput" class="col-sm-3 control-label">Services:</label>
	                            <div class="col-sm-3">
	                            <select name="service" id="service" class="form-control flightservice select2" style="width:100%;">
	                               <option></option>
	                            </select>
	                            </div>
	                         </div>
				      		<div class="form-group " id="val1">
	                            <label for="mediuminput" class="col-sm-3 control-label">Departure:</label>
	                           <div class="col-sm-3">
	                                    <div class="input-group date">
	                                        <input type="text" class="form-control fromDATElist" name="departure" id="departure" placeholder="yyyy-mm-dd">
	                                        <span class="input-group-addon"><i class="fa fa-calendar"></i></span>
	                                    </div>
	                                </div>
	                        </div>
	                        <div class="form-group " id="val2">
	                            <label for="mediuminput" class="col-sm-3 control-label">Return:</label>
	                           <div class="col-sm-3">
	                                    <div class="input-group date">
	                                        <input type="text" class="form-control toDATElist" name="return" id="return" placeholder="yyyy-mm-dd">
	                                        <span class="input-group-addon"><i class="fa fa-calendar"></i></span>
	                                    </div>
	                                </div>
	                        </div>
	                        <div class="form-group " id="val5">
	                            <label for="mediuminput" class="col-sm-3 control-label car">From:</label>
	                            <div class="col-sm-3">
	                              <input type="text" class="form-control" id="from" name="from" placeholder="">
	                            </div>
	                        </div>
	                        <div class="form-group " id="val6">
	                            <label for="mediuminput" class="col-sm-3 control-label car">To:</label>
	                            <div class="col-sm-3">
	                              <input type="text" class="form-control" id="to" name="to" placeholder="">
	                            </div>
	                        </div>
	                        <div class="form-group " id="val2">
	                            <label class="col-sm-3"></label>
	                           <div class="col-sm-3">
	                              		<input type="checkbox" id="stopover" name="stopover" value="1"> Stop-Over
	                            </div>
	                        </div>
	                        <div class="panel-footer">
	                        <div class="row">
	                        <div class="col-sm-2">
	                        </div>
	                            <div class="col-sm-4">
	                                <div class="btn-toolbar">
	                                    <input type="submit" class="btn-primary btn" value="Submit"/>
	                                    <input type="reset" class="btn-default btn" value="Clear"/>
	                                </div>
	                            </div>
	                        </div>
	                      </div>
	                      </form>
				      </div><!-- TAB 3 -->
				      	<div class="tab-pane" id="miscellaneoustab">
				      	<form class="form-horizontal" action="TravelPlanList" method="POST">
				      		<c:forEach items="${plan}" var="list" begin="0" end="0">
                        	<input type="hidden" name="tno" id="tno" value="${list.tono}">
                        	<input type="hidden" name="tpid" id="tpid" value="${list.planid}">
                     	   </c:forEach>
				      		<input type="hidden" name="type" id="type" value="12">
				      		<input type="hidden" name="forms" id="forms" value="miscellaneous">
	                        <div class="form-group ">
	                            <label for="mediuminput" class="col-sm-3 control-label">PaymentConfirmation#:</label>
	                            <div class="col-sm-3">
	                              <input type="text" class="form-control" id="pcn" name="pcn" placeholder="0000000">
	                            </div>
	                        </div>
	                        <div class="form-group ">
	                            <label for="mediuminput" class="col-sm-3 control-label">Vendor:</label>
	                            <div class="col-sm-3">
	                              <input type="text" class="form-control" id="vendor" name="vendor" placeholder="Name">
	                            </div>
	                        </div>
	                        <div class="form-group ">
	                            <label for="mediuminput" class="col-sm-3 control-label">Description:</label>
	                            <div class="col-sm-3">
	                              <textarea class="form-control" id="description" name="description"></textarea>
	                            </div>
	                        </div>
	                        <div class="form-group" id="val10">
								<label class="col-sm-3 control-label">Amount:</label>
								<div class="col-sm-3">
									<div class="input-group">
										<input class="form-control" type="text" name="amount" id="amount">
										<span class="input-group-addon">.00</span>
									</div>
								</div>
							</div>
	                        <div class="panel-footer">
	                        <div class="row">
	                        <div class="col-sm-2">
	                        </div>
	                            <div class="col-sm-4">
	                                <div class="btn-toolbar">
	                                    <input type="submit" class="btn-primary btn" value="Submit"/>
	                                    <input type="reset" class="btn-default btn" value="Clear"/>
	                                </div>
	                            </div>
	                        </div>
	                      </div>
	                      </form>
				      </div><!-- TAB 4 -->
				    </div>
				  </div>
				</div>
                <!-- PANEL PRIMARY TAB -->
            </div>
        </div>

		</div> <!-- container -->
	</div> <!--wrap -->
</div> <!-- page-content -->

    <%@include file="_Footer.jsp"%>
    <%@include file="modal/_ImportTravelPlan.jsp"%>

</div> <!-- page-container -->
<script type="text/javascript">
var fromdate = new Date("<c:out value="${plan[0].fromdate}"/>");
var todate = new Date("<c:out value="${plan[0].todate}"/>");
//alert("<c:out value="${policylist[0].maxbudget}"/>");
</script>
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
<script type="text/javascript" src='assets/js/from-todate.js'></script>
</body>
</html>