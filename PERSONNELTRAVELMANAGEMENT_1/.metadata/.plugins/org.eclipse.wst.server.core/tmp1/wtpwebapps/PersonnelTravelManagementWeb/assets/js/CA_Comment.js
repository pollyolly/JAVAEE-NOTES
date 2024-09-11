$(document).ready(function() {
	//TOCOMMENT
	$(".editComment").click(function() {
		var myid = $(this).data("commentid");
		$.ajax({
			url : "CashAdvanceOfficer",
			type : "POST",
			data : {
				forms : "getComment",
				id : myid
			},
			dataType: "JSON",
			cache : "false",
			success : function(data) {
				$("#id").val("");
				$("#comment").val("");
				$("#id").val(data[0].id);
				$("#comment").val(data[0].comment);
			}
		});
	});
	$(".addComment").click(function() {
		var myid = $(this).data("commentid");
		$.ajax({
			url : "CashAdvanceOfficer",
			type : "POST",
			data : {
				forms : "getComment",
				id : myid
			},
			dataType: "JSON",
			cache : "false",
			success : function(data) {
				$("#id").val("");
				$("#comment").val("");
				$("#id").val(data[0].id);
			}
		});
	});
});
