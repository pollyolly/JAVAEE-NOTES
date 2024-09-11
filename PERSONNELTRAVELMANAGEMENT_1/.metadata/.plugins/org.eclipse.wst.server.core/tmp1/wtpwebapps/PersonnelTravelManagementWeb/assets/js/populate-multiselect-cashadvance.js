$(document).ready(function() {
	$('.tono').change(function (){
		$('.employee').multiSelect();
		//$('.employee').multiSelect('disable');
		var mytono = $(".tono option:selected").text();
		$('.employee').append('<option></option>');
	    if (mytono != null && mytono != '')
	    {
	    		$.ajax({
	    			url : "CashAdvance",
	    			type : "POST",
	    			data : {
	    				forms : "popuEmployee",
	    				tono : mytono
	    			},
	    			dataType: "JSON",
	    			cache : "false",
	    			success : function(data) {
	    				$('.employee').empty();
	    				$.each(data, function(i, item){
	    					$('.employee').append($("<option></option>").val(data[i].id).text(data[i].name));
	    				});
	    			$('.employee').multiSelect('refresh');
	    			}
	    		});
	    }      
	});  
});