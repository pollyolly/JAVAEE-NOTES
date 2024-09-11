$(document).ready(function() {
	
	//EMPLOYEE PASSPORT
	$(".editPassport").click(function() {
		var myid = $(this).data("passid");
		$.ajax({
			url : "EmployeePassport",
			type : "POST",
			data : {
				forms : "editForm",
				passid : myid
			},
			dataType: "JSON",
			cache : "false",
			success : function(data) {
				$("#id").val("");
				$("#expirationdate2").val("");
				$("#passport2").val("");
				$("#employee2").val("");
				$("#status2").val("");
				
				$("#employee2 option:first").remove();
				$("#status2 option:first").remove();
				
				$("#id").val(data[0].passportid);
				$("#expirationdate2").val(data[0].expirydate);
				$("#passport2").val(data[0].passportno);
				
				$("#status2").prepend('<option value="'+data[0].statusid+'" selected="selected">'+data[0].status+'</option>');
				
				$("#employee2").prepend('<option value="'+data[0].employeeid+'" selected="selected">'+data[0].employee+'</option>');
				$("#employee2").select2();
				$("#employee2").next(".select2").find(".select2-selection").focus(function() {
				    $(this).select2("open");});
			}
		});
	});
	//EMPLOYEE PASSPORT

	//EMPLOYEE CONTACT
	$(".editContact").click(function() {
		var myid = $(this).data("contid");
		$.ajax({
			url : "EmployeeEmergencyContact",
			type : "POST",
			data : {
				forms : "editForm",
				contid : myid
			},
			dataType: "JSON",
			cache : "false",
			success : function(data) {
				$("#id").val("");
				$("#personname2").val("");
				$("#relationship2").val("");
				$("#emergencycontact2").val("");
				$("#employee2").val("");
				$("#status2").val("");
				
				$("#employee2 option:first").remove();
				$("#status2 option:first").remove();
				
				$("#id").val(data[0].contactid);
				$("#personname2").val(data[0].personname);
				$("#relationship2").val(data[0].relationship);
				$("#emergencycontact2").val(data[0].contact);
				
				$("#status2").prepend('<option value="'+data[0].statusid+'" selected="selected">'+data[0].status+'</option>');
				
				$("#employee2").prepend('<option value="'+data[0].employeeid+'" selected="selected">'+data[0].employee+'</option>');
				$("#employee2").select2();
				$("#employee2").next(".select2").find(".select2-selection").focus(function() {
				    $(this).select2("open");});
			}
		});
	});
	
	//EMPLOYEE CONTACT
//SERVICES
	$(".editService").click(function() {
		var myid = $(this).data("editserviceid");
		$.ajax({
			url : "Services",
			type : "POST",
			data : {
				forms : "editForm",
				svid : myid
			},
			dataType: "JSON",
			cache : "false",
			success : function(data) {
				$("#id").val("");
				$("#service2").val("");
				$("#description2").val("");
				$("#type2").val("");
				$("#class2").val("");
				$("#cost2").val("");
				$("#status2").val("");
				$("#id").val(data[0].id);
				$("#service2").val(data[0].service);
				$("#company2").val(data[0].company);
				$("#description2").val(data[0].description);
				$("#type2 option:first").remove();
				$("#type2").prepend('<option value="'+data[0].typeid+'" selected="selected">'+data[0].type+'</option>');
				$("#class2 option:first").remove();
				$("#class2").prepend('<option value="'+data[0].classid+'" selected="selected">'+data[0].serviceclass+'</option>');
				$("#cost2").val(data[0].amount);
				$("#status2 option:first").remove();
				$("#status2").prepend('<option value="'+data[0].statusid+'" selected="selected">'+data[0].status+'</option>');
				$("#company2 option:first").remove();
				$("#company2").prepend('<option value="'+data[0].serviceproviderid+'" selected="selected">'+data[0].company+'</option>');
				$("#company2").select2();
				$("#company2").next(".select2").find(".select2-selection").focus(function() {
				    $(this).select2("open");});
			}
		});
	});
	
//DESTINATION
	$(".editDestination").click(function() {
		var myid = $(this).data("editdestid");
		$.ajax({
			url : "Destination",
			type : "POST",
			data : {
				forms : "editForm",
				id : myid
			},
			dataType: "JSON",
			cache : "false",
			success : function(data) {
				$("#code2").val("");
				$("#city2").val("");
				$("#state2").val("");
				$("#country2").val("");
				$("#status2").val("");
				$("#destinationid").val("");
				$("#destinationid").val(data[0].id);
				$("#code2").val(data[0].code);
				$("#city2").val(data[0].city);
				$("#state2").val(data[0].state);
				$("#country2").val(data[0].country);
				$("#status2 option:first").remove();
				$("#status2").prepend('<option value="'+data[0].statusid+'" selected="selected">'+data[0].status+'</option>');
			}
		});
	});
	
//CURRENCY
	$(".editCurrency").click(function() {
		var myid = $(this).data("editcurrencyid");
		$.ajax({
			url : "Currency",
			type : "POST",
			data : {
				forms : "editForm",
				id : myid
			},
			dataType: "JSON",
			cache : "false",
			success : function(data) {
				$("#name2").val("");
				$("#country2").val("");
				$("#rate2").val("");
				$("#status2").val("");
				$("#currencyid").val("");
				$("#currencyid").val(data[0].id);
				$("#name2").val(data[0].name);
				$("#country2").val(data[0].country);
				$("#rate2").val(data[0].rate);
				$("#status2 option:first").remove();
				$("#status2").prepend('<option value="'+data[0].statusid+'" selected="selected">'+data[0].status+'</option>');
			}
		});
	});
	
//USERMANAGEMENT
	$(".editAcc").click(function() {
		var myid = $(this).data("editaccid");
		$.ajax({
			url : "UserManagement",
			type : "POST",
			data : {
				forms : "editForm",
				accid : myid
			},
			dataType: "JSON",
			cache : "false",
			success : function(data) {
				$("#accountid2").val("");
				$("#employee2").val("");
				$("#role2").val("");
				$("#status2").val("");
				$("#username2").val("");
				$("#password2").val("");
				$("#employee2 option:first").remove();
				$("#role2 option:first").remove();
				$("#status2 option:first").remove();
				
				$("#role2").prepend('<option value="'+data[0].roleid+'" selected="selected">'+data[0].role+'</option>');
				$("#username2").val(data[0].username);
				$("#password2").val(data[0].password);
				$("#status2").prepend('<option value="'+data[0].statusid+'" selected="selected">'+data[0].status+'</option>');
				$("#accountid2").val(data[0].accountid);
				$("#employee2").prepend('<option value="'+data[0].employeeid+'" selected="selected">'+data[0].employee+'</option>');
				$("#employee2").select2();
				$("#employee2").next(".select2").find(".select2-selection").focus(function() {
				    $(this).select2("open");});
			}
		});
	});
	
//DEPARTMENT	
	$(".editDept").click(function() {
		var myid = $(this).data("editdeptid");
		$.ajax({
			url : "Department",
			type : "POST",
			data : {
				forms : "editForm",
				deptid : myid
			},
			dataType: "JSON",
			cache : "false",
			success : function(data) {
				$("#name2").val("");
				$("#description2").val("");
				$("#status2").val("");
				$("#departmentid2").val(data[0].departmentid);
				$("#status2 option:first").remove();
				$("#name2").val(data[0].department);
				$("#description2").val(data[0].description);
				$("#status2").prepend('<option value="'+data[0].statusid+'" selected="selected">'+data[0].status+'</option>');
			}
		});
	});
//APPROVING OFFICER	
	$(".editApprov").click(function() {
		var myid = $(this).data("editappid");
		$.ajax({
			url : "ApprovingOfficer",
			type : "POST",
			data : {
				forms : "editForm",
				appoffid : myid
			},
			dataType: "JSON", //tangalin muna para malaman kung gumagana, nag eexpect kasi sya ng json na babalik.
			cache : "false",
			success : function(data) {
				$("#employee2 option:first").remove();
				$("#status2 option:first").remove();
				$("#officerid").val(data[0].officerid);
				$("#description2").val(data[0].description);
				$("#status2").prepend('<option value="'+data[0].statusid+'" selected="selected">'+data[0].status+'</option>');
				$("#employee2").prepend('<option value="'+data[0].employeeid+'" selected="selected">'+data[0].employee+'</option>');
				$("#employee2").select2();
				$("#employee2").next(".select2").find(".select2-selection").focus(function() {
				    $(this).select2("open");});
			}
		});
	});
	
//COMPANY POLICY
	$(".editPolicy").click(function() {
		var myid = $(this).data("editpolicyid");
		$.ajax({
			url : "CompanyPolicy",
			type : "POST",
			data : {
				forms : "editForm",
				policyid : myid
			},
			dataType: "JSON", //tangalin muna para malaman kung gumagana, nag eexpect kasi sya ng json na babalik.
			cache : "false",
			success : function(data) {
				$("#maxexpense2").val("");
				$("#maxbudget2").val("");
				$("#expensedays2").val("");
				$("#receiptamount2").val("");
				$("#policyid").val("");
				$("#officerid").val(data[0].officerid);
				$("#maxexpense2").val(data[0].maxexpense);
				$("#maxbudget2").val(data[0].maxbudget);
				$("#expensedays2").val(data[0].expensedays);
				$("#receiptamount2").val(data[0].receiptamount);
				$("#status2 option:first").remove();
				$("#status2").prepend('<option value="'+data[0].statusid+'" selected="selected">'+data[0].status+'</option>');
				$("#department2").select2();
				$("#department2").next(".select2").find(".select2-selection").focus(function() {
				    $(this).select2("open");});
				$("#policyid").val(data[0].policyid)
			}
		});
	});
//EXPENSE CATEGORY
$(".editExpenseCat").click(function() {
		var myid = $(this).data("expensecatid");
		$.ajax({
			url : "ExpenseCategory",
			type : "POST",
			data : {
				forms : "editForm",
				expenseid : myid
			},
			dataType: "JSON", //tangalin muna para malaman kung gumagana, nag eexpect kasi sya ng json na babalik.
			cache : "false",
			success : function(data) {
				$("#name2").val("");
				$("#name2").val(data[0].name);	
				$("#rate2").val("");
				$("#rate2").val(data[0].rate);
				$("#status2 option:first").remove();
				$("#status2").prepend('<option value="'+data[0].statusid+'" selected="selected">'+data[0].status+'</option>');
				$("#department2 option:first").remove();
				$("#department2").prepend('<option value="'+data[0].departmentid+'" selected="selected">'+data[0].department+'</option>');
				$("#department2").select2();
				$("#department2").next(".select2").find(".select2-selection").focus(function() {
				    $(this).select2("open");});
				$("#expensecatid").val(data[0].expensecatid);
				
			}
		});
	});
//EMPLOYEE
$(".editemployee").click(function() {
	var myid = $(this).data("editemp");
	$.ajax({
		url : "EmployeeInformation",
		type : "POST",
		data : {
			forms : "editForm",
			empid : myid
		},
		dataType: "JSON", //tangalin muna para malaman kung gumagana, nag eexpect kasi sya ng json na babalik.
		cache : "false",
		success : function(data) {
			$("#employeeid").val("");
			$("#employeeid").val(data[0].employeeid);
			$("#firstname2").val("");
			$("#firstname2").val(data[0].firstname);	
			$("#middlename2").val("");
			$("#middlename2").val(data[0].middlename);
			$("#lastname2").val("");
			$("#lastname2").val(data[0].lastname);
			$("#department2 option:first").remove();
			$("#department2").prepend('<option value="'+data[0].departmentid+'" selected="selected">'+data[0].department+'</option>');
			$("#department2").select2();
			$("#department2").next(".select2").find(".select2-selection").focus(function() {
			    $(this).select2("open");});
			$("#position2 option:first").remove();
			$("#position2").prepend('<option value="'+data[0].positionid+'" selected="selected">'+data[0].position+'</option>');
			$("#position2").select2();
			$("#position2").next(".select2").find(".select2-selection").focus(function() {
			    $(this).select2("open");});
			$("#birthdate2").val("0000/00/00");
			$("#birthdate2").val(data[0].birthdate);
			$("#gender2 option:first").remove();
			$("#gender2").prepend('<option value="'+data[0].gender+'" selected="selected">'+data[0].gender+'</option>');
			$("#contact2").val("");
			$("#contact2").val(data[0].contact);
			$("#email2").val("");
			$("#email2").val(data[0].email);
			$("#address2").val("");
			$("#address2").val(data[0].address);
			//$("#passportno2").val("");
			//$("#passportno2").val(data[0].passportno);
			//$("#expirationdate2").val("");
			//$("#expirationdate2").val(data[0].expirydate);
			//$("#emergencycontact2").val("");
			//$("#emergencycontact2").val(data[0].emergencycontact);
			//$("#personname2").val("");
			//$("#personname2").val(data[0].peronname);
			//$("#relationship2").val("");
			//$("#relationship2").val(data[0].relationship);
			$("#status2 option:first").remove();
			$("#status2").prepend('<option value="'+data[0].statusid+'" selected="selected">'+data[0].status+'</option>');
		}
	});
});

//CARDINFORMATION
$(".editCard").click(function() {
	var myid = $(this).data("editcardinfo");
	$.ajax({
		url : "CardInformation",
		type : "POST",
		data : {
			forms : "editForm",
			cardinfoid : myid
		},
		dataType: "JSON", //tangalin muna para malaman kung gumagana, nag eexpect kasi sya ng json na babalik.
		cache : "false",
		success : function(data) {
			$("#cardinfoid").val("");
			$("#cardnumber2").val("");
			$("#expirydate2").val("");
			$("#cardinfoid").val(data[0].cardid);
			$("#cardnumber2").val(data[0].cardnumber);	
			$("#expirydate2").val(data[0].expirydate);
			$("#cardtype2 option:first").remove();
			$("#cardtype2").prepend('<option value="'+data[0].cardtypeid+'" selected="selected">'+data[0].cardtype+'</option>');
			$("#ownership2 option:first").remove();
			$("#ownership2").prepend('<option value="'+data[0].ownershipid+'" selected="selected">'+data[0].ownership+'</option>');
			$("#employee2 option:first").remove();
			$("#employee2").prepend('<option value="'+data[0].employeeid+'" selected="selected">'+data[0].employee+'</option>');
			$("#employee2").select2();
			$("#employee2").next(".select2").find(".select2-selection").focus(function() {
			    $(this).select2("open");});
			$("#status2 option:first").remove();
			$("#status2").prepend('<option value="'+data[0].statusid+'" selected="selected">'+data[0].status+'</option>');
		}
	});
});

//POSTION

$(".editPosition").click(function() {
	var myid = $(this).data("editposition");
	$.ajax({
		url : "Position",
		type : "POST",
		data : {
			forms : "editForm",
			positionid : myid
		},
		dataType: "JSON", //tangalin muna para malaman kung gumagana, nag eexpect kasi sya ng json na babalik.
		cache : "false",
		success : function(data) {
			$("#positionid").val("");
			$("#positionid").val(data[0].positionid);
			$("#position2").val("");
			$("#position2").val(data[0].position);
			$("#description2").val("");
			$("#description2").val(data[0].description);	
			$("#status2 option:first").remove();
			$("#status2").prepend('<option value="'+data[0].statusid+'" selected="selected">'+data[0].status+'</option>');
		}
	});
});

//Services
$(".editServ").click(function() {
	var myid = $(this).data("editService");
	$.ajax({
		url : "Services",
		type : "POST",
		data : {
			forms : "editForm",
			positionid : myid
		},
		dataType: "JSON", //tangalin muna para malaman kung gumagana, nag eexpect kasi sya ng json na babalik.
		cache : "false",
		success : function(data) {
			$("#positionid").val("");
			$("#positionid").val(data[0].positionid);
			$("#position2").val("");
			$("#position2").val(data[0].position);
			$("#description2").val("");
			$("#description2").val(data[0].description);	
			$("#status2 option:first").remove();
			$("#status2").prepend('<option value="'+data[0].statusid+'" selected="selected">'+data[0].status+'</option>');
		}
	});
});
//SERVICE PROVIDER
$(".editSP").click(function() {
	var myid = $(this).data("editspid");
	$.ajax({
		url : "ServiceProvider",
		type : "POST",
		data : {
			forms : "editForm",
			spid : myid
		},
		dataType: "JSON", //tangalin muna para malaman kung gumagana, nag eexpect kasi sya ng json na babalik.
		cache : "false",
		success : function(data) {
			$("#id").val(data[0].id);
			$("#company2").val(data[0].company);
			$("#contact2").val(data[0].contact);
			$("#website2").val(data[0].website);
			$("#email2").val(data[0].email);
			$("#address2").val(data[0].address);
			$("#status2 option:first").remove();
			$("#status2").prepend('<option value="'+data[0].statusid+'" selected="selected">'+data[0].status+'</option>');
		}
	});
});
//SERVICE PROVIDER
});
