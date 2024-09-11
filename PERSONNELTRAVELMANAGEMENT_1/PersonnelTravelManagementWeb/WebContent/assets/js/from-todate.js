$(document).ready(function() {
	$.fn.datepicker.defaults.format = "yyyy-mm-dd";
	 //FROM - TO DATE
	 var startDate = new Date();
	 var FromEndDate = new Date();
	  $('.fromDATE').datepicker({
		  format: 'yyyy-mm-dd',
		  placeholder: 'yyyy-mm-dd'
	    }).on('changeDate', function(selected){
	          startDate = new Date(selected.date.valueOf());
	          startDate.setDate(startDate.getDate(new Date(selected.date.valueOf())));
	          $('.toDATE').datepicker('setStartDate', startDate);
	      }); 
	  $('.toDATE').datepicker({
		  format: 'yyyy-mm-dd',
		  placeholder: 'yyyy-mm-dd'
	    }).on('changeDate', function(selected){
	          FromEndDate = new Date(selected.date.valueOf());
	          FromEndDate.setDate(FromEndDate.getDate(new Date(selected.date.valueOf())));
	          $('.fromDATE').datepicker('setEndDate', FromEndDate);
	      });
	  
	  $('.listDATE').datepicker('setStartDate', fromdate);
	 // $('.listDATE').datepicker('setEndDate', todate);
	  
	  $('.fromDATElist').datepicker('setStartDate', fromdate);
	  $('.fromDATElist').datepicker('setEndDate', todate);
	  $('.toDATElist').datepicker('setStartDate', fromdate);
	  $('.toDATElist').datepicker('setEndDate', todate);
	 
	/*  $('.listDATE').datepicker({
		  format: 'yyyy-mm-dd',
		  placeholder: 'yyyy-mm-dd'
	    }).on('changeDate', function(selected){
	    	fromdate = new Date(selected.date.valueOf());
	    	fromdate.setDate(fromdate.getDate(new Date(selected.date.valueOf())));
	          $('.fromDATElist').datepicker('setStartDate', fromdate);
	      }); */
	  $('.fromDATElist').datepicker({
		  format: 'yyyy-mm-dd',
		  placeholder: 'yyyy-mm-dd'
	    }).on('changeDate', function(selected){
	    	fromdate = new Date(selected.date.valueOf());
	    	fromdate.setDate(fromdate.getDate(new Date(selected.date.valueOf())));
	          $('.toDATElist').datepicker('setStartDate', fromdate);
	      }); 
	  $('.toDATElist').datepicker({
		  format: 'yyyy-mm-dd',
		  placeholder: 'yyyy-mm-dd'
	    }).on('changeDate', function(selected){
	    	todate = new Date(selected.date.valueOf());
	    	todate.setDate(todate.getDate(new Date(selected.date.valueOf())));
	          $('.fromDATElist').datepicker('setEndDate', todate);
	      });
});