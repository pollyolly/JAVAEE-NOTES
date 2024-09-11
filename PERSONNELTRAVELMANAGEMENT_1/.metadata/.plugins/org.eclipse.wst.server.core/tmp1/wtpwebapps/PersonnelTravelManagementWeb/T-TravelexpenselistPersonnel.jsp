<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
	<!--BEGIN TABLE-->
	<link rel="stylesheet" type="text/css" href="assets/plugins/datatables/dataTables.css">
	<!--END TABLE-->
    <link rel='stylesheet' type='text/css' href='assets/fonts/glyphicons/css/glyphicons.min.css' /> 
	<!--BEGIN CUSTOM.CSS--> 
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
				<li><b>Travel Expense List</b></li>
			</ol>
			<div class="options">
                  <a href="#myModal" data-toggle="modal"  class="btn btn-default">Import</a>
            </div>
		</div>
		<div class="container">
        <div class="row">
            <div class="col-sm-6">
            <div class="panel panel-primary">
                <div class="panel-body">
                    <table class="table-1">
                        <c:forEach items="${travelexpense}" var="list" begin="0" end="0">
                            <tr>
                                <td>TO.#:</td><td><c:out value="${list.tono}"/></td>
                            </tr>
                            <tr>
                                <td>Personnel:</td><td><c:out value="${list.name}"/></td>
                            </tr>
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
            <div class="col-sm-6">
            <div class="panel panel-primary">
                <div class="panel-body">
                    <table class="table-1">
                    <c:forEach items="${travelexpense}" var="list" begin="0" end="0">
                    		<tr>
                                <td><b>Cash Advance:</b></td><td><fmt:formatNumber value="${list.cashadvance}" type="currency" currencySymbol="P" minFractionDigits="2"/></td>
                            </tr>
                            <tr>
                                <td><b>Reimbursable:</b></td><td><fmt:formatNumber value="${list.reimburse}" type="currency" currencySymbol="P" minFractionDigits="2"/></td>
                            </tr>
                            <tr>
                                <td><b>Non-Reimbursable:</b></td><td><fmt:formatNumber value="${list.nonreimburse}" type="currency" currencySymbol="P" minFractionDigits="2"/></td>
                            </tr>
                            	<c:choose>
	                            	<c:when test="${list.cashadvance > list.reimburse}">
	                            		<tr>
	                            			<td><b>Return:</b></td><td><fmt:formatNumber value="${list.cashadvance - list.reimburse}" type="currency" currencySymbol="P" minFractionDigits="2"/></td>
	                            		</tr>
	                            	</c:when>
	                            	<c:otherwise>
	                            		<tr>
	                            			<td><b>Return:</b></td><td>P0.00</td>
	                            		</tr>
	                            	</c:otherwise>
                            	</c:choose>
                           	 <tr>
                            	<td><b>Total Expense:</b></td><td>
                            	<c:choose>
                            			<c:when test="${(list.nonreimburse + list.reimburse) > policylist[0].maxexpense}">
                            				<label class="label label-danger">
                            				<fmt:formatNumber value="${list.nonreimburse + list.reimburse}" type="currency" currencySymbol="P" minFractionDigits="2"/>
                            				</label>
                            			</c:when>
                            			<c:otherwise>
                            				<fmt:formatNumber value="${list.nonreimburse + list.reimburse}" type="currency" currencySymbol="P" minFractionDigits="2"/>
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
		<!--BEGIN TABLE-->
		<div class="row">
              <div class="col-md-12">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <h4>Travel Expense List</h4>
                            <div class="options">   
                                <a href="javascript:;" class="panel-collapse"><i class="fa fa-chevron-down"></i></a>
                            </div>
                        </div>
                        <div class="panel-body collapse in">
                           <div class="table-responsive">
                            <table class="table  table-striped table-bordered  table-hover datatables dataTable" id="DataTables_Table_0">
                                <thead>
                                    <tr>
                                    <th>Date</th>
                                    <th>Type</th>
                                    <th>Details</th>
                                    <th>Amount</th>
                                    <th>Reim</th>
                                    <th>Billable</th>
                                    <th>Receipt#</th>
                                    <th>Reason</th>
                                    </tr>
                                </thead>
                                
                            <tbody>
                            <c:forEach items="${travelexpenselist}" var="list">
                             <c:choose>
                            		<c:when test="${list.type == 'Flight'}">
                            		<tr>
                                        <td>${list.date}</td>
                                        <td>${list.type}</td>
                                        <td>
                                        <b>Vendor:</b> ${list.vendor}<br>
                                        <b>Departure:</b> ${list.departure}<br>
                                        <b>Return:</b> ${list.returns}<br>
                                        <b>From:</b> ${list.ffrom} <br>
                                        <b>To:</b> ${list.fto}<br>
                                        <b>StopOver:</b> <c:choose>
												<c:when test="${list.stopover > 0}">
													Yes
												</c:when>
												<c:otherwise>
													No
												</c:otherwise>
												</c:choose>
                                        </td>
                                        <td>
                                        <c:choose>
                                       		<c:when test="${policylist[0].receiptamount < list.amount && list.reimburse > 0}">
                                        		<label class="label label-danger">
                                        		<fmt:formatNumber value="${list.amount}" type="currency" currencySymbol="P" minFractionDigits="2"/>
                                        		</label>
                                        	</c:when>
                                        	<c:otherwise>
                                        		<fmt:formatNumber value="${list.amount}" type="currency" currencySymbol="P" minFractionDigits="2"/>
                                        	</c:otherwise>
                                        </c:choose>
                                        </td>
                                        <td>
                                        	<c:choose>
												<c:when test="${list.reimburse > 0}">
													Yes
												</c:when>
											</c:choose>
                                        </td>
                                        <td>
                                        	<c:choose>
												<c:when test="${list.billable > 0}">
													Yes
												</c:when>
											</c:choose>
                                        </td>
                                        <td>
                                        	<c:choose>
												<c:when test="${list.reimburse > 0}">
													<label>${list.pcn}</label>
												</c:when>
												<c:otherwise>
													<label class="label label-default">None</label>
												</c:otherwise>
											</c:choose>
                                        </td>
                                        <td>${list.reason}</td>
                                    </tr>
                                    </c:when>
                                    <c:when test="${list.type == 'Hotel'}">
                            		<tr>
                                        <td>${list.date}</td>
                                        <td>${list.type}</td>
                                        <td>
                                        <b>Vendor:</b> ${list.vendor}<br>
                                        <b>Check-In:</b> ${list.checkin}<br>
                                        <b>Check-Out:</b> ${list.checkout}
                                        </td>
                                        <td>
                                        <c:choose>
                                       		<c:when test="${policylist[0].receiptamount < list.amount && list.reimburse > 0}">
                                        		<label class="label label-danger">
                                        		<fmt:formatNumber value="${list.amount}" type="currency" currencySymbol="P" minFractionDigits="2"/>
                                        		</label>
                                        	</c:when>
                                        	<c:otherwise>
                                        		<fmt:formatNumber value="${list.amount}" type="currency" currencySymbol="P" minFractionDigits="2"/>
                                        	</c:otherwise>
                                        </c:choose>
                                        </td>
                                        <td>
                                        	<c:choose>
												<c:when test="${list.reimburse > 0}">
													Yes
												</c:when>
											</c:choose>
                                        </td>
                                        <td>
                                        	<c:choose>
												<c:when test="${list.billable > 0}">
													Yes
												</c:when>
											</c:choose>
                                        </td>
                                        <td>
                                        	<c:choose>
												<c:when test="${list.reimburse > 0}">
													<label>${list.pcn}</label>
												</c:when>
												<c:otherwise>
													<label class="label label-default">None</label>
												</c:otherwise>
											</c:choose>
                                        </td>
                                        <td>${list.reason}</td>
                                    </tr>
                                    </c:when>
                                    <c:when test="${list.type == 'Car Rental'}">
                            		<tr>
                                        <td>${list.date}</td>
                                        <td>${list.type}</td>
                                        <td>
                                        <b>Vendor:</b> ${list.vendor}<br>
                                        <b>From:</b> ${list.cfrom}<br>
                                        <b>To:</b> ${list.cto}<br>
                                        <b>Pick-Up:</b> ${list.pickup}<br>
                                        <b>Drop-Off:</b> ${list.dropoff}
                                        </td>
                                        <td>
                                        <c:choose>
                                       		<c:when test="${policylist[0].receiptamount < list.amount && list.reimburse > 0}">
                                        		<label class="label label-danger">
                                        		<fmt:formatNumber value="${list.amount}" type="currency" currencySymbol="P" minFractionDigits="2"/>
                                        		</label>
                                        	</c:when>
                                        	<c:otherwise>
                                        		<fmt:formatNumber value="${list.amount}" type="currency" currencySymbol="P" minFractionDigits="2"/>
                                        	</c:otherwise>
                                        </c:choose>
                                        </td>
                                        <td>
                                        	<c:choose>
												<c:when test="${list.reimburse > 0}">
													Yes
												</c:when>
											</c:choose>
                                        </td>
                                        <td>
                                        	<c:choose>
												<c:when test="${list.billable > 0}">
													Yes
												</c:when>
											</c:choose>
                                        </td>
                                        
                                        <td>
                                        	<c:choose>
												<c:when test="${list.reimburse > 0}">
													<label>${list.pcn}</label>
												</c:when>
												<c:otherwise>
													<label class="label label-default">None</label>
												</c:otherwise>
											</c:choose>
                                        </td>
                                        <td>${list.reason}</td>
                                    </tr>
                                    </c:when>
                                    <c:when test="${list.type == 'Miscellaneous'}">
                            		<tr>
                                        <td>${list.date}</td>
                                        <td>${list.type}</td>
                                        <td>
                                        <b>Vendor:</b> ${list.miscvendor}<br>
                                        <b>Description:</b> ${list.description}
                                        </td>
                                        <td>
                                        <c:choose>
                                       		<c:when test="${policylist[0].receiptamount < list.amount && list.reimburse > 0}">
                                        		<label class="label label-danger">
                                        		<fmt:formatNumber value="${list.amount}" type="currency" currencySymbol="P" minFractionDigits="2"/>
                                        		</label>
                                        	</c:when>
                                        	<c:otherwise>
                                        		<fmt:formatNumber value="${list.amount}" type="currency" currencySymbol="P" minFractionDigits="2"/>
                                        	</c:otherwise>
                                        </c:choose>
                                        </td>
                                        <td>
                                        	<c:choose>
												<c:when test="${list.reimburse > 0}">
													Yes
												</c:when>
											</c:choose>
                                        </td>
                                        <td>
                                        	<c:choose>
												<c:when test="${list.billable > 0}">
													Yes
												</c:when>
											</c:choose>
                                        </td>
                                        <td>
                                        	<c:choose>
												<c:when test="${list.reimburse > 0}">
													<label>${list.pcn}</label>
												</c:when>
												<c:otherwise>
													<label class="label label-default">None</label>
												</c:otherwise>
											</c:choose>
                                        </td>
                                        <td>${list.reason}</td>
                                    </tr>
                                    </c:when>
                                    <c:when test="${list.type == 'Mileage'}">
                            		<tr>
                                        <td>${list.date}</td>
                                        <td>${list.type}</td>
                                        <td>
                                        <b>From:</b> ${list.mfrom}<br>
                                        <b>To:</b> ${list.mto}<br>
                                        <b>Distance:</b> ${list.distance}
                                        </td>
                                        <td>
                                        <c:choose>
                                       		<c:when test="${policylist[0].receiptamount < list.amount && list.reimburse > 0}">
                                        		<label class="label label-danger">
                                        		<fmt:formatNumber value="${list.amount}" type="currency" currencySymbol="P" minFractionDigits="2"/>
                                        		</label>
                                        	</c:when>
                                        	<c:otherwise>
                                        		<fmt:formatNumber value="${list.amount}" type="currency" currencySymbol="P" minFractionDigits="2"/>
                                        	</c:otherwise>
                                        </c:choose>
                                        </td>
                                        <td>
                                        	<c:choose>
												<c:when test="${list.reimburse > 0}">
													Yes
												</c:when>
											</c:choose>
                                        </td>
                                        <td>
                                        	<c:choose>
												<c:when test="${list.billable > 0}">
													Yes
												</c:when>
											</c:choose>
                                        </td>
                                        <td>
                                        	<c:choose>
												<c:when test="${list.reimburse > 0}">
													<label>${list.pcn}</label>
												</c:when>
												<c:otherwise>
													<label class="label label-default">None</label>
												</c:otherwise>
											</c:choose>
                                        </td>
                                        <td>${list.reason}</td>
                                    </tr>
                                    </c:when>
                                    <c:when test="${list.type == 'Meal'}">
                            		<tr>
                                        <td>${list.date}</td>
                                        <td>${list.type}</td>
                                        <td>
                                        <b>Vendor:</b> ${list.mvendor}<br>
                                        <b>Description:</b> ${list.mdescription}
                                        </td>
                                        <td>
                                        <c:choose>
                                       		<c:when test="${policylist[0].receiptamount < list.amount && list.reimburse > 0}">
                                        		<label class="label label-danger">
                                        		<fmt:formatNumber value="${list.amount}" type="currency" currencySymbol="P" minFractionDigits="2"/>
                                        		</label>
                                        	</c:when>
                                        	<c:otherwise>
                                        		<fmt:formatNumber value="${list.amount}" type="currency" currencySymbol="P" minFractionDigits="2"/>
                                        	</c:otherwise>
                                        </c:choose>
                                        </td>
                                        <td>
                                        	<c:choose>
												<c:when test="${list.reimburse > 0}">
													Yes
												</c:when>
											</c:choose>
                                        </td>
                                        <td>
                                        	<c:choose>
												<c:when test="${list.billable > 0}">
													Yes
												</c:when>
											</c:choose>
                                        </td>
                                        <td>
                                        	<c:choose>
												<c:when test="${list.reimburse > 0}">
													<label>${list.pcn}</label>
												</c:when>
												<c:otherwise>
													<label class="label label-default">None</label>
												</c:otherwise>
											</c:choose>
                                        </td>
                                        <td>${list.reason}</td>
                                    </tr>
                                    </c:when>
                                </c:choose>
                            </c:forEach>
                            </tbody>
                                    </table>
                               </div>     
                        </div>
                    </div>
                </div>
            </div>
		<!-- END TABLE -->
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
				        <a href="#cartab" data-toggle="tab">Car</a>
				      </li>
				      <li>
				        <a href="#hoteltab" data-toggle="tab">Hotel</a>
				      </li>
				      <li>
				        <a href="#flighttab" data-toggle="tab">Flight</a>
				      </li>
				      <li>
				        <a href="#mileage" data-toggle="tab">Mileage</a>
				      </li>
				      <li>
				        <a href="#meal" data-toggle="tab">Meal</a>
				      </li>
				      <li>
				        <a href="#miscellaneoustab" data-toggle="tab">Misc</a>
				      </li>
				    </ul>
				  
				  </div>
				  <div class="panel-body">
				    <div class="tab-content">
				      <div class="tab-pane active" id="cartab">
                        <form class="form-horizontal" action="TravelExpenseListPersonnel" method="POST">
                        <c:forEach items="${travelexpense}" var="list" begin="0" end="0">
                        	<input type="hidden" name="odid" id="odid" value="${list.id}">
                        	</c:forEach>
                        	<input type="hidden" name="type" id="type" value="9">
                        	<input type="hidden" name="forms" id="forms" value="car">
                        	<div class="form-group">
	                            <label class="col-sm-3 control-label">Date:</label>
	                                <div class="col-sm-3">
	                                    <div class="input-group date">
	                                        <input class="form-control listDATE" type="text"  id="date" name="date" placeholder="yyyy-mm-dd" required>
	                                        <span class="input-group-addon"><i class="fa fa-calendar"></i></span>
	                                    </div>
	                                </div>
	                        </div>
	                        <div class="form-group " id="val5">
	                            <label for="mediuminput" class="col-sm-3 control-label car">Receipt#:</label>
	                            <div class="col-sm-3">
	                              <input type="text" class="form-control" id="pcn" name="pcn" placeholder="">
	                            </div>
	                        </div>
	                         <div class="form-group " id="val5">
	                            <label class="col-sm-3 control-label car">Vendor:</label>
	                            <div class="col-sm-3">
	                              		<input class="form-control" type="text" id="vendor" name="vendor" placeholder="">
	                            </div>
	                        </div>
	                        <div class="form-group " id="val5">
	                            <label class="col-sm-3 control-label car">From:</label>
	                            <div class="col-sm-3">
	                              <input type="text" class="form-control" id="from" name="from" placeholder="">
	                            </div>
	                        </div>
	                        <div class="form-group " id="val6">
	                            <label class="col-sm-3 control-label car">To:</label>
	                            <div class="col-sm-3">
	                              <input type="text" class="form-control" id="to" name="to" placeholder="">
	                            </div>
	                        </div>
	                        <div class="form-group " id="val7">
	                            <label  class="col-sm-3 control-label car">PickUp:</label>
	                            <div class="col-sm-3">
	                                    <div class="input-group date">
	                                        <input type="text" class="form-control fromDATElist" id="pickup" name="pickup" placeholder="yyyy-mm-dd">
	                                        <span class="input-group-addon"><i class="fa fa-calendar"></i></span>
	                                    </div>
	                                </div>
	                        </div>
	                        <div class="form-group " id="val8">
	                            <label class="col-sm-3 control-label car">DropOff:</label>
	                            <div class="col-sm-3">
	                                    <div class="input-group date">
	                                        <input type="text" class="form-control toDATElist" id="dropoff" name="dropoff" placeholder="yyyy-mm-dd">
	                                        <span class="input-group-addon"><i class="fa fa-calendar"></i></span>
	                                    </div>
	                                </div>
	                        </div>
	                        <div class="form-group" id="val10">
								<span class="col-sm-3"></span>
								<div class="col-sm-3">
									<div class="input-group">
										<input class="reimb" type="checkbox" name="reimb" id="reimb" value="1"> Reimburse
									</div>
								</div>
							</div>
							<div class="form-group" id="val10">
								<span class="col-sm-3"></span>
								<div class="col-sm-3">
									<div class="input-group">
										<input class="" type="checkbox" name="billable" id="billable" value="1"> Billable
									</div>
								</div>
							</div>
	                        <div class="form-group ">
	                            <label for="mediuminput" class="col-sm-3 control-label">Currency:</label>
	                            <div class="col-sm-3">
	                              <select name="status" id="status" class="form-control currencyCar" required>
	                                <option value="">Choose...</option>
	                                <c:forEach items="${currencylist}" var="list">
	                                <option value="${list.rate}">${list.name} - ${list.country}</option>
	                                </c:forEach>
	                            </select>
	                            </div>
	                            <input class="amountCar" type="hidden" name="amount" id="amount" value=""/>
                          </div>
	                        <div class="form-group" id="val10">
								<label class="col-sm-3 control-label">Amount:</label>
									<div class="col-sm-3">
										<div class="input-group">
											<input class="form-control amount2Car" type="text" name="amount2" id="amount2">
											<span class="input-group-addon">.00</span>
										</div>
									</div>
							</div>
							<div class="form-group ">
	                            <label for="mediuminput" class="col-sm-3 control-label">Reason:</label>
	                            <div class="col-sm-3">
	                              <textarea class="form-control" id="reason" name="reason"></textarea>
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
				      	<form class="form-horizontal" action="TravelExpenseListPersonnel" method="POST">
				      		<c:forEach items="${travelexpense}" var="list" begin="0" end="0">
                        	<input type="hidden" name="odid" id="odid" value="${list.id}">
                        	</c:forEach>
				      		<input type="hidden" name="type" id="type" value="7">
				      		<input type="hidden" name="forms" id="forms" value="hotel">
				      		<div class="form-group">
	                            <label class="col-sm-3 control-label">Date:</label>
	                                <div class="col-sm-3">
	                                    <div class="input-group date">
	                                        <input type="text" class="form-control listDATE" id="date" name="date" placeholder="yyyy-mm-dd" required>
	                                        <span class="input-group-addon"><i class="fa fa-calendar"></i></span>
	                                    </div>
	                                </div>
	                        </div>
	                        <div class="form-group " id="val5">
	                            <label for="mediuminput" class="col-sm-3 control-label car">Receipt#:</label>
	                            <div class="col-sm-3">
	                              <input type="text" class="form-control" id="pcn" name="pcn" placeholder="">
	                            </div>
	                        </div>
	                        <div class="form-group " id="val5">
	                            <label for="mediuminput" class="col-sm-3 control-label car">Vendor:</label>
	                            <div class="col-sm-3">
	                              <input type="text" class="form-control" id="vendor" name="vendor" placeholder="">
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
							<div class="form-group" id="val10">
								<span class="col-sm-3"></span>
								<div class="col-sm-3">
									<div class="input-group">
										<input class="" type="checkbox" name="reimb" value="1"> Reimburse
									</div>
								</div>
							</div>
							<div class="form-group" id="val10">
								<span class="col-sm-3"></span>
								<div class="col-sm-3">
									<div class="input-group">
										<input class="" type="checkbox" name="billable" value="1"> Billable
									</div>
								</div>
							</div>
	                        <div class="form-group ">
	                            <label for="mediuminput" class="col-sm-3 control-label">Currency:</label>
	                            <div class="col-sm-3">
	                              <select name="status" id="status" class="form-control currencyHotel" required>
	                                <option value="">Choose...</option>
	                                <c:forEach items="${currencylist}" var="list">
	                                <option value="${list.rate}">${list.name} - ${list.country}</option>
	                                </c:forEach>
	                            </select>
	                            </div>
	                            <input class="amountHotel" type="hidden" name="amount" id="amount" value=""/>
                          </div>
	                        <div class="form-group" id="val10">
								<label class="col-sm-3 control-label">Amount:</label>
									<div class="col-sm-3">
										<div class="input-group">
											<input class="form-control amount2Hotel" type="text" name="amount2" id="amount2">
											<span class="input-group-addon">.00</span>
										</div>
									</div>
							</div>
							<div class="form-group ">
	                            <label for="mediuminput" class="col-sm-3 control-label">Reason:</label>
	                            <div class="col-sm-3">
	                              <textarea class="form-control" id="reason" name="reason"></textarea>
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
				      	<form class="form-horizontal" action="TravelExpenseListPersonnel" method="POST">
				      		<c:forEach items="${travelexpense}" var="list" begin="0" end="0">
                        	<input type="hidden" name="odid" id="odid" value="${list.id}">
                        	</c:forEach>
				      		<input type="hidden" name="type" id="type" value="8">
				      		<input type="hidden" name="forms" id="forms" value="flight">
				      		<div class="form-group">
	                            <label class="col-sm-3 control-label">Date:</label>
	                                <div class="col-sm-3">
	                                    <div class="input-group date">
	                                        <input type="text" class="form-control listDATE" id="date" name="date" placeholder="yyyy-mm-dd" required>
	                                        <span class="input-group-addon"><i class="fa fa-calendar"></i></span>
	                                    </div>
	                                </div>
	                        </div>
	                        <div class="form-group " id="val5">
	                            <label for="mediuminput" class="col-sm-3 control-label car">Receipt#:</label>
	                            <div class="col-sm-3">
	                              <input type="text" class="form-control" id="pcn" name="pcn" placeholder="">
	                            </div>
	                        </div>
	                        <div class="form-group " id="val5">
	                            <label for="mediuminput" class="col-sm-3 control-label car">Vendor:</label>
	                            <div class="col-sm-3">
	                              <input type="text" class="form-control" id="vendor" name="vendor" placeholder="">
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
	                        <div class="form-group" id="val10">
								<span class="col-sm-3"></span>
								<div class="col-sm-3">
									<div class="input-group">
										<input class="" type="checkbox" name="reimb" id="reimb" value="1"> Reimburse
									</div>
								</div>
							</div>
							<div class="form-group" id="val10">
								<span class="col-sm-3"></span>
								<div class="col-sm-3">
									<div class="input-group">
										<input class="" type="checkbox" name="billable" id="billable" value="1"> Billable
									</div>
								</div>
							</div>
	                        <div class="form-group ">
	                            <label for="mediuminput" class="col-sm-3 control-label">Currency:</label>
	                            <div class="col-sm-3">
	                              <select name="status" id="status" class="form-control currencyFlight" required>
	                                <option value="">Choose...</option>
	                                <c:forEach items="${currencylist}" var="list">
	                                <option value="${list.rate}">${list.name} - ${list.country}</option>
	                                </c:forEach>
	                            </select>
	                            </div>
	                            <input class="amountFlight" type="hidden" name="amount" id="amount" value=""/>
                          </div>
	                        <div class="form-group" id="val10">
								<label class="col-sm-3 control-label">Amount:</label>
									<div class="col-sm-3">
										<div class="input-group">
											<input class="form-control amount2Flight" type="text" name="amount2" id="amount2">
											<span class="input-group-addon">.00</span>
										</div>
									</div>
							</div>
							<div class="form-group ">
	                            <label for="mediuminput" class="col-sm-3 control-label">Reason:</label>
	                            <div class="col-sm-3">
	                              <textarea class="form-control" id="reason" name="reason"></textarea>
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
				      	<div class="tab-pane" id="mileage">
				      	<form class="form-horizontal" action="TravelExpenseListPersonnel" method="POST">
				      		<c:forEach items="${travelexpense}" var="list" begin="0" end="0">
                        	<input type="hidden" name="odid" id="odid" value="${list.id}">
                        	</c:forEach>
				      		<input type="hidden" name="type" id="type" value="10">
				      		<input type="hidden" name="forms" id="forms" value="mileage">
				      		<div class="form-group">
	                            <label class="col-sm-3 control-label">Date:</label>
	                                <div class="col-sm-3">
	                                    <div class="input-group date">
	                                        <input type="text" class="form-control listDATE" id="date" name="date" placeholder="yyyy-mm-dd" required>
	                                        <span class="input-group-addon"><i class="fa fa-calendar"></i></span>
	                                    </div>
	                                </div>
	                        </div>
	                        <div class="form-group " id="val5">
	                            <label for="mediuminput" class="col-sm-3 control-label car">Receipt#:</label>
	                            <div class="col-sm-3">
	                              <input type="text" class="form-control" id="pcn" name="pcn" placeholder="">
	                            </div>
	                        </div>
	                        <div class="form-group">
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
	                        <div class="form-group " id="val6">
	                            <label for="mediuminput" class="col-sm-3 control-label car">Distance:</label>
	                            <div class="col-sm-3">
	                              <input type="text" class="form-control" id="distance" name="distance" placeholder="">
	                            </div>
	                        </div>
	                        <div class="form-group" id="val10">
								<span class="col-sm-3"></span>
								<div class="col-sm-3">
									<div class="input-group">
										<input class="" type="checkbox" name="reimb" id="reimb" value="1"> Reimburse
									</div>
								</div>
							</div>
							<div class="form-group" id="val10">
								<span class="col-sm-3"></span>
								<div class="col-sm-3">
									<div class="input-group">
										<input class="" type="checkbox" name="billable" id="billable" value="1"> Billable
									</div>
								</div>
							</div>
							<div class="form-group ">
	                            <label for="mediuminput" class="col-sm-3 control-label">Currency:</label>
	                            <div class="col-sm-3">
	                              <select name="status" id="status" class="form-control currencyMileage" required>
	                                <option value="">Choose...</option>
	                                <c:forEach items="${currencylist}" var="list">
	                                <option value="${list.rate}">${list.name} - ${list.country}</option>
	                                </c:forEach>
	                            </select>
	                            </div>
	                            <input class="amountMileage" type="hidden" name="amount" id="amount" value=""/>
                          </div>
	                        <div class="form-group" id="val10">
								<label class="col-sm-3 control-label">Amount:</label>
									<div class="col-sm-3">
										<div class="input-group">
											<input class="form-control amount2Mileage" type="text" name="amount2" id="amount2">
											<span class="input-group-addon">.00</span>
										</div>
									</div>
							</div>
							<div class="form-group ">
	                            <label for="mediuminput" class="col-sm-3 control-label">Reason:</label>
	                            <div class="col-sm-3">
	                              <textarea class="form-control" id="reason" name="reason"></textarea>
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
				      <div class="tab-pane" id="meal">
				      	<form class="form-horizontal" action="TravelExpenseListPersonnel" method="POST">
				      		<c:forEach items="${travelexpense}" var="list" begin="0" end="0">
                        	<input type="hidden" name="odid" id="odid" value="${list.id}">
                        	</c:forEach>
				      		<input type="hidden" name="type" id="type" value="11">
				      		<input type="hidden" name="forms" id="forms" value="meal">
	                        <div class="form-group">
	                            <label class="col-sm-3 control-label">Date:</label>
	                                <div class="col-sm-3">
	                                    <div class="input-group date">
	                                        <input type="text" class="form-control listDATE" id="date" name="date" placeholder="yyyy-mm-dd" required>
	                                        <span class="input-group-addon"><i class="fa fa-calendar"></i></span>
	                                    </div>
	                                </div>
	                        </div>
	                        <div class="form-group " id="val5">
	                            <label for="mediuminput" class="col-sm-3 control-label car">Receipt#:</label>
	                            <div class="col-sm-3">
	                              <input type="text" class="form-control" id="pcn" name="pcn" placeholder="">
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
								<span class="col-sm-3"></span>
								<div class="col-sm-3">
										<input type="checkbox" name="reimb" id="reimb" value="1"> Reimburse
								</div>
							</div>
							<div class="form-group">
	                            <label class="col-sm-3"></label>
	                           <div class="col-sm-3">
	                              		<input type="checkbox" id="billable" name="billable" value="1"> Billable
	                            </div>
	                        </div>
							<div class="form-group ">
	                            <label for="mediuminput" class="col-sm-3 control-label">Currency:</label>
	                            <div class="col-sm-3">
	                              <select name="status" id="status" class="form-control currencyMeal" required>
	                                <option value="">Choose...</option>
	                                <c:forEach items="${currencylist}" var="list">
	                                <option value="${list.rate}">${list.name} - ${list.country}</option>
	                                </c:forEach>
	                            </select>
	                            </div>
	                            <input class="amountMeal" type="hidden" name="amount" id="amount" value=""/>
                          </div>
	                        <div class="form-group" id="val10">
								<label class="col-sm-3 control-label">Amount:</label>
									<div class="col-sm-3">
										<div class="input-group">
											<input class="form-control amount2Meal" type="text" name="amount2" id="amount2">
											<span class="input-group-addon">.00</span>
										</div>
									</div>
							</div>
							<div class="form-group ">
	                            <label for="mediuminput" class="col-sm-3 control-label">Reason:</label>
	                            <div class="col-sm-3">
	                              <textarea class="form-control" id="reason" name="reason"></textarea>
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
				      </div><!-- TAB 5 -->
				 	  <div class="tab-pane" id="miscellaneoustab">
				      	<form class="form-horizontal" action="TravelExpenseListPersonnel" method="POST">
				      		<c:forEach items="${travelexpense}" var="list" begin="0" end="0">
                        	<input type="hidden" name="odid" id="odid" value="${list.id}">
                        	</c:forEach>
				      		<input type="hidden" name="type" id="type" value="12">
				      		<input type="hidden" name="forms" id="forms" value="miscellaneous">
				      		<div class="form-group">
	                            <label class="col-sm-3 control-label">Date:</label>
	                                <div class="col-sm-3">
	                                    <div class="input-group date">
	                                        <input type="text" class="form-control listDATE" id="date" name="date" placeholder="yyyy-mm-dd" required>
	                                        <span class="input-group-addon"><i class="fa fa-calendar"></i></span>
	                                    </div>
	                                </div>
	                        </div>
	                        <div class="form-group " id="val5">
	                            <label for="mediuminput" class="col-sm-3 control-label car">Receipt#:</label>
	                            <div class="col-sm-3">
	                              <input type="text" class="form-control" id="pcn" name="pcn" placeholder="">
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
								<span class="col-sm-3"></span>
								<div class="col-sm-3">
									<div class="input-group">
										<input class="" type="checkbox" name="reimb" id="reimb" value="1"> Reimburse
									</div>
								</div>
							</div>
							<div class="form-group" id="val10">
								<span class="col-sm-3"></span>
								<div class="col-sm-3">
									<div class="input-group">
										<input class="" type="checkbox" name="billable" id="billable" value="1"> Billable
									</div>
								</div>
							</div>
	                       <div class="form-group ">
	                            <label for="mediuminput" class="col-sm-3 control-label">Currency:</label>
	                            <div class="col-sm-3">
	                              <select name="status" id="status" class="form-control currencyMisc" required>
	                                <option value="">Choose...</option>
	                                <c:forEach items="${currencylist}" var="list">
	                                <option value="${list.rate}">${list.name} - ${list.country}</option>
	                                </c:forEach>
	                            </select>
	                            </div>
	                            <input class="amountMisc" type="hidden" name="amount" id="amount" value=""/>
                          </div>
	                        <div class="form-group" id="val10">
								<label class="col-sm-3 control-label">Amount:</label>
									<div class="col-sm-3">
										<div class="input-group">
											<input class="form-control amount2Misc" type="text" name="amount2" id="amount2">
											<span class="input-group-addon">.00</span>
										</div>
									</div>
							</div>
							<div class="form-group ">
	                            <label for="mediuminput" class="col-sm-3 control-label">Reason:</label>
	                            <div class="col-sm-3">
	                              <textarea class="form-control" id="reason" name="reason"></textarea>
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
				      </div><!-- TAB 6 -->
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
	<%@include file="modal/_ImportTravelExpense.jsp"%>
</div> <!-- page-container -->
<script type="text/javascript">
var fromdate = new Date("<c:out value="${travelexpense[0].fromdate}"/>");
var todate = new Date("<c:out value="${travelexpense[0].todate}"/>");
var expdays = "<c:out value="${policylist[0].expensedays}"/>";
var status = "<c:out value="${travelexpense[0].status}"/>";
</script>
<script type='text/javascript' src='assets/js/expense-policy.js'></script> 
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

<script type='text/javascript' src='assets/js/data-table.js'></script> 
<script type='text/javascript' src='assets/js/placeholdr.js'></script> 
<script type='text/javascript' src='assets/js/application.js'></script> 

<script type='text/javascript' src='assets/demo/demo.js'></script>
<script type='text/javascript' src='assets/js/multi-select.js'></script>
<script type='text/javascript' src='assets/js/populate-multiselect.js'></script>
<script type="text/javascript" src="assets/plugins/quicksearch/jquery.quicksearch.min.js"></script>
<script type='text/javascript' src='assets/plugins/form-select2/select2.min.js'></script>
<script type='text/javascript' src='assets/plugins/form-multiselect/js/jquery.multi-select.min.js'></script>
<script type='text/javascript' src='assets/plugins/form-datepicker/js/bootstrap-datepicker.js'></script>
<script type='text/javascript' src='assets/js/tools.js'></script>
<script type="text/javascript" src='assets/js/alert.js'></script>
<script type="text/javascript" src='assets/js/from-todate.js'></script>
<script type="text/javascript" src='assets/js/currency-rate.js'></script>
</body>
</html>