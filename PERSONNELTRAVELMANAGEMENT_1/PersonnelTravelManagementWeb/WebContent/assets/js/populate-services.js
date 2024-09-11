$(document).ready(function() {
	//CAR
	$(".carserviceprovider").change(function (){
		var spid = $(".carserviceprovider option:selected").val();
		//var tnos = $("#tno").val();
		var datas = null;
		datas = [];
	    if (spid != null && spid != '')
	    {
	    		$.ajax({
	    			url : "TravelPlanList",
	    			type : "POST",
	    			data : {
	    				forms : "popuServices",
	    				ids : spid
	    			},
	    			dataType: "JSON",
	    			cache : "false",
	    			success : function(data) {
	    				$('.carservice').empty();
	    				//$('.service').select2();
	    				$.each(data, function(i, item){
	    					datas.push({id: data[i].id, text: data[i].service});
	    				});
	    				$('.carservice').select2({
	    					data: datas
	    				});
	    				//alert(spid);
	    			}
	    		});
	    }      
	});//CAR
	//HOTEL
	$(".hotelserviceprovider").change(function (){
		var spid = $(".hotelserviceprovider option:selected").val();
		var datas = null;
		datas = [];
	    if (spid != null && spid != '')
	    {
	    		$.ajax({
	    			url : "TravelPlanList",
	    			type : "POST",
	    			data : {
	    				forms : "popuServices",
	    				ids : spid
	    			},
	    			dataType: "JSON",
	    			cache : "false",
	    			success : function(data) {
	    				$('.hotelservice').empty();
	    				//$('.service').select2();
	    				$.each(data, function(i, item){
	    					datas.push({id: data[i].id, text: data[i].service});
	    				});
	    				$('.hotelservice').select2({
	    					data: datas
	    				});
	    				//alert(spid);
	    			}
	    		});
	    }      
	});
	//HOTEL
	//FLIGHT
	$(".flightserviceprovider").change(function (){
		var spid = $(".flightserviceprovider option:selected").val();
		var datas = null;
		datas = [];
	    if (spid != null && spid != '')
	    {
	    		$.ajax({
	    			url : "TravelPlanList",
	    			type : "POST",
	    			data : {
	    				forms : "popuServices",
	    				ids : spid
	    			},
	    			dataType: "JSON",
	    			cache : "false",
	    			success : function(data) {
	    				$('.flightservice').empty();
	    				//$('.service').select2();
	    				$.each(data, function(i, item){
	    					datas.push({id: data[i].id, text: data[i].service});
	    				});
	    				$('.flightservice').select2({
	    					data: datas
	    				});
	    				//alert(spid);
	    			}
	    		});
	    }      
	});
	//FLIGHT
});