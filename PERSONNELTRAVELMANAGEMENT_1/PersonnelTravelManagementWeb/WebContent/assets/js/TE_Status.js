$(document).ready(function() {
	//APPROVED
	$('.approveTE').click(function(){
		var chckBox = $('input[name="commentid"]:checked').map(function(){
			return this.value;
		}).get();
		var stat = $(this).data("status");
		if(chckBox != ''){
		if(confirm("Are you sure?")){
			$.ajax({
				url : "TravelExpenseOfficer",
				type : "POST",
				data : {
					forms : "addStatus",
					id : JSON.stringify(chckBox),
					status : stat
				},
				dataType: "JSON",
				cache : "false",
				success : function(data) {
					
				}
			});
			window.location.reload();	
		}
		} else { alert("Check box is empty!");}		
	});
	//CANCEL
	$('.cancelTE').click(function(){
		var chckBox = $('input[name="commentid"]:checked').map(function(){
			return this.value;
		}).get();
		var stat = $(this).data("status");
		if(chckBox != ''){
		if(confirm("Are you sure?")){
			$.ajax({
				url : "TravelExpenseOfficer",
				type : "POST",
				data : {
					forms : "addStatus",
					id : JSON.stringify(chckBox),
					status : stat
				},
				dataType: "JSON",
				cache : "false",
				success : function(data) {
					
				}
			});
			window.location.reload();		
		}
		} else { alert("Check box is empty!");}		
	});
});
