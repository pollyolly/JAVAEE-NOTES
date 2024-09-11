	
	var _MS_PER_DAY = 1000 * 60 * 60 * 24;
	var a = new Date();
	var now = Date.UTC(a.getFullYear(), a.getMonth(), a.getDate());
	var to = Date.UTC(todate.getFullYear(), todate.getMonth(), todate.getDate());
	var mydays = Math.floor((now - to)/_MS_PER_DAY);
	if(mydays > expdays && status == "Not Approved"){
		alert("Expense is " + mydays + " days old it have reached "+ expdays + " days limit.");
	} else{
		if(0 < mydays){
			alert("Expense days is "+ mydays +" days old.");
		}else{
			alert("Expense is "+ Math.abs(mydays) +" days before it reach the limit.");                                
		}
	}