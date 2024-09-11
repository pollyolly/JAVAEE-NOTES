$(document).ready(function() {
	//APPROVED
	$(".approveTO").click(function() {
		var chckBox = $('input[name="commentid"]:checked').map(function(){
			return this.value;
		}).get();
		
		var stat = $(this).data("status");
		
			ajaxCall(stat, chckBox);
			windowLoad();
			
	});
	//CANCEL
	$(".cancelTO").click(function() {
		var chckBox = $('input[name="commentid"]:checked').map(function(){
			return this.value;
		}).get();
		
		var stat = $(this).data("status");
		
			ajaxCall(stat, chckBox);
			windowLoad();
				
	});
	function windowLoad(){
		window.location.reload();	
	}
	
	function ajaxCall(stat, chckBox){
		//if(chckBox != ''){
		//if(confirm("Are you sure?")){
		$.ajax({
			url : "TravelOrderOfficer",
			type : "POST",
			data : {
				forms : "addStatus",
				id : JSON.stringify(chckBox),
				status : stat
			},
			dataType : "JSON",
			cache : "false",
			success : function(data) {
				
			}
		});
		//}
		//} else { alert("Check box is empty!");}
	}
});

